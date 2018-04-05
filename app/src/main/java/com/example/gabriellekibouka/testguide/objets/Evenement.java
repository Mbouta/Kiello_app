package com.example.gabriellekibouka.testguide.objets;

/**
 * Created by gabrielle kibouka on 16/03/2018.
 */

public class Evenement {
    String id;
    int image;
    String titre;
    String description;

    public Evenement(int image, String titre, String description) {
        this.image = image;
        this.titre = titre;
        this.description = description;
    }

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
}
