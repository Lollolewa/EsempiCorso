package org.generation.italy.esempiCorso.eserciziStream;

import java.time.LocalDate;
import java.util.Comparator;
import java.util.List;

public class BookRepository {
    private List<Book> libri = List.of(new Book (1,"angeli e demoni", 3,1000,17.40, LocalDate.of(2000,6,15),Category.HORROR,
                            List.of(new Autore(145,"Marco","Falconetti", LocalDate.of(1998,8,4),"iraniana","polacca")),"romano"),
                            new Book (2,"il codice da Vinci", 2,1500,12.30, LocalDate.of(1995,2,19),Category.SCIENCE_FICTION,
                            List.of(new Autore(212,"Gianluca","Pricopie", LocalDate.of(1997,12,19),"afgana","restiamoDiscreti")),"tedesco"));


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
    //public List<Book> findAuthorByCategory(List<Autore> a, Category c) {
        //un metodo che resituisca la lista di tutti gli autori che hanno mai scritto libri in una data categoria.
        // Gli autori devono essere ordinati per cognome e nome alfabetico e devono apparire nella lista una sola volta.
        //return libri.stream().filter(b->b.getCategoria().equals(c)).map(Book::getAutori).distinct().sorted(Comparator.comparing(Autore::getNome)).toList();

    //}

}
