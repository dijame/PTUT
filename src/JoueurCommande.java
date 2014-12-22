/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */


import java.awt.event.KeyEvent;
import org.newdawn.slick.Input;
import org.newdawn.slick.KeyListener;
import org.newdawn.slick.SlickException;

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
  
        public JoueurCommande(Joueur joueur) throws SlickException{
            this.joueur=joueur;
        }
        
       
    
        
    @Override
    public void setInput(Input input) {
            this.input = input;
    }
    
   
    public void keyPressed(int key, char c) {
        if(joueur.getGameBegin() == true) {
            switch (key) {
                    case Input.KEY_UP:
                        joueur.setDirection(1);
                        joueur.setMoving(true);
                    break;
                    case Input.KEY_DOWN:
                        joueur.setDirection(2);
                        joueur.setMoving(true);
                    break;
                    case Input.KEY_ENTER:
                        joueur.setDirection(3);
                        joueur.setMoving(true);
                    break;
            }

        }
        if(joueur.getNewGame() == true) {
	 if (joueur.getNom().length()<10 && key != Input.KEY_BACK) 
	  if (c!=0) {
            joueur.setNom(joueur.getNom() + c);
	  } 
          if (key == Input.KEY_BACK && joueur.getNom().length() > 0) joueur.setNom(joueur.getNom().substring(0,joueur.getNom().length()-1));
        }
        
        if(joueur.getGameStart()== true && joueur.getNewGame() == false) {
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

            }
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
