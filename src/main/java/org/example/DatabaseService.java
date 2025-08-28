package org.example;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class DatabaseService {
    private static final String DB_URL = "jdbc:sqlite:ca_onboarding.db";

    public static void saveCA(String name, String email, String utmLink) {
        try (Connection conn = DriverManager.getConnection(DB_URL)) {
            String sql = "CREATE TABLE IF NOT EXISTS ca_registrations (" +
                    "id INTEGER PRIMARY KEY AUTOINCREMENT," +
                    "name TEXT NOT NULL," +
                    "email TEXT NOT NULL," +
                    "utmLink TEXT NOT NULL)";
            conn.createStatement().execute(sql);

            PreparedStatement stmt = conn.prepareStatement(
                    "INSERT INTO ca_registrations (name, email, utmLink) VALUES (?, ?, ?)");
            stmt.setString(1, name);
            stmt.setString(2, email);
            stmt.setString(3, utmLink);
            stmt.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
