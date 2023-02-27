package com.crossasyst.personregistration.mapper;

import com.crossasyst.personregistration.entity.PracticeEntity;
import com.crossasyst.personregistration.model.Practice;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring")
public interface PracticeMapper {
    PracticeEntity modelToEntity(Practice practice);
    Practice entityToModel(PracticeEntity practiceEntity);
    List<Practice> allEntityToModel (List<PracticeEntity> enterpriseEntityList);

}
