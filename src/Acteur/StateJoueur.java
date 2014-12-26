package Acteur;


import Acteur.Joueur;
import java.io.Serializable;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Albert
 */
public class StateJoueur implements Serializable{
    
    private String nom;
    private int gold;
    private int badge;
    private int pokedex;
    private float x, y;

    public StateJoueur(Joueur joueur) {
        this.x = joueur.getX();
        this.y = joueur.getY();
        this.nom = joueur.getNom();
        this.gold = joueur.getGold();
        this.badge = joueur.getBadge();
        this.pokedex = joueur.getPokedex();
    }

    /**
     * @return the nom
     */
    public String getNom() {
        return nom;
    }

    /**
     * @return the gold
     */
    public int getGold() {
        return gold;
    }

    /**
     * @return the badge
     */
    public int getBadge() {
        return badge;
    }

    /**
     * @return the pokedex
     */
    public int getPokedex() {
        return pokedex;
    }

    /**
     * @return the x
     */
    public float getX() {
        return x;
    }

    /**
     * @return the y
     */
    public float getY() {
        return y;
    }
}
