package com.crossasyst.personregistration.repository;

import com.crossasyst.personregistration.entity.PracticeEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PracticeRepository extends JpaRepository<PracticeEntity,Long> {
}
