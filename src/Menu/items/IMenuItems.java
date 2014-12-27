package Menu.items;

import Acteur.Joueur;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.state.StateBasedGame;

public interface IMenuItems {

	void doSomething(StateBasedGame game,Joueur Joueur) throws SlickException;
	
}
