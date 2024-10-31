package org.generation.italy.esempiCorso.sql.model;

import org.generation.italy.esempiCorso.sql.DatabaseConnection;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class Book {
    private int id; // Identificatore del libro
    private String title; // Titolo del libro
    private int num_pages; // Numero di pagine del libro
    private double weight; // Peso del libro
    private String category; // Categoria del libro
    private int publisher_id; // ID del publisher


    // Metodo per aggiungere un libro nel database"""

    // Costruttore della classe Book
    public Book(int id, String title, int num_pages, double weight, String category, int publisher_id) {
        this.id = id;
        this.title = title;
        this.num_pages = num_pages;
        this.weight = weight;
        this.category = category;
        this.publisher_id = publisher_id;
    }

    // Override del metodo toString per una rappresentazione leggibile dell'oggetto
    @Override
    public String toString() {
        return "Book{" +
                "id=" + id +
                ", title='" + title + '\'' +
                ", num_pages=" + num_pages +
                ", weight=" + weight +
                ", category='" + category + '\'' +
                ", publisher_id=" + publisher_id +
                '}';
    }

    // Metodi getter per accedere ai valori dei campi
    public int getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    public int getNum_pages() {
        return num_pages;
    }

    public double getWeight() {
        return weight;
    }

    public String getCategory() {
        return category;
    }

    public int getPublisher_id() {
        return publisher_id;
    }
}


    // VIOLAZIONE DEL PRINCIPIO DI RESPONSABILITA SINGOLA.
    // PRIMO PRINCIPIO DEL SOLID


// Metodo per aggiungere un libro nel database MAAAAAA non posso farlo.
//private static final String INSERT_SQL = """
//            INSERT INTO books (id,title, num_pages, weight, category, publisher_id)
//            VALUES (?,?,?,?,?,?)
//            """;
//    public void insert()throws SQLException {
//        try(Connection c = DatabaseConnection.getConnection()){
//            PreparedStatement   ps = c.prepareStatement(INSERT_SQL){
//                ps.setInt(1, id);
//                ps.setString(2, title);
//                ps.setInt(3, num_pages);
//                ps.setDouble(4, weight);
//                ps.setString(5, category);
//                ps.setInt(6, publisher_id);
//                ps.executeUpdate();
//            }
//        }
//    }

