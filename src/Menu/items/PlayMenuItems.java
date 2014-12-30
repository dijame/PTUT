package Menu.items;

import Acteur.Personnage.Joueur;
import Acteur.Personnage.StateJoueur;
import InGame.MapGameState;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.newdawn.slick.Color;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.Image;
import org.newdawn.slick.Input;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.state.StateBasedGame;

public enum PlayMenuItems implements IMenuItems {

	Pokedex    {
            private Image background;
            private int cursorIndex = 0;
            private int maxCursorIndex;
            private int cursorPositionY = 30;
            @Override
            public void doSomething(StateBasedGame game, Joueur joueur,Graphics g) throws SlickException{
                background = new Image("ressource/Pictures/pokedexbg.png");
                background.draw(0,0,800,600);
                joueur.getPkm().getPkmAnim(cursorIndex)[0].draw(30, 100);
                maxCursorIndex = joueur.getPkm().getTabPokemon().length;
                g.setColor(Color.black);
                for(int i = 0;i<maxCursorIndex;i++){
                    int decalRect = i * 30;
                    joueur.getPkm().getPkmAnim(i)[0].draw(310, 40+decalRect, 20, 20);
                    g.drawString(joueur.getPkm().getPokemon(i).getNom(), 330, 40+decalRect);
                }
                g.setColor(Color.blue);
                g.drawRect(300, cursorPositionY, 200, 30);
            }

            @Override
            public void keyPressed(int key, char c) {
                switch(key){
                    case Input.KEY_DOWN:
	        	if(cursorIndex<maxCursorIndex -1){
	        		cursorIndex++;
	        		cursorPositionY += 30;
	        	}
	            break;
	        case Input.KEY_UP:
	        	if(cursorIndex>0){
	        		cursorIndex--;
	        		cursorPositionY -= 30;
	        	}
	            break;
                }
            }

    }, Pokemon    {

            private Image background;
            private int cursorIndex = 0;
            private int maxCursorIndex;
            private int cursorPositionY = 30;
            @Override
            public void doSomething(StateBasedGame game, Joueur joueur,Graphics g) throws SlickException{
                background = new Image("ressource/Pictures/pokeselbg.png");
                background.draw(0,0,800,600);
                joueur.getPkm().getPkmAnim(cursorIndex)[0].draw(30, 250);
                maxCursorIndex = joueur.playerPkm.length;
                g.setColor(Color.black);
                for(int i = 0;i<maxCursorIndex;i++){
                    int decalRect = i * 105;
                    g.drawRect(200, 30+decalRect, 400, 100);
                    g.drawString(joueur.playerPkm[i].getNom(), 210, 55+decalRect);
                    g.drawString(Integer.toString(joueur.playerPkm[i].getLevel()), 230, 70+decalRect);
                    g.drawString(Integer.toString(joueur.playerPkm[i].getPv()) + "/" + Integer.toString(joueur.playerPkm[i].getPvMax()), 230, 90+decalRect);
                }
                g.setColor(Color.blue);
                g.drawRect(200, cursorPositionY, 400, 100);
            }

            @Override
            public void keyPressed(int key, char c) {
                switch(key){
                    case Input.KEY_DOWN:
	        	if(cursorIndex<maxCursorIndex -1){
	        		cursorIndex++;
	        		cursorPositionY += 105;
	        	}
	            break;
	        case Input.KEY_UP:
	        	if(cursorIndex>0){
	        		cursorIndex--;
	        		cursorPositionY -= 105;
	        	}
	            break;
                }
            }

    }, Bag    {

            private Image background;
            @Override
            public void doSomething(StateBasedGame game, Joueur Joueur,Graphics g) throws SlickException{
                background = new Image("ressource/Pictures/BagScreen.png");
                background.draw(0,0,800,600);            
            }

            @Override
            public void keyPressed(int key, char c) {
            }

    }, Pokegear    {
        
        private Image background;
            @Override
            public void doSomething(StateBasedGame game, Joueur Joueur,Graphics g) throws SlickException{
                background = new Image("ressource/Pictures/TrainerCard.png");
                background.draw(0,0,800,600);            }

            @Override
            public void keyPressed(int key, char c) {
            }


    }, Gold    {

            @Override
            public void doSomething(StateBasedGame game, Joueur Joueur,Graphics g) {
            }

            @Override
            public void keyPressed(int key, char c) {
            }

    }, Save    {

            @Override
            public void doSomething(StateBasedGame game, Joueur joueur,Graphics g) {
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

            @Override
            public void keyPressed(int key, char c) {
            }


    }, Option    {

            @Override
            public void doSomething(StateBasedGame game, Joueur Joueur,Graphics g) {
            }

            @Override
            public void keyPressed(int key, char c) {
            }


    }, Exit    {
         
            @Override
            public void doSomething(StateBasedGame game, Joueur Joueur,Graphics g) {
                game.enterState(MapGameState.ID);
            }

            @Override
            public void keyPressed(int key, char c) {
            }


    };

}
