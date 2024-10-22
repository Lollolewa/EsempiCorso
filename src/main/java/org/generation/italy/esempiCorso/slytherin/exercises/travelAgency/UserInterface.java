package org.generation.italy.esempiCorso.slytherin.exercises.travelAgency;
// commento per test git
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Scanner;

public class UserInterface {
    List<Voyage> voyages = new ArrayList<>();
    private AbstractVoyageRepository repository = new VoyageRepository(voyages);

    public void begin() {
        Scanner scanner = new Scanner(System.in);
        int choice;

        repository.create(new Voyage(List.of(
                new Destination("TOKYO", "Japan", "Park Hyatt Tokyo", 8, List.of("Anime Tour", "Sumo Wrestling"), List.of("Sukiyabashi Jiro", "Narisawa")),
                new Destination("KYOTO", "Japan", "The Ritz-Carlton Kyoto", 6, List.of("Temple Visit", "Tea Ceremony"), List.of("Kikunoi", "Hyotei"))),
                1003, 5500.00, LocalDate.of(2024, 12, 20), Category.luxury));

        repository.create(new Voyage(List.of(
                new Destination("NEW YORK", "USA", "The Plaza", 6, List.of("Broadway Show", "Central Park Walk"), List.of("Per Se", "Le Bernardin")),
                new Destination("MIAMI", "USA", "Fontainebleau", 5, List.of("Beach Day", "Art Deco Tour"), List.of("Joe's Stone Crab", "Zuma"))),
                1004, 4000.00, LocalDate.of(2025, 3, 10), Category.luxury));

        repository.create(new Voyage(List.of(
                new Destination("BARCELONA", "Spain", "W Barcelona", 5, List.of("Sagrada Familia Tour", "Tapas Crawl"), List.of("Tickets", "Lasarte")),
                new Destination("MADRID", "Spain", "The Westin Palace", 4, List.of("Prado Museum Visit", "Flamenco Show"), List.of("DiverXO", "Coque"))),
                1005, 3500.00, LocalDate.of(2025, 12, 5), Category.comfort));

        repository.create(new Voyage(List.of(
                new Destination("PARIS", "France", "Ritz Paris", 7, List.of("Eiffel Tower Tour", "Louvre Visit"), List.of("L'Arpège", "Guy Savoy")),
                new Destination("NICE", "France", "Hotel Negresco", 5, List.of("Beach Day", "Old Town Walk"), List.of("La Vague d'Or", "Le Chantecler"))),
                1006, 6000.00, LocalDate.of(2024, 11, 15), Category.luxury));

        repository.create(new Voyage(List.of(
                new Destination("ROME", "Italy", "Hotel Eden", 6, List.of("Colosseum Tour", "Vatican Visit"), List.of("La Pergola", "Il Pagliaccio")),
                new Destination("FLORENCE", "Italy", "Four Seasons Hotel Firenze", 4, List.of("Uffizi Gallery", "Duomo Climb"), List.of("Enoteca Pinchiorri", "La Bottega del Buon Caffè")),
                new Destination("MILAN", "Italy", "Four Seasons Hotel Firenze", 4, List.of("Uffizi Gallery", "Duomo Climb"), List.of("Enoteca Pinchiorri", "La Bottega del Buon Caffè"))),
                1007, 4500.00, LocalDate.of(2025, 2, 1), Category.backpacker));

        repository.create(new Voyage(List.of(
                new Destination("ROME", "Australia", "Park Hyatt Sydney", 8, List.of("Opera House Tour", "Bondi Beach Visit"), List.of("Quay", "Tetsuya's")),
                new Destination("MELBOURNE", "Australia", "Crown Towers", 5, List.of("Great Ocean Road Trip", "Street Art Tour"), List.of("Attica", "Vue de Monde"))),
                1008, 7000.00, LocalDate.of(2025, 2, 20), Category.luxury));

        repository.create(new Voyage(List.of(
                new Destination("BANGKOK", "Thailand", "Mandarin Oriental", 5, List.of("Grand Palace Tour", "Floating Market Visit"), List.of("Nahm", "Gaggan Anand")),
                new Destination("PHUKET", "Thailand", "Amanpuri", 6, List.of("Island Hopping", "Old Town Walk"), List.of("Raya", "One Chun"))),
                1009, 3800.00, LocalDate.of(2024, 11, 10), Category.backpacker));

        repository.create(new Voyage(List.of(
                new Destination("MARRAKECH", "Morocco", "La Mamounia", 6, List.of("Medina Tour", "Camel Ride"), List.of("La Grande Table Marocaine", "Nomad")),
                new Destination("FES", "Morocco", "Riad Fes", 4, List.of("Tannery Visit", "Ceramic Workshop"), List.of("Nur", "Café Clock"))),
                1010, 3200.00, LocalDate.of(2025, 4, 5), Category.budget));


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
                    for (Voyage v: repository.findActiveVoyages())
                        System.out.println(v);
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
        showVoyages(repository.findVoyagesByDestination(dest));
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

    private void showVoyages (Collection<Voyage> vs){
        for (Voyage v : vs){
            System.out.println(v);
        }
    }
}