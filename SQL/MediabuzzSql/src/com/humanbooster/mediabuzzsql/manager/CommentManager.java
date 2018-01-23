package com.humanbooster.mediabuzzsql.manager;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.humanbooster.mediabuzzsql.pojos.Comment;

public class CommentManager {

    private Connection connection;
    private PreparedStatement psmt;
    
    public CommentManager(Connection connection) {
        this.connection = connection;
    }
    
    public Comment createComment(Comment comment) throws SQLException {
        
        String query = "INSERT INTO comment (text,dateAjout,idUser,idMedia) VALUES " +
                "(?,?,?,?)";
        
        psmt = connection.prepareStatement(query,Statement.RETURN_GENERATED_KEYS);
        
        psmt.setString(1, comment.getText());
        psmt.setTimestamp(2, comment.getDateAjout());
        psmt.setInt(3, comment.getIdUser());
        psmt.setInt(4, comment.getIdMedia());
        
        psmt.executeUpdate();
        
        ResultSet rs = psmt.getGeneratedKeys();
        
        if(rs.next()){
            comment.setId(rs.getInt(1));
        }
        
        rs.close();
        psmt.close();
        
        return comment;
    }
    
    public List<Comment> getAllCommentsDesc() throws SQLException {
        
        Comment comment = null;
        List<Comment> comments = new ArrayList<>();
        
        String query = "SELECT * FROM comment ORDER BY dateAjout DESC";
        
        psmt = connection.prepareStatement(query);
        
        ResultSet rs = psmt.executeQuery();
        
        while(rs.next()) {
            comment = new Comment(rs.getString("text"),rs.getTimestamp("dateAJout"),rs.getInt("idUser"),rs.getInt("idMedia"));
            comment.setId(rs.getInt(1));
            comments.add(comment);
        }
        
        rs.close();
        psmt.close();
        
        return comments;
    }
 
    public List<Comment> getCommentsByUser(int idUser) throws SQLException {
      
        Comment comment = null;
        List<Comment> comments = new ArrayList<>();
        
        String query = "SELECT * FROM comment WHERE idUser = ? ORDER BY dateAjout DESC";
        
        psmt = connection.prepareStatement(query);
        
        psmt.setInt(1, idUser);
        
        ResultSet rs = psmt.executeQuery();
        
        while(rs.next()) {
            comment = new Comment(rs.getString("text"),rs.getTimestamp("dateAJout"),rs.getInt("idUser"),rs.getInt("idMedia"));
            comment.setId(rs.getInt(1));
            comments.add(comment);
        }
        
        rs.close();
        psmt.close();
        
        return comments;
    }

    public List<Comment> getCommentsByMedia(int idMedia) throws SQLException {
        
        Comment comment = null;
        List<Comment> comments = new ArrayList<>();
        
        String query = "SELECT * FROM comment WHERE idMedia = ? ORDER BY dateAjout DESC";
        
        psmt = connection.prepareStatement(query);
        
        psmt.setInt(1, idMedia);
        
        ResultSet rs = psmt.executeQuery();
        
        while(rs.next()) {
            comment = new Comment(rs.getString("text"),rs.getTimestamp("dateAJout"),rs.getInt("idUser"),rs.getInt("idMedia"));
            comment.setId(rs.getInt(1));
            comments.add(comment);
        }
        
        rs.close();
        psmt.close();
        
        return comments;
    }
    
    public int numberOfCommentsByUser(int idUser) throws SQLException {
        
        int number = 0;
        
        String query = "SELECT COUNT(id) FROM comment WHERE idUser = ?";
        
        psmt = connection.prepareStatement(query);
        
        psmt.setInt(1, idUser);
        
        ResultSet rs = psmt.executeQuery();
        
        if(rs.next()) {
            number = rs.getInt(1);
        }
        
        rs.close();
        psmt.close();
        
        return number;
    }
    
    public int numberOfCommentsByMedia(int idMedia) throws SQLException {
        
        int number = 0;
        
        String query = "SELECT COUNT(id) FROM comment WHERE idMedia = ?";
        
        psmt = connection.prepareStatement(query);
        
        psmt.setInt(1, idMedia);
        
        ResultSet rs = psmt.executeQuery();
        
        if(rs.next()) {
            number = rs.getInt(1);
        }
        
        rs.close();
        psmt.close();
        
        return number;
    }
//    ADD VIEW ON COMMENT
}
