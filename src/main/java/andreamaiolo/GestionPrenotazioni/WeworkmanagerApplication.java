package andreamaiolo.GestionPrenotazioni;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class WeworkmanagerApplication {

    public static void main(String[] args) {
        SpringApplication.run(WeworkmanagerApplication.class, args);

    }

//    Si deve realizzare un applicativo per la gestione delle prenotazioni delle postazioni aziendali.
//    Ogni postazione è identificata da un codice univoco, una descrizione, un tipo [PRIVATO, OPENSPACE, SALA RIUNIONI],
//    un numero massimo di occupanti ed un edificio. L'edificio ha un nome, un indirizzo ed una città.
//    Una postazione può essere prenotata da un utente, che è identificato da uno username, un nome completo ed una email.
//    La prenotazione vale per un solo giorno e può essere effettuata solo se per quel giorno la postazione risulta libera.
//    Un utente può ricercare le postazioni indicando il tipo di postazione desiderato e la città di interesse.
//    Un utente può avere più prenotazioni in corso, ma non può prenotare più di una postazione per una particolare data.
//
//    Realizzare un’applicazione Spring Boot, denominata GestionePrenotazioni, ed implementare il
//    modello dei dati necessario a realizzare l'applicazione. Implementare la persistenza
//    utilizzando Spring Data JPA, realizzando database e repositories necessari, oltre al
//    mapping delle entities persistenti.
//

}
