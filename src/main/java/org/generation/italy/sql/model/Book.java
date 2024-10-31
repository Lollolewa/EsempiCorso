package org.generation.italy.sql.model;

import org.generation.italy.sql.DatabaseConnection;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class Book {
    private int id, num_pages, publisher_id;
    private String title, category;
    private double weight;

    private static final String INSERT_SQL = """
            insert into books(id, title, category, weight, num_pages)
            values(?, ?, ?, ?, ?)
            """;

    public Book(int id, int num_pages, int publisher_id, String title, String category, double weight) {
        this.id = id;
        this.num_pages = num_pages;
        this.publisher_id = publisher_id;
        this.title = title;
        this.category = category;
        this.weight = weight;
    }

    @Override
    public String toString() {
        return "Book{" +
                "id=" + id +
                ", num_pages=" + num_pages +
                ", publisher_id=" + publisher_id +
                ", title='" + title + '\'' +
                ", category='" + category + '\'' +
                ", weight=" + weight +
                '}';
    }
    /*public void insert() throws SQLException{
        try(Connection c = DatabaseConnection.getConnection();
        PreparedStatement ps = c.prepareStatement(INSERT_SQL){
            ps.setInt(1,id);
            ps.setInt(2, num_pages);
            ps.setString(3, category);
            ps.setDouble(4,weight);
            ps.setString(5, title);
            ps.executeUpdate();
        } viola il principio open close*/
}
