package com.crossasyst.personregistration.mapper;

import com.crossasyst.personregistration.entity.LocationEntity;
import com.crossasyst.personregistration.model.Location;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring")
public interface LocationMapper {
    LocationEntity modelToEntity(Location location);
    Location entityToModel(LocationEntity locationEntity);
    List<Location> allEntityToModel(List<LocationEntity> locationEntities);
}
