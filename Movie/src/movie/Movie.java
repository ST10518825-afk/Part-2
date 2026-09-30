/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package movie;


public class Movie {
    public String title;
    public String genre;
    public double baseTicketPrice;

    public Movie(String title, String genre, double baseTicketPrice) {
        this.title = title;
        this.genre = genre;
        this.baseTicketPrice = baseTicketPrice;
    }

    public String getTitle() { return title; }
    public String getGenre() { return genre; }
    public double getBaseTicketPrice() { return baseTicketPrice; }

    public void displayMovieDetails() {
        System.out.printf("Title: %-20s | Genre: %-12s | Base Price: R%.2f\n", 
                title, genre, baseTicketPrice);
    }


    
}
