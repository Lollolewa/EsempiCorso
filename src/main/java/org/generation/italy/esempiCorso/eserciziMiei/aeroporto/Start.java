package org.generation.italy.esempiCorso.eserciziMiei.aeroporto;

import org.generation.italy.esempiCorso.eserciziMiei.aeroporto.entities.Ticket;
import org.generation.italy.esempiCorso.sql.DatabaseConnection;
import org.generation.italy.esempiCorso.sql.dao.DaoException;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.Scanner;

public class Start {
//    public static Scanner sc = new Scanner(System.in);
//
//    public static void main(String[] args) throws DaoException {
//        interfacciaUtente();
//    }
//
//    public static void interfacciaUtente() throws DaoException{
//        Optional<Connection> optCon = DatabaseConnection.getConnection();
//        if(optCon.isEmpty()){
//            System.out.println("Problema nella creazione della connessione");
//            return;
//        }
//        System.out.println("Benvenuta/o al sistema di gestione degli aeroporti!\n");
//        int risposta;
//        do{
//            System.out.println("Le operazioni eseguibili sono:\n1 - Visualizza Ticket da codice\n" +
//                    "2 - Visualizza Tickets tramite ID passeggero\n3 - Crea nuovo Ticket\n4 - Rimuovi Passeggero tramite ID passeggero\n" +
//                    "Inserire l'operazione da eseguire: ");
//            risposta = sc.nextInt();
//            sc.nextLine();
//        }while(risposta != 1 && risposta != 2 && risposta != 3 && risposta != 4);
//        switch(risposta){
//            case 1:
//                try(Connection connection = optCon.get()){
//                    AeroportoDaoJdbc aeroporto = new AeroportoDaoJdbc(connection);
//                    // VISUALIZZA TICKET DA CODICE
//                    System.out.println("\nInserire il codice del ticket da visualizzare: ");
//                    String codice = sc.nextLine();
//                    Optional<Ticket> ticket = aeroporto.getTicketByCode(codice);
//                    System.out.println(Optional.of(ticket).toString());
//                } catch (SQLException e) {
//                    throw new DaoException(e.getMessage(), e);
//                }
//                break;
//            case 2:
//                try(Connection connection = optCon.get()){
//                    List<Ticket> tickets = new ArrayList<>();
//                    AeroportoDaoJdbc aeroporto = new AeroportoDaoJdbc(connection);
//                    // VISUALIZZA TICKETS TRAMITE ID PASSEGGERO
//                    System.out.println("\nInserire l'ID del passeggero: ");
//                    int id = sc.nextInt();
//                    tickets = aeroporto.getPassengerTicketsById(id);
//                    System.out.println(tickets.toString());
//                } catch (SQLException e) {
//                    throw new DaoException(e.getMessage(), e);
//                }
//                break;
//            case 3:
//                try(Connection connection = optCon.get()){
//                    AeroportoDaoJdbc aeroporto = new AeroportoDaoJdbc(connection);
//                    // CREAZIONE NUOVO TICKET
//                    System.out.println("\nInserire il codice del ticket da creare: ");
//                    String codice = sc.nextLine();
//                    System.out.println("\nInserire l'ID del passeggero collegato a questo Ticket (deve essere un passeggero già esistente: ");
//                    int id = sc.nextInt();
//                    sc.nextLine();
//                    Ticket ticket = new Ticket(codice,  id);
//                    //lo aggiungo al database (senza l'id perchè viene autogenerato nel database)
//                    Optional<Ticket> nuovoTicket = aeroporto.createNewTicket(ticket);
//                    if (nuovoTicket.isPresent()) {
//                        System.out.printf("Ticket creato con successo:%nID: %d%nCodice: %s%n", nuovoTicket.get().getId(), nuovoTicket.get().getCode());
//                    } else {
//                        System.out.println("Problema nella creazione del ticket");
//                    }
//                } catch (SQLException e) {
//                    throw new DaoException(e.getMessage(), e);
//                }
//                break;
//            case 4:
//                try(Connection connection = optCon.get()){
//                    AeroportoDaoJdbc aeroporto = new AeroportoDaoJdbc(connection);
//                    // RIMUOVI PASSEGGERO TRAMITE ID PASSEGGERO
//                    System.out.println("\nInserire l'ID del passeggero: ");
//                    int id = sc.nextInt();
//                    if(aeroporto.removePassengerById(id)){
//                        System.out.println("Passeggero rimosso con successo!");
//                    } else{
//                        System.out.println("Non e' stato possibile rimuovere il passeggero.");
//                    }
//                } catch (SQLException e) {
//                    throw new DaoException(e.getMessage(), e);
//                }
//                break;
//        }
//    }
}
