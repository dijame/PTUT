package Acteur.Personnage;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import org.newdawn.slick.Input;
import org.newdawn.slick.KeyListener;

/**
 *
 * @author Simka
 */
public class JoueurCommande implements KeyListener {
    
    /*
        Cette classe permet de déplacer notre personnage sur les map
        
    */
    private Joueur joueur;
    private Input input;
  
    public JoueurCommande(Joueur joueur) {
        this.joueur=joueur;
    }
        
    @Override
    public void setInput(Input input) {
            this.input = input;
    }
    
   
    public void keyPressed(int key, char c) {
            switch (key) {
            case Input.KEY_UP:
                this.joueur.setDirection(0); 
                this.joueur.setMoving(true);
                break;

            case Input.KEY_LEFT:
                this.joueur.setDirection(1);
                this.joueur.setMoving(true);
                break;

            case Input.KEY_DOWN:
                this.joueur.setDirection(2);
                this.joueur.setMoving(true);
                break;

            case Input.KEY_RIGHT:
                this.joueur.setDirection(3);
                this.joueur.setMoving(true);
                break;
            case Input.KEY_X :
                
            }
}

    @Override
    public void keyReleased(int key, char c) {
     
            this.joueur.setMoving(false);
        
    }

    @Override
    public boolean isAcceptingInput() {
        return true;
    }

    @Override
    public void inputEnded() {
    }

    @Override
    public void inputStarted() {
    }

   
  
    
}
