package com.localmart.entities.mapper;

import com.localmart.model.ItemList;
import javax.annotation.Generated;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2021-06-13T16:14:24+0530",
    comments = "version: 1.2.0.Final, compiler: javac, environment: Java 1.8.0_292 (Private Build)"
)
public class ItemListMapperImpl implements ItemListMapper {

    @Override
    public com.localmart.entities.ItemList toItemListEntity(ItemList itemListModel) {
        if ( itemListModel == null ) {
            return null;
        }

        com.localmart.entities.ItemList itemList = new com.localmart.entities.ItemList();

        itemList.setMeasure( itemListModel.getMeasure() );
        itemList.setQuantity( itemListModel.getQuantity() );
        itemList.setImageName( itemListModel.getImageName() );
        itemList.setPrice( itemListModel.getPrice() );
        itemList.setName( itemListModel.getName() );
        itemList.setBrand( itemListModel.getBrand() );

        return itemList;
    }

    @Override
    public ItemList toItemListModel(com.localmart.entities.ItemList itemListEntity) {
        if ( itemListEntity == null ) {
            return null;
        }

        ItemList itemList = new ItemList();

        itemList.setMeasure( itemListEntity.getMeasure() );
        itemList.setQuantity( itemListEntity.getQuantity() );
        itemList.setImageName( itemListEntity.getImageName() );
        itemList.setPrice( itemListEntity.getPrice() );
        itemList.setName( itemListEntity.getName() );
        itemList.setBrand( itemListEntity.getBrand() );

        return itemList;
    }
}
