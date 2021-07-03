package com.localmart.entities.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;
import org.springframework.stereotype.Service;

import com.localmart.entities.UserProfile;


@Mapper
@Service
public interface UserProfileMapper {
	UserProfileMapper INSTANCE = Mappers.getMapper(UserProfileMapper.class);
	
	@Mapping(target="name", source="userProfileModel.name")
	@Mapping(target="mobileNumber", source="userProfileModel.mobileNumber")
	@Mapping(target="email", source="userProfileModel.email")
	@Mapping(target="customerType", source="userProfileModel.customerType")
	UserProfile toUserProfileEntity(com.localmart.model.UserProfile userProfileModel);

	@Mapping(target="name", source="userProfileEntity.name")
	@Mapping(target="mobileNumber", source="userProfileEntity.mobileNumber")
	@Mapping(target="email", source="userProfileEntity.email")
	@Mapping(target="customerType", source="userProfileEntity.customerType")
	com.localmart.model.UserProfile toUserProfileModel(UserProfile userProfileEntity);

}
