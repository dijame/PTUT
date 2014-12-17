/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */


import org.newdawn.slick.Animation;
import org.newdawn.slick.AppGameContainer;
import org.newdawn.slick.BasicGame;
import org.newdawn.slick.Color;
import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.Image;
import org.newdawn.slick.Input;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.SpriteSheet;
import org.newdawn.slick.tiled.TiledMap;

public class WindowGame extends BasicGame {
    /*
        -- x et y sont les coordonées du personnage
        -- camX et camY sont les coordonées de la caméra
    
        --/!\ Cette classe WindowGame fait TOUT 
        --/!\ Les classes Carte, FenetreJeu, Joueur & JoueurCommande sont censé faire tout ce que fait la classe WindowsGame
        --/!\ L'idéal, serait de creer des classe Camera, Quete, Gestion de combat etc.. et de mettre à jour la classe MAP, pour 
        --/!\ la gestion de collision..
    */
    // Variable contenu
    private GameContainer container;
    private Image background;
    // Continue \\
    private Image choixImg;
    private int choixContinue;
    private float choixX;
    private float choixY;
    private TiledMap map;

    private float x = 300, y = 300; 
   // pour la camera private float camX = x, camY=y;
    private int direction;
    private boolean moving = false;
    private Animation[] animations = new Animation[8];
    
    // Variable d'état
    private boolean gameBegin;
    private boolean gameStart;
    private boolean gameBattle;

    public static void main(String[] args) throws SlickException {
        new AppGameContainer(new WindowGame(), 800, 600, false).start();
    }

    public WindowGame() {
        super("PTUT: Test ");
    }
    //Cette methode init charge les ressources
    @Override
    public void init(GameContainer container) throws SlickException {
        this.container = container;
        this.gameBegin = true;
        this.gameStart = false;
        this.gameBattle = false;
        
        // Background --> Continue
        this.background = new Image("ressource/Background/continue.png");
        this.choixImg = new Image("ressource/Background/arrow.png");
        this.choixContinue = 1;
        this.choixX = 35;
        this.choixY = 47;
        // MAP
        this.map = new TiledMap("ressource/map/map1.tmx");
        
        // Init du personnage
        SpriteSheet spriteSheet = new SpriteSheet("ressource/sprites/spriteMomo.png", 57, 57);// image contenant les sprites
        // animations[0] pour aller au sud, [1] a l'ouest, [2] au nord [3] à l'est
        
        this.animations[0] = loadAnimation(spriteSheet, 0, 1, 3);//Dans les lignes avec loadAnimation
        this.animations[1] = loadAnimation(spriteSheet, 0, 1, 1);//(spriteSheet, x, final x, y)
        this.animations[2] = loadAnimation(spriteSheet, 0, 1, 0);//x represente la position initial du personnage 
        this.animations[3] = loadAnimation(spriteSheet, 0, 1, 2);//final x, represente la position final du personnage.
        this.animations[4] = loadAnimation(spriteSheet, 1, 3, 3);//y represente la ligne ou se situe le personnage
        this.animations[5] = loadAnimation(spriteSheet, 1, 3, 1);
        this.animations[6] = loadAnimation(spriteSheet, 1, 3, 0);
        this.animations[7] = loadAnimation(spriteSheet, 1, 3, 2);
    }
    // Cette méthode loadAnimation, permet d'effectuer les animations
    private Animation loadAnimation(SpriteSheet spriteSheet, int startX, int endX, int y) {
        Animation animation = new Animation();
        for (int x = startX; x < endX; x++) {
            animation.addFrame(spriteSheet.getSprite(x, y), 200);
        }
        return animation;
    }
    //Cette methode permet d'afficher le jeu
    @Override
    public void render(GameContainer container, Graphics g) throws SlickException {
        if (gameBegin == true){ // Si début du jeu
            background.draw(0, 0, 800, 600);
            choixImg.draw(choixX, choixY);
        }
        if(gameStart == true){ // Si on est dans le jeu !
            this.map.render(0, 0);
            g.setColor(new Color(0, 0, 0, .5f));
            g.fillOval(x-30 , y - 6, 32, 16);  //Dessine l'ombre du personnage
            g.drawAnimation(animations[direction + (moving ? 4 : 0)], x - 40, y - 40);
   //Pour la camera     g.translate(container.getWidth() / 2 - (int) this.camX, container.getHeight() / 2 - (int) this.camY);
        }
    }
    //Cette methode permet de raffraichir le jeu
    @Override
    public void update(GameContainer container, int delta) throws SlickException {
        System.out.println(choixContinue);
        if(gameBegin == true) {
            if (this.moving) {
                switch (this.direction) {
                    case 1:
                        if(choixContinue > 1){
                            choixContinue --;
                            choixY -= 60 ;
                            this.moving = false;
                        }
                    break;
                    case 2:
                        if(choixContinue < 3) {
                            choixContinue ++;
                            choixY += 60; 
                            this.moving = false;
                        }
                    break;
                    case 3:
                        if(choixContinue == 1) {
                            gameBegin = false;
                            gameStart = true;
                        }
                    break; 

                }
            }
        }
        
        if(gameStart == true) {
            if (this.moving) {
                switch (this.direction) {
                    //0 nord, 1 ouest, 2 sud, 3 est ...
                case 0:
                    this.y -= .1f * delta;
                    break;
                case 1:
                    this.x -= .1f * delta;
                    break;
                case 2:
                    this.y += .1f * delta;
                    break;
                case 3:
                    this.x += .1f * delta;
                    break;
                }

            }
        }
    }

    @Override
    public void keyReleased(int key, char c) {
        this.moving = false;
        if (Input.KEY_SPACE == key) {
            this.container.exit();
        }
    }

    @Override
    public void keyPressed(int key, char c) {
        // Déplacement dans le menu
        if(gameBegin == true){
            switch (key) {
                case Input.KEY_UP:
                    this.direction = 1;
                    this.moving = true;
                break;
                case Input.KEY_DOWN:
                    this.direction = 2;
                    this.moving = true;
                break;
                case Input.KEY_ENTER:
                    this.direction = 3;
                    this.moving = true;
                break;
            }
            
        }
        if (gameStart == true) {
        // Déplacement du personnage (Input)
            switch (key) {
            case Input.KEY_UP:
                this.direction = 0;
                this.moving = true;
                break;
            case Input.KEY_LEFT:
                this.direction = 1;
                this.moving = true;
                break;
            case Input.KEY_DOWN:
                this.direction = 2;
                this.moving = true;
                break;
            case Input.KEY_RIGHT:
                this.direction = 3;
                this.moving = true;
                break;

            }
        }
    }   
}
