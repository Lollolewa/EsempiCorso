package org.generation.italy.esempiCorso.griffindor.eserciziCollection.Libreria;

import java.time.LocalDate;
import java.util.List;
import java.util.OptionalDouble;
import java.util.stream.Collectors;

public class BookRepository {
    private List<Book> books;

    public BookRepository(List<Book> books) {
        this.books = books;
    }

    // Returns all books of a given category
    public List<Book> findByCategory(Category target) {
        return books.stream()
                .filter(book -> book.getCategory().equals(target))
                .collect(Collectors.toList());
    }

    // Returns all books containing a word in the title and published within a date range, sorted by cost descending
    public List<Book> findByTitleLikeAndPublishedBetween(String word, LocalDate start, LocalDate end) {
        return books.stream()
                .filter(book -> book.getTitle().contains(word) &&
                        (book.getPublicationDate().isAfter(start) || book.getPublicationDate().isEqual(start)) &&
                        (book.getPublicationDate().isBefore(end) || book.getPublicationDate().isEqual(end)))
                .sorted((b1, b2) -> Double.compare(b2.getCost(), b1.getCost())) // Sort by cost descending
                .collect(Collectors.toList());
    }

    // Returns the average cost of books in a given language
    public double findAvgCostByLanguage(String language) {
        OptionalDouble avgCost = books.stream()
                .filter(book -> book.getLanguage().equals(language))
                .mapToDouble(Book::getCost)
                .average();
        return avgCost.orElse(0.0); // Return 0 if no books are found
    }

    // Returns all books written by an author with the given id
    public List<Book> findByAuthorId(int id) {
        return books.stream()
                .filter(book -> book.getAuthors().stream().anyMatch(author -> author.getId() == id))
                .collect(Collectors.toList());
    }

    // Returns all books with more than one author, sorted by the number of authors in descending order
    public List<Book> findBooksWithMultipleAuthors() {
        return books.stream()
                .filter(book -> book.getAuthors().size() > 1)
                .sorted((b1, b2) -> Integer.compare(b2.getAuthors().size(), b1.getAuthors().size())) // Sort by number of authors descending
                .collect(Collectors.toList());
    }

    // Returns all authors who have written books in a given category, sorted by last name and first name
    public List<Author> findAuthorsByCategory(Category category) {
        return books.stream()
                .filter(book -> book.getCategory().equals(category))
                .flatMap(book -> book.getAuthors().stream()) // Extract authors
                .sorted((a1, a2) -> {
                    int lastNameComparison = a1.getLastName().compareTo(a2.getLastName());
                    return lastNameComparison != 0 ? lastNameComparison : a1.getFirstName().compareTo(a2.getFirstName());
                })
                .collect(Collectors.toList());
    }
}

