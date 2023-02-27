package com.crossasyst.personregistration.service;

import com.crossasyst.personregistration.entity.LocationEntity;
import com.crossasyst.personregistration.entity.PracticeEntity;
import com.crossasyst.personregistration.mapper.LocationMapper;
import com.crossasyst.personregistration.model.Location;
import com.crossasyst.personregistration.repository.LocationRepository;
import com.crossasyst.personregistration.repository.PracticeRepository;
import com.crossasyst.personregistration.response.LocationResponse;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.swing.text.html.Option;
import java.util.List;
import java.util.Optional;

@Service
@Log4j2
public class LocationService {

    private final LocationRepository locationRepository;
    private final LocationMapper locationMapper;
    private final PracticeRepository practiceRepository;

    @Autowired
    public LocationService(LocationRepository locationRepository, LocationMapper locationMapper, PracticeRepository practiceRepository) {
        this.locationRepository = locationRepository;
        this.locationMapper = locationMapper;
        this.practiceRepository = practiceRepository;
    }

    public LocationResponse createLocationUsingPracticeId(Location location, Long practiceId) {
        PracticeEntity practiceEntity = practiceRepository.findById(practiceId).get();
        List<LocationEntity> locationEntities = practiceEntity.getLocationEntity();
        LocationEntity locationEntity = locationMapper.modelToEntity(location);
        locationEntities.add(locationEntity);
        practiceEntity.setPracticeId(practiceId);
        locationRepository.save(locationEntity);
        LocationResponse locationResponse = new LocationResponse();
        locationResponse.setLocationId(locationEntity.getLocationId());
        log.info("Location Created Successfully With LocationId={}", locationEntity.getLocationId());
        return locationResponse;
    }

    public Location getLocationByLocationId(Long locationId) {
        Optional<LocationEntity> locationEntityOption = locationRepository.findById(locationId);
        Location location = new Location();
        if (locationEntityOption.isPresent()) {
            location = locationMapper.entityToModel(locationEntityOption.get());
            log.info("Location Found With LocationId={}", locationId);

        } else {
            log.info("Location Not Found");
        }
        return location;
    }

    public List<Location> getAllLocationByPracticeId(Long practiceId) {
        PracticeEntity practiceEntity = practiceRepository.findById(practiceId).get();
        List<LocationEntity> locationEntities = practiceEntity.getLocationEntity();
        List<Location> locations = locationMapper.allEntityToModel(locationEntities);
        practiceEntity.setPracticeId(practiceId);
        log.info("Get All Location Using PracticeId={}", practiceId);
        return locations;
    }
}
