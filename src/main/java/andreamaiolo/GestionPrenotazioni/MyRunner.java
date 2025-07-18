package andreamaiolo.GestionPrenotazioni;

import andreamaiolo.GestionPrenotazioni.entities.Bookings;
import andreamaiolo.GestionPrenotazioni.entities.Building;
import andreamaiolo.GestionPrenotazioni.entities.User;
import andreamaiolo.GestionPrenotazioni.entities.WorkStation;
import andreamaiolo.GestionPrenotazioni.enums.WorkstationType;
import andreamaiolo.GestionPrenotazioni.services.BookingService;
import andreamaiolo.GestionPrenotazioni.services.BuildingService;
import andreamaiolo.GestionPrenotazioni.services.UserService;
import andreamaiolo.GestionPrenotazioni.services.WorkStationService;
import com.github.javafaker.Faker;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.time.LocalDate;
import java.util.List;
import java.util.Locale;
import java.util.function.Supplier;

@Component
public class MyRunner implements CommandLineRunner {
    private final Faker faker = new Faker(Locale.ITALY);
    @Autowired
    private UserService userService;
    @Autowired
    private BookingService bookingService;
    @Autowired
    private BuildingService buildingService;
    @Autowired
    private WorkStationService workStationService;

    @Override
    public void run(String... args) throws Exception {
//fill db
        Supplier<User> userSupplier = () -> {
            User newUser = new User(faker.name().firstName(), faker.internet().emailAddress(), faker.name().lastName());
            return newUser;
        };

//        for (int i = 0; i < 20; i++) {
//            userService.saveUser(userSupplier.get());
//        }

        Supplier<Building> buildingSupplier = () -> {
            Building newBuilding = new Building(faker.address().firstName(), faker.address().fullAddress(), faker.address().cityName());
            return newBuilding;
        };

//        for (int i = 0; i < 20; i++) {
//            buildingService.saveBuilding(buildingSupplier.get());
//        }

        List<Building> allBuildings = buildingService.findAll();


        Supplier<WorkStation> wsSupplier = () -> {
            WorkStation newWs = new WorkStation(faker.lorem().sentence(5), faker.number().randomDigitNotZero(),
                    allBuildings.get(faker.random().nextInt(allBuildings.size())),
                    WorkstationType.values()[faker.random().nextInt(WorkstationType.values().length)]);
            return newWs;
        };

//
//        for (int i = 0; i < 20; i++) {
//            workStationService.saveWs(wsSupplier.get());
//        }

        //cant add existing users or buildings
//        User check = new User("test", "AmeDeo.palmieri@libero.it", "test");
//        userService.saveUser(check);
//        Building check2 = new Building("dhjdj", "piano 6 via ercole 1, lia calabro, CS 56702", "dsjhf");
//        buildingService.saveBuilding(check2);


        User userfromDb = userService.findById(3);
        WorkStation wsFromDb = workStationService.findById(53);

        //search by tupe
//        List<WorkStation> wsByOpenspace = workStationService.findByType("og45");
//        System.out.println(wsByOpenspace);

        //search by city name
        List<WorkStation> wsInCity = buildingService.findByCityName("zelida sardo")
                .stream()
                .flatMap(building -> workStationService.findByBuildingId(building.getId()).stream())
                .toList();
        System.out.println(wsInCity);

        Bookings newB2 = new Bookings(userfromDb, wsFromDb, LocalDate.of(2025, 01, 03));
        bookingService.saveBooking(newB2);
    }
}
