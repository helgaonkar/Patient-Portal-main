package com.crossasyst.personregistration.repository;

import com.crossasyst.personregistration.entity.EnterpriseEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EnterpriseRepository extends JpaRepository<EnterpriseEntity, Long> {
}
