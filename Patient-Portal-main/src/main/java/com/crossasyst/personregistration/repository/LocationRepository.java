package com.crossasyst.personregistration.repository;

import com.crossasyst.personregistration.entity.LocationEntity;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface LocationRepository extends CrudRepository<LocationEntity,Long> {
}
