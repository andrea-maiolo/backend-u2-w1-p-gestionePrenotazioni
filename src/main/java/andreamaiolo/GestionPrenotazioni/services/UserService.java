package andreamaiolo.GestionPrenotazioni.services;

import andreamaiolo.GestionPrenotazioni.entities.User;
import andreamaiolo.GestionPrenotazioni.exceptions.NotfoundException;
import andreamaiolo.GestionPrenotazioni.repositories.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {
    @Autowired
    private UserRepo userRepo;

    public void saveUser(User userToSave) {
        userRepo.save(userToSave);
        System.out.println("user saved in db!");
    }

    public User findById(long id) {
        return userRepo.findById(id).orElseThrow(() -> new NotfoundException("cannot find anything"));
    }

    public void deleteUser(long id) {
        User u = this.findById(id);
        userRepo.delete(u);
        System.out.println("user deleted");
    }

    public List<User> findAll() {
        return userRepo.findAll();
    }
}
