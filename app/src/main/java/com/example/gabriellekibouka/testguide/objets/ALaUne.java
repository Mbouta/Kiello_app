package com.example.gabriellekibouka.testguide.objets;

/**
 * Created by gabrielle kibouka on 15/03/2018.
 */

public class ALaUne {
    //attributs titre, photo, description
    String id;
//    String image;
    int image;
    String titre;
    String description;

    public ALaUne(int image, String titre, String description) {
        this.image = image;
        this.titre = titre;
        this.description = description;
    }

//    public String getImage() {
//        return image;
//    }
//
//    public void setImage(String image) {
//        this.image = image;
//    }

    public int getImage() {
        return image;
    }

    public void setImage(int image) {
        this.image = image;
    }

    public String getTitre() {
        return titre;
    }

    public void setTitre(String titre) {
        this.titre = titre;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }
}
