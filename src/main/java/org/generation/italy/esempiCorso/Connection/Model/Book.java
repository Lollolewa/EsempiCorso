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

    public int getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    public int getNum_page() {
        return num_page;
    }

    public String getCategory() {
        return category;
    }

    public double getWeight() {
        return weight;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setNum_page(int num_page) {
        this.num_page = num_page;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public void setWeight(double weight) {
        this.weight = weight;
    }

    public void setPublisherId(int publisherId) {
        this.publisherId = publisherId;
    }

    public int getPublisherId() {
        return publisherId;
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

