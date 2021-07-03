package com.localmart.entities.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;
import org.springframework.stereotype.Service;

import com.localmart.entities.Category;

@Mapper
@Service
public interface CategoryMapper {
  CategoryMapper INSTANCE = Mappers.getMapper(CategoryMapper.class);
  
  @Mapping(target = "categoryName", source = "category.categoryName")
  @Mapping(target = "image", source = "category.image")
  Category toCategoryEntity(com.localmart.model.Category category);
  
  @Mapping(target = "categoryName", source = "category.categoryName")
  @Mapping(target = "image", source = "category.image")
  com.localmart.model.Category toCategoryModel(Category category);
  
}
