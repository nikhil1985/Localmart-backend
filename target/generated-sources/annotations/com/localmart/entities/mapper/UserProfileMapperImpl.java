package com.localmart.entities.mapper;

import com.localmart.model.UserProfile;
import javax.annotation.Generated;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2021-06-13T16:14:24+0530",
    comments = "version: 1.2.0.Final, compiler: javac, environment: Java 1.8.0_292 (Private Build)"
)
public class UserProfileMapperImpl implements UserProfileMapper {

    @Override
    public com.localmart.entities.UserProfile toUserProfileEntity(UserProfile userProfileModel) {
        if ( userProfileModel == null ) {
            return null;
        }

        com.localmart.entities.UserProfile userProfile = new com.localmart.entities.UserProfile();

        userProfile.setName( userProfileModel.getName() );
        userProfile.setCustomerType( userProfileModel.getCustomerType() );
        userProfile.setMobileNumber( userProfileModel.getMobileNumber() );
        userProfile.setEmail( userProfileModel.getEmail() );

        return userProfile;
    }

    @Override
    public UserProfile toUserProfileModel(com.localmart.entities.UserProfile userProfileEntity) {
        if ( userProfileEntity == null ) {
            return null;
        }

        UserProfile userProfile = new UserProfile();

        userProfile.setName( userProfileEntity.getName() );
        userProfile.setCustomerType( userProfileEntity.getCustomerType() );
        userProfile.setMobileNumber( userProfileEntity.getMobileNumber() );
        userProfile.setEmail( userProfileEntity.getEmail() );

        return userProfile;
    }
}
