package Menu.items;

import Acteur.Joueur;
import Acteur.StateJoueur;
import InGame.MapGameState;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.newdawn.slick.Image;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.state.StateBasedGame;

public enum PlayMenuItems implements IMenuItems {

	Pokedex    {
            private Image background;
            @Override
            public void doSomething(StateBasedGame game, Joueur Joueur) throws SlickException{
                background = new Image("ressource/Pictures/pokedexbg.png");
                background.draw(0,0,800,600);
            }

    }, Pokemon    {

            @Override
            public void doSomething(StateBasedGame game, Joueur Joueur) {
                throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
            }

    }, Bag    {

            private Image background;
            @Override
            public void doSomething(StateBasedGame game, Joueur Joueur) throws SlickException{
                background = new Image("ressource/Pictures/BagScreen.png");
                background.draw(0,0,800,600);            }

    }, Pokegear    {
        
        private Image background;
            @Override
            public void doSomething(StateBasedGame game, Joueur Joueur) throws SlickException{
                background = new Image("ressource/Pictures/TrainerCard.png");
                background.draw(0,0,800,600);            }


    }, Gold    {

            @Override
            public void doSomething(StateBasedGame game, Joueur Joueur) {
                throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
            }

    }, Save    {

            @Override
            public void doSomething(StateBasedGame game, Joueur joueur) {
                FileOutputStream sortieDeFicher = null;
                try {
                    StateJoueur sauvegarde = new StateJoueur(joueur);
                    sortieDeFicher = sortieDeFicher = new FileOutputStream("ressource/Save/save.pkm");
                    ObjectOutputStream sortieDObjet = new ObjectOutputStream(sortieDeFicher);
                    sortieDObjet.writeObject(sauvegarde);
                    sortieDObjet.close();
                } catch (FileNotFoundException ex) {
                    Logger.getLogger(PlayMenuItems.class.getName()).log(Level.SEVERE, null, ex);
                } catch (IOException ex) {
                    Logger.getLogger(PlayMenuItems.class.getName()).log(Level.SEVERE, null, ex);
                } finally {
                    try {
                        sortieDeFicher.close();
                    } catch (IOException ex) {
                        Logger.getLogger(PlayMenuItems.class.getName()).log(Level.SEVERE, null, ex);
                    }
                }
                game.enterState(MapGameState.ID);
            }


    }, Option    {

            @Override
            public void doSomething(StateBasedGame game, Joueur Joueur) {
                throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
            }


    }, Exit    {
         
            @Override
            public void doSomething(StateBasedGame game, Joueur Joueur) {
                game.enterState(MapGameState.ID);
            }


    };

}
