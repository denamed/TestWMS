package com.denamed.TestWMS.services;

import com.denamed.TestWMS.entities.Building;
import com.denamed.TestWMS.repositories.BuildingRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BuildingService {

    private final BuildingRepository buildingRepository;

    @Autowired
    public BuildingService(BuildingRepository buildingRepository) {
        this.buildingRepository = buildingRepository;
    }

    public List<Building> findAll(){
        return buildingRepository.findAll();
    }

    public Building addBuilding(Building building) throws Exception{
        if(buildingRepository.existsById(building.getBuildId())) {
            throw new Exception("<style>.alert {color: #FF3300;}</style><h2 class=\"alert\">Building with id " + building.getBuildId() + " already exists</h2>");
        } else {
            return buildingRepository.save(building);
        }
    }

    public void deleteBuilding(int buildId){
        buildingRepository.deleteById(buildId);
    }

}
