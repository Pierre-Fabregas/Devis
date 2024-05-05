/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.mavenproject1;

/**
 *
 * @author fabre
 */
import java.util.List;

public class Mur {

    int idMur;
    int rectangleId; // Identifiant du rectangle auquel le mur appartient
    int numero_mur; // Numéro du mur dans le rectangle
    int nbrePortes;
    int nbreFenetres;
    Coin coinDebut;
    Coin coinFin;
    List<Revetement> listeRevetement;
    double hauteur; // Hauteur du mur

    public Mur(int idMur, int rectangleId, int numero_mur, int nbrePortes, int nbreFenetres, Coin coinDebut, Coin coinFin, List<Revetement> listeRevetement, double hauteur) {
        this.idMur = idMur;
        this.rectangleId = rectangleId;
        this.numero_mur = numero_mur;
        this.nbrePortes = nbrePortes;
        this.nbreFenetres = nbreFenetres;
        this.coinDebut = coinDebut;
        this.coinFin = coinFin;
        this.listeRevetement = listeRevetement;
        this.hauteur = hauteur;
    }
    
    /*public int RetrouverMur( int rectangleId, int numero_mur){
        for (Mur mur: Liste_murs) {
            if (rectangleId == mur.getRectangleId() && numero_mur == mur.getNumero_mur()){
                return mur.getIdMur();}
        }
    }*/
            

    public void setIdMur(int idMur) {
        this.idMur = idMur;
    }

    public void setRectangleId(int rectangleId) {
        this.rectangleId = rectangleId;
    }

    public void setNumero_mur(int numero_mur) {
        this.numero_mur = numero_mur;
    }

    public void setNbrePortes(int nbrePortes) {
        this.nbrePortes = nbrePortes;
    }

    public void setNbreFenetres(int nbreFenetres) {
        this.nbreFenetres = nbreFenetres;
    }

    public void setCoinDebut(Coin coinDebut) {
        this.coinDebut = coinDebut;
    }

    public void setCoinFin(Coin coinFin) {
        this.coinFin = coinFin;
    }

    public void setListeRevetement(List<Revetement> listeRevetement) {
        this.listeRevetement = listeRevetement;
    }

    public void setHauteur(double hauteur) {
        this.hauteur = hauteur;
    }

    public int getIdMur() {
        return idMur;
    }

    public int getRectangleId() {
        return rectangleId;
    }

    public int getNumero_mur() {
        return numero_mur;
    }

    public int getNbrePortes() {
        return nbrePortes;
    }

    public int getNbreFenetres() {
        return nbreFenetres;
    }

    public Coin getCoinDebut() {
        return coinDebut;
    }

    public Coin getCoinFin() {
        return coinFin;
    }

    public List<Revetement> getListeRevetement() {
        return listeRevetement;
    }

    public double getHauteur() {
        return hauteur;
    }

       
    
    @Override
    public String toString() {
        return "Mur{" + "idMur=" + idMur + ", rectangleId=" + rectangleId + ", murNumber=" + numero_mur + ", nbrePortes=" + nbrePortes + ", nbreFenetres=" + nbreFenetres + ", coinDebut=" + coinDebut + ", coinFin=" + coinFin + ", listeRevetement=" + listeRevetement + ", hauteur=" + hauteur + '}';
    }
}

