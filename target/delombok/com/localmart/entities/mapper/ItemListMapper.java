package com.localmart.entities.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;
import org.springframework.stereotype.Service;

import com.localmart.entities.ItemList;

@Mapper
@Service
public interface ItemListMapper {

	ItemListMapper INSTANCE = Mappers.getMapper(ItemListMapper.class);

	@Mapping(target = "id", ignore = true)
	@Mapping(target = "name", source = "itemListModel.name")
	@Mapping(target = "brand", source = "itemListModel.brand")
	@Mapping(target = "measure", source = "itemListModel.measure")
	@Mapping(target = "quantity", source = "itemListModel.quantity")
	@Mapping(target = "price", source = "itemListModel.price")
	@Mapping(target = "imageName", source = "itemListModel.imageName")
	ItemList toItemListEntity(com.localmart.model.ItemList itemListModel);

	@Mapping(target = "name", source = "itemListEntity.name")
	@Mapping(target = "brand", source = "itemListEntity.brand")
	@Mapping(target = "measure", source = "itemListEntity.measure")
	@Mapping(target = "quantity", source = "itemListEntity.quantity")
	@Mapping(target = "price", source = "itemListEntity.price")
	@Mapping(target = "imageName", source = "itemListEntity.imageName")
	com.localmart.model.ItemList toItemListModel(ItemList itemListEntity);

}
