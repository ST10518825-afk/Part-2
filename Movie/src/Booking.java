
import movie.Movie;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */


public class Booking implements Billable {
    public Customer customer;
    public Movie movie;
    public int numberOfTickets;

    public Booking(Customer customer, Movie movie, int numberOfTickets) {
        this.customer = customer;
        this.movie = movie;
        this.numberOfTickets = numberOfTickets;
    }

    @Override
    public double calculateTotalCost() {
        return movie.getBaseTicketPrice() * numberOfTickets;
    }

    public void displayBookingDetails() {
        System.out.printf("Customer: %-15s | Movie: %-20s | Tickets: %-2d | Total Cost: R%.2f\n",
                customer.getName(), movie.getTitle(), numberOfTickets, calculateTotalCost());
    }
    
}
