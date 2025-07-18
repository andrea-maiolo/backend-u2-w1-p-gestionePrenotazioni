package andreamaiolo.GestionPrenotazioni.repositories;

import andreamaiolo.GestionPrenotazioni.entities.Bookings;
import andreamaiolo.GestionPrenotazioni.entities.User;
import andreamaiolo.GestionPrenotazioni.entities.WorkStation;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.List;

@Repository
public interface BookingsRepo extends JpaRepository<Bookings, Long> {

    List<Bookings> findByDateOfBookingAndUserId(LocalDate date, User user);

    List<Bookings> findByDateOfBookingAndWorkStationId(LocalDate date, WorkStation ws);
}
