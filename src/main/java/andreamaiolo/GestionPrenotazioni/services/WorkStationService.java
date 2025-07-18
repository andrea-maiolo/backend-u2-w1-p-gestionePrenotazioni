package andreamaiolo.GestionPrenotazioni.services;

import andreamaiolo.GestionPrenotazioni.entities.WorkStation;
import andreamaiolo.GestionPrenotazioni.exceptions.NotfoundException;
import andreamaiolo.GestionPrenotazioni.repositories.WorkStationRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class WorkStationService {
    @Autowired
    private WorkStationRepo workStationRepo;

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
}
