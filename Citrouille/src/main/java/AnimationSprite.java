import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;
import javax.swing.ImageIcon;
import javax.swing.JPanel;
import javax.swing.Timer;

public class AnimationSprite extends JPanel {
    protected static ImageIcon sprite; 
    protected static ImageIcon marche_haut; 
    protected static ImageIcon marche_bas; 
    protected static ImageIcon marche_droite; 
    protected static ImageIcon marche_gauche; 
    protected static ImageIcon dash_droite; 
    protected static ImageIcon dash_gauche; 
    protected static ImageIcon dash_haut; 
    protected static ImageIcon dash_bas; 
    
    
    protected static ImageIcon haut; 
    protected static ImageIcon bas; 
    protected static ImageIcon droite; 
    protected static ImageIcon gauche;
    protected static ImageIcon map; 
    protected static Image[] collision; 
    
    protected static int facteur1 = 3;
    protected static int facteur2 = facteur1 - 1; 
    protected static int vitesse; 
    protected boolean keyDroite; 
    protected boolean keyGauche; 
    protected boolean keyHaut; 
    protected boolean keyBas;
   
    protected static int x; 
    protected static int y;
    protected static int x_SpriteHitbox; 
    protected static int y_SpriteHitbox;
    protected static int [] x_PoingHitbox; 
    protected static int [] y_PoingHitbox; 
    protected ImageIcon SpriteHitbox = new ImageIcon("src/main/java/dessin/HitBox/Sprite_HitBox.png"); 
    protected ImageIcon PoingHitboxX = new ImageIcon("src/main/java/dessin/HitBox/PoingX_HitBox.png"); 
    protected ImageIcon PoingHitboxY = new ImageIcon("src/main/java/dessin/HitBox/PoingY_HitBox.png"); 
            
    protected boolean keyDashDroite; 
    protected boolean keyDashGauche; 
    protected boolean keyDashHaut; 
    protected boolean keyDashBas;
    protected boolean isKeyDashPressed; 
    protected int keyTypeDash; 
    
    protected Timer right; 
    protected Timer left; 
    protected Timer up; 
    protected Timer down; 
    
    protected Timer dashD; 
    protected Timer dashG; 
    protected Timer dashH; 
    protected Timer dashB; 
    protected Timer stopDash; 
    protected int dashType; 
    
    protected boolean checkCollision;
    protected static int taille; 
    protected static ArrayList<Integer>[] coo; 
    protected static ArrayList<Integer>[] dimension;
    
    protected int ChangeMaxY = 265;  
    protected int ChangeMinY = -3;  
    protected int AppMaxY = 247; 
    protected int AppMinY = 2; 
    
    protected int ChangeMaxX = 475;  
    protected int ChangeMinX = -10;  
    protected int AppMaxX = 465; 
    protected int AppMinX = 5; 
    
    protected int vitesseDash; 
    
    protected boolean isAttaquePressed;
    protected Timer stopNumAttaquePoing; 
    protected Timer attaqueEnMouvement; 
    protected Timer [] stopPoingDroite; 
    protected Timer [] stopPoingGauche;
    protected Timer stopPoingBas; 
    protected Timer stopPoingHaut; 
    protected ImageIcon [] attaquePoingDroite;
    protected ImageIcon [] attaquePoingGauche;  
    protected ImageIcon attaquePoingBas; 
    protected ImageIcon attaquePoingHaut; 
    protected int numAttaque = 1; 
    
    protected ImageIcon attaque_lance; 
    protected boolean poingActifDroite; 
    protected boolean poingActifGauche; 
    protected boolean poingActifHaut; 
    protected boolean poingActifBas; 
    
    
    public AnimationSprite(int x, int y){  
        this.x = x*facteur1; 
        this.y = y*facteur1;
        stopPoingDroite = new Timer[3]; 
        stopPoingGauche = new Timer[3]; 
        attaquePoingDroite = new ImageIcon[3]; 
        attaquePoingGauche = new ImageIcon[3]; 
        x_PoingHitbox = new int[2]; 
        y_PoingHitbox = new int[2]; 
        for(int i=0; i<x_PoingHitbox.length; i++){
            x_PoingHitbox[i] = -50;  
            y_PoingHitbox[i] = -50;
        }
        egaliserCooHitBox();
        setVitesse(); 
        setAnimation(); 
        setSprite();
        Marche();
        MarcheInstantane(); 
        Released(); 
        Souris();  
        setDashDroite(); 
        setFocusable(true); 
    }
    //Modifier la vitesse selon le facteur(qui est definit en fonction de la taille de la fenetre; 
    public static void setVitesse(){
        if(facteur1 == 4){
            vitesse = facteur1 + 2; 
        }else if(facteur1 == 3){
            vitesse = facteur1 + 1; 
        }else if(facteur1 == 2){
            vitesse = facteur1 ; 
        }else if(facteur1 == 5){
            vitesse = facteur1 + 3; 
        }
    }
    //Definir les images de chaque type de marche selon leur direcion; 
    public void setAnimation(){
        if(marche_haut == null){
            ImageIcon i = new ImageIcon("src/main/java/dessin/Marche/marche_dos.gif"); 
            marche_haut = i; 
            i = new ImageIcon("src/main/java/dessin/Marche/marche_face.gif"); 
            marche_bas = i; 
            i = new ImageIcon("src/main/java/dessin/Marche/marche_droite.gif"); 
            marche_droite = i;
            i = new ImageIcon("src/main/java/dessin/Marche/marche_gauche.gif"); 
            marche_gauche = i; 
            i = new ImageIcon("src/main/java/dessin/sprite/marche_dos.gif"); 
            haut = i; 
            i = new ImageIcon("src/main/java/dessin/sprite/marche_face.gif"); 
            bas = i; 
            i = new ImageIcon("src/main/java/dessin/sprite/marche_droite.gif"); 
            droite = i; 
            i = new ImageIcon("src/main/java/dessin/sprite/marche_gauche.gif"); 
            gauche = i; 
        }
    }
    //Definir les images de chaque Attaque => Passe par une ImageIcon puis par une Image pour ensuite la convertir en ImageIcon pour reinitialer le gif au debut;
    private void setPoingDroite(){
        ImageIcon icon = new ImageIcon("src/main/java/dessin/AttaqueFrontale/Droite/poing_droite1.gif"); 
        Image image = icon.getImage().getScaledInstance(icon.getIconWidth(), icon.getIconHeight(), Image.SCALE_DEFAULT); 
        attaquePoingDroite[0] = new ImageIcon(image); 
        icon = new ImageIcon("src/main/java/dessin/AttaqueFrontale/Droite/poing_droite2.gif");  
        image = icon.getImage().getScaledInstance(icon.getIconWidth(), icon.getIconHeight(), Image.SCALE_DEFAULT); 
        attaquePoingDroite[1] = new ImageIcon(image);
        icon = new ImageIcon("src/main/java/dessin/AttaqueFrontale/Droite/poing_droite3.gif");  
        image = icon.getImage().getScaledInstance(icon.getIconWidth(), icon.getIconHeight(), Image.SCALE_DEFAULT); 
        attaquePoingDroite[2] = new ImageIcon(image);
    
    }
    private void setPoingGauche(){
        ImageIcon icon = new ImageIcon("src/main/java/dessin/AttaqueFrontale/Gauche/poing_gauche1.gif"); 
        Image image = icon.getImage().getScaledInstance(icon.getIconWidth(), icon.getIconHeight(), Image.SCALE_DEFAULT); 
        attaquePoingGauche[0] = new ImageIcon(image); 
        icon = new ImageIcon("src/main/java/dessin/AttaqueFrontale/Gauche/poing_gauche2.gif");  
        image = icon.getImage().getScaledInstance(icon.getIconWidth(), icon.getIconHeight(), Image.SCALE_DEFAULT); 
        attaquePoingGauche[1] = new ImageIcon(image);
        icon = new ImageIcon("src/main/java/dessin/AttaqueFrontale/Gauche/poing_gauche3.gif");  
        image = icon.getImage().getScaledInstance(icon.getIconWidth(), icon.getIconHeight(), Image.SCALE_DEFAULT); 
        attaquePoingGauche[2] = new ImageIcon(image);
    }
    private void setPoingHaut(){
        ImageIcon icon = new ImageIcon("src/main/java/dessin/AttaqueFrontale/Haut/poing_haut.gif"); 
        Image image = icon.getImage().getScaledInstance(icon.getIconWidth(), icon.getIconHeight(), Image.SCALE_DEFAULT); 
        attaquePoingHaut = new ImageIcon(image); 
    }
    private void setPoingBas(){
        ImageIcon icon = new ImageIcon("src/main/java/dessin/AttaqueFrontale/Bas/poing_bas.gif"); 
        Image image = icon.getImage().getScaledInstance(icon.getIconWidth(), icon.getIconHeight(), Image.SCALE_DEFAULT); 
        attaquePoingBas = new ImageIcon(image); 
    }
    
    
    //Definir les images de chaque dash => Passe par une ImageIcon puis par une Image pour ensuite la convertir en ImageIcon pour reinitialer le gif au debut;
    private void setDashDroite(){
        ImageIcon icon = new ImageIcon("src/main/java/dessin/Dash/dash_droite.gif"); 
        Image image = icon.getImage().getScaledInstance(icon.getIconWidth(), icon.getIconHeight(), Image.SCALE_DEFAULT); 
        dash_droite = new ImageIcon(image); 
    }
    private void setDashGauche(){
        ImageIcon icon = new ImageIcon("src/main/java/dessin/Dash/dash_gauche.gif"); 
        Image image = icon.getImage().getScaledInstance(icon.getIconWidth(), icon.getIconHeight(), Image.SCALE_DEFAULT); 
        dash_gauche = new ImageIcon(image); 
    }
    private void setDashHaut(){
        ImageIcon icon = new ImageIcon("src/main/java/dessin/Dash/dash_haut.gif"); 
        Image image = icon.getImage().getScaledInstance(icon.getIconWidth(), icon.getIconHeight(), Image.SCALE_DEFAULT); 
        dash_haut = new ImageIcon(image); 
    }
    private void setDashBas(){
        ImageIcon icon = new ImageIcon("src/main/java/dessin/Dash/dash_bas.gif"); 
        Image image = icon.getImage().getScaledInstance(icon.getIconWidth(), icon.getIconHeight(), Image.SCALE_DEFAULT); 
        dash_bas = new ImageIcon(image); 
    }
    
    //Definir les images des collisions pour Debug; 
    protected void setImageCollision(int taille){
        collision = new Image[taille];  
        ImageIcon i = new ImageIcon("src/main/java/dessin/Maps/collision.png"); 
        for(int j=0; j<collision.length; j++){
            collision[j] = i.getImage(); 
        }
    }
    //Afficher la derniere image du Sprite lors d'un changement de Map, ou d'un redimensionnement; 
    private void setSprite(){
        if(sprite == bas || sprite == marche_bas ){
            sprite = bas;
        }else if(sprite == haut || sprite == marche_haut){
            sprite = haut;
        }else if(sprite == droite || sprite == marche_droite || sprite == dash_droite){
            sprite = droite;
        }
        else if(sprite == gauche|| sprite == marche_gauche || sprite == dash_gauche){
            sprite = gauche;
        }else if(sprite == dash_bas){
            sprite = bas; 
            x += 18*facteur2; 
            egaliserCooHitBox();
        }else if(sprite == dash_haut){
            sprite = haut;
            x += 17*facteur2;
            egaliserCooHitBox(); 
        }
        else{
            sprite = haut; 
        }
    }
  
    //Definis la marche du Sprite avec des Timer pous une marche instantanee + les Dash;
    private void MarcheInstantane(){
        //MARCHE; 
        right = new Timer(16, (ActionEvent e) -> { 
            checkCollision(); 
            if(keyDroite){
                x += vitesse; 
                if(sprite == marche_droite){
                    egaliserCooHitBox();
                }else{
                    x_SpriteHitbox += vitesse; 
                }
                MapsSuivante();  //Verifie si le Sprite n'atteind pas le bord de le Map pour afficher la Map suivante; 
            }
        }); 
        left = new Timer(16, (ActionEvent e) -> {
            checkCollision();
            if(keyGauche){
                x -= vitesse;
                if(sprite == marche_gauche){
                    egaliserCooHitBox();
                }else{
                    x_SpriteHitbox -= vitesse; 
                }
                MapsSuivante();
            } 
        }); 
        up = new Timer(16, (ActionEvent e) -> {
            checkCollision();
            if(keyHaut){
                y -= vitesse;
                if(sprite == marche_haut){
                    egaliserCooHitBox();
                }else{
                    y_SpriteHitbox -= vitesse; 
                }
                MapsSuivante();
            }
        }); 
        down = new Timer(16, (ActionEvent e) -> {
            checkCollision();
            if(keyBas){
                y += vitesse;
                if(sprite == marche_bas){
                    egaliserCooHitBox();
                }else{
                    y_SpriteHitbox += vitesse; 
                }
                MapsSuivante();
            }
        });
        //DASH; 
        stopDash = new Timer(650, (ActionEvent e) -> { //Lance l'animation des Dash selon le DashType pendant une duree precise; 
            if(dashType == 1){
                dashD.stop();               //Mettre au Dash qui permet l'avancement du Sprite; 
                sprite = marche_droite;
                x += 67 *facteur2; 
                keyDashDroite = false;//Reinitialise vite fait le positionnement du sprite;     
            }else if(dashType == 2){
                dashG.stop(); 
                sprite = marche_gauche; 
                keyDashGauche = false;
            }else if(dashType == 3){
                dashH.stop(); 
                sprite = marche_haut; 
                x+= 17*facteur2; 
                keyDashHaut = false;
            }else if(dashType == 4){
                dashB.stop(); 
                sprite = marche_bas; 
                x+= 18*facteur2;
                y += 45*facteur2;
                keyDashBas = false;
            }
            keyGauche = true;
            keyDroite = true;               //Permet au joueur de continuer la marche normale apres la fin du dash s'il a laisser un croix directionnelle pressee (fournit un gameplay plus confortable sans que le joueur ne soit oblige de presse a nouveau une touche);            
            keyHaut = true; 
            keyBas = true; 
            dashType = 0;
            stopDash.stop();                               //Arrete ce timer ce qui met fin au processu du dash;
        });
        dashD = new Timer(16, (ActionEvent e) -> {
            checkCollision(); 
            if(!checkCollision){
                x = x + 6*facteur1; 
                x_SpriteHitbox = x_SpriteHitbox + 6*facteur1; 
                MapsSuivante(); 
            }else{
                while(checkCollision){
                    checkCollision(); 
                    x -= vitesse*facteur1;
                    x_SpriteHitbox -= vitesse*facteur1; 
                }
                dashD.stop();
            }
        });
        dashG = new Timer(16, (ActionEvent e) -> {
            checkCollision();
            if(!checkCollision){
                x = x - 6*facteur1; 
                egaliserCooHitBox();
                MapsSuivante(); 
            }else{
                while(checkCollision){
                    checkCollision(); 
                    x += vitesse*facteur1;
                    egaliserCooHitBox();
                }
                dashG.stop();
            }
        });
        dashH = new Timer(16, (ActionEvent e) -> {
            checkCollision();
            if(!checkCollision){
                y = y - 5*facteur1; 
                egaliserCooHitBox();
                x_SpriteHitbox += 17*facteur2; 
                MapsSuivante(); 
            }else{
                while(checkCollision){
                    checkCollision(); 
                    y += vitesse*facteur1;
                    egaliserCooHitBox();
                    x_SpriteHitbox += 17*facteur2; 
                }
                dashH.stop();
            }
        });
        dashB = new Timer(16, (ActionEvent e) -> {
            checkCollision();
            if(!checkCollision){
                y = y + 5*facteur1; 
                egaliserCooHitBox();
                x_SpriteHitbox += 18*facteur2; 
                y_SpriteHitbox += 45*facteur2;
                MapsSuivante(); 
            }else{
                while(checkCollision){
                    checkCollision(); 
                    y -= vitesse*facteur1;
                    egaliserCooHitBox();
                    x_SpriteHitbox += 18*facteur2; 
                    y_SpriteHitbox += 45*facteur2;
                }
                dashB.stop();
            }
        });
        stopNumAttaquePoing = new Timer(700, (ActionEvent e) -> {     //POING1 => 530 frame && POING2 => 400; 
            numAttaque = 1;
            stopPoingDroite[0].stop();
        }); 
        attaqueEnMouvement = new Timer(16, (ActionEvent e) -> { 
            if(keyDroite){
                x_PoingHitbox[0] += vitesse; 
            }else if(keyGauche){
                x_PoingHitbox[0] -= vitesse; 
            }else if(keyHaut){
                y_PoingHitbox[1] -= vitesse; 
            }else if(keyBas){
                y_PoingHitbox[1] += vitesse; 
            }   
        }); 
        //ATTQUE POING DROITE;
        stopPoingDroite[0] = new Timer(390, (ActionEvent e) -> {     //POING1 => 530 frame && POING2 => 400; 
            if(sprite == attaquePoingDroite[0]){
                sprite = droite; 
            } 
            deleteHitBoxAttackX();
            poingActifDroite = false; 
            stopPoingDroite[0].stop();
        }); 
        stopPoingDroite[1] = new Timer(420, (ActionEvent e) -> {     //POING1 => 530 frame && POING2 => 400; 
            if(sprite == attaquePoingDroite[1]){
                sprite = droite; 
            } 
            deleteHitBoxAttackX();
            poingActifDroite = false;  
            stopPoingDroite[1].stop();
        });
        stopPoingDroite[2] = new Timer(500, (ActionEvent e) ->  {     //POING1 => 530 frame && POING2 => 400; 
            if(sprite == attaquePoingDroite[2]){
                sprite = droite; 
            } 
            deleteHitBoxAttackX();
            poingActifDroite = false;  
            stopPoingDroite[2].stop();
        }); 
        //ATTQUE POING GAUCHE;
        stopPoingGauche[0] = new Timer(390, (ActionEvent e) -> {
            if(sprite == attaquePoingGauche[0]){
                sprite = gauche; 
                x += 29*facteur2; 
            } 
            deleteHitBoxAttackX();
            poingActifGauche = false; 
            stopPoingGauche[0].stop();
        }); 
        stopPoingGauche[1] = new Timer(420, (ActionEvent e) -> { 
            if(sprite == attaquePoingGauche[1]){
                sprite = gauche; 
                x += 29*facteur2; 
            } 
            deleteHitBoxAttackX();
            poingActifGauche = false;  
            stopPoingGauche[1].stop();
        });
        stopPoingGauche[2] = new Timer(500, (ActionEvent e) ->  { 
            if(sprite == attaquePoingGauche[2]){
                sprite = gauche; 
                x += 29*facteur2; 
            } 
            deleteHitBoxAttackX();
            poingActifGauche = false;  
            stopPoingGauche[2].stop();
        }); 
        stopPoingBas = new Timer(480, (ActionEvent e) ->  { 
            if(sprite == attaquePoingBas){
                sprite = bas; 
                x += 4*facteur2; 
            } 
            deleteHitBoxAttackY();
            poingActifBas = false;  
            stopPoingBas.stop();
        }); 
        stopPoingHaut= new Timer(480, (ActionEvent e) ->  { 
            if(sprite == attaquePoingHaut){
                sprite = haut; 
                x += 4*facteur2; 
                y += 48*facteur2;
                egaliserCooHitBox(); 
            } 
            deleteHitBoxAttackY();
            poingActifHaut = false;  
            stopPoingHaut.stop();
        }); 
    }
    // ACTION SPRITE; 
    // ACTION SPRITE; 
    private void Marche(){
        addKeyListener(new KeyAdapter(){
        @Override
            public void keyPressed(KeyEvent e){
                if(!checkCollision && !keyDashDroite && !keyDashGauche && !keyDashHaut && !keyDashBas){     //Regarde si le sprite n'est pas rentrer en collision et s'il aucun Dash n'est pas active avant d'effectuer une action;
                    switch (e.getKeyCode()) {
                        case KeyEvent.VK_RIGHT:
                            deletePoingY(); 
                            //Action : Marche du Sprite vers la droite ->;
                            keyDroite = true;   //Activer seulement la varible bool concerner => effectuer seulement la marche vers la droite; 
                            keyGauche = false; //3 variables bool --> false => faire une action de marche en meme temps;
                            keyHaut = false; 
                            keyBas = false;
                            if(!right.isRunning()){ //Verifie que le Timer n'est pas active pour eviter de le lancer plusieurs fois;
                                right.start();      //Lancer le Timer pour faire avancer le Sprite;
                            }
                            if(!attaqueEnMouvement.isRunning()){
                                attaqueEnMouvement.start();
                            }
                            if(!poingActifDroite){
                                sprite = marche_droite; 
                            }
                            break;
                        case KeyEvent.VK_LEFT:
                            deletePoingY(); 
                            //Action : Marche du Sprite vers la gauche <-;
                            keyDroite = false;
                            keyGauche = true;
                            keyHaut = false;
                            keyBas = false;
                            if(!left.isRunning()){
                                left.start();
                            }
                            if(!attaqueEnMouvement.isRunning()){
                                attaqueEnMouvement.start(); 
                            }
                            if(!poingActifGauche && !poingActifDroite){
                                sprite = marche_gauche; 
                            }
                            break;
                        case KeyEvent.VK_DOWN:
                            //Action : Marche du Sprite vers le bas ;
                            deletePoingX();
                            keyDroite = false;
                            keyGauche = false;
                            keyHaut = false;  
                            keyBas = true;
                            if(!down.isRunning()){
                                down.start();
                            }
                            if(!attaqueEnMouvement.isRunning()){
                                attaqueEnMouvement.start(); 
                            }
                            if(!poingActifBas && !poingActifHaut){
                                sprite = marche_bas; 
                            }
                            break;
                        case KeyEvent.VK_UP:
                            //Action : Marche du Sprite vers le haut;
                            deletePoingX();
                            keyDroite = false;
                            keyGauche = false;
                            keyHaut = true; 
                            keyBas = false;
                            if(!up.isRunning()){
                                up.start();
                            }
                            if(!attaqueEnMouvement.isRunning()){
                                attaqueEnMouvement.start(); 
                            }
                            if(!poingActifBas && !poingActifHaut){
                                sprite = marche_haut; 
                            }
                            break;
                        default:
                            break;
                    }
                     
                    //DASH;
                    if(!isKeyDashPressed){
                           if(e.getKeyCode() == KeyEvent.VK_C && sprite == marche_droite || e.getKeyCode() == KeyEvent.VK_C && sprite == droite){ //Action : Dash vers la droite, si le sprite est dirige vers la droite (grace a son image) --->; 
                           setDashDroite(); 
                           dashType = 1;                //Definit le type de dash (1: dash vers la droite, 2: dash vers la gauche, 3: dash vers le haut, 4: dash vers la bas); 
                           sprite = dash_droite;        //Changer l'image du Sprite pour une animation plus coherente;
                           x -= 67*facteur2;            //Resoud vite fait le probleme de positionnement entre tous les autres sprites et le sprite dash_droite (cas specifique du a un probleme de dimension et de positionnement logique);
                           keyDroite = false;
                           keyDashDroite = true; 
                           if(!dashD.isRunning()){
                              dashD.start();  
                           }
                        }else if(e.getKeyCode() == KeyEvent.VK_C && sprite == marche_gauche || e.getKeyCode() == KeyEvent.VK_C && sprite == gauche){ //Action : Dash vers la droite, si le sprite est dirige vers la gauche (grace a son image) <---; 
                           setDashGauche(); 
                           dashType = 2; 
                           sprite = dash_gauche;    
                           keyGauche = false;
                           keyDashGauche = true; 
                           if(!dashG.isRunning()){
                              dashG.start();  
                           }
                        }else if (e.getKeyCode() == KeyEvent.VK_C && sprite == marche_haut || e.getKeyCode() == KeyEvent.VK_C && sprite == haut){
                            setDashHaut(); 
                            sprite = dash_haut; 
                            x -= 17*facteur2; 
                            dashType = 3; 
                            keyHaut = false; 
                            keyDashHaut = true; 
                            if(!dashH.isRunning()){
                              dashH.start();  
                           }
                        }else if (e.getKeyCode() == KeyEvent.VK_C && sprite == marche_bas || e.getKeyCode() == KeyEvent.VK_C && sprite == bas){
                            setDashBas(); 
                            sprite = dash_bas; 
                            x -= 18*facteur2; 
                            y -= 45*facteur2; 
                            dashType = 4; 
                            keyBas = false; 
                            keyDashBas = true; 
                            if(!dashB.isRunning()){
                              dashB.start();  
                           }
                        }
                        if(e.getKeyCode() == KeyEvent.VK_C){
                            if(!stopDash.isRunning()){
                                if(dashType == 1 || dashType ==2 || dashType == 3 || dashType == 4){
                                   stopDash.start();
                                   isKeyDashPressed = true; 
                                } 
                            }
                        }
                    }
                    //ATTAQUE POING; 
                    if(e.getKeyCode() == KeyEvent.VK_X && !isAttaquePressed){
                        //ATTAQUE POING DROITE; 
                        if(sprite == droite || sprite == marche_droite){
                            setPoingDroite();
                            stopNumAttaquePoing.stop();
                            switch (numAttaque) {
                                case 1:
                                    numAttaque = 2;
                                    sprite = attaquePoingDroite[0];
                                    x_PoingHitbox[0] = x_SpriteHitbox + 29*facteur2;
                                    y_PoingHitbox[0] = y_SpriteHitbox + 8*facteur2;
                                    if(!stopPoingDroite[0].isRunning()){
                                        stopPoingDroite[0].start();
                                        if(!stopNumAttaquePoing.isRunning()){
                                            stopNumAttaquePoing.start();
                                        }
                                    }   break;
                                case 2:
                                    numAttaque = 3;
                                    sprite = attaquePoingDroite[1];
                                    x_PoingHitbox[0] = x_SpriteHitbox + 23*facteur2;
                                    y_PoingHitbox[0] = y_SpriteHitbox + 11*facteur2;
                                    if(!stopPoingDroite[1].isRunning()){
                                        stopPoingDroite[1].start();
                                        if(!stopNumAttaquePoing.isRunning()){
                                            stopNumAttaquePoing.start();
                                        }
                                    }   
                                    break;
                                default:
                                    numAttaque = 1;
                                    sprite = attaquePoingDroite[2];
                                    x_PoingHitbox[0] = x_SpriteHitbox + 24*facteur2;
                                    y_PoingHitbox[0] = y_SpriteHitbox + 12*facteur2;
                                    isAttaquePressed = true;
                                    if(!stopPoingDroite[2].isRunning()){
                                        stopPoingDroite[2].start();
                                    }   break;
                            } 
                            poingActifDroite = true;
                        //ATTAQUE POING GAUCHE; 
                        }else if(sprite == gauche || sprite == marche_gauche){
                            setPoingGauche();
                            keyDroite = false; 
                            stopNumAttaquePoing.stop();
                            switch (numAttaque) {
                                case 1:
                                    numAttaque = 2;
                                    sprite = attaquePoingGauche[0];
                                    x_PoingHitbox[0] = x_SpriteHitbox - 33*facteur2;
                                    y_PoingHitbox[0] = y_SpriteHitbox + 8*facteur2;
                                    x -= 29*facteur2;
                                    if(!stopPoingGauche[0].isRunning()){
                                        stopPoingGauche[0].start();
                                        if(!stopNumAttaquePoing.isRunning()){
                                            stopNumAttaquePoing.start();
                                        }
                                    }   break;
                                case 2:
                                    numAttaque = 3;
                                    sprite = attaquePoingGauche[1];
                                    x_PoingHitbox[0] = x_SpriteHitbox - 27*facteur2;
                                    y_PoingHitbox[0] = y_SpriteHitbox + 11*facteur2;
                                    x -= 29*facteur2;
                                    if(!stopPoingGauche[1].isRunning()){
                                        stopPoingGauche[1].start();
                                        if(!stopNumAttaquePoing.isRunning()){
                                            stopNumAttaquePoing.start();
                                        }
                                    }   break;
                                default:
                                    numAttaque = 1;
                                    sprite = attaquePoingGauche[2];
                                    x_PoingHitbox[0] = x_SpriteHitbox - 28*facteur2;
                                    y_PoingHitbox[0] = y_SpriteHitbox + 12*facteur2;
                                    x -= 29*facteur2;
                                    isAttaquePressed = true;
                                    if(!stopPoingGauche[2].isRunning()){
                                        stopPoingGauche[2].start();
                                    }   break;
                            }
                            poingActifGauche = true; 
                        }else if(sprite == bas || sprite == marche_bas){
                            setPoingBas();
                            keyGauche = false; 
                            sprite = attaquePoingBas; 
                            x -= 4*facteur2; 
                            x_PoingHitbox[1] = x_SpriteHitbox + 2*facteur2;
                                    y_PoingHitbox[1] = y_SpriteHitbox + 39*facteur2;
                            if(!stopPoingBas.isRunning()){
                                stopPoingBas.start();
                            }
                            poingActifBas = true; 
                            isAttaquePressed = true;
                        }else if(sprite == haut || sprite == marche_haut){
                            setPoingHaut();
                            keyBas = false; 
                            sprite = attaquePoingHaut; 
                            x -= 4*facteur2;
                            y -= 48*facteur2; 
                            x_PoingHitbox[1] = x_SpriteHitbox + 2*facteur2;
                            y_PoingHitbox[1] = y_SpriteHitbox - 50*facteur2;
                            if(!stopPoingHaut.isRunning()){
                                stopPoingHaut.start();
                            }
                            poingActifHaut = true; 
                            isAttaquePressed = true;
                        }
                    }
                    checkCollision();
                }
                //Ouvre une nouvel fenetre (JFrame : DimensionFenetre de la class Carte) qui est un Menu pour regler la taille de l'ecran; 
                if(e.getKeyCode() == KeyEvent.VK_ESCAPE){ 
                    if(!Carte.getFenetreDimension().isVisible()){               //Regarde si la fenetre est deja affichee pour ne pas l'ouvrir plusieurs fois;
                        Carte.getFenetreDimension().setVisible(true);
                        Carte.getFenetreDimension().setFocusable(true); //Activer le focus pour reperer les actions des boutons; 
                        Carte.getFenetreDimension().requestFocus();
                    }
                }
                //Changement manuel des Maps(Optionnelle); 
                if(e.getKeyCode() == KeyEvent.VK_NUMPAD8){
                    switch (getMaps().getClass().getName()) {
                        case "Maps1":
                            Carte.switchPanel(new Maps2(x/facteur1, AppMaxY));
                            break;
                        case "Maps3":
                            Carte.switchPanel(new Maps1(x/facteur1, AppMaxY));
                            break;
                        case "Maps5":
                            Carte.switchPanel(new Maps4(x/facteur1, AppMaxY));
                            break;
                        case "Maps6":
                            Carte.switchPanel(new Maps5(x/facteur1, AppMaxY));
                            break;
                        case "Maps8":
                            Carte.switchPanel(new Maps7(x/facteur1, AppMaxY));
                            break;
                        case "Maps7":
                            Carte.switchPanel(new Maps9(x/facteur1, AppMaxY));
                            break;
                        default:
                            break;
                        }
                }
                if(e.getKeyCode() == KeyEvent.VK_NUMPAD2){
                    switch (getMaps().getClass().getName()) {
                        case "Maps1":
                            Carte.switchPanel(new Maps3(x/facteur1, AppMinY));
                            break;
                        case "Maps2":
                            Carte.switchPanel(new Maps1(x/facteur1, AppMinY));
                            break;
                        case "Maps4":
                            Carte.switchPanel(new Maps5(x/facteur1, AppMinY));        
                            break;
                        case "Maps5":
                            Carte.switchPanel(new Maps6(x/facteur1, AppMinY));
                            break;
                        case "Maps7":
                            Carte.switchPanel(new Maps8(x/facteur1, AppMinY));
                            break;
                        case "Maps9":
                            Carte.switchPanel(new Maps7(x/facteur1, AppMinY));
                            break;
                        default:
                            break;
                    }
                }
                if(e.getKeyCode() == KeyEvent.VK_NUMPAD6){
                    switch (getMaps().getClass().getName()) {
                        case "Maps1":
                            Carte.switchPanel(new Maps5(AppMinX, y/facteur1));
                            break;
                        case "Maps2":
                            Carte.switchPanel(new Maps4(AppMinX, y/facteur1));
                            break;
                        case "Maps3":
                            Carte.switchPanel(new Maps6(AppMinX, y/facteur1));
                            break;
                        case "Maps5":
                            Carte.switchPanel(new Maps7(AppMinX, y/facteur1));
                            break;
                        case "Maps6":
                            Carte.switchPanel(new Maps8(AppMinX, y/facteur1));
                            break;
                         case "Maps4":
                            Carte.switchPanel(new Maps9(AppMinX, y/facteur1));
                            break;
                        default:
                            break;
                    }
                }
                if(e.getKeyCode() == KeyEvent.VK_NUMPAD4){
                    switch (getMaps().getClass().getName()) {
                        case "Maps4":
                            Carte.switchPanel(new Maps2(AppMaxX, y/facteur1));
                            break;
                        case "Maps5":
                            Carte.switchPanel(new Maps1(AppMaxX, y/facteur1));
                            break;  
                        case "Maps6":
                            Carte.switchPanel(new Maps3(AppMaxX, y/facteur1));
                            break;
                        case "Maps7" : 
                            Carte.switchPanel(new Maps5(AppMaxX, y/facteur1));
                            break; 
                        case "Maps8" : 
                            Carte.switchPanel(new Maps6(AppMaxX, y/facteur1));
                            break; 
                        case "Maps9" : 
                            Carte.switchPanel(new Maps4(AppMaxX, y/facteur1));
                            break; 
                        default:
                            break;
                    }
                }
            } 
        }); 
    }
    //Action de la souris, si la souris est clique et que le Menu de reglage de dimension est ouvert, alors pour des raisons de confort, le Menu (cad le JFrame DimensionFenetre) est ferme; 
    public void Souris(){
        addMouseListener(new MouseAdapter(){
            @Override
            public void mouseClicked(MouseEvent e){
                x = e.getX()-8*facteur1;
                y = e.getY()-15*facteur1; 
                egaliserCooHitBox();
                if(Carte.getFenetreDimension().isVisible()){
                    Carte.getFenetreDimension().setVisible(false);
                    Carte.getFenetreDimension().dispose();
                }
            }
        });
    }
    //Arreter la marche instantanee du Sprite lorsqu'un bouton n'est plus presse; 
    public void Released(){
        addKeyListener(new KeyAdapter(){
           @Override
           public void keyReleased(KeyEvent e){
                checkCollision(); 
                if(e.getKeyCode() == KeyEvent.VK_RIGHT){
                    if(sprite == marche_droite){   
                        sprite = droite;            //Passer d'une animation de marche a une animation fixe pour la coherence du jeu; 
                    } 
                    keyDroite = false;              //Reinitialiser l'etat de la marche a false car la marche est inactive; 
                    right.stop();                   //Mettre fin au Timer de la Marche et donc de l'avancement du Sprite; 
                    if(checkCollision){             //Si le Sprite est en Collision et que que le touche pour avancer est relachee, alors le sprite recule de quelque pixel pour ne pas etre coller à la collision;
                        x -= vitesse*2; 
                        egaliserCooHitBox(); 
                    } 
                    attaqueEnMouvement.stop();
                }
                if(e.getKeyCode() == KeyEvent.VK_LEFT){
                    if(sprite == marche_gauche){
                        sprite = gauche;
                    }
                    keyGauche = false;
                    left.stop();
                    if(checkCollision){
                        x += vitesse*2; 
                        egaliserCooHitBox(); 
                    }
                    attaqueEnMouvement.stop();
                }
                if(e.getKeyCode() == KeyEvent.VK_DOWN){
                    if(sprite == marche_bas){
                        sprite = bas;
                    }
                    keyBas = false;
                    down.stop();
                    if(checkCollision){
                        y -= vitesse*2; 
                        egaliserCooHitBox(); 
                    }
                    attaqueEnMouvement.stop();
                }
                if(e.getKeyCode() == KeyEvent.VK_UP){
                    if(sprite == marche_haut){
                        sprite = haut;
                    }
                    keyHaut = false;
                    up.stop();
                    if(checkCollision){
                        y += vitesse*2; 
                        egaliserCooHitBox(); 
                    }
                    attaqueEnMouvement.stop();
                }
                if(e.getKeyCode() == KeyEvent.VK_C){
                    isKeyDashPressed = false; 
                }
                if(e.getKeyCode() == KeyEvent.VK_X){
                    isAttaquePressed = false; 
                }
                checkCollision = false;         //Reinitialise l'etat des collision a false car le Sprite ne rencontre desormais plus de collision;
            }
        });
    }
    //Traitement des Collisions, checkCollision devient true si le sprite en rencontre; 
    public void checkCollision() {
        checkCollision = false; 
        for(int i=0; i<collision.length; i++){
            if (x_SpriteHitbox + SpriteHitbox.getIconWidth()*facteur2 >= coo[i].get(0) && x_SpriteHitbox <= coo[i].get(0) + dimension[i].get(0) &&
                (y_SpriteHitbox-2) + SpriteHitbox.getIconHeight()*facteur2 >= coo[i].get(1) && (y_SpriteHitbox-2) <= coo[i].get(1)+ dimension[i].get(1)) {
                this.right.stop();
                this.left.stop();
                this.up.stop();
                this.down.stop(); 
                this.checkCollision = true; 
            }
        }
    }
    //Methode Overriode pour changer de JPanel et donc de classe et de Maps; 
    public void MapsSuivante(){}
    
    public AnimationSprite getMaps(){
        return new AnimationSprite(0, 0); 
    }
    //Arreter tous les timers lors du changement de Map(donc lors d'un changement de classe pour eviter les ralentissements); 
    public void Stop(){
        right.stop(); 
        left.stop(); 
        down.stop();
        up.stop();
        attaqueEnMouvement.stop();
        if(dashD.isRunning()){
            dashD.stop();
        }else if(dashG.isRunning()){
            dashG.stop();
        }else if(dashH.isRunning()){
            dashH.stop();
        }else if(dashB.isRunning()){
            dashB.stop();
        }
        stopDash.stop();
    }
    //Affecte une nouvelle valeur pour le facteur dans le processus de redimension du JFrame (Redefinit la taille du sprite, celle de la maps, de la vitesse et des coordonnees); 
    public static void setFacteur(int fact){
        x = x/facteur1; 
        y = y/facteur1; 
        facteur1 = fact; 
        x = x*facteur1; 
        y = y*facteur1; 
        facteur2 = facteur1 - 1; 
        setVitesse(); 
    }
    public static int getFacteur(){
        return facteur1; 
    }
    //Methode Override pour fournir un numero propre a chaques classes (donc chaques Maps), servira a fournir un menu de reglage personnalise (JFrame dimensionFenetre de la classe Carte) selon l'esthetisme de la carte; 
    public int getNumberClass(){
        return 0; 
    }
    public void egaliserCooHitBox(){
        x_SpriteHitbox = x; 
        y_SpriteHitbox = y; 
    }
    public void deleteHitBoxAttackX(){
        x_PoingHitbox[0] = 0; 
        y_PoingHitbox[0] = 0;  
    }
    public void deleteHitBoxAttackY(){
        x_PoingHitbox[1] = -50; 
        y_PoingHitbox[1] = -50;
    }
    public void deletePoingX(){
        if(poingActifDroite || poingActifGauche){
            for(int i=0; i<stopPoingGauche.length; i++){
                stopPoingGauche[i].stop(); 
            }
            for(int i=0; i<stopPoingDroite.length; i++){
                stopPoingDroite[i].stop(); 
            }
            if(sprite == attaquePoingGauche[0] || sprite == attaquePoingGauche[1] || sprite == attaquePoingGauche[2]){
                x += 29*facteur2; 
            }
            poingActifDroite = false;
            poingActifGauche = false; 
        } 
        deleteHitBoxAttackX();
    }
    public void deletePoingY(){
        if(poingActifBas || poingActifHaut){
            stopPoingBas.stop(); 
            stopPoingHaut.stop(); 
            if(sprite == attaquePoingBas){
                x += 4*facteur2; 
            }else if( sprite == attaquePoingHaut){
                x += 4*facteur2; 
                y  += 51*facteur2; 
            }
            poingActifHaut = false;
            poingActifBas = false; 
        }
        deleteHitBoxAttackY(); 
    }
}