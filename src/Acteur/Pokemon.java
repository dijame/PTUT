package Acteur;


import org.newdawn.slick.SlickException;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Albert
 */
public class Pokemon {
    
    //Variable stat pokémon vie, etc ...
    private String nom;
    private static int n_pkm;
    private int pv;
    private int atq;
    private int def;
    private int atqSpe;
    private int defSpe;
    private int vitt;
    
    private Pokemon tabPokemon[] = new Pokemon[25];
    
    public Pokemon(String nom,int pv,int atq, int def, int atqSpe, int defSpe,int vitt) {
        n_pkm++;
        this.nom = nom;
        this.pv = pv;
        this.atq = atq;
        this.def = def;
        this.atqSpe = atqSpe;
        this.defSpe = defSpe;
        this.vitt = vitt;
    }
    public void init() throws SlickException {
        remplirPokemon();
    }
    
    public void render() throws SlickException {
        
    }
    
    public void update() throws SlickException {
        
    }
    
    public void remplirPokemon() {
        tabPokemon[0] = new Pokemon("Bulbizarre",45,49,49,65,65,45);
        tabPokemon[1] = new Pokemon("Salameche",39,52,43,60,40,65);
        tabPokemon[2] = new Pokemon("Carapuce",44,48,65,50,64,43);
        tabPokemon[3] = new Pokemon("Pikachu",35,55,40,50,50,90);
        tabPokemon[4] = new Pokemon("Caninos",55,70,45,70,50,60);
    }
    
}
