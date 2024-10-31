package org.generation.italy.esempiCorso.Connection.Prime;

import org.generation.italy.esempiCorso.Connection.DataBaseConnection;

import java.sql.*;

public class QueryParametrizzataGiusta {
    public static void main(String[] args) {

    try (Connection connection = DataBaseConnection.getConnection()) {
        String query = "select * from books where title = ?";
        PreparedStatement ps = connection.prepareStatement(query);
        ps.setString(1,"La giungla"); //questo serve per passare un parametro al ?
        ResultSet rs = ps.executeQuery();
        while (rs.next()) {
            int id = rs.getInt("id");
            String title = rs.getString("title");
            System.out.println("libro con id: " + id + " con titolo " + title);
        }
    } catch (SQLException e) {
        e.printStackTrace();
    }
}
}


