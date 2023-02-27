package com.crossasyst.personregistration.controller;

import com.crossasyst.personregistration.model.PatchDto;
import com.crossasyst.personregistration.model.Person;
import com.crossasyst.personregistration.response.PersonResponse;
import com.crossasyst.personregistration.service.PersonService;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.extern.log4j.Log4j2;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping(name = "v1")
@Tag(name = "Person controller", description = "Add person details")
@Log4j2
public class PersonController {

    private final PersonService personService;

    public PersonController(PersonService personService) {
        this.personService = personService;
    }


    @ApiResponse(responseCode = "200", description = "Success")
    @ApiResponse(responseCode = "400", description = "Invalid request")
    @ApiResponse(responseCode = "404", description = "Not found")
    @ApiResponse(responseCode = "500", description = "System error")
    @PostMapping(path = "/persons", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    //@RolesAllowed("admin")
    public ResponseEntity<PersonResponse> createPerson(@RequestBody Person person) {
        PersonResponse personResponse = personService.CreatePerson(person);
        log.info("Start Creating Person");
        return new ResponseEntity<>(personResponse, HttpStatus.OK);
    }

    @GetMapping(value = "/persons/{personId}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Person> getPersonByPersonId(@PathVariable Long personId) {
        Person person = personService.getPersonByPersonId(personId);
        log.info("Start Getting Person By PersonId");
        return new ResponseEntity<>(person, HttpStatus.OK);
    }

    @PatchMapping(path = "/persons/{personId}", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Void> updatePersonImageById(@RequestBody PatchDto patchDto, @PathVariable Long personId) {
        log.info("Start Patch Image");
        personService.updatePersonImageById(personId, patchDto);
        return ResponseEntity.ok().build();
    }

    @DeleteMapping(path = "/persons/{personId}")
    public ResponseEntity<Void> deletePersonById(@PathVariable Long personId) {
        log.info("Start Deleting Person ");
        personService.deletePersonById(personId);
        return ResponseEntity.ok().build();
    }

    @PutMapping(path = "/persons/{personId}", produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Person> updatePersonById(@PathVariable Long personId, @RequestBody Person person) {
        log.info(" Start Updating Person ");
        person = personService.updatePersonById(personId, person);
        return ResponseEntity.ok().build();
    }
}
