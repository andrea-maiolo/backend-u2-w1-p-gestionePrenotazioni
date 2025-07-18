package andreamaiolo.GestionPrenotazioni.services;

import andreamaiolo.GestionPrenotazioni.entities.Bookings;
import andreamaiolo.GestionPrenotazioni.exceptions.NotfoundException;
import andreamaiolo.GestionPrenotazioni.exceptions.ValidationException;
import andreamaiolo.GestionPrenotazioni.repositories.BookingsRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BookingService {
    @Autowired
    private BookingsRepo bookingsRepo;

    public void saveBooking(Bookings bookingToSave) {


        List<Bookings> bookingByDate = bookingsRepo.findByDateOfBookingAndUserId(bookingToSave.getDateOfBooking(),
                bookingToSave.getUserId());
        System.out.println(bookingByDate);

        if (bookingByDate.size() > 0) {
            throw new ValidationException("user has already a booking");
        } else {
            List<Bookings> bookingByWorkStationAndDate = bookingsRepo.findByDateOfBookingAndWorkStationId(bookingToSave.getDateOfBooking(),
                    bookingToSave.getWorkStationId());
            System.out.println(bookingByDate);

            if (bookingByWorkStationAndDate.size() > 0) {
                throw new ValidationException("work station already booked on this date");
            } else {
                bookingsRepo.save(bookingToSave);
            }
        }

    }

    public Bookings findById(long id) {
        return bookingsRepo.findById(id).orElseThrow(() -> new NotfoundException("cannot find anything"));
    }

    public void deleteBooking(long id) {
        Bookings booking = this.findById(id);
        bookingsRepo.delete(booking);
        System.out.println("booking deleted");
    }

    public List<Bookings> findAll() {
        return bookingsRepo.findAll();
    }
}
