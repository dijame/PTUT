package InGame;


import Acteur.Personnage.Joueur;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.newdawn.slick.Music;
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
public class MusicGame {
    
    // BGM
    private Music title;
    
    // SE
    private Music select;
    
    public MusicGame() {
        try {
            this.select = new Music("ressource/Music/SE/select.wav");  // Son des menus
            this.title = new Music("ressource/Music/BGM/TitleMomo.ogg");
        } catch (SlickException ex) {
            Logger.getLogger(MusicGame.class.getName()).log(Level.SEVERE, null, ex);
        }
    }



    public Music getSelect() {
        return select;
    }

    /**
     * @return the title
     */
    public Music getTitle() {
        return title;
    }
}
