
import movie.Movie;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */


public class ThreeDMovie extends Movie {
    public double glassFee;

    public ThreeDMovie(String title, String genre, double baseTicketPrice, double glassFee) {
        super(title, genre, baseTicketPrice);
        this.glassFee = glassFee;
    }

    public double getBaseTicketPrice() {
        return super.getBaseTicketPrice() + glassFee;
    }

    public void displayMovieDetails() {
        System.out.printf("Title: %-20s | Genre: %-12s | Base Price: R%.2f (3D Glass Fee: R%.2f included)\n", 
                title, genre, getBaseTicketPrice(), glassFee);
    }
    
    
    
}
