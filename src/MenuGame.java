
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
    
    private Image background;
    private Image choixImg;
    private int choixContinue;
    private float choixX;
    private float choixY;

    private Joueur joueur;
    private JoueurCommande commande;
    
    //Variable d'état
    private boolean gameTitle;
    
    public MenuGame(Joueur joueur, JoueurCommande commande){
        this.joueur =joueur;
        this.commande = commande;
    }
    
    public void init() throws SlickException {
        this.gameTitle = true;
        this.choixImg = new Image("ressource/Background/arrow.png");
        this.background = new Image("ressource/Background/bg_1.png");
        this.choixContinue = 1;
        this.choixX = 35;
        this.choixY = 47;
    }
    
    public void render(Graphics g) throws SlickException {
        background.draw(0, 0, 800, 600);
        if(gameTitle == false) {
            choixImg.draw(choixX, choixY);
            g.setColor(Color.black);
            g.drawString(joueur.getNom(),160,350);
            g.drawString(Integer.toString(joueur.getGold()),160,410);
            g.drawString(Integer.toString(joueur.getBadge()),180,470);
            g.drawString(Integer.toString(joueur.getPokedex()),120,530);
       }
    }
    
    public void update() throws SlickException, InterruptedException {
        if(gameTitle == false) background= new Image("ressource/Background/continue.png");
        if(joueur.getGameBegin() == true) {
            if(joueur.getMoving() == true) {
                switch (joueur.getDirection()) {
                    case 1:
                        if(choixContinue > 1){
                            choixContinue --;
                            choixY -= 60 ;
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
                            if(choixContinue == 1) {
                                this.joueur.setGameBegin(false);
                                this.joueur.setGameStart(true);
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
}