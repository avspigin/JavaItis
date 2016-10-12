package ru.itis.models;

import java.sql.*;
import java.sql.DriverManager;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

/**
 * Created by Span on 12.10.2016.
 */
public class JdbcConnection {

    private static JdbcConnection instance = null;
    private static Connection connection = null;
    private static final String URL_DB = "jdbc:postgresql://localhost:5432/Dbauto";
    private static final String USER_NAME_DB = "postgres";
    private static final String USER_PASSWORD_DB = "oblivion1987";

    public JdbcConnection() {
        try {
            Class.forName("org.postgresql.Driver");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();

        }
    }

    static {
        instance = new JdbcConnection();
    }

    public Connection getConnection(){
        if(connection == null) try {
            connection = DriverManager.getConnection(URL_DB, USER_NAME_DB, USER_PASSWORD_DB);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return connection;
    }

    public static JdbcConnection getInstance(){
        return instance;
    }
}
