package Menu.items;

import Acteur.Joueur;
import InGame.*;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.newdawn.slick.state.StateBasedGame;

public enum StartMenuItems implements IMenuItems {

	Continue    {
		@Override
        public void doSomething(StateBasedGame game,Joueur joueur)
        {
            try {
                joueur.charger();
            } catch (IOException ex) {
                Logger.getLogger(StartMenuItems.class.getName()).log(Level.SEVERE, null, ex);
            } catch (ClassNotFoundException ex) {
                Logger.getLogger(StartMenuItems.class.getName()).log(Level.SEVERE, null, ex);
            }
            game.enterState(MapGameState.ID);
        }


    }, NewGame    {

            @Override
            public void doSomething(StateBasedGame game,Joueur joueur) {
                game.enterState(NewGameState.ID);
            }

	
    }, Options    {

            @Override
            public void doSomething(StateBasedGame game,Joueur joueur) {
            }

    };
}
