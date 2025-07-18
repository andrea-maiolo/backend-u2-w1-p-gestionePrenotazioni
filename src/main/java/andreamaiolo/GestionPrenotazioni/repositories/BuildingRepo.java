package andreamaiolo.GestionPrenotazioni.repositories;

import andreamaiolo.GestionPrenotazioni.entities.Building;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BuildingRepo extends JpaRepository<Building, Long> {

    boolean existsByAddressIgnoreCase(String address);
}
