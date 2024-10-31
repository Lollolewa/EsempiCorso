package org.generation.italy.esempiCorso.inheritance.stream;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class BookRepository {
    private List<Book> books = new ArrayList<>();

    public void addBook(Book book) {
        books.add(book);
    }

    public List<Book> findByCategory(Category target){
        return books.stream().filter(book -> book.getCategoria()== target).toList();
    }
    public List<Book> findByTitleLikeAndPublishedBetween(String word, LocalDate start, LocalDate end){
        return books.stream().filter(book -> book.getTitolo().contains(word))
                             .sorted(Comparator.comparingDouble(Book::getCosto)
                             .reversed())
                             .toList();

    }
    public double findAvgCostByLanguage(String language){
        return books.stream().filter(book -> book.getLingua().equals(language))
                             .mapToDouble(Book::getCosto)
                             .average()
                             .orElse(0.0);
    }
    public List<Book> findByAuthorId(int id){
        return books.stream().filter(book->book.getAuthors().stream().anyMatch(authors ->authors.getId()==id)).toList();
    }

    public List<Book> findByMostAuthors(){
        return books.stream().filter(book->book.getAuthors().size()>1).sorted(Comparator.comparingInt(Book::getNumberOfAuthors)).toList().reversed();
    }
    public List<Author> findAuthorsByCategory(Category category){
        return books.stream().filter(book->book.getCategoria()==category)
                .flatMap(book -> book.getAuthors().stream())
                .sorted(Comparator.comparing(Author::getSurname).thenComparing(Author::getName))
                .distinct()
                .toList();
    }
}




//Creare una classe BookRepository che mantiene una lista di libri e permette di eserguire i seguenti metodi:

//un metodo che ritorna tutti i libri per una data categoria in input (intendo parametro di input del metodo, non input dall utente..)
//ad esempio List<Book> findByCategory(Category target) {...}

//un metodo che ritorna tutti i libri che hanno una data parola (in input) come parte del loro titolo e sono stati pubblicati entro una dato
//range di date, ordinati per costo decrescente
//List<Book> findByTitleLikeAndPublishedBetween(String word, LocalDate start, LocalDate end) {...}

//un metodo che restituisce il costo medio per i libri scritti in una data lingua
//double findAvgCostByLanguage(String language)

//un metodo che restituisce tutti i libri scritti da un autore di cui viene dato l'id
//List<Book> findByAuthorId(int id);

//un metodo che restituisca la lista di tutti i libri che hanno piu'di un autore, ordinati per numero di autori decrescente

//un metodo che resituisca la lista di tutti gli autori che hanno mai scritto libri in una data categoria. Gli autori devono essere ordinati per
//cognome e nome alfabetico e devono apparire nella lista una sola volta. (distinct)
