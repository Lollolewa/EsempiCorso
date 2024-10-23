package org.generation.italy.esempiCorso.ravenclaw.library;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class BookRepository {

    private List<Book> bookList = new ArrayList<>();

    public BookRepository() {

        Author a1 = new Author(1234, "Bobson", "Rocketto", "Africa", LocalDate.of(1923, 12, 12), List.of("Italian", "English", "Dutch"));

        Book b1 = new Book("La vita di Bobby Rocket", 34, 300, 34, LocalDate.of(2020, 12, 3), Category.ADVENTURE, List.of("Italian", "English", "Dutch"), List.of(a1));
        Book b2 = new Book("La vita di Michale Rock", 300, 432, 70, LocalDate.of(1989, 3, 5), Category.HORROR, List.of("Italian", "English", "Dutch"), List.of(a1));

        bookList.add(b1);
        bookList.add(b2);
    }


    public List<Book> bookListByCategory(Category x) {
        return bookList.stream().filter(book -> book.getCategory().equals(x)).toList();
    }

    public List<Book> findBookTrio(String word, LocalDate startRange, LocalDate endRange) {
        return bookList.stream().filter(b -> b.titleContains(word) && b.isPublishedBetween(startRange, endRange))
                .sorted(Comparator.comparingDouble(Book::getCost).reversed()).toList();
    }

    public double findAvgCostByLanguage(String language){
        return bookList.stream().filter(book -> book.getBookLanguages().contains(language)).mapToDouble(Book::getCost)
                       .average().orElse(0);

//        if (r.isPresent()){
//            return r.getAsDouble();
//        }
//        return 0;
    }

    public List<Book> findByAuthorId(int id){
        return bookList.stream().filter(book -> book.getAuthors().stream().anyMatch(a -> a.getAuthorId() == id)).toList();
    }



//public List<Book> findBookTrio (String word, LocalDate startRange, LocalDate endRange){
//    return bookList.stream().filter(book -> book.getTitle().contains(word))
//                            .filter(book -> startRange.minusDays(1).isBefore(book.getPublicationDate()))
//                            .filter(book -> endRange.isAfter(book.getPublicationDate()))
////                            .sorted((b1,b2) -> Double.compare(b2.getCost(),b1.getCost())); //per i poveri
//                            .sorted(Comparator.comparingDouble(Book::getCost).reversed()).toList();
//
//}
//
//    public List<Book> findBookTrio2 (String word, LocalDate startRange, LocalDate endRange){
//        return bookList.stream().filter(b -> b.getTitle().contains(word) &&
//                        startRange.minusDays(1).isBefore(b.getPublicationDate())&&
//                        endRange.isAfter(b.getPublicationDate()))
//                        .sorted(Comparator.comparingDouble(Book::getCost).reversed()).toList();
//
//    }

}
