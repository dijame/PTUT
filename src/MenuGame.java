
import Acteur.JoueurCommande;
import Acteur.Joueur;
import java.io.IOException;
import org.newdawn.slick.Color;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.Image;
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
public class MenuGame {
    
    // GameBegin
    private Image background;
    private Image choixImg;
    private int choixContinue;
    private float choixX;
    private float choixY;

    private Joueur joueur;
    private JoueurCommande commande;
    
    //Menu inGame
    private Image menuImg;
    private int choixMenu;
    
    //Variable d'état
    private boolean gameTitle;
    
    public MenuGame(Joueur joueur, JoueurCommande commande){
        this.joueur =joueur;
        this.commande = commande;
    }
    
    public void init() throws SlickException {
        //GameBegin
        this.gameTitle = true;
        this.choixImg = new Image("ressource/Background/arrow.png");
        this.background = new Image("ressource/Background/bg_1.png");
        this.choixContinue = 1;
        this.choixX = 35;
        this.choixY = 47;
        
        //Menu Jeu
        this.menuImg = new Image("ressource/Pictures/Menu.png");
        this.choixMenu = 1;
    }
    
    public void render(Graphics g) throws SlickException, IOException {
        if(joueur.getGameBegin() == true) { // Menu en début de jeu
            background.draw(0, 0, 800, 600);
            if(joueur.getNewGame() == true) {
                g.drawString(joueur.getNom(), 450, 480);
            }       
            if(joueur.getNewGame() == false) {
                
            }
        }
        if(joueur.getMenu() == true) { // Graphique menu inGame
            choixX= 570;
            menuImg.draw(0, 0, 800, 600);
            choixImg.draw(choixX,choixY);
        }
    }
    
    public void update() throws SlickException, InterruptedException, IOException {
        if(gameTitle == false && joueur.getNewGame() == false) background= new Image("ressource/Background/continue.png");
        if(joueur.getGameBegin() == true) {
            if(joueur.getMoving() == true) {
                switch (joueur.getDirection()) { // Menu Continue,New Game et Option
                    case 1:
                        if(choixContinue > 1){
                            choixContinue --;
                            choixY -= 60; 
                            Thread.sleep(100);
                        }
                    break;
                    case 2:
                        if(choixContinue < 3) {
                            choixContinue ++;
                            choixY += 60; 
                            Thread.sleep(100);
                       }
                    break;
                    case 3:
                        if(gameTitle == false) {
                            if(choixContinue == 1) {// Continue
                                    joueur.setGameBegin(false);
                                    joueur.setGameStart(true);  
                           }
                            if(choixContinue == 2) { // New Game
                                joueur.setNewGame(true);
                                joueur.setNom("");
                                background = new Image("ressource/Background/newGame.png");
                                choixY= 47;
                           }
                        } 
                        else {
                            joueur.setDirection(1);
                            gameTitle = false;
                        }
                    break; 

               }
           }
        }
        if(joueur.getMenu() == true) {
            if(joueur.getMoving() == true) {
                switch (joueur.getDirection()) { // Menu inGame Pokedex,...
                    case 1:
                        if(choixMenu > 1){
                            choixMenu --;
                            choixY -= 60;
                            Thread.sleep(100);
                        }
                    break;
                    case 2:
                        if(choixMenu < 8) {
                            choixMenu ++;
                            choixY += 60; 
                            Thread.sleep(100);
                        }
                    break;
                    case 3:
                        if(choixMenu == 6) { // Save
                            joueur.setMenu(false);
                           }
                        if(choixMenu == 8) joueur.setMenu(false); // Exit
                    break;
                }
            }
        }
    }
    public Image getChoixImg() {
        return choixImg;
    }
    public int getChoixContinue() {
        return choixContinue;
    }
    public void setChoixImg(Image choixImg) {
        this.choixImg = choixImg;
    }
    public void setChoixContinue(int choixContinue) {
        this.choixContinue = choixContinue;
    }
    public void setGameTitle(boolean gameTitle) {
        this.gameTitle = gameTitle;
    }
    public boolean getGameTitle() {
        return gameTitle;
    }

    /**
     * @return the choixMenu
     */
    public int getChoixMenu() {
        return choixMenu;
    }
}