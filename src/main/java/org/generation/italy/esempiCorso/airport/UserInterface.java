package org.generation.italy.esempiCorso.airport;

import org.generation.italy.esempiCorso.airport.model.Passenger;
import org.generation.italy.esempiCorso.airport.model.Ticket;
import org.generation.italy.esempiCorso.airport.repository.AirportRepository;
import org.generation.italy.esempiCorso.airport.repository.AirportRepositoryJDBC;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.*;
import org.apache.commons.lang3.RandomStringUtils;
import org.generation.italy.esempiCorso.airport.repository.PassengerRepository;
import org.generation.italy.esempiCorso.airport.repository.TicketRepository;

public class UserInterface {
    Scanner sc = new Scanner(System.in);
    Connection connection;
    TicketRepository ticketRepJDBC;
    PassengerRepository passengerRepJDBC;

    public UserInterface(Connection connection, TicketRepository ticketRepJDBC, PassengerRepository passengerRepJDBC) {
        this.connection = connection;
        this.ticketRepJDBC = ticketRepJDBC;
        this.passengerRepJDBC = passengerRepJDBC;
    }

    public void begin() throws Exception {
        int response = 0;
        do {
            System.out.println("Benvenuto! seleziona un numero per compiere l'operazione desiderata:\n" +
                    "1: ricercare un biglietto per codice\n" +
                    "2: mostrare tutti i biglietti di una persona con un certo id\n" +
                    "3: creare un nuovo biglietto per un passengero esistente\n" +
                    "4: mostrare i passengeri per numero di biglietti mai comprati\n" +
                    "5: cancellare un passengero per id\n" +
                    "6: esci\n");
            response = sc.nextInt();
            sc.nextLine();

            switch (response) {
                case 1:
                    getTicketByCode();
                    break;
                case 2:
                    showPassengerTickets();
                    break;
                case 3:
                    createNewTicketForPassenger();
                    break;
                case 4:
                    showNumTicketsAllPassengers();
                    break;
                case 5:
                    deleteByID();
                    break;
            }
        } while (response != 6);
        System.out.println("Goodbye.");
    }
    public void getTicketByCode() throws Exception {
        System.out.println("inserisci il codice da cercare nel db:");
        String code = sc.nextLine();
        Optional<Ticket> ticket = ticketRepJDBC.searchTicketByCode(code);
        if (ticket.isEmpty()) {
            System.out.println("codice non trovato, riprovare:");
            return;
        }
        Ticket t = ticket.get();
        System.out.println(ticket);
    }
    public void showPassengerTickets() throws Exception {
        System.out.println("inserisci l'id del passeggero di cui vuoi vedere i biglietti:");
        int id = sc.nextInt();
        sc.nextLine();
        List<Ticket> passengerTickets = ticketRepJDBC.getPassengersTikets(id);
        System.out.println(passengerTickets);
    }
    public void createNewTicketForPassenger() throws Exception {
        System.out.println("inserisci l'id del passeggero per cui vuoi creare un nuovo biglietto:");
        int passengerID = sc.nextInt();
        sc.nextLine();
        Random r = new Random();
        //int ticketCode = r.nextInt(1000); //e se esiste già uno con quel codice?
        String newRandomCode = RandomStringUtils.random(10, true, true);
        Ticket newTicket = ticketRepJDBC.createNewPassengerTicket(newRandomCode, passengerID);
        System.out.println(newTicket);
    }
    public void showNumTicketsAllPassengers() throws Exception {
        HashMap<Passenger,Integer> numTicketsAllPassengers = passengerRepJDBC.findAllOrderByNumTickets();
        numTicketsAllPassengers.forEach((key, value) -> System.out.println(key + "numero di biglietti acquistati: " + value + "\n"));
    }
    public void deleteByID() throws Exception {
        System.out.println("inserisci l'id del passeggero che vuoi eliminare:");
        int delID = sc.nextInt();
        sc.nextLine();
        boolean didRemove = passengerRepJDBC.deletePassengerByID(delID);
        if (didRemove) {
            System.out.println("Passeggero eliminato");
            return;
        }
        System.out.println("ID non trovato, riprovare.");
    }
}


/* creare un applicazione da linea di comando che permette di :
        - [ ] ricercare un biglietto per codice
- [ ] mostrare tutti i biglietti di una persona di cui si da in input l id
- [ ] creare un nuovo biglietto per un passengero esistente
- [ ] mostrare i passengeri per numero di biglietti mai comprati in ordine decresente,
- [ ] cancellare un passengero per id*/