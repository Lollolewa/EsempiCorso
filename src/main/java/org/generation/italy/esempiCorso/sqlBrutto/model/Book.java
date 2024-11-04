package org.generation.italy.esempiCorso.sqlBrutto.model;

public class Book {
    private int id;
    private String title;
    private int num_pages;
    private double weight;
    private String category;
    private int publisher_id;

    public Book(int id, String title, int num_pages, double weight, String category, int publisher_id) {
        this.id = id;
        this.title = title;
        this.num_pages = num_pages;
        this.weight = weight;
        this.category = category;
        this.publisher_id = publisher_id;
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
}


//private final static String INSERT_SQL = """
//            insert into books(id, title, num_pages, weight, category, publisher_id)
//            values(?, ?, ?, ?, ?, ?);
//            """;



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


