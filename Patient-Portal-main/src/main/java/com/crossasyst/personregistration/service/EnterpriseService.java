package com.crossasyst.personregistration.service;

import com.crossasyst.personregistration.entity.EnterpriseEntity;
import com.crossasyst.personregistration.mapper.EnterpriseMapper;
import com.crossasyst.personregistration.model.Enterprise;
import com.crossasyst.personregistration.repository.EnterpriseRepository;
import com.crossasyst.personregistration.response.EnterpriseResponse;
import lombok.extern.log4j.Log4j2;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@Log4j2
public class EnterpriseService {
    private final EnterpriseMapper enterpriseMapper;
    private final EnterpriseRepository enterpriseRepository;

    public EnterpriseService(EnterpriseMapper enterpriseMapper, EnterpriseRepository enterpriseRepository) {
        this.enterpriseMapper = enterpriseMapper;
        this.enterpriseRepository = enterpriseRepository;
    }

    public EnterpriseResponse createEnterprise(Enterprise enterprise) {
        EnterpriseEntity enterpriseEntity = enterpriseMapper.modelToEntity(enterprise);
        enterpriseRepository.save(enterpriseEntity);
        EnterpriseResponse enterpriseResponse = new EnterpriseResponse();
        enterpriseResponse.setEnterpriseId(enterpriseEntity.getEnterpriseId());
        log.info("Enterprise Create With EnterpriseId={}", enterpriseResponse.getEnterpriseId());
        return enterpriseResponse;
    }

    public Enterprise getEnterpriseById(Long enterpriseId) {
        Optional<EnterpriseEntity> enterpriseEntityOptional = enterpriseRepository.findById(enterpriseId);
        Enterprise enterprise = new Enterprise();
        if (enterpriseEntityOptional.isPresent()) {
            enterprise = enterpriseMapper.entityToModel(enterpriseEntityOptional.get());
            log.info("Enterprise Found With EnterpriseId={}", enterpriseId);
            log.info(enterpriseEntityOptional.toString());

        } else {
            log.info("EnterpriseId Not Found");
        }
        return enterprise;
    }

    public List<Enterprise> getAllEnterprise() {
        List<EnterpriseEntity> enterpriseEntityList = enterpriseRepository.findAll();
        List<Enterprise> enterpriseList = enterpriseMapper.allEntityToModels(enterpriseEntityList);
        log.info("All Enterprises Found Successfully");
        return enterpriseList;
    }

    public Enterprise updateEnterpriseById(Long enterpriseId, Enterprise enterprise) {
        Optional<EnterpriseEntity> enterpriseEntityOptional = enterpriseRepository.findById(enterpriseId);
        if (enterpriseEntityOptional.isPresent()) {
            EnterpriseEntity enterpriseEntity = enterpriseEntityOptional.get();
            enterpriseEntity = enterpriseMapper.modelToEntity(enterprise);
            enterpriseRepository.save(enterpriseEntity);
            log.info("Enterprise Update Successfully With EnterpriseId={} ", enterpriseId);

        } else {
            log.info("EnterpriseId Not Found");
        }
        return enterprise;
    }


    public void deleteEnterpriseById(Long enterpriseId) {
        Optional<EnterpriseEntity> enterpriseEntityOptional = enterpriseRepository.findById(enterpriseId);
        if (enterpriseEntityOptional.isPresent()) {
            enterpriseRepository.delete(enterpriseEntityOptional.get());
            log.info("Deleted Successfully");
        }
    }
}
