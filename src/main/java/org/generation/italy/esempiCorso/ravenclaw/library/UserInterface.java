package org.generation.italy.esempiCorso.ravenclaw.library;

import java.time.LocalDate;
import java.util.List;


public class UserInterface {
    public void begin() {

        BookRepository bookList = new BookRepository();

        // AUTHOR GENERATION
        Author bramStoker = new Author(
                1, "Bram", "Stoker", "Irish", LocalDate.of(1847, 11, 8), List.of("English"));

        Author stephenKing = new Author(
                2, "Stephen", "King", "American", LocalDate.of(1947, 9, 21), List.of("English"));

        Author robertLouisStevenson = new Author(
                3, "Robert Louis", "Stevenson", "Scottish", LocalDate.of(1850, 11, 13), List.of("English", "French"));

        Author julesVerne = new Author(
                4, "Jules", "Verne", "French", LocalDate.of(1828, 2, 8), List.of("French", "English"));

        Author janeAusten = new Author(
                5, "Jane", "Austen", "British", LocalDate.of(1775, 12, 16), List.of("English"));

        Author alessandroManzoni = new Author(
                6, "Alessandro", "Manzoni", "Italian", LocalDate.of(1785, 3, 7), List.of("Italian"));

        Author frankHerbert = new Author(
                7, "Frank", "Herbert", "American", LocalDate.of(1920, 10, 8), List.of("English"));

        Author georgeOrwell = new Author(
                8, "George", "Orwell", "British", LocalDate.of(1903, 6, 25), List.of("English"));

        Author ernestHemingway = new Author(
                9, "Ernest", "Hemingway", "American", LocalDate.of(1899, 7, 21), List.of("English", "Spanish"));

        Author cormacMcCarthy = new Author(
                10, "Cormac", "McCarthy", "American", LocalDate.of(1933, 7, 20), List.of("English"));

        // HORROR
        bookList.add(new Book("Dracula", 1, 418, 19.99, LocalDate.of(1897, 5, 26), Category.HORROR, List.of("English"), List.of(bramStoker)));
        bookList.add(new Book("It", 2, 1138, 24.99, LocalDate.of(1986, 9, 15), Category.HORROR, List.of("English"), List.of(stephenKing)));

        // ADVENTURE
        bookList.add(new Book("L'Isola del tesoro", 3, 312, 12.99, LocalDate.of(1883, 11, 14), Category.ADVENTURE, List.of("English", "Italian"), List.of(robertLouisStevenson)));
        bookList.add(new Book("Ventimila leghe sotto i mari", 4, 432, 14.99, LocalDate.of(1870, 6, 20), Category.ADVENTURE, List.of("French", "Italian"), List.of(julesVerne)));

        // CLASSICS
        bookList.add(new Book("Orgoglio e pregiudizio", 5, 279, 9.99, LocalDate.of(1813, 1, 28), Category.CLASSICS, List.of("English"), List.of(janeAusten)));
        bookList.add(new Book("I promessi sposi", 6, 720, 17.99, LocalDate.of(1827, 3, 14), Category.CLASSICS, List.of("Italian"), List.of(alessandroManzoni)));

        // SCIENCE_FICTION
        bookList.add(new Book("Dune", 7, 604, 22.99, LocalDate.of(1965, 8, 1), Category.SCIENCE_FICTION, List.of("English"), List.of(frankHerbert)));
        bookList.add(new Book("1984", 8, 328, 11.99, LocalDate.of(1949, 6, 8), Category.SCIENCE_FICTION, List.of("English"), List.of(georgeOrwell)));

        // NARRATIVE
        bookList.add(new Book("Il vecchio e il mare", 9, 127, 8.99, LocalDate.of(1952, 9, 1), Category.NARRATIVE, List.of("English", "Spanish"), List.of(ernestHemingway)));
        bookList.add(new Book("La strada", 10, 287, 10.99, LocalDate.of(2006, 9, 26), Category.NARRATIVE, List.of("English"), List.of(cormacMcCarthy)));

        //IMPLEMENTS METHODS
        System.out.println(bookList.findAvgCostByLanguage("English"));
        bookList.bookListByCategory(Category.HORROR).forEach(System.out::println);
        bookList.findByAuthorId(4).forEach(System.out::println);
        bookList.findBookTrio("Dune", LocalDate.of(1952, 12, 3), LocalDate.of(2023, 12, 3)).forEach(System.out::println);

    }
}
