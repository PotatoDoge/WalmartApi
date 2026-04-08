package com.walmartapi.service;

import com.walmartapi.entity.ProductEntity;
import com.walmartapi.model.Product;
import com.walmartapi.repository.ProductRepository;
import org.springframework.stereotype.Service;

@Service
public class ProductService {

    private final ProductRepository productRepository;

    public ProductService(ProductRepository productRepository){
        this.productRepository = productRepository;
    }

    public Product saveProduct(Product product) {

        ProductEntity productEntity = new ProductEntity();
        productEntity.setDescription(product.getDescription());
        productEntity.setName(product.getName());
        productEntity.setPrice(product.getPrice());

        ProductEntity savedEntity = productRepository.save(productEntity);

        product.setName(savedEntity.getName());
        product.setId(savedEntity.getId());
        product.setDescription(savedEntity.getDescription());
        product.setPrice(savedEntity.getPrice());

        return product;
    }

}
