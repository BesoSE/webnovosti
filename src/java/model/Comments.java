/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

/**
 *
 * @author korisnik
 */
public class Comments {
    private int id;
    private String comment;
    private int iduser;
    private int idnews;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }

    public int getIduser() {
        return iduser;
    }

    public void setIduser(int iduser) {
        this.iduser = iduser;
    }

    public int getIdnews() {
        return idnews;
    }

    public void setIdnews(int idnews) {
        this.idnews = idnews;
    }
    
    
}
