/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Menu;

import Acteur.Joueur;
import InGame.Carte;
import Menu.items.*;
import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.Image;
import org.newdawn.slick.Input;
import org.newdawn.slick.KeyListener;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.state.BasicGameState;
import org.newdawn.slick.state.StateBasedGame;

/**
 *
 * @author Albert
 */
public class MenuGameState extends BasicGameState{
    
    public static final int ID = 3;
    private StateBasedGame game;
    // extra logic
	protected Joueur joueur;
	protected Carte map;
        
	// business logic
	protected int cursorIndex;
	protected int maxCursorIndex;
	protected IMenuItems [] menuItems;

	//UI logic
	protected Image choixImg;
	protected int cursorPositionX;
	protected int cursorPositionY;
	protected Image menuImg;

    public MenuGameState(Carte map, Joueur joueur) throws SlickException {
        this.joueur = joueur;
        this.map = map;
    }

    @Override
    public void init(GameContainer gc, StateBasedGame sbg) throws SlickException {
        this.menuItems = new IMenuItems [] {PlayMenuItems.Pokedex, PlayMenuItems.Pokemon,PlayMenuItems.Bag,PlayMenuItems.Pokegear,PlayMenuItems.Gold,PlayMenuItems.Save,PlayMenuItems.Option,PlayMenuItems.Exit };
        this.cursorIndex = 0;
        this.maxCursorIndex = this.menuItems.length-1;

        this.choixImg = new Image("ressource/Background/arrow.png");
        this.cursorPositionX = 570;
        this.cursorPositionY = 47;
        this.menuImg = new Image("ressource/Pictures/Menu.png");
        this.game = game;
    }

    @Override
    public void render(GameContainer gc, StateBasedGame game, Graphics g) throws SlickException {
        this.map.render();
        this.joueur.render(g);
        menuImg.draw(0,0,800,600);
        choixImg.draw(cursorPositionX,cursorPositionY);
    }

    @Override
    public void update(GameContainer gc, StateBasedGame sbg, int i) throws SlickException {
    }
    
    @Override
	public void keyPressed(int key, char arg1) {
        switch (key) {
	        case Input.KEY_DOWN:
	        	if(cursorIndex<maxCursorIndex){
	        		cursorIndex++;
	        		cursorPositionY += 60;
	        	}
	            break;
	        case Input.KEY_UP:
	        	if(cursorIndex>0){
	        		cursorIndex--;
	        		cursorPositionY -= 60;
	        	}
	            break;
	        case Input.KEY_ENTER:
	        	menuItems[cursorIndex].doSomething(game,joueur);
	            break;
        }
	}
    @Override
    public void keyReleased(int key, char c) {
        
    }

    @Override
    public int getID() {
        return ID;
    }
    
}
