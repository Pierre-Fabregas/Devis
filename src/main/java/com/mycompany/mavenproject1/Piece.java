/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.mavenproject1;

/**
 *
 * @author macbookpro
 */

public class Piece {
    private int IdPiece;
    private int idAppartementPiece;
    private int sol;
    private int plafond;
    private Mur[] listeMurs;

    public void afficher() {
    }
@Override
    public String toString() {
        String listeM = "";
        for (int i = 0; i < listeMurs.length; i++) {
            if (listeMurs[i] != null) {
                listeM += listeMurs[i].getIdMur() + ",";
            }
        }
        if (listeM.endsWith(",")) {
            listeM = listeM.substring(0, listeM.length() - 1);
        }
        return IdPiece + ";" + sol + ";" + plafond + ";(" + listeM + ")";
    }

    public static double surface(int idPiece, Niveau[] niveaux, Appartement[] appartements, Piece[] pieces, Mur[] murs,
            Sol[] sols,
            Plafond[] plafonds, Coin[] coins) {
        Mur[] listeMurs = pieces[idPiece].listeMurs;
        int sol = pieces[idPiece].sol;
        int plafond = pieces[idPiece].plafond;
        double surfaceMurs = 0;
        for (int i = 0; i < listeMurs.length; i++) {
            if (listeMurs[i] != null) {
                surfaceMurs += Mur.surface(i, niveaux, appartements, pieces, murs, murs[i].getNbrePortes(),
                        murs[i].getNbreFenetres());
            }
        }
        double surfaceSol = Sol.surface(sol, sols);
        double surfacePlafond = Plafond.surface(plafond, plafonds);
        double surface = surfaceMurs + surfaceSol + surfacePlafond;
        return surface;
    }

    public double montantRevetement() {
        return 0;
    }

    // --------------------------------------------------------------------------------
    // Fonction pour creer les pieces

    public static Piece[] creationPieces(Mur[] murs) {
        System.out.println("Creation des pieces");
        System.out.println(
                "Veuillez entrer les coordonnees des pieces du batiment avec le format suivant : idPiece;idSol;idPlafond;idMur(idMur1,idMur2,etc.). Entrez 'fin' pour terminer.");
        String entree = Lire.S();
        Piece[] pieces = new Piece[100];
        while (!entree.equals("fin")) {
            int idPiece = Integer.parseInt(entree.split(";")[0]);
            int idSol = Integer.parseInt(entree.split(";")[1]);
            int idPlafond = Integer.parseInt(entree.split(";")[2]);
            Mur[] listeMur = new Mur[100];
            String liste = entree.substring(entree.indexOf("(") + 1, entree.indexOf(")"));
            String[] listeMurString = liste.split(",");
            for (int i = 0; i < listeMurString.length; i++) {
                murs[Integer.parseInt(listeMurString[i])].setPieceId(idPiece);
                System.out.println("idPieceMur: " + murs[Integer.parseInt(listeMurString[i])].getIdpieceMur());
                listeMur[Integer.parseInt(listeMurString[i])] = murs[Integer
                        .parseInt(listeMurString[i])];
            }
            Piece piece = new Piece(idPiece, idSol, idPlafond, listeMur);
            pieces[idPiece] = piece;
            entree = Lire.S();

        }
        for (int i = 0; i < pieces.length; i++) {
            if (pieces[i] != null) {
                System.out.println(pieces[i]);
            }
        }
        System.out.println("");
        return pieces;
    }

    // --------------------------------------------------------------------------------
    // Constructeur

    public Piece(int idPiece, int sol, int plafond, Mur[] listeMurs) {
        this.IdPiece = idPiece;
        this.sol = sol;
        this.plafond = plafond;
        this.listeMurs = listeMurs;
    }
     public int getIdAppartementPiece() {
        return idAppartementPiece;
    }

    public int getIdPiece() {
        return IdPiece;
    }

    public void setIdAppartementPiece(int idAppartementPiece) {
        this.idAppartementPiece = idAppartementPiece;
    }
    
    
    

     
   
    
}