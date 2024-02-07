package ru.job4j.oo3.sql;

import java.sql.*;

public class SQLStorage {

    public static void main(String[] args) {
        String url = "jdbc:postgresql://localhost:5432/storage";
        String username = "postgres";
        String password = "password";
        Connection conn = null;
        try {
            conn = DriverManager.getConnection(url, username, password);
            PreparedStatement st = conn.prepareStatement("delete from  car_body where id=?");
            st.setInt(1, 7);
            st.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (conn != null) {
                try {
                    conn.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
