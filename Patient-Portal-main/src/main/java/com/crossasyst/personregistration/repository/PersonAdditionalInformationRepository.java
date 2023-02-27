package com.crossasyst.personregistration.repository;

import com.crossasyst.personregistration.entity.PersonAdditionalInformationEntity;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PersonAdditionalInformationRepository extends CrudRepository<PersonAdditionalInformationEntity,Long> {
}
