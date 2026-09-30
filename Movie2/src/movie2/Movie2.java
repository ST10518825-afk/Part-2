/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package movie2;


public class Movie2 {
     public String title;
    public String genre;
    public double price;

    public Movie2(String title, String genre, double price) {
        this.title = title;
        this.genre = genre;
        this.price = price;
    }

    public String getTitle() { return title; }
    public String getGenre() { return genre; }
    public double getPrice() { return price; }

    @Override
    public String toString() {
        return String.format("%s (%s) - R%.2f", title, genre, price);
    }
    
    
}
