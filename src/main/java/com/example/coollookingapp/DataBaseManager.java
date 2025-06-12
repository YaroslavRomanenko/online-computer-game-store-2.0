package com.example.coollookingapp;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import javax.sql.DataSource;
import java.io.InputStream;
import java.sql.*;

public class DataBaseManager {
    private static String JDBC_URL;
    private static final BCryptPasswordEncoder PASSWORD_ENCODER = new BCryptPasswordEncoder();

    public static void setDBConfigurations() {
//        ObjectMapper mapper = new ObjectMapper();
//
//        InputStream inputStream = DataSource.class.getResourceAsStream("/db_config.json");
//        if (inputStream == null) {
//            throw new RuntimeException("Ca")
//        }
        // DbConfig config = ;
    }

    public static Connection establishConnection() throws SQLException {
        System.out.println("Establishing connection...");
        return DriverManager.getConnection(JDBC_URL);
    }

    public static boolean userLoginVerification(Connection connection, String username, String passwordHash) throws SQLException {
        if (connection == null) {
            connection = establishConnection();
        }

        String sqlQuery = "SELECT username, password_hash FROM Users WHERE username = ?";

        try (PreparedStatement st = connection.prepareStatement(sqlQuery)) {
            st.setString(1, username);

            try (ResultSet rs = st.executeQuery()) {
                if (rs.next()) {
                    String storedPasswordHash = rs.getString("password_hash");
                    return PASSWORD_ENCODER.matches(passwordHash, storedPasswordHash);
                } else {
                    return false;
                }
            }
        }
    }
}
