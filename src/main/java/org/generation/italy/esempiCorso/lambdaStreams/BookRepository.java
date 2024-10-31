package org.generation.italy.esempiCorso.lambdaStreams;

import java.time.LocalDate;
import java.util.*;
import java.util.stream.Collectors;

public class BookRepository {
    List<Book> books = new ArrayList<>();

    public List<Book> findByCategory(Category c) {
        return books.stream().
                filter(book -> c == book.getCategoria())
                .toList();
    }

    public List<Book> findByTitleLikeAndPublishedBetween(String word, LocalDate start, LocalDate end) {
        return books.stream()
                .filter(book -> book.getTitolo().equalsIgnoreCase(word))
                .filter(book -> book.isDateInRange(book.getDataPubblicazione(), start, end))
                .toList();
    }

    public double findAvgCostByLanguage(String language) {
        return books.stream().
                filter(book -> language.equalsIgnoreCase(book.getLingua()))
                .mapToDouble(Book::getCosto)
                .average()
                .orElse(0.0);
    }

    public List<Book> findByAuthorId(int id) {
        return books.stream(). // anyMatch() per vedere se almeno un elemento soddisfa la condizione
                filter(book -> book.getAutori().stream().anyMatch(author -> author.getId() == id))
                .toList();
    }

    public List<Book> sortByAuthorNumber() {
        return books.stream().
                sorted(Comparator.comparingInt(Book::getNumberAuthors).reversed())
                .toList();
    }

    public List<Author> findAuthorsByCategory(Category c) {
        return books.stream()
                .filter(book -> book.getCategoria() == c)
                .flatMap(book -> book.getAutori().stream()) // flatmap() estrae liste autori ritorna un'unica lista (non stream di stream, ma stream e basta) e alla fine bisogna fare stream()
                .distinct()
                .sorted(Comparator.comparing(Author::getCognome).thenComparing(Author::getNome))
                .toList();
    }

    public int findTotalPagesByCategory(int id) {
        return books.stream()
                .filter(book -> book.getAutori().stream().
                        anyMatch(author -> author.getId() == id))
                .mapToInt(Book::getPages)
                .sum();
    }

    public int findTotalPagesByAuthor(Category c) {
        return books.stream()
                .filter(book -> book.getCategoria() == c)
                        .mapToInt(Book::getPages)
                .sum();
    }

    public double findAvgPricebyLanguage() {
        return books.stream()
                .filter(book -> book.getLingua().equalsIgnoreCase("francese"))
                .mapToDouble(Book::getCosto)
                .average()
                .orElse(0.0);
    }

    public Optional<Author> findAuthorWithMostBooks() {
//        Map<String, Integer> map = new HashMap<>();
//        hashMap:
//        map.put("ss", 1); // salva coppia chiave-valore
//        map.get("ss"); // legge valore attraverso la chiave
        return books.stream()
                .flatMap(b -> b.getAutori().stream()) // estrae uno stream di autori dallo stream di books (non stream di stream, solo stream di autori)
//        il metodo groupingBy() crea HASHMAP (Map<Author, Long>) in cui la chiave è l'autore stesso e il valore è il numero di occorrenze (quanti libri ha scritto).
//        a -> a : è UNA LAMBDA -> cosa usare come chiave (cioè l'aurore): dato un autore la chiave è l'autore.
//        Collectors.counting(): questo è il collector usato per contare il numero di volte che ogni autore appare nello stream. è UNA LAMBDA e indica il valore, cioè conta quante volte hai visto autore
                // collect significa "raccogli elementi" e nelle parentesi dice come raccoglierli: Il metodo collect() è estremamente flessibile ed è essenziale per trasformare
                // uno stream in una collezione o in un valore finale. Grazie alla classe Collectors, puoi creare mappe, liste, set, contare elementi, unire stringhe e molto altro.
                .collect(Collectors.groupingBy(a->a, Collectors.counting())) // estrazione chiave autore, raggruppa autori e conta libri (valore è num di volte che è contato l'autore)
                .entrySet().stream() // restituisce tutte le coppie chiave-valore della mappa sotto forma di un Set di oggetti
                .max(Map.Entry.comparingByValue())// paragona valori con natural order e prende max
                .map(Map.Entry::getKey); // key extraction, funziona anche se l'optional è vuoto
    }





}
