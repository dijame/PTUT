/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Menu;

import Acteur.Joueur;
import InGame.MusicGame;
import org.newdawn.slick.Image;
import org.newdawn.slick.Input;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.state.StateBasedGame;
import Menu.items.IMenuItems;
import Menu.items.StartMenuItems;
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
    
    public MainScreenGameState(Joueur joueur,MusicGame music) throws SlickException {
        this.joueur = joueur;
        this.music = music;
    }
    @Override
    public void init(GameContainer gc, StateBasedGame game) throws SlickException {
        this.menuItems = new IMenuItems [] {StartMenuItems.Continue, StartMenuItems.NewGame,StartMenuItems.Options};
	this.cursorIndex = -1;
	this.maxCursorIndex = this.menuItems.length-1;
        
        this.title = new Image("ressource/Background/bg_1.png");
        this.choixImg = new Image("ressource/Background/arrow.png");
        this.cursorPositionX = 35;
        this.cursorPositionY = 47;
        music.getTitle().loop();
        this.game = game;    
    }

    @Override
    public void render(GameContainer gc, StateBasedGame game, Graphics g) throws SlickException {
        title.draw(0,0,800,600);
        if(cursorIndex != -1) {
        choixImg.draw(cursorPositionX,cursorPositionY);
        g.setColor(Color.black);
        g.drawString(joueur.getNom(), 170, 350);
        g.drawString(Integer.toString(joueur.getGold()), 170, 410);
        g.drawString(Integer.toString(joueur.getPokedex()), 190, 470);
        g.drawString(Integer.toString(joueur.getBadge()), 130, 530);
        music.getTitle().stop();
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
	        	if(cursorIndex<maxCursorIndex && cursorIndex != -1){
	        		cursorIndex++;
	        		cursorPositionY += 60;
                                this.music.getSelect().play();
	        	}
	            break;
	        case Input.KEY_UP:
	        	if(cursorIndex>0){
	        		cursorIndex--;
	        		cursorPositionY -= 60;
                                this.music.getSelect().play();
	        	}
	            break;
	        case Input.KEY_ENTER:
                        if(cursorIndex == -1) cursorIndex = 0;
                        else try {
                            menuItems[cursorIndex].doSomething(game,joueur);
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
