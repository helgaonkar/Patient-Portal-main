package com.crossasyst.personregistration.service;

import com.crossasyst.personregistration.entity.PersonAdditionalInformationEntity;
import com.crossasyst.personregistration.entity.PersonEntity;
import com.crossasyst.personregistration.mapper.PersonAdditionalInformationMapper;
import com.crossasyst.personregistration.model.PersonAdditionalInformation;
import com.crossasyst.personregistration.repository.PersonAdditionalInformationRepository;
import com.crossasyst.personregistration.repository.PersonRepository;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@Log4j2
public class PersonAdditionalInformationService {
    private final PersonAdditionalInformationRepository personAdditionalInformationRepository;
    private final PersonAdditionalInformationMapper personAdditionalInformationMapper;
    private final PersonRepository personRepository;

    @Autowired
    public PersonAdditionalInformationService(PersonAdditionalInformationRepository personAdditionalInformationRepository, PersonAdditionalInformationMapper personAdditionalInformationMapper, PersonRepository personRepository) {
        this.personAdditionalInformationRepository = personAdditionalInformationRepository;
        this.personAdditionalInformationMapper = personAdditionalInformationMapper;
        this.personRepository = personRepository;
    }

    public PersonAdditionalInformation updatePersonAdditionalInformationByPersonId(Long personId, PersonAdditionalInformation personAdditionalInformation) {
        PersonEntity personEntity = personRepository.findById(personId).get();
        PersonAdditionalInformationEntity personAdditionalInformationEntity = personEntity.getPersonAdditionalInformationEntity();
        personAdditionalInformationEntity = personAdditionalInformationMapper.modelToEntity(personAdditionalInformation);
        personEntity.setPersonId(personId);
        personAdditionalInformationRepository.save(personAdditionalInformationEntity);
        log.info("“Person additional information updated successfully with PersonId={}", personId);
        return personAdditionalInformation;


    }


}
