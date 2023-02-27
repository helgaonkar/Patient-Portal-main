package com.crossasyst.personregistration.mapper;

import com.crossasyst.personregistration.entity.PersonAdditionalInformationEntity;
import com.crossasyst.personregistration.model.PersonAdditionalInformation;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface PersonAdditionalInformationMapper {
    PersonAdditionalInformationEntity modelToEntity(PersonAdditionalInformation personAdditionalInformation);
}
