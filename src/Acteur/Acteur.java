/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Acteur;

import Acteur.Pokemon.Pokemon;

/**
 *
 * @author Albert
 */
public class Acteur {
    
    protected String nom;
    public Pokemon [] playerPkm;
    protected boolean dresseur;
    protected Pokemon pokemon;

    public Acteur(Pokemon pokemon) {
        this.pokemon = pokemon;
        playerPkm = new Pokemon[5];
    }
    /**
     * @return the nom
     */
    public String getNom() {
        return nom;
    }

    /**
     * @param nom the nom to set
     */
    public void setNom(String nom) {
        this.nom = nom;
    }

    /**
     * @return the playerPkm
     */
    public Pokemon[] getPlayerPkm() {
        return playerPkm;
    }

    /**
     * @param playerPkm the playerPkm to set
     */
    public void setPlayerPkm(Pokemon[] playerPkm) {
        this.playerPkm = playerPkm;
    }

    /**
     * @return the dresseur
     */
    public boolean getDresseur() {
        return dresseur;
    }

    /**
     * @param dresseur the dresseur to set
     */
    public void setDresseur(boolean dresseur) {
        this.dresseur = dresseur;
    }
    
    
}
