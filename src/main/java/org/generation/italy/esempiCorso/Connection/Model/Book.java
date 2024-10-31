package org.generation.italy.esempiCorso.Connection.Model;

import org.generation.italy.esempiCorso.Connection.DataBaseConnection;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class Book {
    private int id;
    private String title;
    private int num_page;
    private String category;
    private double weight;
    private int publisherId;
//    private static final String INSERT_SQL = """
//            INSERT INTO books(id,title,num_page,category,weight)
//            values(?,?,?,?,?)
//            """;

    public Book(int id, String title, int num_page, String category, double weight, int publisherId) {
        this.id = id;
        this.title = title;
        this.num_page = num_page;
        this.category = category;
        this.weight = weight;
        this.publisherId = publisherId;
    }

    @Override
    public String toString() {
        return "Book{" +
                "id=" + id +
                ", title='" + title + '\'' +
                ", num_pages=" + num_page +
                ", category='" + category + '\'' +
                ", weight=" + weight +
                ", publisherId=" + publisherId +
                '}';
    }
//    public void insert() throws SQLException { NON SI FAAAAA , VIOLA IL PRINCIPIO DI RESPONSABILITA SINGOLAAAA
//        try(Connection c = DataBaseConnection.getConnection();
//            PreparedStatement ps = c.prepareStatement(INSERT_SQL)){
//            ps.setInt(1,id);
//            ps.setString(2,title);
//            ps.setInt(3,num_page);
//            ps.setString(4,category);
//            ps.setDouble(5,weight);
//            ps.executeUpdate();
//        }
    }

