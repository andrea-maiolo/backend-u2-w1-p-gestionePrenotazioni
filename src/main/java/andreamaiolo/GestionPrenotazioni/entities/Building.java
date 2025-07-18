package andreamaiolo.GestionPrenotazioni.entities;

import jakarta.persistence.*;

import java.util.List;


@Entity
@Table(name = "buildings")
public class Building {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private long id;
    private String name;
    private String address;
    private String city;

    @OneToMany(mappedBy = "building")
    private List<WorkStation> workStationsInBuilding;

    public Building() {
    }

    public Building(String name, String address, String city) {
        this.name = name;
        this.address = address;
        this.city = city;
    }

    public long getId() {
        return id;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "Building{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", address='" + address + '\'' +
                ", city='" + city + '\'' +
                '}';
    }
}
