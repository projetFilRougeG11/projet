package com.humanbooster.mediabuzzsql.manager;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.humanbooster.mediabuzzsql.pojos.Media;

public class ContentManager {

    private Connection connection;
    private PreparedStatement psmt;
    
    //private int limit = variable statique pour ajouter la limit dans les requêtes sql
    
    public ContentManager(Connection connection) {
        this.connection = connection;
    }
       
    public Media createContent(Media media) throws SQLException {
        
        String query = "INSERT INTO media (type,name,description,format,tailleMo,location,view,dateAjout,userLogin) " +
                " VALUES (?,?,?,?,?,?,?,?,?) ";
        
        psmt = connection.prepareStatement(query, Statement.RETURN_GENERATED_KEYS);
        
        psmt.setString(1, media.getType());
        psmt.setString(2, media.getName());
        psmt.setString(3, media.getDescription());
        psmt.setString(4, media.getFormat());
        psmt.setFloat(5, media.getTailleMo());
        psmt.setString(6, media.getLocation());
        psmt.setInt(7, media.getView());
        psmt.setTimestamp(8, media.getDateAjout());
        psmt.setString(9, media.getUserLogin());
        
        psmt.executeUpdate();
        
        ResultSet rs = psmt.getGeneratedKeys();
        
        if(rs.next()) {
            media.setId(rs.getInt(1));
        }
        
        rs.close();
        psmt.close();
        
        return media;
    }
    
    public List<Media> getAllImagesByUser(String login) throws SQLException {
        
        Media media = null;
        List<Media> medias = new ArrayList<>();
        
        String query = "SELECT * FROM media WHERE type = ? AND userLogin = ? ORDER BY dateAjout DESC";
        
        psmt = connection.prepareStatement(query);
        
        psmt.setString(1, "image");
        psmt.setString(2, login);
        
        ResultSet rs = psmt.executeQuery();
        
        while(rs.next()) {
            media = new Media(rs.getString("type"),rs.getString("name"),rs.getString("description"),rs.getString("format"),rs.getFloat("tailleMo"),rs.getString("location"),rs.getTimestamp("dateAjout"),rs.getString("userLogin"));
            media.setId(rs.getInt(1));
            medias.add(media);
        }
        
        rs.close();
        psmt.close();
        
        return medias;
    }
    
    public List<Media> getAllImagesDesc() throws SQLException {
        
        Media media = null;
        List<Media> medias = new ArrayList<>();
        
        String query = "SELECT * FROM media WHERE type = ? ORDER BY dateAjout DESC";
        
        psmt = connection.prepareStatement(query);
        
        psmt.setString(1, "image");
        
        ResultSet rs = psmt.executeQuery();
        
        while(rs.next()) {
            media = new Media(rs.getString("type"),rs.getString("name"),rs.getString("description"),rs.getString("format"),rs.getFloat("tailleMo"),rs.getString("location"),rs.getTimestamp("dateAjout"),rs.getString("userLogin"));
            media.setId(rs.getInt(1));
            medias.add(media);
        }
        
        rs.close();
        psmt.close();
        
        return medias;
    }
    
    public List<Media> getAllAudiosByUser(String login) throws SQLException {
        
        Media media = null;
        List<Media> medias = new ArrayList<>();
        
        String query = "SELECT * FROM media WHERE type = ? AND userLogin = ? ORDER BY dateAjout DESC";
        
        psmt = connection.prepareStatement(query);
        
        psmt.setString(1, "audio");
        psmt.setString(2, login);
        
        ResultSet rs = psmt.executeQuery();
        
        while(rs.next()) {
            media = new Media(rs.getString("type"),rs.getString("name"),rs.getString("description"),rs.getString("format"),rs.getFloat("tailleMo"),rs.getString("location"),rs.getTimestamp("dateAjout"),rs.getString("userLogin"));
            media.setId(rs.getInt(1));
            medias.add(media);
        }
        
        rs.close();
        psmt.close();
        
        return medias;
    }
 
    public List<Media> getAllAudiosDesc() throws SQLException {
        
        Media media = null;
        List<Media> medias = new ArrayList<>();
        
        String query = "SELECT * FROM media WHERE type = ? ORDER BY dateAjout";
        
        psmt = connection.prepareStatement(query);
        
        psmt.setString(1, "audio");
        
        ResultSet rs = psmt.executeQuery();
        
        while(rs.next()) {
            media = new Media(rs.getString("type"),rs.getString("name"),rs.getString("description"),rs.getString("format"),rs.getFloat("tailleMo"),rs.getString("location"),rs.getTimestamp("dateAjout"),rs.getString("userLogin"));
            media.setId(rs.getInt(1));
            medias.add(media);
        }
        
        rs.close();
        psmt.close();
        
        return medias;
    }

    public List<Media> getAllVideosByUser(String login) throws SQLException {
        
        Media media = null;
        List<Media> medias = new ArrayList<>();
        
        String query = "SELECT * FROM media WHERE type = ? AND userLogin = ? ORDER BY dateAjout DESC";
        
        psmt = connection.prepareStatement(query);
        
        psmt.setString(1, "video");
        psmt.setString(2, login);
        
        ResultSet rs = psmt.executeQuery();
        
        while(rs.next()) {
            media = new Media(rs.getString("type"),rs.getString("name"),rs.getString("description"),rs.getString("format"),rs.getFloat("tailleMo"),rs.getString("location"),rs.getTimestamp("dateAjout"),rs.getString("userLogin"));
            media.setId(rs.getInt(1));
            medias.add(media);
        }
        
        rs.close();
        psmt.close();
        
        return medias;
    }
    
    public List<Media> getAllVideosDesc() throws SQLException {
        
        Media media = null;
        List<Media> medias = new ArrayList<>();
        
        String query = "SELECT * FROM media WHERE type = ? ORDER BY dateAjout";
        
        psmt = connection.prepareStatement(query);
        
        psmt.setString(1, "video");
        
        ResultSet rs = psmt.executeQuery();
        
        while(rs.next()) {
            media = new Media(rs.getString("type"),rs.getString("name"),rs.getString("description"),rs.getString("format"),rs.getFloat("tailleMo"),rs.getString("location"),rs.getTimestamp("dateAjout"),rs.getString("userLogin"));
            media.setId(rs.getInt(1));
            medias.add(media);
        }
        
        rs.close();
        psmt.close();
        
        return medias;
    }
  
    public List<Media> getAllMedias() throws SQLException {
        Media media = null;
        List<Media> medias = new ArrayList<>();
        
        String query = "SELECT * FROM media";
        
        psmt = connection.prepareStatement(query);
        
        ResultSet rs = psmt.executeQuery();
        
        while(rs.next()) {
            media = new Media(rs.getString("type"),rs.getString("name"),rs.getString("description"),rs.getString("format"),rs.getFloat("tailleMo"),rs.getString("location"),rs.getTimestamp("dateAjout"),rs.getString("userLogin"));
            media.setId(rs.getInt(1));
            medias.add(media);
        }
        
        rs.close();
        psmt.close();
        
        return medias;
    }

    public List<Media> getAllMediasDesc() throws SQLException {
        Media media = null;
        List<Media> medias = new ArrayList<>();
        
        String query = "SELECT * FROM media ORDER BY dateAjout DESC";
        
        psmt = connection.prepareStatement(query);
        
        ResultSet rs = psmt.executeQuery();
        
        while(rs.next()) {
            media = new Media(rs.getString("type"),rs.getString("name"),rs.getString("description"),rs.getString("format"),rs.getFloat("tailleMo"),rs.getString("location"),rs.getTimestamp("dateAjout"),rs.getString("userLogin"));
            media.setId(rs.getInt(1));
            medias.add(media);
        }
        
        rs.close();
        psmt.close();
        
        return medias;
    }
  
    public int getNumberOfContentByUser (String login) throws SQLException {

        int sum = 0;
        String query = "SELECT COUNT(id) FROM media WHERE userLogin = ? ";

        psmt = connection.prepareStatement(query);
        
        psmt.setString(1,login);
        
        ResultSet rs = psmt.executeQuery();
        if(rs.next()) {
            sum += rs.getInt(1);
         }

        psmt.close();
        rs.close();
        
        return sum;
    }
    
    public int getNumberOfContentByUser (String login, String type) throws SQLException {

        int sum = 0;
        String query = "SELECT COUNT(id) FROM media WHERE userLogin = ? AND type = ?";
        
        psmt = connection.prepareStatement(query);
        
        psmt.setString(1,login);
        psmt.setString(2,type);
               
        ResultSet rs = psmt.executeQuery();
         
        if(rs.next()) {
            sum += rs.getInt(1);
        }
        
        psmt.close();
        
        return sum;
    }
    
    public void addView(int idMedia) throws SQLException {
        
        String query = "UPDATE media SET view = ( view + 1 ) WHERE id = ?";
        
        psmt = connection.prepareStatement(query);
        
        psmt.setInt(1, idMedia);
        
        psmt.executeUpdate();
        
        psmt.close();
    }
      
    public List<Media> searchMedia(List<String> words) throws SQLException {
        
        Media media = null;
        List<Media> medias = new ArrayList<>();
        
        String postQuery = "";
        int count = 0;
        
        if(!words.isEmpty()) {
            for (String string : words) {
                if (count == 0) {
                    postQuery = postQuery + " WHERE name LIKE ? OR description LIKE ? ";
                } else {
                    postQuery = postQuery + " OR name LIKE ? OR description LIKE ? ";
                }
                ++count;
            }
            
            postQuery = postQuery + " ORDER BY dateAjout DESC LIMIT 10 ";
            
            count = 1;
            
            String query = "SELECT * FROM media " + postQuery;
            psmt = connection.prepareStatement(query);
            
            for (String string : words) {
                psmt.setString(count++, "%"+string+"%");
                psmt.setString(count++, "%"+string+"%");
            }
            
            ResultSet rs = psmt.executeQuery();
            
            while(rs.next()) {
                media = new Media(rs.getString("type"),rs.getString("name"),rs.getString("description"),rs.getString("format"),rs.getInt("tailleMo"),rs.getString("location"),rs.getInt("view"),rs.getTimestamp("dateAjout"),rs.getString("userLogin"));
                media.setId(rs.getInt(1));
                medias.add(media);
            }
            
            rs.close();
            psmt.close();
            
            return medias;
        } else {
            System.out.println("Your search returns an empty list of values.");
            return medias;
        }
    }

}
