package andreamaiolo.GestionPrenotazioni.services;

import andreamaiolo.GestionPrenotazioni.entities.Bookings;
import andreamaiolo.GestionPrenotazioni.exceptions.NotfoundException;
import andreamaiolo.GestionPrenotazioni.repositories.BookingsRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BookingService {
    @Autowired
    private BookingsRepo bookingsRepo;

    public void saveBooking(Bookings bookingToSave) {
        bookingsRepo.save(bookingToSave);
        System.out.println("booking saved in db!");
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
