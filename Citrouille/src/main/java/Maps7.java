import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

public class Maps7 extends AnimationSprite{
    private ImageIcon plante =  new ImageIcon("src/main/java/dessin/Maps/Elèment_Premier_Plan/plante2.png");
     
    public Maps7(int x, int y){
        super(x, y);
        taille = 25; 
        setMap();
        setPreferredSize(new Dimension(map.getIconWidth()*facteur1, map.getIconHeight()*facteur1)); 
        collision = new Image[taille]; 
        setImageCollision(taille); 
 
        //Collision; 
        RemplirCoordonee();  
    }

    private static void RemplirCoordonee(){
        dimension = new ArrayList[taille]; 
        coo = new ArrayList[taille];
        for(int i=0; i<coo.length; i++){
            coo[i] = new ArrayList<>(); 
        }
        for(int i=0; i<dimension.length; i++){
            dimension[i] = new ArrayList<>(); 
        }
        //Arbre gauche; 
        coo[0].add(0*facteur1); coo[0].add(104*facteur1);
        coo[1].add(0*facteur1); coo[1].add(184*facteur1);
        dimension[0].add(183*facteur1); dimension[0].add(7*facteur1);
        dimension[1].add(83*facteur1); dimension[1].add(7*facteur1);
            //descente; 
        coo[2].add(212*facteur1); coo[2].add(129*facteur1);
        coo[3].add(126*facteur1); coo[3].add(217*facteur1);
        dimension[2].add(32*facteur1); dimension[2].add(141*facteur1); 
        dimension[3].add(32*facteur1); dimension[3].add(53*facteur1);
            //diagonale haut; 
        coo[4].add(182*facteur1); coo[4].add(107*facteur1);
        coo[5].add(197*facteur1); coo[5].add(118*facteur1);
        dimension[4].add(32*facteur1); dimension[4].add(7*facteur1);
        dimension[5].add(32*facteur1); dimension[5].add(7*facteur1);
            //diagonale bas;
        coo[6].add(82*facteur1); coo[6].add(187*facteur1);
        dimension[6].add(32*facteur1); dimension[6].add(7*facteur1); 
        coo[7].add(98*facteur1); coo[7].add(194*facteur1);
        dimension[7].add(32*facteur1); dimension[7].add(7*facteur1); 
        coo[8].add(113*facteur1); coo[8].add(2005*facteur1);
        dimension[8].add(32*facteur1); dimension[8].add(7*facteur1);
            //seul; 
        coo[9].add(224*facteur1); coo[9].add(45*facteur1);
        dimension[9].add(32*facteur1); dimension[9].add(7*facteur1);
        coo[10].add(389*facteur1); coo[10].add(130*facteur1);
        dimension[10].add(52*facteur1); dimension[10].add(39*facteur1);
        
        //Pierre; 
        coo[11].add(27*facteur1); coo[11].add(206*facteur1);
        dimension[11].add(45*facteur1); dimension[11].add(8*facteur1);
        coo[12].add(60*facteur1); coo[12].add(207*facteur1);
        dimension[12].add(12*facteur1); dimension[12].add(25*facteur1);
        coo[13].add(60*facteur1); coo[13].add(223*facteur1);
        dimension[13].add(68*facteur1); dimension[13].add(9*facteur1);
        coo[14].add(339*facteur1); coo[14].add(53*facteur1);
        dimension[14].add(12*facteur1); dimension[14].add(217*facteur1);
        
        //Plante; 
        coo[15].add(10*facteur1); coo[15].add(83*facteur1);
        dimension[15].add(14*facteur1); dimension[15].add(2*facteur1);
        coo[16].add(66*facteur1); coo[16].add(83*facteur1);
        dimension[16].add(14*facteur1); dimension[16].add(2*facteur1);
        coo[17].add(124*facteur1); coo[17].add(83*facteur1);
        dimension[17].add(14*facteur1); dimension[17].add(2*facteur1);
        coo[18].add(264*facteur1); coo[18].add(119*facteur1);
        dimension[18].add(14*facteur1); dimension[18].add(2*facteur1);
        coo[19].add(307*facteur1); coo[19].add(185*facteur1);
        dimension[19].add(14*facteur1); dimension[19].add(2*facteur1);
        
        coo[20].add(264*facteur1); coo[20].add(254*facteur1);
        dimension[20].add(14*facteur1); dimension[20].add(2*facteur1);
        coo[21].add(371*facteur1); coo[21].add(89*facteur1);
        dimension[21].add(14*facteur1); dimension[21].add(2*facteur1);
        coo[22].add(448*facteur1); coo[22].add(89*facteur1);
        dimension[22].add(14*facteur1); dimension[22].add(2*facteur1);
        
        //Hauteur; 
        coo[23].add(0*facteur1); coo[23].add(0*facteur1);
        dimension[23].add(185*facteur1); dimension[23].add(53*facteur1);
        coo[24].add(295*facteur1); coo[24].add(0*facteur1);
        dimension[24].add(185*facteur1); dimension[24].add(53*facteur1);
    
    }
    
      @Override
    public void paintComponent(Graphics g){
        super.paintComponent(g);
        Graphics2D g2d = (Graphics2D) g;    
        RemplirCoordonee(); 
        for(int i=0; i<collision.length; i++){
            g2d.drawImage(collision[i], coo[i].get(0), coo[i].get(1), dimension[i].get(0)+1, dimension[i].get(1)+1, this);                 
        }
        g2d.drawImage(map.getImage(), 0, 0, map.getIconWidth()*facteur1, map.getIconHeight()*facteur1, this);
        g2d.drawImage(sprite.getImage(), x, y, sprite.getIconWidth()*facteur2, sprite.getIconHeight()*facteur2, this);
        g2d.drawImage(plante.getImage(), 0, 35*facteur1, plante.getIconWidth()*facteur1, plante.getIconHeight()*facteur1, this);
        repaint(); 
    }
    
    @Override
    public AnimationSprite getMaps(){
        return new Maps7(x/facteur1, y/facteur1); 
    }
    
    @Override
    public void MapsSuivante(){
        if(x_SpriteHitbox < ChangeMinX*facteur1){
            Stop(); 
            Carte.switchPanel(new Maps5(AppMaxX, y/facteur1)); 
        }else if(y_SpriteHitbox > ChangeMaxY*facteur1){
            Stop(); 
            Carte.switchPanel(new Maps8(x/facteur1, AppMinY)); 
        }else if(y_SpriteHitbox < ChangeMinY*facteur1){
            Stop(); 
            Carte.switchPanel(new Maps9(x/facteur1, AppMaxY)); 
        } 
    }
    public void setMap(){  
        map = new ImageIcon("src/main/java/dessin/Maps/Map7.png");  
    }    
    
    public int getNumberClass(){
        return 7; 
    }
}