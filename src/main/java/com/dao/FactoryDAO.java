package com.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class FactoryDAO {
    private String url;
    private String username;
    private String password;

    FactoryDAO(String url, String username, String password) {
        this.url = url;
        this.username = username;
        this.password = password;
    }

    public static FactoryDAO getInstance() {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
        } catch (ClassNotFoundException e) {

        }

        FactoryDAO instance = new FactoryDAO("jdbc:mysql://localhost:3306/ProjetJavaEE", "root", "network");


        return instance;
    }

    public Connection getConnection() throws SQLException {
        return DriverManager.getConnection(url, username, password);
    }
}