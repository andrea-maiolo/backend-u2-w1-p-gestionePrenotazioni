package andreamaiolo.GestionPrenotazioni.repositories;

import andreamaiolo.GestionPrenotazioni.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepo extends JpaRepository<User, Long> {

    boolean existsByEmailIgnoreCase(String email);
}
