/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import movie.Movie;

public class MovieBookingSystem {
    public static List<Movie> movies = new ArrayList<>();
    public static List<Customer> customers = new ArrayList<>();
    public static List<Booking> bookings = new ArrayList<>();

    public static void main(String[] args) {
        // Pre-populate with sample data
        movies.add(new Movie("Inception", "Sci-Fi", 120.00));
        movies.add(new ThreeDMovie("Avatar", "Action", 150.00, 30.00));

        customers.add(new Customer("C101", "Alice Smith"));
        customers.add(new Customer("C102", "Bob Jones"));

        Scanner scanner = new Scanner(System.in);
        int choice;

        do {
            System.out.println("\n=================================================");
            System.out.println("            MOVIE BOOKING SYSTEM                ");
            System.out.println("=================================================");
            System.out.println("1. Add movie to system");
            System.out.println("2. Display available movies");
            System.out.println("3. Register customer");
            System.out.println("4. Book a movie");
            System.out.println("5. Display all bookings");
            System.out.println("6. Calculate total cost of customer's booking");
            System.out.println("7. Exit");
            System.out.print("Enter your choice (1-7): ");

            if (scanner.hasNextInt()) {
                choice = scanner.nextInt();
                scanner.nextLine(); // Consume newline
            } else {
                System.out.println("Invalid input! Please enter a number.");
                scanner.nextLine();
                choice = 0;
                continue;
            }

            switch (choice) {
                case 1:
                    addMovie(scanner);
                    break;
                case 2:
                    displayMovies();
                    break;
                case 3:
                    registerCustomer(scanner);
                    break;
                case 4:
                    bookMovie(scanner);
                    break;
                case 5:
                    displayBookings();
                    break;
                case 6:
                    calculateCustomerTotalCost(scanner);
                    break;
                case 7:
                    System.out.println("Thank you for using the Movie Booking System. Goodbye!");
                    break;
                default:
                    System.out.println("Invalid choice. Please select between 1 and 7.");
            }
        } while (choice != 7);

        scanner.close();
    }

    // 1. Add movies
    public static void addMovie(Scanner scanner) {
        System.out.print("Enter Movie Title: ");
        String title = scanner.nextLine().trim();

        System.out.print("Enter Genre: ");
        String genre = scanner.nextLine().trim();

        System.out.print("Enter Base Ticket Price (R): ");
        double price = scanner.nextDouble();
        scanner.nextLine();

        System.out.print("Is this a 3D movie? (yes/no): ");
        String is3D = scanner.nextLine().trim();

        if (is3D.equalsIgnoreCase("yes")) {
            System.out.print("Enter 3D Glass Fee (R): ");
            double glassFee = scanner.nextDouble();
            scanner.nextLine();
            movies.add(new ThreeDMovie(title, genre, price, glassFee));
        } else {
            movies.add(new Movie(title, genre, price));
        }
        System.out.println("Movie added successfully!");
    }

    // 2. Display available movies
    public static void displayMovies() {
        if (movies.isEmpty()) {
            System.out.println("No movies available.");
            return;
        }
        System.out.println("\n--- AVAILABLE MOVIES ---");
        for (int i = 0; i < movies.size(); i++) {
            System.out.print((i + 1) + ". ");
            movies.get(i).displayMovieDetails();
        }
    }

    // 3. Register customers
    public static void registerCustomer(Scanner scanner) {
        System.out.print("Enter Customer ID: ");
        String id = scanner.nextLine().trim();

        System.out.print("Enter Customer Name: ");
        String name = scanner.nextLine().trim();

        customers.add(new Customer(id, name));
        System.out.println("Customer registered successfully!");
    }

    // 4. Book a movie
    public static void bookMovie(Scanner scanner) {
        if (customers.isEmpty() || movies.isEmpty()) {
            System.out.println("Please ensure there are registered customers and movies before booking.");
            return;
        }

        System.out.println("\n--- SELECT CUSTOMER ---");
        for (int i = 0; i < customers.size(); i++) {
            System.out.print((i + 1) + ". ");
            customers.get(i).displayCustomerDetails();
        }
        System.out.print("Select customer number: ");
        int custChoice = scanner.nextInt() - 1;

        displayMovies();
        System.out.print("Select movie number: ");
        int movieChoice = scanner.nextInt() - 1;

        System.out.print("Enter number of tickets: ");
        int tickets = scanner.nextInt();
        scanner.nextLine();

        if (custChoice >= 0 && custChoice < customers.size() && movieChoice >= 0 && movieChoice < movies.size() && tickets > 0) {
            Booking newBooking = new Booking(customers.get(custChoice), movies.get(movieChoice), tickets);
            bookings.add(newBooking);
            System.out.println("Booking successful!");
        } else {
            System.out.println("Invalid selection or ticket quantity.");
        }
    }

    // 5. Display all bookings
    public static void displayBookings() {
        if (bookings.isEmpty()) {
            System.out.println("No bookings found.");
            return;
        }
        System.out.println("\n--- ALL BOOKINGS ---");
        for (Booking b : bookings) {
            b.displayBookingDetails();
        }
    }

    // 6. Calculate total cost for a specific customer
    public static void calculateCustomerTotalCost(Scanner scanner) {
        System.out.print("Enter Customer Name or ID to calculate total bookings cost: ");
        String search = scanner.nextLine().trim();

        double grandTotal = 0;
        boolean found = false;

        for (Booking b : bookings) {
            if (b.customer.getName().equalsIgnoreCase(search) || b.customer.getCustomerId().equalsIgnoreCase(search)) {
                grandTotal += b.calculateTotalCost();
                found = true;
            }
        }

        if (found) {
            System.out.printf("Total cost of all bookings for '%s': R%.2f\n", search, grandTotal);
        } else {
            System.out.println("No active bookings found for: " + search);
        }
    }
    
}
