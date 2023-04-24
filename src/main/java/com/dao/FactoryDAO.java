package com.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class FactoryDAO {
    private String url;
    private String username;
    private String password;
    
    private static final Logger LOGGER = LoggerFactory.getLogger(VilleDAOImpl.class);


    FactoryDAO(String url, String username, String password) {
        this.url = url;
        this.username = username;
        this.password = password;
    }

    public static FactoryDAO getInstance() {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
        } catch (Exception e) {
        	LOGGER.error("context", e);
        }
        return new FactoryDAO("jdbc:mysql://localhost:3306/ProjetJavaEE", "root", "network");
    }

    public Connection getConnection() throws SQLException {
        return DriverManager.getConnection(url, username, password);
    }
}