package andreamaiolo.GestionPrenotazioni.entities;

import jakarta.persistence.*;

import java.time.LocalDate;

@Entity
public class Bookings {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private long id;

    @ManyToOne
    private WorkStation workStationId;

    @ManyToOne
    private User userId;

    private LocalDate dateOfBooking;


    public Bookings() {
    }

    public Bookings(User userId, WorkStation workStationId, LocalDate dateOfBooking) {
        this.userId = userId;
        this.workStationId = workStationId;
        this.dateOfBooking = dateOfBooking;
    }

    public long getId() {
        return id;
    }

    public WorkStation getWorkStationId() {
        return workStationId;
    }

    public void setWorkStationId(WorkStation workStationId) {
        this.workStationId = workStationId;
    }

    public User getUserId() {
        return userId;
    }

    public void setUserId(User userId) {
        this.userId = userId;
    }

    public LocalDate getDateOfBooking() {
        return dateOfBooking;
    }

    public void setDateOfBooking(LocalDate dateOfBooking) {
        this.dateOfBooking = dateOfBooking;
    }

    @Override
    public String toString() {
        return "Bookings{" +
                "id=" + id +
                ", workStationId=" + workStationId.getId() +
                ", userId=" + userId.getName() +
                ", dateOfBooking=" + dateOfBooking +
                '}';
    }
}
