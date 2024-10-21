package org.generation.italy.esempiCorso.griffindor.eserciziCollection.travelAgency;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class UserInterface {
    List<Voyage> voyages = new ArrayList<>();
    private AbstractVoyageRepository repository = new VoyageRepository(voyages);

    public void begin() {
        Scanner scanner = new Scanner(System.in);
        int choice;

        repository.create(new Voyage(List.of(
                new Destination("ROMA", "roma", "Hotel Roma", 10, List.of("Mangiare", "Girare"), List.of("Ristorante Roma", "Ristorante Lazio")),
                new Destination("PARIGI", "Francia", "Hotel Parigi", 10, List.of("Mangiare", "Girare"), List.of("Ristorante Parigi", "Ristorante France"))),
                1001, 3000.00, LocalDate.of(2024, 10, 18), Category.luxury));

        System.out.println("""
                Welcome to the travel agency. What would you like to do?
                 1. Create a trip
                 2. Cancel a trip
                 3. View the list of all active travel offers
                 4. View the list of all offers related to a specific destination
                 5. View the list of all active travel offers that contain a specific word in their name
                 6. View the list of all travel offers in a specific category and with a number of destinations
                 7. Exit
                """);

        do {
            System.out.print("Enter your choice (1-7): ");
            choice = getValidIntegerInput(scanner, "Enter your choice (1-7)", 1, 7);

            switch (choice) {
                case 1:
                    createTrip(scanner);
                    break;
                case 2:
                    cancelTrip(scanner);
                    break;
                case 3:
                    System.out.println(repository.findActiveVoyages());
                    break;
                case 4:
                    viewVoyagesByDestination(scanner);
                    break;
                case 5:
                    searchActiveVoyagesByWord(scanner);
                    break;
                case 6:
                    viewVoyagesByCategory(scanner);
                    break;
                case 7:
                    System.out.println("Goodbye!");
                    break;
            }
            System.out.println();
        } while (choice != 7);
        scanner.close();
    }

    private int getValidIntegerInput(Scanner scanner, String prompt, int min, int max) {
        int input = 0;
        do {
            System.out.print(prompt + ": ");
            try {
                input = scanner.nextInt();
                scanner.nextLine();
                if (input < min || input > max) {
                    System.out.println("Invalid input. Please enter a number between " + min + " and " + max + ".");
                }
            } catch (Exception e) {
                System.out.println("Invalid input. Please enter a number.");
                scanner.nextLine();
            }
        } while (input < min || input > max);
        return input;
    }

    private void createTrip(Scanner scanner) {
        String cityOfDestination, description, hotelName, otherActivities;
        int stayDays;
        List<Destination> destinations = new ArrayList<>();
        Voyage voyage;

        System.out.println("Welcome to Travel Agency");

        String addMoreDestinations;
        do {

            cityOfDestination = getNonEmptyInput(scanner, "Enter the city of destination").toUpperCase().trim();
            description = getNonEmptyInput(scanner, "Enter the description of the destination");

            List<String> restaurants = new ArrayList<>();
            String addMoreRestaurants;
            do {
                String restaurant = getNonEmptyInput(scanner, "Enter the restaurant name");
                restaurants.add(restaurant);
                addMoreRestaurants = getNonEmptyInput(scanner, "Do you want to add more restaurants? (y/n)");
            } while (addMoreRestaurants.equalsIgnoreCase("y"));

            List<String> activities = new ArrayList<>();
            String addMoreActivities;
            do {
                otherActivities = getNonEmptyInput(scanner, "Enter the other activities");
                activities.add(otherActivities);
                addMoreActivities = getNonEmptyInput(scanner, "Do you want to add more activities? (y/n)");
            } while (addMoreActivities.equalsIgnoreCase("y"));

            hotelName = getNonEmptyInput(scanner, "Enter the hotel name");
            stayDays = getValidIntegerInput(scanner, "How many days do you want to stay?", 1, Integer.MAX_VALUE);

            Destination newDestination = new Destination(cityOfDestination, description, hotelName, stayDays, activities, restaurants);
            destinations.add(newDestination);

            addMoreDestinations = getNonEmptyInput(scanner, "Do you want to enter more destinations? (y/n)");
        } while (addMoreDestinations.equalsIgnoreCase("y"));

        // Continue with creating the voyage
        int id = getUniqueVoyageId(scanner);
        double price = getValidDoubleInput(scanner, "Enter the budget", 0.0, Double.MAX_VALUE);
        LocalDate startLocalDate = getFutureDate(scanner);
        Category target = getCategoryFromUser(scanner);

        voyage = new Voyage(destinations, id, price, startLocalDate, target);
        repository.create(voyage);
        System.out.println("Voyage with ID " + id + " has been created.");
        System.out.println("Voyage: " + voyage);
    }
    private String getNonEmptyInput(Scanner scanner, String prompt) {
        String input;
        do {
            System.out.print(prompt + ": ");
            input = scanner.nextLine().trim();
        } while (input.isEmpty());
        return input;
    }

    private int getUniqueVoyageId(Scanner scanner) {
        int id;
        boolean isUnique;
        do {
            id = getValidIntegerInput(scanner, "Enter the ID of the destination", 0, Integer.MAX_VALUE);
            isUnique = !isIdPresent(id);
            if (!isUnique) {
                System.out.println("ID already exists. Please enter a unique ID.");
            }
        } while (!isUnique);
        return id;
    }

    private double getValidDoubleInput(Scanner scanner, String prompt, double min, double max) {
        double input;
        do {
            System.out.print(prompt + ": ");
            input = scanner.nextDouble();
            scanner.nextLine();
            if (input < min || input > max) {
                System.out.println("Invalid input. Please enter a number between " + min + " and " + max + ".");
            }
        } while (input < min || input > max);
        return input;
    }

    private LocalDate getFutureDate(Scanner scanner) {
        LocalDate startLocalDate;
        String startDate;
        do {
            System.out.print("Enter the start date (year-month-day format, e.g. 2022-01-01): ");
            startDate = scanner.nextLine();
            try {
                startLocalDate = LocalDate.parse(startDate);
                if (!startLocalDate.isAfter(LocalDate.now())) {
                    System.out.println("Invalid date. The start date must be in the future.");
                }
            } catch (Exception e) {
                System.out.println("Invalid date format. Please enter year-month-day format.");
                startLocalDate = LocalDate.now();
            }
        } while (!startLocalDate.isAfter(LocalDate.now()));
        return startLocalDate;
    }

    private void cancelTrip(Scanner scanner) {
        System.out.println("Which trip do you want to cancel? Enter the ID.");
        int id = getValidIntegerInput(scanner, "Enter the ID", 0, Integer.MAX_VALUE);
        boolean found = isIdPresent(id);
        if (found) {
            boolean success = repository.delete(id);
            if (success) {
                System.out.println("Voyage with ID " + id + " has been cancelled.");
            } else {
                System.out.println("Could not cancel the voyage with ID " + id + ".");
            }
        } else {
            System.out.println("Voyage with ID " + id + " not found.");
        }
    }
    private boolean isIdPresent(int id) {
        for (Voyage v : voyages) {
            if (v.getId() == id) {
                return true;
            }
        }
        return false;
    }

    private void viewVoyagesByDestination(Scanner scanner) {
        System.out.println("Which destination are you interested in?");
        String dest = scanner.nextLine();
        System.out.println(repository.findVoyagesByDestination(dest));
    }

    private void searchActiveVoyagesByWord(Scanner scanner) {
        System.out.println("Which word do you want to search within the list of active travel offers?");
        String searchWord = scanner.nextLine();
        System.out.println(repository.findActiveVoyagesByWord(searchWord));
    }

    private void viewVoyagesByCategory(Scanner scanner) {
        Category target = getCategoryFromUser(scanner);
        int minDestinations = getValidIntegerInput(scanner, "Enter the minimum number of destinations", 0, Integer.MAX_VALUE);
        System.out.println(repository.findCategoriesAndDestinations(target, minDestinations));
    }

    private Category getCategoryFromUser(Scanner scanner) {
        int category;
        do {
            category = getValidIntegerInput(scanner, "Enter the category (1. luxury, 2. comfort, 3. budget, 4. backpacker)", 1, 4);
        } while (category < 1 || category > 4);
        return Category.fromInteger(category);
    }
}