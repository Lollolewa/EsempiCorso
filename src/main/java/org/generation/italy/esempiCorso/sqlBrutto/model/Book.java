package org.generation.italy.esempiCorso.sqlBrutto.model;

public class Book {
    private int id;
    private String title;
    private int num_pages;
    private double weight;
    private String category;
    private int publisher_id;

    private final static String INSERT_SQL = """
           insert into books(id, title, category, weight, publisher_id) // def publ_id = 1
           values(?, ?, ?, ?, ?);
           """;

    public Book(int id, int publisher_id, String category, double weight, int num_pages, String title) {
        this.id = id;
        this.publisher_id = publisher_id;
        this.category = category;
        this.weight = weight;
        this.num_pages = num_pages;
        this.title = title;
    }

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


//    // VIOLAZIONE PRINCICPIO RESP SINGOLAA: sembra comodo metterlo qui ma diventa pasticcio
// CREO CLASE
//    public void insert() throws SQLException {
//        try (Connection c = DatabaseConnection.getConnection();
//        PreparedStatement ps = c.prepareStatement(INSERT_SQL)) { // non va proprio ben eperché potrei avere null
//            ps.setInt(1, id);
//            ps.setString(2, title);
//            ps.setInt(3,num_pages);
//            ps.setDouble(4,weight);
//            ps.setString(5,category);
//            ps.setInt(6, publisher_id);
//        }
//    }

}
