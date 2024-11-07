package org.generation.italy.esempiCorso.sql.aereoporto.ui;

import org.generation.italy.esempiCorso.sql.aereoporto.entities.Passenger;
import org.generation.italy.esempiCorso.sql.aereoporto.services.AbstractReservationService;

public class UserInterface {
    private AbstractReservationService service;

    public void setService(AbstractReservationService service) {
        this.service = service;
    }

    /// iniezione della dipendenza AbstractReservationService
    /// inversione del controllo (sinonimo)
    public UserInterface(AbstractReservationService s){
        this.service = s;
    }

    public void findPassenger(){
        String code = "abc";
        String passengerName = "Ciccio";
        Passenger p = service.findPassengerByTicketCode(code, passengerName);
    }
}
