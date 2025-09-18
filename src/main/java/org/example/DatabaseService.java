package org.example;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class DatabaseService {
    private static final String DB_URL = "jdbc:sqlite:ca_onboarding.db";

    public static void saveCA(String name, String email, String utmSource,
                              String utmMedium, String utmCampaign, String utmId, String utmLink) {
        try (Connection conn = DriverManager.getConnection(DB_URL)) {
            String sql = "CREATE TABLE IF NOT EXISTS ca_registrations (" +
                    "id INTEGER PRIMARY KEY AUTOINCREMENT," +
                    "name TEXT NOT NULL," +
                    "email TEXT NOT NULL," +
                    "utm_source TEXT NOT NULL," +
                    "utm_medium TEXT NOT NULL," +
                    "utm_campaign TEXT NOT NULL," +
                    "utm_id TEXT NOT NULL," +
                    "utm_link TEXT NOT NULL)";
            conn.createStatement().execute(sql);

            PreparedStatement stmt = conn.prepareStatement(
                    "INSERT INTO ca_registrations " +
                            "(name, email, utm_source, utm_medium, utm_campaign, utm_id, utm_link) " +
                            "VALUES (?, ?, ?, ?, ?, ?, ?)");
            stmt.setString(1, name);
            stmt.setString(2, email);
            stmt.setString(3, utmSource);
            stmt.setString(4, utmMedium);
            stmt.setString(5, utmCampaign);
            stmt.setString(6, utmId);
            stmt.setString(7, utmLink);
            stmt.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    // Fetch all onboarded CAs
    public static List<String> fetchAllCAs() {
        List<String> caList = new ArrayList<>();
        try (Connection conn = DriverManager.getConnection(DB_URL)) {
            String sql = "SELECT name, email, utm_source, utm_medium, utm_campaign, utm_id, utm_link " +
                         "FROM ca_registrations ORDER BY id DESC";
            ResultSet rs = conn.createStatement().executeQuery(sql);

            while (rs.next()) {
                String record = String.format(
                        "Name: %s | Email: %s | Source: %s | Medium: %s | Campaign: %s | ID: %s | Link: %s",
                        rs.getString("name"),
                        rs.getString("email"),
                        rs.getString("utm_source"),
                        rs.getString("utm_medium"),
                        rs.getString("utm_campaign"),
                        rs.getString("utm_id"),
                        rs.getString("utm_link")
                );
                caList.add(record);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return caList;
    }
}
