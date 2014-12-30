/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package InGame;

import Acteur.Personnage.Joueur;
import org.newdawn.slick.Color;
import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.Image;
import org.newdawn.slick.Input;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.state.BasicGameState;
import org.newdawn.slick.state.StateBasedGame;

/**
 *
 * @author Albert
 */
public class NewGameState extends BasicGameState{
    public final static int ID = 3;
    private StateBasedGame game;
    private Image background;
    private Joueur joueur;
    
    public NewGameState(Joueur joueur) throws SlickException{
        this.joueur = joueur;
    }


    @Override
    public void init(GameContainer gc, StateBasedGame game) throws SlickException {
        this.game = game;
        background = new Image("ressource/Background/newGame.png");
    }

    @Override
    public void render(GameContainer gc, StateBasedGame game, Graphics g) throws SlickException {
        background.draw(0,0,800,600);
        g.setColor(Color.black);
        g.drawString(joueur.getNom(),450,470);
    }

    @Override
    public void update(GameContainer gc, StateBasedGame game, int i) throws SlickException {
    }
    
    @Override
    public void keyReleased(int key,char c){
    }
    
    @Override
    public void keyPressed(int key, char c) {
        if(joueur.getNom().length() < 10 && key != Input.KEY_BACK) 
            joueur.setNom(joueur.getNom() + c);
        if(joueur.getNom().length() > 0 && key == Input.KEY_BACK)  
            joueur.setNom(joueur.getNom().substring(0,joueur.getNom().length() - 1));
        if(key == Input.KEY_ENTER) game.enterState(MapGameState.ID);

    }
    
    @Override
    public int getID() {
        return ID;
    }
    
}
