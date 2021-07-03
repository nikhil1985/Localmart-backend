package com.localmart.entities.mapper;

import com.localmart.model.Category;
import javax.annotation.Generated;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2021-06-13T16:14:24+0530",
    comments = "version: 1.2.0.Final, compiler: javac, environment: Java 1.8.0_292 (Private Build)"
)
public class CategoryMapperImpl implements CategoryMapper {

    @Override
    public com.localmart.entities.Category toCategoryEntity(Category category) {
        if ( category == null ) {
            return null;
        }

        com.localmart.entities.Category category1 = new com.localmart.entities.Category();

        category1.setImage( category.getImage() );
        category1.setCategoryName( category.getCategoryName() );

        return category1;
    }

    @Override
    public Category toCategoryModel(com.localmart.entities.Category category) {
        if ( category == null ) {
            return null;
        }

        Category category1 = new Category();

        category1.setImage( category.getImage() );
        category1.setCategoryName( category.getCategoryName() );

        return category1;
    }
}
