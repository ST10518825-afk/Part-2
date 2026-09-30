/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import movie2.Movie2;

public class MovieBookingGUI extends JFrame {
    // GUI Components (All public)
    public JTextField txtTitle;
    public JTextField txtGenre;
    public JTextField txtPrice;
    public JButton btnAddMovie;

    public DefaultListModel<Movie2> movieListModel;
    public JList<Movie2> movieJList;

    public JTextField txtCustomerName;
    public JButton btnBookMovie;

    public JTextArea txtBookingConfirmation;

    public MovieBookingGUI() {
        // Window setup
        setTitle("Movie Booking System");
        setSize(650, 550);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setLayout(new BorderLayout(10, 10));

        // ------------------ Top Panel: Add Movie Section ------------------
        JPanel addMoviePanel = new JPanel(new GridLayout(4, 2, 5, 5));
        addMoviePanel.setBorder(BorderFactory.createTitledBorder("Add New Movie"));

        addMoviePanel.add(new JLabel("Movie Title:"));
        txtTitle = new JTextField();
        addMoviePanel.add(txtTitle);

        addMoviePanel.add(new JLabel("Genre:"));
        txtGenre = new JTextField();
        addMoviePanel.add(txtGenre);

        addMoviePanel.add(new JLabel("Ticket Price (R):"));
        txtPrice = new JTextField();
        addMoviePanel.add(txtPrice);

        btnAddMovie = new JButton("Add Movie");
        addMoviePanel.add(new JLabel("")); // Empty spacer
        addMoviePanel.add(btnAddMovie);

        // ------------------ Center Panel: Available Movies (JList) ------------------
        JPanel listPanel = new JPanel(new BorderLayout(5, 5));
        listPanel.setBorder(BorderFactory.createTitledBorder("Available Movies"));

        movieListModel = new DefaultListModel<>();
        // Pre-populate with sample movies using Movie2
        movieListModel.addElement(new Movie2("Inception", "Sci-Fi", 120.00));
        movieListModel.addElement(new Movie2("Avatar", "Action", 150.00));
        movieListModel.addElement(new Movie2("The Lion King", "Animation", 90.00));

        movieJList = new JList<>(movieListModel);
        movieJList.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        JScrollPane listScrollPane = new JScrollPane(movieJList);
        listPanel.add(listScrollPane, BorderLayout.CENTER);

        // Combine Top and Center panels into a North container
        JPanel topContainer = new JPanel(new BorderLayout(10, 10));
        topContainer.add(addMoviePanel, BorderLayout.NORTH);
        topContainer.add(listPanel, BorderLayout.CENTER);
        add(topContainer, BorderLayout.NORTH);

        // ------------------ Bottom Panel: Booking & Confirmation ------------------
        JPanel bookingPanel = new JPanel(new BorderLayout(10, 10));

        // Customer Details Sub-panel
        JPanel custPanel = new JPanel(new FlowLayout(FlowLayout.LEFT));
        custPanel.setBorder(BorderFactory.createTitledBorder("Book Movie"));
        custPanel.add(new JLabel("Customer Name:"));
        txtCustomerName = new JTextField(15);
        custPanel.add(txtCustomerName);

        btnBookMovie = new JButton("Book Movie");
        custPanel.add(btnBookMovie);

        // Display area for booking confirmation
        txtBookingConfirmation = new JTextArea(6, 40);
        txtBookingConfirmation.setEditable(false);
        txtBookingConfirmation.setFont(new Font("Monospaced", Font.PLAIN, 12));
        JScrollPane areaScrollPane = new JScrollPane(txtBookingConfirmation);
        areaScrollPane.setBorder(BorderFactory.createTitledBorder("Booking Confirmation"));

        bookingPanel.add(custPanel, BorderLayout.NORTH);
        bookingPanel.add(areaScrollPane, BorderLayout.CENTER);

        add(bookingPanel, BorderLayout.CENTER);

        // ------------------ Action Listeners ------------------

        // Add Movie Action
        btnAddMovie.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                addMovie();
            }
        });

        // Book Movie Action
        btnBookMovie.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                bookMovie();
            }
        });
    }

    public void addMovie() {
        String title = txtTitle.getText().trim();
        String genre = txtGenre.getText().trim();
        String priceStr = txtPrice.getText().trim();

        if (title.isEmpty() || genre.isEmpty() || priceStr.isEmpty()) {
            JOptionPane.showMessageDialog(this, "Please fill in all movie details.", "Input Error", JOptionPane.ERROR_MESSAGE);
            return;
        }

        try {
            double price = Double.parseDouble(priceStr);
            Movie2 newMovie = new Movie2(title, genre, price);
            movieListModel.addElement(newMovie);

            // Clear input fields
            txtTitle.setText("");
            txtGenre.setText("");
            txtPrice.setText("");

            JOptionPane.showMessageDialog(this, "Movie added successfully!");
        } catch (NumberFormatException ex) {
            JOptionPane.showMessageDialog(this, "Please enter a valid price number.", "Input Error", JOptionPane.ERROR_MESSAGE);
        }
    }

    public void bookMovie() {
        Movie2 selectedMovie = movieJList.getSelectedValue();
        String customerName = txtCustomerName.getText().trim();

        if (selectedMovie == null) {
            JOptionPane.showMessageDialog(this, "Please select a movie from the list.", "Selection Error", JOptionPane.WARNING_MESSAGE);
            return;
        }

        if (customerName.isEmpty()) {
            JOptionPane.showMessageDialog(this, "Please enter the customer name.", "Input Error", JOptionPane.WARNING_MESSAGE);
            return;
        }

        // Display confirmation details
        String confirmation = "================ BOOKING CONFIRMATION ================\n" +
                               " Customer Name : " + customerName + "\n" +
                               " Movie Title   : " + selectedMovie.getTitle() + "\n" +
                               " Genre         : " + selectedMovie.getGenre() + "\n" +
                               " Ticket Price  : R" + String.format("%.2f", selectedMovie.getPrice()) + "\n" +
                               " Status        : Confirmed\n" +
                               "======================================================";

        txtBookingConfirmation.setText(confirmation);
        txtCustomerName.setText("");
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                new MovieBookingGUI().setVisible(true);
            }
        });
    }

    public void setTitle(String movie_Booking_System) {
        
    }

    public void setSize(int i, int i0) {
        
    }

    public void setDefaultCloseOperation(int EXIT_ON_CLOSE) {
        
    }

    private void setLocationRelativeTo(Object object) {
        
    }

    private void setLayout(BorderLayout borderLayout) {
        
    }

    private void add(JPanel topContainer, String NORTH) {
        
    }
}
