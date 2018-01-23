package com.humanbooster.mediabuzzsql.pojos;

import java.sql.Timestamp;

public class Comment {
    private int id;
    private String text;
    private Timestamp dateAjout;
    private int idUser;
    private int idMedia;
    
    public Comment(String text, Timestamp dateAjout, int idUser, int idMedia) {
        super();
        this.text = text;
        this.dateAjout = dateAjout;
        this.idUser = idUser;
        this.idMedia = idMedia;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public Timestamp getDateAjout() {
        return dateAjout;
    }

    public void setDateAjout(Timestamp dateAjout) {
        this.dateAjout = dateAjout;
    }

    public int getIdUser() {
        return idUser;
    }

    public void setIdUser(int idUser) {
        this.idUser = idUser;
    }

    public int getIdMedia() {
        return idMedia;
    }

    public void setIdMedia(int idMedia) {
        this.idMedia = idMedia;
    }

    @Override
    public String toString() {
        return "Comment [id=" + id + ", text=" + text + ", dateAjout=" + dateAjout + ", idUser=" + idUser + ", idMedia="
                + idMedia + "]";
    }
 
}
