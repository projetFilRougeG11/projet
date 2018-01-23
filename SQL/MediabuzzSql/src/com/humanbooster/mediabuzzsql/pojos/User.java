package com.humanbooster.mediabuzzsql.pojos;

import java.sql.Timestamp;

public class User {
    private String login;
    private String password;
    private String mail;
    private Timestamp dateInscription;
    
    public User(String login, String password, String mail, Timestamp dateInscription) {
        super();
        this.login = login;
        this.password = password;
        this.mail = mail;
        this.dateInscription = dateInscription;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getMail() {
        return mail;
    }

    public void setMail(String mail) {
        this.mail = mail;
    }

    public Timestamp getDateInscription() {
        return dateInscription;
    }

    public void setDateInscription(Timestamp dateInscription) {
        this.dateInscription = dateInscription;
    }

    @Override
    public String toString() {
        return "User [login=" + login + ", password=" + password + ", mail=" + mail + ", dateInscription="
                + dateInscription + "]";
    }
    
}
