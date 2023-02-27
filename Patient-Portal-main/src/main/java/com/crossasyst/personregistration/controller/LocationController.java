package com.crossasyst.personregistration.controller;

import com.crossasyst.personregistration.model.Location;
import com.crossasyst.personregistration.response.LocationResponse;
import com.crossasyst.personregistration.service.LocationService;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@Log4j2
public class LocationController {
    private final LocationService locationService;

    @Autowired
    public LocationController(LocationService locationService) {
        this.locationService = locationService;
    }

    @PostMapping(value = "/practices/{practiceId}/locations", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<LocationResponse> createLocationUsingPracticeId(@RequestBody Location location, @PathVariable Long practiceId) {
        log.info("Creating Location By Using PracticeId");
        LocationResponse locationResponse = locationService.createLocationUsingPracticeId(location, practiceId);
        return new ResponseEntity<>(locationResponse, HttpStatus.OK);
    }
    @GetMapping(value = "/locations/{locationId}",produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Location> getLocationByLocationId(@PathVariable Long locationId){
        log.info("Start Getting Locations By LocationId");
        Location location=locationService.getLocationByLocationId(locationId);
        return new ResponseEntity<>(location,HttpStatus.OK);
    }
    @GetMapping(value = "/practices/{practiceId}/locations")
    private ResponseEntity<List<Location>> getAllLocationByPracticeId(@PathVariable Long practiceId){
        log.info("Getting All Locations By PracticeId");
        List<Location>locations=locationService.getAllLocationByPracticeId(practiceId);
        return new ResponseEntity<>(locations,HttpStatus.OK);
    }

}
