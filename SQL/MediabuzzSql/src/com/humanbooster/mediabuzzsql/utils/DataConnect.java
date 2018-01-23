package com.humanbooster.mediabuzzsql.utils;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DataConnect {
    
    /**
     * Méthode permettant de récupérer la connexion à la BDD
     * 
     * @return
     * @throws SQLException
     * @throws ClassNotFoundException
     */
    
    
    public static Connection getConnection() throws SQLException, ClassNotFoundException {
        String url = "jdbc:mysql://localhost:3306/mediabuzzSql?useSSL=true";
        String user = "root";
        String password = "";
        
        Class.forName("com.mysql.jdbc.Driver");
        
        Connection connexion = DriverManager.getConnection(url, user, password);
        
        return connexion;
    }
    
    /**
     * Méthode permettant de fermer la connexion
     * @param connection
     * @throws SQLException
     */
    
    public static void closeConnection(Connection connection) throws SQLException {
        connection.close();
    }

}
