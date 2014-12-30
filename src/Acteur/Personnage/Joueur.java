package Acteur.Personnage;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import Acteur.Acteur;
import Acteur.Pokemon.Pokemon;
import InGame.Carte;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.ObjectInputStream;
import org.newdawn.slick.Animation;
import org.newdawn.slick.Color;
import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.Image;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.SpriteSheet;

/**
 *
 * @author Simka
 */
public class Joueur extends Acteur{
    
    //Animation
    private float x, y;
    private int direction;
    private boolean moving = false;
    private Animation[] animations = new Animation[8];
    private Carte map;
    
            
    //Variable Stat (Nom,Gold,etc ...)
    private int gold;
    private int badge;
    private int pokedex;
    
    public Joueur(Pokemon pokemon,Carte map){
        super(pokemon);
        this.map = map;
    }
    
    public void init() throws SlickException {
        //Variable position
        x = 665; y = 567;
        direction = 1;
        //Variable Stat
        this.nom = "";
        this.gold = 0;
        this.badge = 0;
        this.pokedex = 0;
        this.dresseur = true;
        for(int i =0;i<5;i++) {
            playerPkm[i] = pokemon.getPokemon(i);
        }
    }
    public void initAnimation() throws SlickException {
        SpriteSheet spriteSheet = new SpriteSheet("ressource/sprites/spriteMomo.png", 57, 57);// image contenant les sprites
        // animations[0] pour aller au sud, [1] a l'ouest, [2] au nord [3] à l'est
        
        this.animations[0] = loadAnimation(spriteSheet, 0, 1, 3);//Dans les lignes avec loadAnimation
        this.animations[1] = loadAnimation(spriteSheet, 0, 1, 1);//(spriteSheet, x, final x, y)
        this.animations[2] = loadAnimation(spriteSheet, 0, 1, 0);//x represente la position initial du personnage 
        this.animations[3] = loadAnimation(spriteSheet, 0, 1, 2);//final x, represente la position final du personnage.
        this.animations[4] = loadAnimation(spriteSheet, 1, 3, 3);//y represente la ligne ou se situe le personnage
        this.animations[5] = loadAnimation(spriteSheet, 1, 3, 1);
        this.animations[6] = loadAnimation(spriteSheet, 1, 3, 0);
        this.animations[7] = loadAnimation(spriteSheet, 1, 3, 2);
    }
    
    // Cette méthode loadAnimation, permet d'effectuer les animations
    private Animation loadAnimation(SpriteSheet spriteSheet, int startX, int endX, int y) {
        Animation animation = new Animation();
        for (int x = startX; x < endX; x++) {
            animation.addFrame(spriteSheet.getSprite(x, y), 200);
        }
        return animation;
    }
    
    /* Cete méthode permet d'afficher le personnage
            -fillOval permet de mettre une ombre sous le personnage.
    
    */
      public void render(GameContainer container, Graphics g) throws SlickException {
        
        // Animation
        g.setColor(new Color(0, 0, 0, .5f));
        g.fillOval(x-30 , y - 6, 32, 16);
        g.drawAnimation(animations[direction + (moving ? 4 : 0)], x - 40, y - 40);
    }
    
    // Cette méthode permet de mettre à jour la position du personnage
    public void update(int delta){
        for (int objectID = 0; objectID < map.getObjectCount(0); objectID++) {
        if (x > map.getObjectX(0, objectID)
                && x < map.getObjectX(0, objectID) + map.getObjectWidth(0, objectID)
                && y > map.getObjectY(0, objectID)
                && y < map.getObjectY(0, objectID) + map.getObjectHeight(0, objectID)) {
            if ("teleport".equals(map.getObjectType(0, objectID))) {
                x = Float.parseFloat(map.getObjectProperty(0, objectID, "dest-x", Float.toString(x)));
                y = Float.parseFloat(map.getObjectProperty(0, objectID, "dest-y", Float.toString(y)));
            } 
        }
     }
        if (this.moving) {
        float futurX = getFuturX(delta);
        float futurY = getFuturY(delta);
        boolean collision = isCollision(futurX, futurY);
        if (collision) {
            this.moving = false;
        } else {
            this.x = futurX;
            this.y = futurY;
        }
    }
    //mise à jour de la camera \\
}

private boolean isCollision(float x, float y) {
    int tileW = this.map.getTileWidth();
    int tileH = this.map.getTileHeight();
    int logicLayer = this.map.getLayerIndex("logic");
    Image tile = this.map.getTileImage((int) x / tileW, (int) y / tileH, logicLayer);
    boolean collision = tile != null;
    if (collision) {
        Color color = tile.getColor((int) x % tileW, (int) y % tileH);
        collision = color.getAlpha() > 0;
    }
    return collision;
}

private float getFuturX(int delta) {
    float futurX = this.x;
    switch (this.direction) {
    case 1: futurX = this.x - .1f * delta; break;
    case 3: futurX = this.x + .1f * delta; break;
    }
    return futurX;
}

private float getFuturY(int delta) {
    float futurY = this.y;
    switch (this.direction) {
    case 0: futurY = this.y - .1f * delta; break;
    case 2: futurY = this.y + .1f * delta; break;
    }
    return futurY;
}
    /*      Les getteurs et setteur permettent, à partir de la classe JoueurCommande d'avoir acces
            à la position du personnage, savoir si il est en mouvement via sa direction et le boolean
            mooving.
    */
    public void charger() throws FileNotFoundException, IOException, ClassNotFoundException {
        FileInputStream entreeDeFicher  = new FileInputStream("ressource/Save/save.pkm");
        ObjectInputStream entreeDObjet = new ObjectInputStream(entreeDeFicher);
        StateJoueur sauvegarde = (StateJoueur) entreeDObjet.readObject();
        entreeDObjet.close();
        transformerEn(sauvegarde);
    }
    public float getX(){
       return x;
    }       
    public void setX(float x){
       this.x = x;
    }       
    public float getY(){
       return y;
    }       
    public void setY(float y){
        this.y = y;
    }       
    public int getDirection (){
        return direction;
    }       
    public void setDirection(int direction){
        this.direction = direction;
    }
    public boolean getMoving(){
        return moving;
    }
    public void setMoving(boolean moving){
        this.moving = moving;
    }
    public int getGold() {
       return gold;
    }
    public void setGold(int gold) {
       this.gold = gold;
    }
    public int getBadge() {
           return badge;
    }
    public void setBadge(int badge) {
        this.badge = badge;
    }
    public int getPokedex() {
       return pokedex;
    }
    public void setPokedex(int pokedex) {
        this.pokedex = pokedex;
    }
    public Pokemon getPkm(){
        return pokemon;
    }


    public void transformerEn(StateJoueur sauvegarde) {
        x = sauvegarde.getX(); y = sauvegarde.getY();
        nom = sauvegarde.getNom();
        gold = sauvegarde.getGold();
        badge = sauvegarde.getBadge();
        pokedex = sauvegarde.getPokedex();
        for(int i = 0;i<playerPkm.length;i++){
            playerPkm[i] = new Pokemon(sauvegarde.getPlayerPkm()[i].getNom(),sauvegarde.getPlayerPkm()[i].getPvMax(),sauvegarde.getPlayerPkm()[i].getPv(),sauvegarde.getPlayerPkm()[i].getAtq(),sauvegarde.getPlayerPkm()[i].getDef(),sauvegarde.getPlayerPkm()[i].getAtqSpe(),sauvegarde.getPlayerPkm()[i].getDefSpe(),sauvegarde.getPlayerPkm()[i].getVitt(),sauvegarde.getPlayerPkm()[i].getType(),sauvegarde.getPlayerPkm()[i].getLevel(),sauvegarde.getPlayerPkm()[i].getPkmSprite());;
        }
    }

}
      
