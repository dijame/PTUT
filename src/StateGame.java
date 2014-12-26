
import Acteur.Joueur;
import Acteur.JoueurCommande;
import InGame.Carte;
import Menu.*;
import InGame.*;
import org.newdawn.slick.AppGameContainer;
import org.newdawn.slick.GameContainer;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.state.StateBasedGame;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Albert
 */
public class StateGame extends StateBasedGame{
    
    private Carte map = new Carte();
    private Joueur joueur = new Joueur(map);
    private JoueurCommande commande = new JoueurCommande(this.joueur);
    private MusicGame music = new MusicGame();
    
    public static void main(String[] args) throws SlickException {
    new AppGameContainer(new StateGame(), 800, 600, false).start();
  }
    
    public StateGame() {
        super("Menu");
    }

    @Override
    public void initStatesList(GameContainer gc) throws SlickException {
        addState(new MainScreenGameState(joueur,music));
        addState(new NewGameState(joueur));
        addState(new MapGameState(map,joueur,commande,music));
        addState(new MenuGameState(map,joueur));
        gc.setTargetFrameRate(60);
    }
}
