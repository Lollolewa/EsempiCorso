package org.generation.italy.esempiCorso.sql.model;

public class Book {
    private int id, numPages, publisherId;
    private String title, category;
    private double weight;

    public Book(int id, int numPages, double weight, int publisherId, String title, String category) {
        this.id = id;
        this.numPages = numPages;
        this.weight = weight;
        this.publisherId = publisherId;
        this.title = title;
        this.category = category;
    }

    @Override
    public String toString() {
        return "Book{" +
                "id=" + id +
                ", numPages=" + numPages +
                ", publisherId=" + publisherId +
                ", title='" + title + '\'' +
                ", category='" + category + '\'' +
                ", weight=" + weight +
                '}';
    }

    public int getId() {
        return id;
    }

    public int getNumPages() {
        return numPages;
    }

    public int getPublisherId() {
        return publisherId;
    }

    public String getTitle() {
        return title;
    }

    public String getCategory() {
        return category;
    }

    public double getWeight() {
        return weight;
    }

    //    private static final String INSERT_SQL = """
//            insert into books(id, title, num_pages, category, weight)
//            values(?, ?, ?, ?, ?);
//            """;

//    public void insert() throws SQLException{
//        try(Connection c = DatabaseConnection.getConnection()){
//            PreparedStatement ps = c.prepareStatement(INSERT_SQL);
//            ps.setInt(1, id);
//            ps.setString(2, title);
//            ps.setInt(3, num_pages);
//            ps.setString(4, category);
//            ps.setDouble(5, weight);
//            ps.executeUpdate();
//        }
//    } NOOOOOOOOOO VIOLAZIONE DEL PRINCIPIO DI RESPONSABILITÀ SINGOLAAAA NOOOOOOOOOOO
}
