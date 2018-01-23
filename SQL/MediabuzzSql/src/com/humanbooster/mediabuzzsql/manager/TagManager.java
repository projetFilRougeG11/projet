package com.humanbooster.mediabuzzsql.manager;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class TagManager {

    private Connection connection;
    private PreparedStatement psmt;
    
    public TagManager(Connection connection) {
        this.connection = connection;
    }
    
//    CREATE
    
//    LIST
    
    public void addTop (int idTag) throws SQLException {
        
        String query = "UPDATE tag SET top = (top + 1) WHERE id = ?";
        
        psmt = connection.prepareStatement(query);
        
        psmt.setInt(1, idTag);
        
        psmt.executeUpdate();
        
        psmt.close();
    }
    
    public void addFlop (int idTag) throws SQLException {
        
        String query = "UPDATE tag SET flop = (flop + 1) WHERE id = ?";
        
        psmt = connection.prepareStatement(query);
        
        psmt.setInt(1, idTag);
        
        psmt.executeUpdate();
        
        psmt.close();
    }

    public int getTopTag(int idTag) throws SQLException {
        
        int nbTop = 0;
        
        String query = "SELECT top FROM tag WHERE id = ?";

        psmt = connection.prepareStatement(query);

        psmt.setInt(1, idTag);
        
        ResultSet rs = psmt.executeQuery();
        
        if(rs.next()) {
            nbTop = rs.getInt(1);
        }
        
        psmt.close();
        rs.close();
        
        return nbTop;
    }
    
    public int getFlopTag(int idTag) throws SQLException {
        
        int nbFlop = 0;
        
        String query = "SELECT flop FROM tag WHERE id = ?";

        psmt = connection.prepareStatement(query);

        psmt.setInt(1, idTag);
        
        ResultSet rs = psmt.executeQuery();

        if(rs.next()) {
            nbFlop = rs.getInt(1);   
        }
        
        psmt.close();
        rs.close();
        
        return nbFlop;
    }

    public int getAvgTag(int idTag) throws SQLException {
        
        double nbTop, nbFlop;
        
        nbTop = (double)this.getTopTag(idTag);
        nbFlop = (double)this.getFlopTag(idTag);
        return (int) Math.round((nbTop / (nbTop + nbFlop)) *100);
    }

    public int getNbVote(int idTag) throws SQLException {
        return this.getTopTag(idTag) + this.getFlopTag(idTag);
    }
    
}
