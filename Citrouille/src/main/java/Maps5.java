import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

public final class Maps5 extends AnimationSprite{
    private ImageIcon plante = new ImageIcon("src/main/java/dessin/Maps/Elèment_Premier_Plan/plante.png"); 
    private ImageIcon arbre = new ImageIcon("src/main/java/dessin/Maps/Elèment_Premier_Plan/arbre5.png");
    
    public Maps5(int x, int y){
        super(x, y);
        taille = 23; 
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
        //Hauteur; 
        coo[0].add(295*facteur1); coo[0].add(0*facteur1);
        coo[1].add(0*facteur1); coo[1].add(0*facteur1);
        dimension[0].add(185*facteur1); dimension[0].add(53*facteur1);
        dimension[1].add(182*facteur1); dimension[1].add(53*facteur1);
        
        //Arbre; 
        coo[2].add(0*facteur1); coo[2].add(0*facteur1);
        coo[3].add(0*facteur1); coo[3].add(184*facteur1);
        dimension[2].add(55*facteur1); dimension[2].add(111*facteur1); 
        dimension[3].add(55*facteur1); dimension[3].add(86*facteur1);
        
        coo[4].add(0*facteur1); coo[4].add(104*facteur1);
        coo[5].add(0*facteur1); coo[5].add(184*facteur1);
        dimension[4].add(135*facteur1); dimension[4].add(7*facteur1);
        dimension[5].add(135*facteur1); dimension[5].add(7*facteur1);
         
        coo[6].add(183*facteur1); coo[6].add(104*facteur1);
        dimension[6].add(112*facteur1); dimension[6].add(7*facteur1); 
        
        coo[7].add(214*facteur1); coo[7].add(184*facteur1);
        dimension[7].add(52*facteur1); dimension[7].add(7*facteur1); 
        
        coo[8].add(343*facteur1); coo[8].add(104*facteur1);
        coo[9].add(343*facteur1); coo[9].add(184*facteur1);
        dimension[9].add(137*facteur1); dimension[9].add(7*facteur1);
        dimension[8].add(137*facteur1); dimension[8].add(7*facteur1);
        
        //Plante; 
        coo[10].add(205*facteur1); coo[10].add(82*facteur1);
        dimension[10].add(4*facteur1); dimension[10].add(3*facteur1);
        coo[11].add(270*facteur1); coo[11].add(82*facteur1);
        dimension[11].add(4*facteur1); dimension[11].add(3*facteur1);
        coo[12].add(238*facteur1); coo[12].add(41*facteur1);
        dimension[12].add(4*facteur1); dimension[12].add(3*facteur1);
    
        coo[13].add(172*facteur1); coo[13].add(251*facteur1);
        dimension[13].add(4*facteur1); dimension[13].add(3*facteur1);
        coo[14].add(193*facteur1); coo[14].add(251*facteur1);
        dimension[14].add(4*facteur1); dimension[14].add(3*facteur1);
        coo[15].add(214*facteur1); coo[15].add(251*facteur1);
        dimension[15].add(4*facteur1); dimension[15].add(3*facteur1);
        
        coo[16].add(262*facteur1); coo[16].add(251*facteur1);
        dimension[16].add(4*facteur1); dimension[16].add(3*facteur1);
        coo[17].add(283*facteur1); coo[17].add(251*facteur1);
        dimension[17].add(4*facteur1); dimension[17].add(3*facteur1);
        coo[18].add(304*facteur1); coo[18].add(251*facteur1);
        dimension[18].add(4*facteur1); dimension[18].add(3*facteur1);
        
        //Pierre; 
        coo[19].add(352*facteur1); coo[19].add(230*facteur1);
        dimension[19].add(12*facteur1); dimension[19].add(40*facteur1);
        coo[20].add(352*facteur1); coo[20].add(230*facteur1);
        dimension[20].add(45*facteur1); dimension[20].add(9*facteur1);
        coo[21].add(385*facteur1); coo[21].add(206*facteur1);
        dimension[21].add(12*facteur1); dimension[21].add(33*facteur1);
       
        coo[22].add(116*facteur1); coo[22].add(261*facteur1);
        dimension[22].add(33*facteur1); dimension[22].add(9*facteur1);
    
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
        g2d.drawImage(plante.getImage(), 156*facteur1, 16*facteur1, plante.getIconWidth()*facteur1, plante.getIconHeight()*facteur1, this);
        g2d.drawImage(arbre.getImage(), 0, 94*facteur1, arbre.getIconWidth()*facteur1, arbre.getIconHeight()*facteur1, this);
        repaint(); 
    }
    
    @Override
    public AnimationSprite getMaps(){
        return new Maps5(x/facteur1, y/facteur1); 
    }
    
    @Override
    public void MapsSuivante(){
        if(x_SpriteHitbox  < ChangeMinX*facteur1){
            Stop(); 
            Carte.switchPanel(new Maps1(AppMaxX, y/facteur1)); 
        }else if(y_SpriteHitbox  < ChangeMinY*facteur1){
            Stop(); 
            Carte.switchPanel(new Maps4(x/facteur1, AppMaxY)); 
        }else if(y_SpriteHitbox > ChangeMaxY*facteur1){
            Stop(); 
            Carte.switchPanel(new Maps6(x/facteur1, AppMinY));
        }else if(x_SpriteHitbox  > ChangeMaxX*facteur1){
            Stop(); 
            Carte.switchPanel(new Maps7(AppMinX, y/facteur1)); 
        }
    }
    public void setMap(){  
        map = new ImageIcon("src/main/java/dessin/Maps/Map5.png");  
    }  
    
    @Override
    public int getNumberClass(){
        return 5; 
    }
}