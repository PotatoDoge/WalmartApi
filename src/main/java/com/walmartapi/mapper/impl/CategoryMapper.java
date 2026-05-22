package com.walmartapi.mapper.impl;

import com.walmartapi.entity.CategoryEntity;
import com.walmartapi.mapper.CustomObjectMapper;
import com.walmartapi.model.Category;
import org.springframework.stereotype.Component;

@Component
public class CategoryMapper implements CustomObjectMapper<CategoryEntity, Category> {

    @Override
    public CategoryEntity mapToEntity(Category dto) {
        CategoryEntity categoryEntity = new CategoryEntity();
        categoryEntity.setDescription(dto.getDescription());
        categoryEntity.setName(dto.getName());
        categoryEntity.setId(dto.getId());
        return categoryEntity;
    }

    @Override
    public Category mapToDto(CategoryEntity entity) {
        Category category = new Category();
        category.setName(entity.getName());
        category.setId(entity.getId());
        category.setDescription(entity.getDescription());
        return category;
    }
}
