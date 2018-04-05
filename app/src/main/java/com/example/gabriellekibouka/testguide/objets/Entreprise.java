package com.example.gabriellekibouka.testguide.objets;

/**
 * Created by gabrielle kibouka on 12/03/2018.
 */

public class Entreprise {
    String nom;
    String adresse;
    String numeroTel;
    String email;
    String categorie;
    String dateDeCreation;
    String boitePostale;
    String description;
    //    String image;
    Integer imag;


    public Entreprise(String nom, String adresse, String numeroTel,
                      String email, String categorie, String dateDeCreation,
                      String boitePostale, String description, Integer imag) {
        this.nom = nom;
        this.adresse = adresse;
        this.numeroTel = numeroTel;
        this.email = email;
        this.categorie = categorie;
        this.dateDeCreation = dateDeCreation;
        this.boitePostale = boitePostale;
        this.description = description;
//        this.image=image;
        this.imag = imag;

    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getAdresse() {
        return adresse;
    }

    public void setAdresse(String adresse) {
        this.adresse = adresse;
    }

    public String getNumeroTel() {
        return numeroTel;
    }

    public void setNumeroTel(String numeroTel) {
        this.numeroTel = numeroTel;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getCategorie() {
        return categorie;
    }

    public void setCategorie(String categorie) {
        this.categorie = categorie;
    }

    public String getDateDeCreation() {
        return dateDeCreation;
    }

    public void setDateDeCreation(String dateDeCreation) {
        this.dateDeCreation = dateDeCreation;
    }

    public String getBoitePostale() {
        return boitePostale;
    }

    public void setBoitePostale(String boitePostale) {
        this.boitePostale = boitePostale;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

//    public String getImage() {
//        return image;
//    }
//
//    public void setImage(String image) {
//        this.image = image;
//    }

    public int getImag() {
        return imag;
    }

    public void setImag(int imag) {
        this.imag = imag;
    }
}



