package andreamaiolo.GestionPrenotazioni.repositories;

import andreamaiolo.GestionPrenotazioni.entities.Bookings;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;

@Repository
public interface BookingsRepo extends JpaRepository<Bookings, Long> {
    boolean existsByDateOfBooking(LocalDate dateToCheck);
}
