package org.generation.italy.esempiCorso.airport.model;

import java.util.List;

public class Airport {
    private int airportID;
    private String airportName;
    private List<Passenger> passengers;

    public Airport (int airportID, String name, List<Passenger> passengers) {
        this.airportID = airportID;
        this.airportName = name;
        this.passengers = passengers;
    }

    public int getAirportID() {
        return airportID;
    }

    public String getAirportName() {
        return airportName;
    }

    @Override
    public String toString() {
        return "airportID: " + airportID + "\n" +
                "airportName: '" + airportName + "\n";
    }
}


/*creare una classe areoporto con id numnerico , un nome e una lista di passengeri,
un passengero e'una cosa che ha un id numerico , un nome , un aereoporto di riferimento,
e una lista di tickets,
un ticket ha un id numerico, una stringa che e' il suo codice,
e un riferimento al passengero a cui appartiene


* creare un applicazione da linea di comando che permette di :
- [ ] ricercare un biglietto per codice
- [ ] mostrare tutti i biglietti di una persona di cui si da in input l id
- [ ] creare un nuovo biglietto per un passengero esistente
- [ ] mostrare i passengeri per numero di biglietti mai comprati in ordine decresente,
- [ ] cancellare un passengero per id
poi vediamo... ora che sicuramente l avete finito...
*  aggiungere all applicazione un altro repository,
che implementa la stessa intefaccia del primo, ma invece che gestire i dati con un DB
li mantiene in una struttura dati in memoria e fa le ricerche usando solo stream e niente cicli for...
* infine pensate al modo piu' elegante possibile per poter switchare da un repository all altro
cambiando meno codice possibile.
 */