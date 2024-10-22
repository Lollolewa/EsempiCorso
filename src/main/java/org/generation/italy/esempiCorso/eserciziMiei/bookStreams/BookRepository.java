package org.generation.italy.esempiCorso.eserciziMiei.bookStreams;

import java.time.LocalDate;
import java.util.Comparator;
import java.util.List;

public class BookRepository {
    private List<Book> books;

    public void setBooks(List<Book> books) {
        this.books = books;
    }

    public List<Book> findBooksByCategory(Category category) {
        return books.stream().filter(b -> b.getCategoria() == category).toList();
    }

    public  List<Book> findByTitleLikeAndPublishedBetween(String word, LocalDate start, LocalDate end) {
        return books.stream()
                .filter(p -> (p.getTitle().contains(word)) && p.getDataPubblicazione().isAfter(start) && p.getDataPubblicazione().isBefore(end))
                .sorted((b1,b2) -> Double.compare(b2.getCosto(), b1.getCosto()))
                .toList();
    }

    public double findAvgCostByLanguage(String language){
        return books.stream()
                .filter(p -> p.getLanguage().equals(language))
                .mapToDouble(p -> p.getCosto())
                .average()
                .getAsDouble();
    }

    public List<Book> findByAuthorId(int id){
        return books.stream()
                    .filter(p -> p.getId() == id)
                    .toList();
    }

    public List<Book> findBooksWithMoreAuthorsOrderedDecrescent() {
        return books.stream()
                    .filter(p -> p.getAuthors().size() > 1)
                .sorted((b1, b2) -> Integer.compare(b2.getAuthors().size(), b1.getAuthors().size())).toList();
    }

    public List<Author> findAuthorByCategory(Category categoria){
        List<Author> autori;
        return books.stream()
                .filter(p ->p.getCategoria().equals(categoria))
                .flatMap(b -> b.getAuthors().stream()) //con flatmap appiattisco le liste di autori in un unico stream di autori
                .distinct() //rimuovo i duplicati
                .sorted(Comparator.comparing(Author :: getSurname).thenComparing(Author::getName))
                .toList();
    }
}
