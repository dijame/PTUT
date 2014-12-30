/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Acteur.Pokemon;

import java.io.Serializable;

/**
 *
 * @author Albert
 */
public class StatePokemon implements Serializable{

    /**
     * @return the n_pkm
     */
    public static int getN_pkm() {
        return n_pkm;
    }
    
    private String nom;
    private static int n_pkm;
    private int pvMax;
    private int pv;
    private int atq;
    private int def;
    private int atqSpe;
    private int defSpe;
    private int vitt;
    private String type;
    private int level;
    private String pkmSprite;
    
    
    public StatePokemon(String nom,int pvMax,int pv,int atq, int def, int atqSpe, int defSpe,int vitt,String type,int level,String pkmSprite) {
        n_pkm++;
        this.nom = nom;
        this.pvMax = pvMax;
        this.pv = pv;
        this.atq = atq;
        this.def = def;
        this.atqSpe = atqSpe;
        this.defSpe = defSpe;
        this.vitt = vitt;
        this.type = type;
        this.level = level;
        this.pkmSprite = pkmSprite;
    } // Constructeur de pokémon

    /**
     * @return the nom
     */
    public String getNom() {
        return nom;
    }

    /**
     * @return the pvMax
     */
    public int getPvMax() {
        return pvMax;
    }

    /**
     * @return the pv
     */
    public int getPv() {
        return pv;
    }

    /**
     * @return the atq
     */
    public int getAtq() {
        return atq;
    }

    /**
     * @return the def
     */
    public int getDef() {
        return def;
    }

    /**
     * @return the atqSpe
     */
    public int getAtqSpe() {
        return atqSpe;
    }

    /**
     * @return the defSpe
     */
    public int getDefSpe() {
        return defSpe;
    }

    /**
     * @return the vitt
     */
    public int getVitt() {
        return vitt;
    }

    /**
     * @return the type
     */
    public String getType() {
        return type;
    }

    /**
     * @return the level
     */
    public int getLevel() {
        return level;
    }

    /**
     * @return the pkmSprite
     */
    public String getPkmSprite() {
        return pkmSprite;
    }

    
}
