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
        //get user bokkings
//        List<Bookings> allTheBookingsByUser = bookingsRepo.findByUserId(bookingToSave.getUserId().getId());
//        //check dates
//        bookingsRepo.existsByDateOfBooking(allTheBookingsByUser.stream()
//                .map(booking -> LocalDate l = booking.getDateOfBooking()))

        boolean userHasBooking = bookingsRepo.existsByUserIdAndDateOfBooking(bookingToSave.getUserId().getId(),
                bookingToSave.getDateOfBooking());
        if (userHasBooking) {
            throw new ValidationException("user already has  abooking");
        } else {
            bookingsRepo.save(bookingToSave);
            System.out.println("b saved!!!!!!!!!!!!");
        }


        //check user doestn have a booking already
//        List<Long> listOfUsersId = allTheBookingsByUser.stream()
//                .map(booking -> booking.getUserId().getId())
//                .toList();
//
//
//
//        if(!userHasBookingAlready){
//            boolean wsNotAvailable = bookingsRepo.
//
//        }else throw new ValidationException("user already has a booking on this date");
//
//
//
//        boolean bookingNotAvailable = bookingsRepo.existsByDateOfBooking(bookingToSave.getDateOfBooking());
//        if (!bookingNotAvailable) {
//            bookingsRepo.save(bookingToSave);
//            System.out.println("booking saved in db!");
//        } else throw new ValidationException("sorry the work space is not available on this date");

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
