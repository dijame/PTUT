package Menu.items;

import Acteur.Joueur;
import InGame.MapGameState;
import org.newdawn.slick.state.StateBasedGame;

public enum PlayMenuItems implements IMenuItems {

	Pokedex    {

            @Override
            public void doSomething(StateBasedGame game, Joueur Joueur) {
                throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
            }

            @Override
            public void doSomething(Joueur Joueur) {
                throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
            }
    }, Pokemon    {

            @Override
            public void doSomething(StateBasedGame game, Joueur Joueur) {
                throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
            }

            @Override
            public void doSomething(Joueur Joueur) {
                throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
            }

    }, Bag    {

            @Override
            public void doSomething(StateBasedGame game, Joueur Joueur) {
                throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
            }

            @Override
            public void doSomething(Joueur Joueur) {
                throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
            }
    }, Pokegear    {

            @Override
            public void doSomething(StateBasedGame game, Joueur Joueur) {
                throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
            }

            @Override
            public void doSomething(Joueur Joueur) {
                throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
            }
    }, Gold    {

            @Override
            public void doSomething(StateBasedGame game, Joueur Joueur) {
                throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
            }

            @Override
            public void doSomething(Joueur Joueur) {
                throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
            }

    }, Save    {

            @Override
            public void doSomething(StateBasedGame game, Joueur Joueur) {
                throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
            }

            @Override
            public void doSomething(Joueur Joueur) {
                
            }

    }, Option    {

            @Override
            public void doSomething(StateBasedGame game, Joueur Joueur) {
                throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
            }

            @Override
            public void doSomething(Joueur Joueur) {
                throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
            }

    }, Exit    {

            @Override
            public void doSomething(StateBasedGame game, Joueur Joueur) {
                game.enterState(MapGameState.ID);
            }

            @Override
            public void doSomething(Joueur Joueur) {
                throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
            }

    };

}
