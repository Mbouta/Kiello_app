package com.example.gabriellekibouka.testguide.objets;

/**
 * Created by lebeau BAFOUIDIZO on 07/04/2018.
 */

public class TimeLine {
    String id;
    String titre;
    String contenu;
    String logoFrom;
    String endPoint;
    String image;
    String date;


    public TimeLine(String id, String titre, String contenu, String logoFrom, String endPoint, String image, String date) {
        this.id = id;
        this.titre = titre;
        this.contenu = contenu;
        this.logoFrom = logoFrom;
        this.endPoint = endPoint;
        this.image = image;
        this.date = date;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getTitre() {
        return titre;
    }

    public void setTitre(String titre) {
        this.titre = titre;
    }

    public String getContenu() {
        return contenu;
    }

    public void setContenu(String contenu) {
        this.contenu = contenu;
    }

    public String getLogoFrom() {
        return logoFrom;
    }

    public void setLogoFrom(String logoFrom) {
        this.logoFrom = logoFrom;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public String getEndPoint() {
        return endPoint;
    }

    public void setEndPoint(String endPoint) {
        this.endPoint = endPoint;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }
}

