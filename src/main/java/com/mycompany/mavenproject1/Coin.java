/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.mavenproject1;

/**
 *
 * @author fabre
 */



public class Coin {
  
    int IdPiececoin;
    int coinNumber;
    double cx, cy;
    int idcoin;

    public Coin(int idcoin, int IdPiececoin, int coinNumber, double cx, double cy) {
        this.IdPiececoin = IdPiececoin;
        this.coinNumber = coinNumber;
        this.cx = cx;
        this.cy = cy;
        this.idcoin = idcoin;
    }

    
    public double getX() {
        return cx;
    }

    public double getY() {
        return cy;
    }

    public int getIdcoin() {
        return idcoin;
    }
    
    // --------------------------------------------------------------------------------
    // Fonction pour creer les coins

  /*  public static Coin[] creationCoins() {
        System.out.println("Creation du batiment");
        System.out.println("Creation des coins");
        System.out.println(
                "Veuillez entrer les coordonnees des coins du batiment avec le format suivant : idCoin;cx;cy. Entrez 'fin' pour terminer.");

        String entree = Lire.S();
        Coin[] coins = new Coin[100];
        while (!entree.equals("fin")) {
            int idCoin = Integer.parseInt(entree.split(";")[0]);
            double cx = Double.parseDouble(entree.split(";")[1]);
            double cy = Double.parseDouble(entree.split(";")[2]);
            Coin coin = new Coin(idcoin,rectangleId, coinNumber,  , cy);
            coins[idCoin] = coin;
            entree = Lire.S();
        }

        for (int i = 0; i < coins.length; i++) {
            if (coins[i] != null) {
                System.out.println(coins[i]);
            }
        }
        System.out.println("");
        return coins;
    } */

    @Override
    public String toString() {
        return "Coin{" + "idcoin" + idcoin + "IdPiececoin=" + IdPiececoin + ", coinNumber=" + coinNumber + ", cx=" + cx + ", cy=" + cy + '}';
    }
}