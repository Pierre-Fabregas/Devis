/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.mavenproject1;

/**
 *
 * @author macbookpro
 */


public class Sol {
  int  idSol ;  
    private Coin[] listeCoins;
    private Revetement[] listeRevetements;

   


   
   
 public void afficher() {
    }
@Override
    public String toString() {
        String listeC = "";
        for (int i = 0; i < listeCoins.length; i++) {
            if (listeCoins[i] != null) {
                listeC += listeCoins[i].getIdcoin() + ",";
            }
        }
        if (listeC.endsWith(",")) {
            listeC = listeC.substring(0, listeC.length() - 1);
        }
        String listeR = "";
        for (int i = 0; i < listeRevetements.length; i++) {
            if (listeRevetements[i] != null) {
                listeR += listeRevetements[i].getIdRevetement() + ",";
            }
        }
        if (listeR.endsWith(",")) {
            listeR = listeR.substring(0, listeR.length() - 1);
        }
        return idSol + ";(" + listeC + ");(" + listeR + ")";
    }
/*
     * Calcule la surface du sol en utilisant la méthode du polygone.
     */
    public static double surface(int idSol, Sol[] sols) {
        int n = 0;
        double X[] = new double[100];
        double Y[] = new double[100];
        Coin[] listeDesCoins = sols[idSol].listeCoins;
        int a = 0;

        double refX = 0;
        double refY = 0;
        int nbCoins = 0;
        for (Coin coin : listeDesCoins) {
            if (coin != null) {
                refX += coin.getX();
                refY += coin.getY();
                nbCoins++;
            }
        }
        refX /= nbCoins;
        refY /= nbCoins;
        for (int i = 0; i < listeDesCoins.length - 1; i++) {
            for (int j = 0; j < listeDesCoins.length - i - 1; j++) {
                if (listeDesCoins[j] != null && listeDesCoins[j + 1] != null) {
                    double angle1 = Math.atan2(listeDesCoins[j].getY() - refY, listeDesCoins[j].getX() - refX);
                    double angle2 = Math.atan2(listeDesCoins[j + 1].getY() - refY,
                            listeDesCoins[j + 1].getY() - refX);
                    if (angle1 > angle2) {
                        Coin temp = listeDesCoins[j];
                        listeDesCoins[j] = listeDesCoins[j + 1];
                        listeDesCoins[j + 1] = temp;
                    }
                }
            }
        }

        for (int i = 0; i < listeDesCoins.length; i++) {
            if (listeDesCoins[i] != null) {
                X[a] = listeDesCoins[i].getX();
                Y[a] = listeDesCoins[i].getY();
                n++;
                a++;
            }
        }
        double surface = 0;
        int j = n - 1;
        for (int i = 0; i < n; i++) {
            surface += (X[j] + X[i]) * (Y[j] - Y[i]);

            j = i;
        }

        return Math.abs(surface / 2.0);
    }
 /*
     * Calcule le montant total des revêtements pour le sol donné.
     */
    public static double montantRevetement(int idSol, Sol[] sols, int nbRevetements) {
        Sol solCalcule = sols[idSol];
        Revetement[] listeRevetement = solCalcule.listeRevetements;
        double montantRevetement = 0;
        double surface = Sol.surface(idSol, sols);
        for (int i = 0; i < listeRevetement.length; i++) {
            if (listeRevetement[i] != null) {
                montantRevetement += listeRevetement[i].getPrixUnitaire();
            }
        }
        montantRevetement *= surface;

        return montantRevetement;
    }

    public static double[] surfaceTotaleRevetement(Sol[] sols, int nbRevetements) {
        double[] surfaceTotaleRevetement = new double[nbRevetements];
        for (int i = 0; i < sols.length; i++) {
            if (sols[i] != null) {
                Sol solCalcule = sols[i];
                Revetement[] listeRevetement = solCalcule.listeRevetements;
                double surface = Sol.surface(i, sols);
                for (int j = 0; j < listeRevetement.length; j++) {
                    if (listeRevetement[j] != null) {
                        surfaceTotaleRevetement[j] += surface;
                    }
                }
            }
        }

        return surfaceTotaleRevetement;
    }
    // --------------------------------------------------------------------------------
   
 /*
     * Fonction pour créer les sols à partir des coordonnées fournies.
     */
    public static Sol[] creationSols(Coin[] coins, Revetement[] revetements, int nbRevetements) {
        System.out.println("Creation des sols");
        System.out.println(
                "Veuillez entrer les coordonnees des sols du batiment avec le format suivant : idSol;idCoin(idCoin1,idCoin2,etc.);idRevetements(idRevetement1,idRevetement2,etc.). Entrez 'fin' pour terminer.");
        String entree = Lire.S();
        Sol[] sols = new Sol[100];
        while (!entree.equals("fin")) {
            int idSol = Integer.parseInt(entree.split(";")[0]);
            Coin[] listeCoin = new Coin[100];
            String liste = entree.split(";")[1];
            liste = liste.substring(liste.indexOf("(") + 1, liste.indexOf(")"));
            String[] listeCoinString = liste.split(",");
            for (int i = 0; i < listeCoinString.length; i++) {
                listeCoin[Integer.parseInt(listeCoinString[i])] = coins[Integer
                        .parseInt(listeCoinString[i])];
            }
            Revetement[] listeRevetements = new Revetement[nbRevetements + 1];
            liste = entree.split(";")[2];
            liste = liste.substring(liste.indexOf("(") + 1, liste.indexOf(")"));
            String[] listeRevetementString = liste.split(",");
            for (int i = 0; i < listeRevetementString.length; i++) {
                listeRevetements[Integer.parseInt(listeRevetementString[i])] = revetements[Integer
                        .parseInt(listeRevetementString[i])];
            }
            Sol sol = new Sol(idSol, listeCoin, listeRevetements);
            sols[idSol] = sol;
            entree = Lire.S();

        }
        for (int i = 0; i < sols.length; i++) {
            if (sols[i] != null) {
                System.out.println(sols[i]);
            }
        }
        System.out.println("");
        return sols;
    }

    // --------------------------------------------------------------------------------
    // Constructeur

    public Sol(int idSol, Coin[] listeCoins, Revetement[] listeRevetements) {
        this.idSol = idSol;
        this.listeCoins = listeCoins;
        this.listeRevetements = listeRevetements;
    }
}
