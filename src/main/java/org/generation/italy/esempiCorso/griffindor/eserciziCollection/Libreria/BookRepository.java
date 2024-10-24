package org.generation.italy.esempiCorso.griffindor.eserciziCollection.Libreria;

import java.time.LocalDate;
import java.util.List;
import java.util.Map;
import java.util.OptionalDouble;
import java.util.stream.Collectors;

public class BookRepository {
    private List<Book> books = List.of(
            new Book(1, "The Hunger", 3.5, 1600, 25.00, LocalDate.of(1955, 06, 12), Category.HORROR,
                    List.of(new Author(1, "George", "Orwell", LocalDate.of(1920, 8, 4), "Italian", "Italian")), "Italian"),
            new Book(2, "The Death", 1.5, 100, 50.00, LocalDate.of(1975, 06, 12), Category.NARRATIVE,
                    List.of(new Author(2, "Carlotta", "Pisano", LocalDate.of(1950, 8, 4), "Italian", "German")), "German"),
            new Book(3, "The Secret Garden", 4.2, 300, 30.50, LocalDate.of(1911, 03, 15), Category.SCIENCE_FICTION,
                    List.of(new Author(3, "Frances", "Hodgson Burnett", LocalDate.of(1849, 11, 24), "English", "English")), "English"),
            new Book(4, "1984", 4.7, 328, 22.90, LocalDate.of(1949, 06, 8), Category.SCIENCE_FICTION,
                    List.of(new Author(4, "George", "Orwell", LocalDate.of(1903, 06, 25), "English", "English")), "English"),
            new Book(5, "The Name of the Rose", 4.3, 512, 35.00, LocalDate.of(1980, 9, 01), Category.SCIENCE_FICTION,
                    List.of(new Author(5, "Umberto", "Eco", LocalDate.of(1932, 01, 05), "Italian", "Italian")), "Italian"),
            new Book(6, "One Hundred Years of Solitude", 4.5, 432, 28.50, LocalDate.of(1967, 05, 30), Category.CLASSICS,
                    List.of(new Author(6, "Gabriel", "García Márquez", LocalDate.of(1927, 03, 06), "Colombian", "Spanish")), "Spanish"),
            new Book(7, "The Little Prince", 4.8, 96, 15.00, LocalDate.of(1943, 04, 06), Category.CLASSICS,
                    List.of(new Author(7, "Antoine", "de Saint-Exupéry", LocalDate.of(1900, 06, 29), "French", "French")), "French"),
            new Book(8, "Pride and Prejudice", 4.6, 432, 20.00, LocalDate.of(1813, 01, 28), Category.CLASSICS,
                    List.of(new Author(8, "Jane", "Austen", LocalDate.of(1775, 12, 16), "English", "English")), "English"),
            new Book(9, "The Lord of the Rings", 4.9, 1178, 45.00, LocalDate.of(1954, 07, 29), Category.ADVENTURE,
                    List.of(new Author(9, "J.R.R.", "Tolkien", LocalDate.of(1892, 01, 03), "English", "English")), "English"),
            new Book(10, "A Song of Ice and Fire", 4.4, 694, 38.00, LocalDate.of(1996, 8, 06), Category.ADVENTURE,
                    List.of(new Author(10, "George R.R.", "Martin", LocalDate.of(1948, 9, 20), "American", "English")), "English"));

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
    // Returns the total number of pages written by an author with a given ID
    public int findTotalPagesByAuthorId(int id) {
        return books.stream()
                .filter(book -> book.getAuthors().stream().anyMatch(author -> author.getId() == id))
                .mapToInt(Book::getPageCount) // Summing up pages
                .sum();
    }

    // Returns the total number of pages for books in a given category
    public int findTotalPagesByCategory(Category category) {
        return books.stream()
                .filter(book -> book.getCategory().equals(category))
                .mapToInt(Book::getPageCount) // Summing up pages
                .sum();
    }

    // Returns the average price of books written by authors who speak French
    public double findAvgCostByFrenchSpeakingAuthors() {
        OptionalDouble avgCost = books.stream()
                .filter(book -> book.getAuthors().stream()
                        .anyMatch(author -> author.getLanguage().equals("French")))
                .mapToDouble(Book::getCost)
                .average();
        return avgCost.orElse(0.0); // Return 0 if no books are found
    }

    // Returns the author who has written the most books; if there are multiple, returns just one
    public Author findAuthorWithMostBooks() {
        return books.stream()
                .flatMap(book -> book.getAuthors().stream()) // Extract authors
                .collect(Collectors.groupingBy(author -> author, Collectors.counting())) // Count books by author
                .entrySet().stream()
                .max((entry1, entry2) -> Long.compare(entry1.getValue(), entry2.getValue())) // Find author with the most books
                .map(Map.Entry::getKey)
                .orElse(null); // Return null if no author is found
    }
}


