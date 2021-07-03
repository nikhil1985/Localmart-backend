package com.localmart.entities.mapper;

import com.localmart.entities.ClientInfo;
import com.localmart.model.ClinetInfo;
import javax.annotation.Generated;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2021-06-13T16:14:24+0530",
    comments = "version: 1.2.0.Final, compiler: javac, environment: Java 1.8.0_292 (Private Build)"
)
public class ClientInfoMapperImpl implements ClientInfoMapper {

    @Override
    public ClientInfo toItemListEntity(ClinetInfo clientInfoModel) {
        if ( clientInfoModel == null ) {
            return null;
        }

        ClientInfo clientInfo = new ClientInfo();

        clientInfo.setFirstName( clientInfoModel.getFirstName() );
        clientInfo.setLastName( clientInfoModel.getLastName() );
        clientInfo.setLocationName( clientInfoModel.getLocationName() );
        clientInfo.setMobileNumber( clientInfoModel.getMobileNumber() );
        clientInfo.setImageUrl( clientInfoModel.getImageUrl() );
        clientInfo.setName( clientInfoModel.getName() );
        clientInfo.setStoreName( clientInfoModel.getStoreName() );
        clientInfo.setCategoryName( clientInfoModel.getCategoryName() );
        clientInfo.setEmail( clientInfoModel.getEmail() );

        return clientInfo;
    }

    @Override
    public ClinetInfo toItemListModel(ClientInfo clientInfoEntity) {
        if ( clientInfoEntity == null ) {
            return null;
        }

        ClinetInfo clinetInfo = new ClinetInfo();

        clinetInfo.setFirstName( clientInfoEntity.getFirstName() );
        clinetInfo.setLastName( clientInfoEntity.getLastName() );
        clinetInfo.setLocationName( clientInfoEntity.getLocationName() );
        clinetInfo.setMobileNumber( clientInfoEntity.getMobileNumber() );
        clinetInfo.setImageUrl( clientInfoEntity.getImageUrl() );
        clinetInfo.setName( clientInfoEntity.getName() );
        clinetInfo.setStoreName( clientInfoEntity.getStoreName() );
        clinetInfo.setCategoryName( clientInfoEntity.getCategoryName() );
        clinetInfo.setEmail( clientInfoEntity.getEmail() );

        return clinetInfo;
    }
}
