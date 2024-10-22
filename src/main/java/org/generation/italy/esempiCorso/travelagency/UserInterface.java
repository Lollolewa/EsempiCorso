package org.generation.italy.esempiCorso.travelagency;

import java.sql.SQLOutput;
import java.time.LocalDate;
import java.util.*;

public class UserInterface {
    private AbstractVoyageRepository repository = new VoyageRepository();
    Scanner sc = new Scanner(System.in);
    public void begin() {

        sc.useLocale(Locale.US); //usa il punto per i double
        int scelta;
        do { //fare ua funzione che stampa il menu con il text block
            System.out.println("Benvenuto nell'agenzia viaggi. Cosa vuoi fare? \n " +
                    "1. Creare un viaggio \n " +
                    "2. Cancellare un viaggio \n " +
                    "3. Consultare la lista di tutte le offerte viaggio attive \n " +
                    "4. Consultare la lista di tutte le offerte che sono relative a una data destinazione \n " +
                    "5. Consultare la lista di tutte le offerte di viaggio attive che contengono nel nome una data parola \n " +
                    "6. Consultare la lista di tutte le offerte di viaggio in una data categoria e con un numero di destinazioni \n " +
                    "7. Uscire. ");

            scelta = sc.nextInt();
            sc.nextLine();
            if (scelta == 1) { //sostituire con lo switch
               createVoyage();
            }
            else if (scelta == 2) { //2. Cancellare un viaggio " +
                deleteVoyage();
            }
            else if (scelta == 3) { //3. Consultare la lista di tutte le offerte viaggio attive \n
                //System.out.println(repository.findActiveVoyages());
                //FATTO COL CULO
                showVoyages(repository.findActiveVoyages());
            }
            else if (scelta == 4) {//4. Consultare la lista di tutte le offerte che sono relative a una data destinazione
                showVoyagesByDestination();
            }
            else if (scelta == 5) {//5. Consultare la lista di tutte le offerte di viaggio attive che contengono nel nome una data parola \n
                showVoyagesByWord();
            }
            else if (scelta == 6) {//"6. Consultare la lista di tutte le offerte di viaggio in una data categoria e con un numero di destinazioni\n
                showVoyagesByCatAndDest();
            }
            else if (scelta == 7){
                System.out.println("Grazie e arrivederci!");
            }
            else{
                System.out.println("Scelta non valida.");
            }
        }while(scelta !=7);
    }

    private void createVoyage() {
        List<Destination> newDes = new ArrayList<>();
        List<String> ristoranti = new ArrayList<>();
        List<String> attivita = new ArrayList<>();
        String altriRist,altreAtt,altreDes,risp;
        Voyage v;
        do {
            do {
                String name = getLine("Creiamo una destinazione. Inserisci il nome");

                do {
                    String rist = getLine("Inserisci il ristorante");
                    ristoranti.add(rist);

                    altriRist = getLine("Vuoi inserirne altri?");

                } while (altriRist.equals("si"));

                String descr = getLine("inserisci la descrizione.");

                String nomeH = getLine("inserisci il nome della struttura in cui pernottare");

                int giorni = getInt("Quanti giorni vuoi stare in questa destinazione?");

                do {
                    String att = getLine("Inserisci le attivita");
                    attivita.add(att);

                    altreAtt = getLine("Vuoi inserirne altri?");
                } while (altreAtt.equals("si"));


                altreDes = getLine("Vuoi inserire altre destinazioni? si/no");

                Destination nuovaD = new Destination(name, ristoranti, descr, nomeH, giorni, attivita);
                newDes.add(nuovaD);
            } while (altreDes.equals("si"));

            double price = getDouble("Inserisci il prezzo");


            LocalDate partenza = getDate("Inserisci la data di partenza. YYYY-MM-DD");

            int durataViaggio = 0;
            for(Destination d : newDes){
                durataViaggio +=d.getNumGiorni();
            }

            LocalDate ritorno = partenza.plusDays(durataViaggio);
            System.out.println("La data di ritorno e': " + ritorno);

            Category target = getCategoryFromUser();

            v = new Voyage(newDes, price, partenza, ritorno, target);

            risp = getLine("Vuoi creare un altro viaggio? si/no");
        } while (risp.equals("si"));
        repository.create(v);
    }

    private void deleteVoyage(){
        int id = getInt("Quale viaggio vuoi cancellare? Inserisci l'id.");

        boolean success = repository.delete(id);
        if(success){
            System.out.println("Viaggio cancellato");
        }
        else{
            System.out.println("Id non riconosciuto.");
        }
    }
    private void showVoyages(Collection<Voyage> voyages) {
        for( Voyage v : voyages){
            System.out.println(v);
        }
    }
    private void showVoyagesByDestination(){
        String dest = getLine("A quale destinazione sei interessato/a?");
        showVoyages(repository.findByDestinationName(dest));
    }
    private void showVoyagesByWord() {
        String parola = getLine("Quale parola vuoi cercare all'interno della lista delle offerte di viaggio attive");
        showVoyages(repository.findActiveVoyagesByWord(parola));
    }
    private void showVoyagesByCatAndDest() {
        Category target = getCategoryFromUser();
        int numDest = getInt("Qual è il numero minimo di destinazioni che vuoi visitare?");
        showVoyages(repository.findByCategoriesAndDuration(target, numDest));
    }
    private Category getCategoryFromUser(){
        int categoria;
        do {
            categoria = getInt("Inserisci la categoria. 1. luxury/ 2. comfort/ 3. budget/ 4. backpacker");

        } while(categoria > 5 || categoria<=0);
        return Category.fromInteger(categoria);
    }
    private String getLine(String prompt){
        System.out.print(prompt+">");
        return sc.nextLine();
    }
    private LocalDate getDate(String prompt){
        System.out.print(prompt+">");
        return LocalDate.parse(sc.nextLine());
    }
    private double getDouble(String prompt){
        System.out.print(prompt+">");
        double d = sc.nextDouble();
        sc.nextLine();
        return d;
    }
    private int getInt(String prompt){
        System.out.print(prompt+">");
        int i = sc.nextInt();;
        sc.nextLine();
        return i;
    }
}
