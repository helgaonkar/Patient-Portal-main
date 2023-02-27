package com.crossasyst.personregistration.service;

import com.crossasyst.personregistration.entity.PersonEntity;
import com.crossasyst.personregistration.mapper.PersonMapper;
import com.crossasyst.personregistration.model.PatchDto;
import com.crossasyst.personregistration.model.Person;
import com.crossasyst.personregistration.repository.PersonRepository;
import com.crossasyst.personregistration.response.PersonResponse;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@Log4j2
public class PersonService {

    public final PersonMapper personMapper;

    public final PersonRepository personRepository;

    @Autowired
    public PersonService(PersonMapper personMapper, PersonRepository personRepository) {
        this.personMapper = personMapper;
        this.personRepository = personRepository;
    }

    public PersonResponse CreatePerson(Person person) {

        log.info("Adding person details");

        PersonEntity personEntity = personMapper.modelToEntity(person);
        personRepository.save(personEntity);
        log.info("Person details saved successfully.");

        PersonResponse personResponse = new PersonResponse();
        personResponse.setPersonId(personEntity.getPersonId());
        log.info("Your person id is {}", personResponse.getPersonId());
        return personResponse;
    }

    public Person getPersonByPersonId(Long personId) {
        Optional<PersonEntity> personEntity = personRepository.findById(personId);
        Person person = new Person();
        if (personEntity.isPresent()) {
            person = personMapper.entityToModel(personEntity.get());
            log.info("Person Found Successfully With PersonId={}", personId);
        } else {
            log.info("Person With PersonId Not Found");
        }
        return person;
    }

    public void updatePersonImageById(Long personId, PatchDto patchDto) {
        Optional<PersonEntity> optionalPersonEntity = personRepository.findById(personId);
        if (optionalPersonEntity.isPresent()) {
            PersonEntity personEntity = optionalPersonEntity.get();
            personEntity.setPersonImage(patchDto.getPersonImage());
            personRepository.save(personEntity);
            log.info("Update Image SuccessFully With PersonId={}", personId);
        } else {
            log.info("PersonId Not Found");
        }
    }

    public void deletePersonById(Long personId) {
        Optional<PersonEntity> personEntityOptional = personRepository.findById(personId);
        if (personEntityOptional.isPresent()) {
            personRepository.delete(personEntityOptional.get());
            log.info("Person Delete Successfully With PersonId={} ", personId);
        } else {
            log.info("PersonId Not Found");
        }
    }

    public Person updatePersonById(Long personId, Person person) {
        Optional<PersonEntity> personEntityOptional = personRepository.findById(personId);
        if (personEntityOptional.isPresent()) {
            PersonEntity personEntity = personEntityOptional.get();
            personEntity = personMapper.modelToEntity(person);
            log.info("Person Update Successfully With PersonId={}", personId);
        } else {
            log.info("PersonId={} Not Found", personId);
        }
        return person;
    }
}
