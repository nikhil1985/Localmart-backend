package com.localmart.entities.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;
import org.springframework.stereotype.Service;

import com.localmart.entities.ClientInfo;

@Mapper
@Service
public interface ClientInfoMapper {

	ClientInfoMapper INSTANCE = Mappers.getMapper(ClientInfoMapper.class);

	@Mapping(target = "id", ignore = true)
	@Mapping(target = "name", source = "clientInfoModel.name")
	@Mapping(target = "firstName", source = "clientInfoModel.firstName")
	@Mapping(target = "lastName", source = "clientInfoModel.lastName")
	@Mapping(target = "email", source = "clientInfoModel.email")
	@Mapping(target = "imageUrl", source = "clientInfoModel.imageUrl")
	@Mapping(target = "storeName", source = "clientInfoModel.storeName")
	@Mapping(target = "locationName", source = "clientInfoModel.locationName")
	@Mapping(target = "categoryName", source = "clientInfoModel.categoryName")
	@Mapping(target = "mobileNumber", source = "clientInfoModel.mobileNumber")
	ClientInfo toItemListEntity(com.localmart.model.ClinetInfo clientInfoModel);

	@Mapping(target = "name", source = "clientInfoEntity.name")
	@Mapping(target = "firstName", source = "clientInfoEntity.firstName")
	@Mapping(target = "lastName", source = "clientInfoEntity.lastName")
	@Mapping(target = "email", source = "clientInfoEntity.email")
	@Mapping(target = "imageUrl", source = "clientInfoEntity.imageUrl")
	@Mapping(target = "storeName", source = "clientInfoEntity.storeName")
	@Mapping(target = "locationName", source = "clientInfoEntity.locationName")
	@Mapping(target = "categoryName", source = "clientInfoEntity.categoryName")
	@Mapping(target = "mobileNumber", source = "clientInfoEntity.mobileNumber")
	com.localmart.model.ClinetInfo toItemListModel(ClientInfo clientInfoEntity);

}
