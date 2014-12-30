package Acteur.Pokemon;


import org.newdawn.slick.Animation;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.SpriteSheet;

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

    /**
     * @return the n_pkm
     */
    public static int getN_pkm() {
        return n_pkm;
    }
    
    //Variable stat pokémon vie, etc ...
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
    
    private Animation[] pkmAnim;
    
    private Pokemon tabPokemon[] = new Pokemon[5];
    
    public Pokemon(String nom,int pvMax,int pv,int atq, int def, int atqSpe, int defSpe,int vitt,String type,int level,String pkmSprite) {
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
    public Pokemon() {
        remplirPokemon();
        pkmAnim = new Animation[1];
    }
    
    public void remplirPokemon() { // On instancie les pokémon du jeu !
        tabPokemon[0] = new Pokemon("Bulbizarre",140,140,79,89,95,85,90,"Plante",50,"ressource/Battlers/bulbizarre.png");
        tabPokemon[1] = new Pokemon("Salameche",139,139,92,73,90,80,90,"Feu",50,"ressource/Battlers/salameche.png");
        tabPokemon[2] = new Pokemon("Carapuce",144,144,88,75,100,80,80,"Eau",50,"ressource/Battlers/carapuce.png");
        tabPokemon[3] = new Pokemon("Pikachu",135,135,75,75,90,80,95,"Electrique",50,"ressource/Battlers/pikachu.png");
        tabPokemon[4] = new Pokemon("Caninos",155,155,120,85,135,90,100,"Feu",50,"ressource/Battlers/caninos.png");
    }
    
    public Pokemon getPokemon(int numPkm) { // récupérer un pokémon avec ses stats.
        return getTabPokemon()[numPkm];
    }
    public Animation[] getPkmAnim(int numPkm) throws SlickException{ // Créer Animation du pokémon choisis
        SpriteSheet spriteSheet = new SpriteSheet(getTabPokemon()[numPkm].getPkmSprite(), 145, 145);// image contenant les sprites
        
        this.pkmAnim[0] = loadAnimation(spriteSheet, 0, 1, 0);
        
        return pkmAnim;
    }
    
    private Animation loadAnimation(SpriteSheet spriteSheet, int startX, int endX, int y) {
    Animation animation = new Animation();
    for (int x = startX; x < endX; x++) {
        animation.addFrame(spriteSheet.getSprite(x, y), 5);
    }
    return animation;
}
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

    /**
     * @return the tabPokemon
     */
    public Pokemon[] getTabPokemon() {
        return tabPokemon;
    }

   
}
