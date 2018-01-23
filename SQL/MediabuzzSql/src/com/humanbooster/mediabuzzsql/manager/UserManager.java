package com.humanbooster.mediabuzzsql.manager;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.humanbooster.mediabuzzsql.pojos.User;
import com.mysql.jdbc.Statement;

public class UserManager {

    private Connection connection;
    private PreparedStatement psmt;
    
    public UserManager(Connection connection) {
        this.connection = connection;
    }
    
    public User createUser(User user) throws SQLException {
        
        String query = "INSERT INTO user " +
                " (login,password,mail,dateInscription) " +
                " VALUES (?,?,?,?) ";
        
        psmt = connection.prepareStatement(query,Statement.RETURN_GENERATED_KEYS);
        
        psmt.setString(1, user.getLogin());
        psmt.setString(2, user.getPassword());
        psmt.setString(3, user.getMail());
        psmt.setTimestamp(4, user.getDateInscription());
        
        psmt.executeUpdate();
        
        ResultSet rs = psmt.getGeneratedKeys();
        
        if(rs.next()) {
            user.setLogin(rs.getString(1));
        }
        
        rs.close();
        psmt.close();        
        
        return user;
    }
    
    public User getUserByLogin(String login) throws SQLException {
        
        User user = null;
        
        String query = "SELECT * FROM user WHERE login = ? ";
        
        psmt = connection.prepareStatement(query);
        
        psmt.setString(1, login);
        
        ResultSet rs =  psmt.executeQuery();
        
        if(rs.next()) {
            user = new User(rs.getString("login"),rs.getString("password"),rs.getString("mail"),rs.getTimestamp("dateInscription"));
        }
        
        rs.close();
        psmt.close();
        
        return user;
    }
    
    public List<User> getAllUser() throws SQLException {
        
        User user = null;
        List<User> users = new ArrayList<>();
        
        String query = "SELECT * FROM user ";
        
        psmt = connection.prepareStatement(query);
        
        ResultSet rs =  psmt.executeQuery();
        
        while(rs.next()) {
            user = new User(rs.getString("login"),rs.getString("password"),rs.getString("mail"),rs.getTimestamp("dateInscription"));
            users.add(user);
        }
        
        rs.close();
        psmt.close();
        
        return users;
    }
}
