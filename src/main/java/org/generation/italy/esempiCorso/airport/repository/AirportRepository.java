package org.generation.italy.esempiCorso.airport.repository;

import org.generation.italy.esempiCorso.airport.model.Passenger;
import org.generation.italy.esempiCorso.airport.model.Ticket;

import java.sql.SQLException;
import java.util.HashMap;
import java.util.List;
import java.util.Optional;

public interface AirportRepository {

}
//ERRORE, UN DAO PER OGNI ENTITà


//* creare un applicazione da linea di comando che permette di :
//- [ ] ricercare un biglietto per codice
//- [ ] mostrare tutti i biglietti di una persona di cui si da in input l id
//- [ ] creare un nuovo biglietto per un passengero esistente
//- [ ] mostrare i passengeri per numero di biglietti mai comprati in ordine decresente,
//- [ ] cancellare un passengero per id