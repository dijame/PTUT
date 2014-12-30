package Menu.items;

import Acteur.Personnage.Joueur;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.state.StateBasedGame;

public interface IMenuItems {

	void doSomething(StateBasedGame game,Joueur Joueur,Graphics g) throws SlickException;
        void keyPressed(int key, char c);
	
}
