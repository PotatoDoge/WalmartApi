package com.walmartapi.service;

import com.walmartapi.entity.CategoryEntity;
import com.walmartapi.entity.ProductEntity;
import com.walmartapi.exception.NotFound;
import com.walmartapi.mapper.CustomObjectMapper;
import com.walmartapi.model.Product;
import com.walmartapi.repository.ProductRepository;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class ProductService {

    private final ProductRepository productRepository;
    private final CustomObjectMapper<ProductEntity, Product> productMapper;
    private final CategoryService categoryService;

    public ProductService(ProductRepository productRepository,
                          CustomObjectMapper<ProductEntity, Product> productMapper,
                          CategoryService categoryService){
        this.productRepository = productRepository;
        this.productMapper = productMapper;
        this.categoryService = categoryService;
    }

    public Product saveProduct(Product product) {

        CategoryEntity categoryEntity = categoryService.findEntityById(product.getCategoryId());

        ProductEntity newProduct = productMapper.mapToEntity(product);

        newProduct.setCategory(categoryEntity);
        ProductEntity savedEntity = productRepository.save(newProduct);

        return productMapper.mapToDto(savedEntity);
    }

    public Product getProductById(Long id){

        Optional<ProductEntity> product = productRepository.findById(id);

        if(product.isEmpty()) {
            throw new NotFound("Product not found");
        }

        return productMapper.mapToDto(product.get());
    }

}
