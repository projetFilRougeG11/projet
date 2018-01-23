package com.humanbooster.mediabuzzsql.pojos;

public class Tag {
    private int id;
    private String content;
    private int top;
    private int flop;
    private int idMedia;
    
    public Tag(String content, int idMedia) {
        super();
        this.content = content;
        this.idMedia = idMedia;
    }

    public Tag(String content, int top, int flop, int idMedia) {
        super();
        this.content = content;
        this.top = top;
        this.flop = flop;
        this.idMedia = idMedia;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public int getTop() {
        return top;
    }

    public void setTop(int top) {
        this.top = top;
    }

    public int getFlop() {
        return flop;
    }

    public void setFlop(int flop) {
        this.flop = flop;
    }

    public int getIdMedia() {
        return idMedia;
    }

    public void setIdMedia(int idMedia) {
        this.idMedia = idMedia;
    }

    @Override
    public String toString() {
        return "Tag [id=" + id + ", content=" + content + ", top=" + top + ", flop=" + flop + ", idMedia=" + idMedia
                + "]";
    }
  
}
