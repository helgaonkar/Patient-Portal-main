package com.crossasyst.personregistration.controller;

import com.crossasyst.personregistration.model.Practice;
import com.crossasyst.personregistration.response.PracticeResponse;
import com.crossasyst.personregistration.service.PracticeService;
import lombok.extern.log4j.Log4j2;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@Log4j2
public class PracticeController {
    private final PracticeService practiceService;

    public PracticeController(PracticeService practiceService) {
        this.practiceService = practiceService;
    }

    @PostMapping(path = "/enterprises/{enterpriseId}/practices", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<PracticeResponse> createPractice(@RequestBody Practice practice, @PathVariable Long enterpriseId) {
        log.info("Start Creating Practice By Using EnterpriseId");
        PracticeResponse practiceResponse = practiceService.createPracticeByEnterpriseId(practice, enterpriseId);
        return new ResponseEntity<>(practiceResponse, HttpStatus.OK);
    }

    @GetMapping(path = "/enterprises/{enterpriseId}/practices")
    public ResponseEntity<List<Practice>> getAllPracticesByEnterpriseId(@PathVariable Long enterpriseId) {
        log.info("Start Getting All Practices Using EnterpriseId");
        List<Practice> practiceList = practiceService.getAllPracticesByEnterpriseId(enterpriseId);
        return new ResponseEntity<>(practiceList, HttpStatus.OK);
    }

    @GetMapping(path = "/practices/{practiceId}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Practice> getPracticeById(@PathVariable Long practiceId) {
        log.info("Start Getting All Practices Using PracticeId");
        Practice practice = practiceService.getPracticeById(practiceId);
        return new ResponseEntity<>(practice, HttpStatus.OK);
    }

    @PutMapping(path = "/practices/{practiceId}", produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Practice> updatePracticeByPracticeId(@PathVariable Long practiceId, @RequestBody Practice practice) {
        log.info("Start Updating Practice By PracticeId ");
        practice = practiceService.updatePracticeByPracticeId(practiceId, practice);
        return new ResponseEntity<>(practice, HttpStatus.OK);
    }

    @DeleteMapping(path = "/practices/practiceId")
    public ResponseEntity<Void> deletePracticeById(@PathVariable Long practiceId) {
        log.info("Start Deleting Person");
        practiceService.deletePracticeById(practiceId);
        return ResponseEntity.ok().build();
    }


}
