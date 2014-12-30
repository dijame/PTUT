/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Menu;

import Acteur.Personnage.Joueur;
import InGame.MusicGame;
import org.newdawn.slick.Image;
import org.newdawn.slick.Input;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.state.StateBasedGame;
import Menu.items.IMenuItems;
import Menu.items.StartMenuItems;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.newdawn.slick.Color;
import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.state.BasicGameState;

/**
 *
 * @author Albert
 */
public class MainScreenGameState extends BasicGameState{
    
        public static final int ID = 1;
    // extra logic
	protected Joueur joueur;
	protected MusicGame music;
	// business logic
	protected int cursorIndex;
	protected int maxCursorIndex;
	protected IMenuItems [] menuItems;

	//UI logic
        private Image title;
	protected Image choixImg;
	protected int cursorPositionX;
	protected int cursorPositionY;
    
    private StateBasedGame game;
    private Graphics g;
    
    public MainScreenGameState(Joueur joueur,MusicGame music) throws SlickException {
        this.joueur = joueur;
        this.music = music;
    }
    @Override
    public void init(GameContainer gc, StateBasedGame game) throws SlickException {
        this.menuItems = new IMenuItems [] {StartMenuItems.Continue, StartMenuItems.NewGame,StartMenuItems.Options};
	this.cursorIndex = -1;
	this.maxCursorIndex = this.menuItems.length-1;
        // On créer un tableau contenant les choix Menu: Continue , ...
        this.title = new Image("ressource/Background/bg_1.png");
        this.choixImg = new Image("ressource/Background/arrow.png");
        this.cursorPositionX = 35;
        this.cursorPositionY = 47;
        music.getTitle().loop();
        this.game = game;    
    }

    @Override
    public void render(GameContainer gc, StateBasedGame game, Graphics g) throws SlickException {
        this.g = g;
        title.draw(0,0,800,600);
        if(cursorIndex != -1) { // Si on est plus sur l'écran titre alors :
            choixImg.draw(cursorPositionX,cursorPositionY);
            g.setColor(Color.black);
            g.drawString(joueur.getNom(), 170, 350);
            g.drawString(Integer.toString(joueur.getGold()), 170, 410);
            g.drawString(Integer.toString(joueur.getPokedex()), 190, 470);
            g.drawString(Integer.toString(joueur.getBadge()), 130, 530);
        }
    }

    @Override
    public void update(GameContainer gc, StateBasedGame game, int delta) throws SlickException {
        if(cursorIndex == 0) title = new Image("ressource/Background/continue.png");
    }
    
    public void keyReleased(int key, char c){
    }
    public void keyPressed(int key, char c) {
        switch (key) {
	        case Input.KEY_DOWN:
	        	if(cursorIndex<maxCursorIndex && cursorIndex != -1){// Si on a pas atteint la limite
	        		cursorIndex++;// du tableau Menu alors on descend dans les choix
	        		cursorPositionY += 60;
                                this.music.getSelect().play();
	        	}
	            break;
	        case Input.KEY_UP:
	        	if(cursorIndex>0){// Si on est en dessous de 0 on monte dans les choix
	        		cursorIndex--;
	        		cursorPositionY -= 60;
                                this.music.getSelect().play();
	        	}
	            break;
	        case Input.KEY_ENTER:
                        music.getTitle().stop();
                        if(cursorIndex == -1) { // Si écran titre :
                            cursorIndex = 0;
                            try {
                                joueur.charger();
                            } catch (IOException ex) {
                                Logger.getLogger(StartMenuItems.class.getName()).log(Level.SEVERE, null, ex);
                            } catch (ClassNotFoundException ex) {
                                Logger.getLogger(StartMenuItems.class.getName()).log(Level.SEVERE, null, ex);
                            }
                        }
                        else try { // Sinon on execute la méthode du coix (Continue,...)
                            menuItems[cursorIndex].doSomething(game,joueur,g);
        } catch (SlickException ex) {
            Logger.getLogger(MainScreenGameState.class.getName()).log(Level.SEVERE, null, ex);
        }
	            break;
        }
	}

    @Override
    public int getID() {
        return ID;
    }

    
}
