package andreamaiolo.GestionPrenotazioni.services;

import andreamaiolo.GestionPrenotazioni.entities.Building;
import andreamaiolo.GestionPrenotazioni.exceptions.NotfoundException;
import andreamaiolo.GestionPrenotazioni.exceptions.ValidationException;
import andreamaiolo.GestionPrenotazioni.repositories.BuildingRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BuildingService {
    @Autowired
    private BuildingRepo buildingRepo;

    public void saveBuilding(Building buildingToSave) {
        boolean buildingInDb = buildingRepo.existsByAddressIgnoreCase(buildingToSave.getAddress());
        if (!buildingInDb) {
            buildingRepo.save(buildingToSave);
            System.out.println("building saved in db!");
        } else throw new ValidationException("building at this address is already registred");
    }

    public Building findById(long id) {
        return buildingRepo.findById(id).orElseThrow(() -> new NotfoundException("cannot find anything"));
    }

    public void deleteBuilding(long id) {
        Building building = this.findById(id);
        buildingRepo.delete(building);
        System.out.println("building deleted");
    }

    public List<Building> findAll() {
        return buildingRepo.findAll();
    }

    public List<Building> findByCityName(String city) {
        return buildingRepo.findByCityIgnoreCase(city);
    }
}
