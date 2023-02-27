package com.crossasyst.personregistration.controller;

import com.crossasyst.personregistration.model.PersonAdditionalInformation;
import com.crossasyst.personregistration.service.PersonAdditionalInformationService;
import lombok.extern.log4j.Log4j2;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@Log4j2
public class PersonAdditionalInformationController {
    private  final PersonAdditionalInformationService personAdditionalInformationService;

    public PersonAdditionalInformationController(PersonAdditionalInformationService personAdditionalInformationService) {
        this.personAdditionalInformationService = personAdditionalInformationService;
    }
    @PutMapping(value = "/persons/{personId}/additional-information",produces = MediaType.APPLICATION_JSON_VALUE,consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<PersonAdditionalInformation> updatePersonAdditionalInformationByPersonId(@PathVariable Long personId, @RequestBody PersonAdditionalInformation personAdditionalInformation){
        log.info("Start Updating PersonAdditionalInformation By Using PersonId  ");
        personAdditionalInformation=personAdditionalInformationService.updatePersonAdditionalInformationByPersonId(personId,personAdditionalInformation);
        return new ResponseEntity<>(personAdditionalInformation, HttpStatus.OK);
    }
}
