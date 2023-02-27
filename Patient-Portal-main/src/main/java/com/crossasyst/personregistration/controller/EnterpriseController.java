package com.crossasyst.personregistration.controller;

import com.crossasyst.personregistration.model.Enterprise;
import com.crossasyst.personregistration.response.EnterpriseResponse;
import com.crossasyst.personregistration.service.EnterpriseService;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
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
public class EnterpriseController {
    private final EnterpriseService enterpriseService;

    @Autowired
    public EnterpriseController(EnterpriseService enterpriseService) {
        this.enterpriseService = enterpriseService;
    }

    @PostMapping(path = "/enterprises", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<EnterpriseResponse> createEnterprise(@RequestBody Enterprise enterprise) {
        log.info("Start Creating Enterprise");
        EnterpriseResponse enterpriseResponse = enterpriseService.createEnterprise(enterprise);
        return new ResponseEntity<>(enterpriseResponse, HttpStatus.OK);
    }

    @GetMapping(path = "/enterprises/{enterpriseId}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Enterprise> getEnterpriseById(@PathVariable Long enterpriseId) {
        log.info("start Getting");
        Enterprise enterprise = enterpriseService.getEnterpriseById(enterpriseId);
        return new ResponseEntity<>(enterprise, HttpStatus.OK);
    }

    @GetMapping(path = "/enterprises")
    public ResponseEntity<List<Enterprise>> getAllEnterprise() {
        log.info("Start Getting All");
        List<Enterprise> enterpriseList = enterpriseService.getAllEnterprise();
        return new ResponseEntity<>(enterpriseList, HttpStatus.OK);
    }

    @PutMapping(path = "/enterprises/{enterpriseId}", produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Enterprise> updateEnterpriseById(@PathVariable Long enterpriseId, @RequestBody Enterprise enterprise) {
        log.info("Start Updating");
        enterprise = enterpriseService.updateEnterpriseById(enterpriseId, enterprise);
        return new ResponseEntity<>(enterprise, HttpStatus.OK);
    }

    @DeleteMapping(path = "/enterprises/{enterpriseId}")
    public ResponseEntity<Void> deleteEnterpriseById(@PathVariable Long enterpriseId) {
        log.info("Start Deleting");
        enterpriseService.deleteEnterpriseById(enterpriseId);
        return ResponseEntity.ok().build();

    }
}
