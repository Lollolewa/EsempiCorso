package org.generation.italy.esempiCorso.griffindor.eserciziCollection.Libreria;

import java.time.LocalDate;

public class Main {
    public static void main(String[] args) {
        // Initialize your BookRepository and other necessary objects here
        BookRepository bookRepository = new BookRepository(/* your list of books */);

        String menu = """
                Choose an operation:
                1. Find books by category
                2. Find books by title and date range
                3. Find average cost by language
                4. Find books by author ID
                5. Find books with multiple authors
                6. Find authors by category
                7. Find total pages by author ID
                8. Find total pages by category
                9. Find average cost of books by French-speaking authors
                10. Find author with most books
                0. Exit
                Enter your choice: """;

        int choice;
        java.util.Scanner scanner = new java.util.Scanner(System.in);

        do {
            System.out.print(menu);
            choice = scanner.nextInt();
            scanner.nextLine();

            switch (choice) {
                case 1 -> {
                    System.out.print("Enter category: ");
                    String category = scanner.nextLine();
                    System.out.println(bookRepository.findByCategory(Category.valueOf(category)));
                }
                case 2 -> {
                    System.out.print("Enter word in title: ");
                    String word = scanner.nextLine();
                    System.out.print("Enter start date (yyyy-MM-dd): ");
                    LocalDate start = LocalDate.parse(scanner.nextLine());
                    System.out.print("Enter end date (yyyy-MM-dd): ");
                    LocalDate end = LocalDate.parse(scanner.nextLine());
                    System.out.println(bookRepository.findByTitleLikeAndPublishedBetween(word, start, end));
                }
                case 3 -> {
                    System.out.print("Enter language: ");
                    String language = scanner.nextLine();
                    System.out.println(bookRepository.findAvgCostByLanguage(language));
                }
                case 4 -> {
                    System.out.print("Enter author ID: ");
                    int id = scanner.nextInt();
                    System.out.println(bookRepository.findByAuthorId(id));
                }
                case 5 -> System.out.println(bookRepository.findBooksWithMultipleAuthors());
                case 6 -> {
                    System.out.print("Enter category: ");
                    String category = scanner.nextLine();
                    System.out.println(bookRepository.findAuthorsByCategory(Category.valueOf(category)));
                }
                case 7 -> {
                    System.out.print("Enter author ID: ");
                    int id = scanner.nextInt();
                    System.out.println(bookRepository.findTotalPagesByAuthorId(id));
                }
                case 8 -> {
                    System.out.print("Enter category: ");
                    String category = scanner.nextLine();
                    System.out.println(bookRepository.findTotalPagesByCategory(Category.valueOf(category)));
                }
                case 9 -> System.out.println(bookRepository.findAvgCostByFrenchSpeakingAuthors());
                case 10 -> System.out.println(bookRepository.findAuthorWithMostBooks());
                case 0 -> System.out.println("Exiting...");
                default -> System.out.println("Invalid choice. Please try again.");
            }
        } while (choice != 0);

        scanner.close();
    }
}

