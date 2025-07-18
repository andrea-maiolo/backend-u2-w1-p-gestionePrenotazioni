package andreamaiolo.GestionPrenotazioni.repositories;

import andreamaiolo.GestionPrenotazioni.entities.Bookings;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;

@Repository
public interface BookingsRepo extends JpaRepository<Bookings, Long> {

    //  boolean existsByUserIdAndDateOfBooking(Long userId, LocalDate dateOfBooking);

    //boolean existsByWorkStationIdAndDateOfBooking(Long workStationId, LocalDate dateOfBooking);

    @Query("SELECT COUNT(b) > 0 FROM Booking b WHERE b.userId = :userId AND b.dateOfBooking = :dateOfBooking")
    boolean existsByUserIdAndDateOfBooking(@Param("userId") Long userId,
                                           @Param("dateOfBooking") LocalDate dateOfBooking);

    // Check if workstation is already booked on a specific date
    @Query("SELECT COUNT(b) > 0 FROM Booking b WHERE b.workStation.id = :workStationId AND b.dateOfBooking = :dateOfBooking")
    boolean existsByWorkStationIdAndDateOfBooking(@Param("workStationId") Long workStationId,
                                                  @Param("dateOfBooking") LocalDate dateOfBooking);

}
