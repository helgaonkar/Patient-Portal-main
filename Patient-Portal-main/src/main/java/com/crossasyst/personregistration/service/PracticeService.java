package com.crossasyst.personregistration.service;

import com.crossasyst.personregistration.entity.AddressEntity;
import com.crossasyst.personregistration.entity.EnterpriseEntity;
import com.crossasyst.personregistration.entity.PracticeEntity;
import com.crossasyst.personregistration.mapper.PracticeMapper;
import com.crossasyst.personregistration.model.Practice;
import com.crossasyst.personregistration.repository.EnterpriseRepository;
import com.crossasyst.personregistration.repository.PracticeRepository;
import com.crossasyst.personregistration.response.PracticeResponse;
import lombok.extern.log4j.Log4j2;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@Log4j2
public class PracticeService {
    private final PracticeMapper practiceMapper;
    private final PracticeRepository practiceRepository;
    private final EnterpriseRepository enterpriseRepository;

    public PracticeService(PracticeMapper practiceMapper, PracticeRepository practiceRepository, EnterpriseRepository enterpriseRepository) {
        this.practiceMapper = practiceMapper;
        this.practiceRepository = practiceRepository;
        this.enterpriseRepository = enterpriseRepository;
    }

    public PracticeResponse createPracticeByEnterpriseId(Practice practice, Long enterpriseId) {

        EnterpriseEntity enterpriseEntity = enterpriseRepository.findById(enterpriseId).get();
        List<PracticeEntity> practiceEntities = enterpriseEntity.getPracticeEntity();

        PracticeEntity practiceEntity = practiceMapper.modelToEntity(practice);
        enterpriseEntity.setEnterpriseId(enterpriseId);
        practiceEntities.add(practiceEntity);
        practiceRepository.save(practiceEntity);
        PracticeResponse practiceResponse = new PracticeResponse();
        practiceResponse.setPracticeId(practiceEntity.getPracticeId());
        log.info("Successfully create practices with PracticeId={} ", practiceResponse.getPracticeId());
        return practiceResponse;
    }

    public List<Practice> getAllPracticesByEnterpriseId(Long enterpriseId) {
        EnterpriseEntity enterpriseEntity = enterpriseRepository.findById(enterpriseId).get();
        List<PracticeEntity> practiceEntities = enterpriseEntity.getPracticeEntity();
        List<Practice> practice = practiceMapper.allEntityToModel(practiceEntities);
        enterpriseEntity.setEnterpriseId(enterpriseId);
        log.info("Get All Practices Using EnterpriseId={}", enterpriseId);
        return practice;
    }

    public Practice getPracticeById(Long practiceId) {
        Optional<PracticeEntity> practiceEntityOptional = practiceRepository.findById(practiceId);
        Practice practice = new Practice();
        if (practiceEntityOptional.isPresent()) {
            practice = practiceMapper.entityToModel(practiceEntityOptional.get());
            log.info("Practice Found With PracticeId={}", practiceId);
        } else {
            log.info("PracticeId Not Found");
        }
        return practice;
    }

    public Practice updatePracticeByPracticeId(Long practiceId, Practice practice) {
        Optional<PracticeEntity> practiceEntityOptional = practiceRepository.findById(practiceId);
        if (practiceEntityOptional.isPresent()) {
            PracticeEntity practiceEntity = practiceEntityOptional.get();
            practiceEntity = practiceMapper.modelToEntity(practice);
            practiceEntity.setPracticeId(practiceId);
            practiceRepository.save(practiceEntity);
            log.info("Practice Update With PracticeId={} ", practiceId);
        } else {
            log.info("PracticeId Not Found");
        }
        return practice;
    }

    public void deletePracticeById(Long practiceId) {
        Optional<PracticeEntity> practiceEntityOptional = practiceRepository.findById(practiceId);
        if (practiceEntityOptional.isPresent()) {
            practiceRepository.delete(practiceEntityOptional.get());
            log.info("Practice With PracticeId={} Delete Successfully", practiceId);
        } else {
            log.info("PracticeId Not Found");
        }
    }
}

