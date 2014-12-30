package Menu.items;

import Acteur.Personnage.Joueur;
import InGame.*;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.state.StateBasedGame;

public enum StartMenuItems implements IMenuItems {

	Continue    {
		@Override
        public void doSomething(StateBasedGame game,Joueur joueur,Graphics g)
        {
            game.enterState(MapGameState.ID);
        }

            @Override
            public void keyPressed(int key, char c) {
                throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
            }


    }, NewGame    {

            @Override
            public void doSomething(StateBasedGame game,Joueur joueur,Graphics g) throws SlickException{
                game.enterState(NewGameState.ID);
                joueur.init();
            }

            @Override
            public void keyPressed(int key, char c) {
            }

	
    }, Options    {

            @Override
            public void doSomething(StateBasedGame game,Joueur joueur,Graphics g) {
            }

            @Override
            public void keyPressed(int key, char c) {
                throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
            }

    };
}
