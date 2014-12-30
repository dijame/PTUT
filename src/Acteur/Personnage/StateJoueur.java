package Acteur.Personnage;


import Acteur.Pokemon.StatePokemon;
import Acteur.Personnage.Joueur;
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
    private StatePokemon[] playerPkm = new StatePokemon[5];

    public StateJoueur(Joueur joueur) {
        this.x = joueur.getX();
        this.y = joueur.getY();
        this.nom = joueur.getNom();
        this.gold = joueur.getGold();
        this.badge = joueur.getBadge();
        this.pokedex = joueur.getPokedex();
        for(int i = 0;i<playerPkm.length;i++){
            this.playerPkm[i] = new StatePokemon(joueur.playerPkm[i].getNom(),joueur.playerPkm[i].getPvMax(),joueur.playerPkm[i].getPv(),joueur.playerPkm[i].getAtq(),joueur.playerPkm[i].getDef(),joueur.playerPkm[i].getAtqSpe(),joueur.playerPkm[i].getDefSpe(),joueur.playerPkm[i].getVitt(),joueur.playerPkm[i].getType(),joueur.playerPkm[i].getLevel(),joueur.playerPkm[i].getPkmSprite());;
        }
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

    /**
     * @return the playerPkm
     */
    public StatePokemon[] getPlayerPkm() {
        return playerPkm;
    }
}
