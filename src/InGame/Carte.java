package InGame;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import org.newdawn.slick.Image;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.tiled.TiledMap;



/**
 *
 * @author Simka
 */
public class Carte {
    /*
        -- Cette classe permettra de gérer les maps (Transition / Colision ...)
    */
    
    private TiledMap map;
    
    public void init() throws SlickException{
        this.map = new TiledMap("ressource/map/tour.tmx");
    }
    
    public void render(){
        // gestion de la camera \\
            this.map.render(0, 0, 0);
            // affichage du personnage \\
            this.map.render(0, 0, 1);
    }
    

    public int getTileWidth() {
        return map.getTileWidth();
    }

    public int getTileHeight() {
        return map.getTileHeight();
    }

    public int getLayerIndex(String logic) {
        return this.map.getLayerIndex(logic);
    }

    public Image getTileImage(int i, int i0, int logicLayer) {
        return this.map.getTileImage(i, i0, logicLayer);
    }

    public int getObjectCount(int i) {
        return this.map.getObjectCount(i);
    }

    public float getObjectX(int i, int objectID) {
        return this.map.getObjectX(i, objectID);
    }

    public float getObjectWidth(int i, int objectID) {
        return this.map.getObjectWidth(i, objectID);
    }

    public float getObjectY(int i, int objectID) {
        return this.map.getObjectY(i,objectID);
    }

    public float getObjectHeight(int i, int objectID) {
        return this.map.getObjectHeight(i, objectID);
    }

    public Object getObjectType(int i, int objectID) {
        return this.map.getObjectType(i, objectID);
    }

    public String getObjectProperty(int i, int objectID, String destx, String toString) {
        return this.map.getObjectProperty(i, objectID, destx, toString);
    }
    
}
