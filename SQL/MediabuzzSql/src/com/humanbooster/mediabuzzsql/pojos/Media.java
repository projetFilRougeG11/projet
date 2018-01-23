package com.humanbooster.mediabuzzsql.pojos;

import java.sql.Timestamp;

public class Media {
    private int id;
    private String type;
    private String name;
    private String description;
    private String format;
    private float tailleMo;
    private String location;
    private int view;
    private Timestamp dateAjout;
    private String userLogin;
    
    
    
    public Media() {
        super();
    }

    public Media(String type, String name, String description, String format, float tailleMo, String location,
            Timestamp dateAjout, String userLogin) {
        this();
        this.type = type;
        this.name = name;
        this.description = description;
        this.format = format;
        this.tailleMo = tailleMo;
        this.location = location;
        this.dateAjout = dateAjout;
        this.userLogin = userLogin;
    }

    public Media(String type, String name, String description, String format, float tailleMo, String location, int view,
            Timestamp dateAjout, String userLogin) {
        super();
        this.type = type;
        this.name = name;
        this.description = description;
        this.format = format;
        this.tailleMo = tailleMo;
        this.location = location;
        this.view = view;
        this.dateAjout = dateAjout;
        this.userLogin = userLogin;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getFormat() {
        return format;
    }

    public void setFormat(String format) {
        this.format = format;
    }

    public float getTailleMo() {
        return tailleMo;
    }

    public void setTailleMo(float tailleMo) {
        this.tailleMo = tailleMo;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public int getView() {
        return view;
    }

    public void setView(int view) {
        this.view = view;
    }

    public Timestamp getDateAjout() {
        return dateAjout;
    }

    public void setDateAjout(Timestamp dateAjout) {
        this.dateAjout = dateAjout;
    }

    public String getUserLogin() {
        return userLogin;
    }

    public void setUserLogin(String userLogin) {
        this.userLogin = userLogin;
    }

    @Override
    public String toString() {
        return "Media [id=" + id + ", type=" + type + ", name=" + name + ", description=" + description + ", format="
                + format + ", tailleMo=" + tailleMo + ", location=" + location + ", view=" + view + ", dateAjout="
                + dateAjout + ", userLogin=" + userLogin + "]";
    }
    
}
