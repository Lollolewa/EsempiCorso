package org.generation.italy.esempiCorso.eserciziMiei.bookStreams;

import java.time.LocalDate;
import java.util.List;

public class Start {
    public static void main(String[] args) {

        Author a1 = new Author(1, "Samuele", "Celletti", "Ita", "Italiano", LocalDate.of(2000, 9, 3));
        Author a2 = new Author(2, "Jane", "Doe", "USA", "English", LocalDate.of(1990, 1, 1));
        Author a3 = new Author(3, "Lucas", "Polpetta", "Svizzera", "English", LocalDate.of(1998, 1, 12));

        Book b1 = new Book(1, 300, "Il Signore degli Anelli", "Ita", 1.5, 20.0, LocalDate.of(2000, 9, 3), List.of(a1, a2), Category.NARRATIVE);
        Book b2 = new Book(2, 500, "Harry Potter", "Eng", 2.0, 30.0, LocalDate.of(1990, 1, 1), List.of(a3, a2), Category.NARRATIVE);
        Book b3 = new Book(3, 200, "L'acchiappasogni", "Ita", 1.0, 15.0, LocalDate.of(1998, 1, 12), List.of(a1, a3), Category.HORROR);

        BookRepository bookRepository = new BookRepository();

        bookRepository.setBooks(List.of(b1, b2, b3));

        List<Author> autori = bookRepository.findAuthorByCategory(Category.NARRATIVE);
        System.out.println(autori);
    }
}
