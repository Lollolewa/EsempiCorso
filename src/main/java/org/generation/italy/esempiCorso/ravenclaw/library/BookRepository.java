package org.generation.italy.esempiCorso.ravenclaw.library;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class BookRepository {

    private List<Book> bookList = new ArrayList<>();

    public void add(Book b) {
        bookList.add(b);
    }

    public List<Book> printBookList(){
        return bookList;
    }

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
        return bookList.stream().filter(book -> book.isWrittenBy(id)).toList();
    }

    public List<Book> findByAuthorNumber(){
        return bookList.stream().filter(book -> book.getAuthors().size()>1)
                                .sorted(Comparator.comparingInt(Book::getAuthorCount).reversed()).toList();
    }

    public List<Author> findAuthorsByCategory(Category category){
        return bookList.stream().filter(book -> book.getCategory().equals(category))
                                .flatMap(a -> a.getAuthors().stream())
                                .sorted(Comparator.comparing(Author::getSurname).thenComparing(Author::getName))
                                .distinct()
                                .toList();
    }
    public int findTotalPagesByIdAuthors(int id){
        return bookList.stream().filter(book->book.getAuthors().stream().anyMatch(author-> author.getAuthorId()==id)).mapToInt(Book::getnPages).sum();
    }
    public int findTotalPagesOfCathegory(Category category){
        return bookList.stream().filter(book ->book.getCategory().equals(category)).mapToInt(Book::getnPages).sum();
    }
    public double findAvgCostByAuthorsSpeakFrancese(){
        return bookList.stream().filter(book -> book.getAuthors().stream().anyMatch(author -> author.getAuthorLanguages().stream().anyMatch(language-> language.equals("French")))).
                          mapToDouble(Book::getCost).average().orElse(0);
    }
//    public Author findAuthorWithMostBooks(){
//        var z = bookList.stream().filter(book -> book.getAuthors().stream().)
//    }
    //Dammi il numero totale di pagine che sono state scritte dall' autore con un certo ID
    //Dammi il numero totale di pagine che sono state scritte per una certa categoria di libri
    //Dammi il valore medio del prezzo dei libri scritti da un autore che parla la lingua francese
    //Dammi l'autore che ha scritto più libri in caso di parimerito scegli l'uomo
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


