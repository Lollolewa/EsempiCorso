package org.generation.italy.esempiCorso.ravenclaw.library;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class BookRepository {

    private List<Book> bookList = new ArrayList<>();

    public List<Book> bookListByCategory(Category x) {
        return bookList.stream().filter(book -> book.getCategory().equals(x)).toList();
    }

    public List<Book> findBookTrio(String word, LocalDate startRange, LocalDate endRange) {
        return bookList.stream().filter(b -> b.titleContains(word) && b.isPublishedBetween(startRange, endRange))
                                .sorted(Comparator.comparingDouble(Book::getCost).reversed()).toList();
    }

    public double findAvgCostByLanguage(String language) {
        return bookList.stream().filter(book -> book.getBookLanguages().contains(language)).mapToDouble(Book::getCost)
                                .average().orElse(0);
    }

    public List<Book> findByAuthorId(int id) {
        return bookList.stream().filter(book -> book.getAuthors().stream().anyMatch(a -> a.getAuthorId() == id)).toList();
    }

    public void add(Book b) {
        bookList.add(b);
    }
}



























//    public double findAvgCostByLanguage(String language){
//        return bookList.stream().filter(book -> book.getBookLanguages().contains(language)).mapToDouble(Book::getCost)
//                .average();

//        if (r.isPresent()){
//            return r.getAsDouble();
//        }
//        return 0;
//    }


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


