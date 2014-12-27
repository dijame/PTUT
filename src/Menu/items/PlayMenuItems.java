package Menu.items;

import Acteur.Joueur;
import InGame.MapGameState;
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
            public void doSomething(StateBasedGame game, Joueur Joueur) {
                throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
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
