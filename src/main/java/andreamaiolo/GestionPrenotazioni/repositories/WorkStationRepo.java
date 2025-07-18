package andreamaiolo.GestionPrenotazioni.repositories;

import andreamaiolo.GestionPrenotazioni.entities.WorkStation;
import andreamaiolo.GestionPrenotazioni.enums.WorkstationType;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface WorkStationRepo extends JpaRepository<WorkStation, Long> {

    List<WorkStation> findByType(WorkstationType type);
}
