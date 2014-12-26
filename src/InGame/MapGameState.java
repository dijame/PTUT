/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package InGame;

import Acteur.JoueurCommande;
import Acteur.Joueur;
import Menu.MenuGameState;
import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.Input;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.state.BasicGameState;
import org.newdawn.slick.state.StateBasedGame;

/**
 *
 * @author Albert
 */
public class MapGameState extends BasicGameState{
    
    public static final int ID = 2;
    private StateBasedGame game;
    private GameContainer container;
    private Carte map;
    private Joueur joueur;
    private JoueurCommande commande;
    private MusicGame music;
    
    public MapGameState(Carte map,Joueur joueur, JoueurCommande commande, MusicGame music) {
        this.map= map;
        this.joueur = joueur;
        this.commande = commande;
        this.music = music;
    }
    
    @Override
    public void init(GameContainer container, StateBasedGame game) throws SlickException {
        this.container = container;
        this.map.init();
        this.joueur.init();
        this.game = game;
    }

    @Override
    public void render(GameContainer gc, StateBasedGame game, Graphics grphcs) throws SlickException {
            this.map.render();
            this.joueur.render(grphcs);
    }
    
    @Override
    public void update(GameContainer gc, StateBasedGame game, int delta) throws SlickException {
        this.joueur.update(delta);
    }
     @Override
    public void keyReleased(int key, char c) {
        if(key == Input.KEY_ESCAPE) this.container.exit();
        else this.commande.keyReleased(key, c);
    }
  
    public void keyPressed(int key, char c) {
        this.commande.keyPressed(key, c);
        if(key == Input.KEY_X) {
            game.enterState(MenuGameState.ID);
        }
    }
        
    public int getID() {
    return ID;
  }

}
