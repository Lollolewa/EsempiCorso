package org.generation.italy.esempiCorso.eserciziStream;

import org.generation.italy.esempiCorso.eserciziAI.Veicoli.Auto;

import java.time.LocalDate;
import java.util.*;
import java.util.function.Function;
import java.util.stream.Collector;
import java.util.stream.Collectors;

public class BookRepository {
    private List<Book> libri = List.of(
            new Book(1, "La Fame", 3.5, 1600, 25.00, LocalDate.of(1955, 06, 12), Category.HORROR,
                    List.of(new Autore(1, "Marco", "Falconetti", LocalDate.of(1920, 8, 4), "Italiana", "Bene")), "discreto"),
            new Book(2, "La morte", 1.5, 100, 50.00, LocalDate.of(1975, 06, 12), Category.NARRATIVE,
                    List.of(new Autore(2, "Carlotta", "Pisano", LocalDate.of(1950, 8, 4), "Italiana", "Tedesco")), "Tedesco"),
            new Book(3, "Il giardino segreto", 4.2, 300, 30.50, LocalDate.of(1911, 03, 15), Category.SCIENCE_FICTION,
                    List.of(new Autore(3, "Frances", "Hodgson Burnett", LocalDate.of(1849, 11, 24), "Inglese", "Inglese")), "Inglese"),
            new Book(4, "1984", 4.7, 328, 22.90, LocalDate.of(1949, 06, 8), Category.SCIENCE_FICTION,
                    List.of(new Autore(4, "George", "Orwell", LocalDate.of(1903, 06, 25), "Inglese", "Inglese")), "Inglese"),
            new Book(5, "Il nome della rosa", 4.3, 512, 35.00, LocalDate.of(1980, 9, 01), Category.SCIENCE_FICTION,
                    List.of(new Autore(5, "Umberto", "Eco", LocalDate.of(1932, 01, 05), "Italiana", "Italiano")), "Italiano"),
            new Book(6, "Cent'anni di solitudine", 4.5, 432, 28.50, LocalDate.of(1967, 05, 30), Category.CLASSICS,
                    List.of(new Autore(6, "Gabriel", "García Márquez", LocalDate.of(1927, 03, 06), "Colombiana", "Spagnolo")), "Spagnolo"),
            new Book(7, "Il piccolo principe", 4.8, 96, 15.00, LocalDate.of(1943, 04, 06), Category.CLASSICS,
                    List.of(new Autore(7, "Antoine", "de Saint-Exupéry", LocalDate.of(1900, 06, 29), "Francese", "Francese")), "Francese"),
            new Book(8, "Orgoglio e pregiudizio", 4.6, 432, 20.00, LocalDate.of(1813, 01, 28), Category.CLASSICS,
                    List.of(new Autore(8, "Jane", "Austen", LocalDate.of(1775, 12, 16), "Inglese", "Inglese")), "Inglese"),
            new Book(9, "Il signore degli anelli", 4.9, 1178, 45.00, LocalDate.of(1954, 07, 29), Category.ADVENTURE,
                    List.of(new Autore(9, "J.R.R.", "Tolkien", LocalDate.of(1892, 01, 03), "Inglese", "Inglese")), "Inglese"),
            new Book(10, "Cronache del ghiaccio e del fuoco", 4.4, 694, 38.00, LocalDate.of(1996, 8, 06), Category.ADVENTURE,
                    List.of(new Autore(10, "George R.R.", "Martin", LocalDate.of(1948, 9, 20), "Americana", "Inglese")), "Inglese"));



    public List<Book> findByCategory(Category target){
        return libri.stream().filter(b->b.getCategoria()==target).toList();
    }

    public List<Book> findByTitleLikeAndPublishedBetween(String word, LocalDate start, LocalDate end){
        //ritorna tutti i libri che hanno una data parola (in input) come parte del loro titolo e sono stati pubblicati entro un dato range di date, ordinati per costo decrescente
        var bookBetweenDates = libri.stream().filter(b->b.getDataPubblicazione().isBefore(end) && b.getDataPubblicazione().isAfter(start)).toList(); // lista che contiene libri pubblicati in un determinato periodo
        return bookBetweenDates.stream().filter(b->b.getTitolo().contains(word)).sorted(Comparator.comparingDouble(Book::getCosto)).toList(); //lista che contiene libri per data parola pubblicati nel periodo calcolato sopra
    }

    public double findAvgCostByLanguage(String language){
        //un metodo che restituisce il costo medio per i libri scritti in una data lingua
        var libriInLingua = libri.stream().filter(b->b.getLingua().equals(language)).toList();
        return libriInLingua.stream().mapToDouble(Book::getCosto).sum()/libri.size();
    }

    public List<Book> findByAuthorId(int id){
        //un metodo che restituisce tutti i libri scritti da un autore di cui viene dato l'id
        return libri.stream().filter(b->b.getAutori().stream().anyMatch(Autore -> Autore.getIdNumerico()==id)).toList();
    }
    public List<Book> findByNumAuthor(List<Autore> a){
        //un metodo che restituisca la lista di tutti i libri che hanno piu'di un autore, ordinati per numero di autori decrescente
        return libri.stream().filter(b->b.getAutori().size()>1).sorted(Comparator.comparingInt((Book b)-> b.getAutori().size()).reversed()).toList();
    }
    public List<Autore> findAuthorByCategory(Category c) {
        //un metodo che resituisca la lista di tutti gli autori che hanno mai scritto libri in una data categoria.
        // Gli autori devono essere ordinati per cognome e nome alfabetico e devono apparire nella lista una sola volta.
        return libri.stream().filter(b->b.getCategoria().equals(c)).flatMap(b ->b.getAutori().stream())
                             .sorted(Comparator.comparing(Autore::getCognome).thenComparing(Autore::getNome)).distinct().toList();
    }
    public int findPagesByAuthor(int id){
        //Dammi il numero totale di pagine che sono state scritte dall' autore con un certo ID
        return libri.stream().filter(b -> b.isWrittenBy(id)).mapToInt(Book::getPagine).sum();
    }
    public int findPageByCategory(Category c){
        //Dammi il numero totale di pagine che sono state scritte per una certa categoria di libri
        return libri.stream().filter(b-> b.getCategoria().equals(c)).mapToInt(Book::getPagine).sum();
    }
    public double averageCostByFrenchLanguage(){
        //Dammi il valore medio del prezzo dei libri scritti da un autore che parla la lingua francese
        return libri.stream().filter(b-> b.getAutori().stream()
                        .anyMatch(author -> author.getLingua().contains("Francese")))
                .mapToDouble(Book::getCosto).average().orElse(0);
    }

    //Dammi l'autore che ha scritto piu libri, in caso di pareggio uno a casa va bene
    public Optional<Autore> hasWrittenMoreBooks(){
        //è una struttura dati di coppie chiavi valori uniche, le chiavi sono un set, l'hashmap usa un hashset per tenere le sue chiavi
        Map<String,Integer> map = new HashMap<>(); //creazione di un hashMap
        //il primo valore è una chiave, il secondo indica il valore associato alla chiave

        map.put("Mario Rossi",1);
        map.put("Giulio Verdi",12);
        map.put("Raffaella Gialli",8);
        int c = map.get("Giulio Verdi"); //c vale 12
        //le mappe sono costruite per registrare chiavi in modo che siano facilmente accessibili
        for(String s: map.keySet()) { // ci da il set di chiavi su cui possiamo fare il forEach per scorrere tutte le chiavi della mappa
            System.out.println(s); //stampi tutte le chiavi
            System.out.println(map.get(s)); //stampi tutti i valori associati alle chiavi
        }
        for(int i : map.values()){ //sto ciclando tutti i valori della mappa
            //key set da la colonna delle chiavi // values da la colonna dei valori
            System.out.println(i); //stampa in ordine non prevedibile, in ordine di hashCode
        }
        //il modo più carino per ciclare è ciclare sulle coppie chiave/valore ->entries della mappa
        for(Map.Entry<String,Integer> kv : map.entrySet()) {//l'insieme delle entries è un set perchè le chiavi sono uniche
            //Entry è un interfaccia definitita dentro l'interfaccia Map perchè è relativa soltanto alle mappe
            System.out.println(kv.getKey() + ":" + kv.getValue()); //stampa le coppie
        }




        Optional<Autore> opzAutore = libri.stream().flatMap(b->b.getAutori().stream())
                .collect(Collectors.groupingBy(a->a, Collectors.counting()))//estrazione della chiave dall'autore a all'autore a(Function.identity(),
                                                                            // raggruppa per autore e conta i libri, il valore corrispondente è il numero di volte che viene contato
                .entrySet().stream() // Stream delle entries (la chiave è l'autore, il valore è il numero di volte in cui l'autore è contato
                .max(Map.Entry.comparingByValue()) // comparatore che paragona i valori, Trova l'autore con il numero massimo di libri
                //.max((kv1,kv2)->kv1.getValue().intValue()-kv2.getValue().intValue())//stiamo lavorando con le generics, estraggo la privitiva int dalla Long
                //.max(Comparator.comparingInt(kv->kv.getValue().intValue())) //estrae automaticamente il valore
                .map(Map.Entry::getKey); // estraggo la chiave dalla coppia, ottenendo l'autore (spoiler è un optional, spoiler cambio il tipo di ritorno)
                //orElse deve dare un valore di default dello stesso tipo dell'optional, tornare un autore di default è una porcheria

        return opzAutore;
    }


}