package andreamaiolo.GestionPrenotazioni.services;

import andreamaiolo.GestionPrenotazioni.entities.Building;
import andreamaiolo.GestionPrenotazioni.entities.WorkStation;
import andreamaiolo.GestionPrenotazioni.enums.WorkstationType;
import andreamaiolo.GestionPrenotazioni.exceptions.NotfoundException;
import andreamaiolo.GestionPrenotazioni.repositories.WorkStationRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class WorkStationService {
    @Autowired
    private WorkStationRepo workStationRepo;

    @Autowired
    private BuildingService buildingService;

    public void saveWs(WorkStation wsToSave) {
        workStationRepo.save(wsToSave);
        System.out.println("ws saved in db!");
    }

    public WorkStation findById(long id) {
        return workStationRepo.findById(id).orElseThrow(() -> new NotfoundException("cannot find anything"));
    }

    public void deleteWs(long id) {
        WorkStation workStation = this.findById(id);
        workStationRepo.delete(workStation);
        System.out.println("ws deleted");
    }

    public List<WorkStation> findAll() {
        return workStationRepo.findAll();
    }

    public List<WorkStation> findByType(String type) {
        String tUpperCase = type.toUpperCase();
        WorkstationType typeToSearch = WorkstationType.valueOf(tUpperCase);
        return workStationRepo.findByType(typeToSearch);
    }

    public List<WorkStation> findByBuildingId(long buildingId) {
        return workStationRepo.findByBuildingId(buildingId);
    }

//added after 5
    public List<WorkStation> findByCity(String city) {
        List<Building> buildingInCity = buildingService.findByCityName(city);
        List<WorkStation> wsInCity = buildingInCity.stream()
                .flatMap(building -> this.findByBuildingId(building.getId()).stream())
                .toList();

        System.out.println(wsInCity);
        return wsInCity;
    }

}
