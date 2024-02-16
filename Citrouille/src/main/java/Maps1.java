import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

public class Maps1 extends AnimationSprite{ 
    private ImageIcon arbre = new ImageIcon("src/main/java/dessin/Maps/Elèment_Premier_Plan/arbre1.png"); 
    
    public Maps1(int x, int y){
        super(x, y);
        taille = 11; 
        setMap(); 
        setPreferredSize(new Dimension(map.getIconWidth()*facteur1, map.getIconHeight()*facteur1)); 
        collision = new Image[taille]; 
        
        setImageCollision(taille); 
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
        
        coo[0].add(107*facteur1); coo[0].add(108*facteur1);
        coo[1].add(363*facteur1); coo[1].add(108*facteur1);
        dimension[0].add(12*facteur1); dimension[0].add(162*facteur1);
        dimension[1].add(12*facteur1); dimension[1].add(162*facteur1);
        
        coo[2].add(107*facteur1); coo[2].add(261*facteur1);
        coo[3].add(267*facteur1); coo[3].add(261*facteur1);
        dimension[2].add(108*facteur1); dimension[2].add(9*facteur1); 
        dimension[3].add(108*facteur1); dimension[3].add(9*facteur1); 
        
        coo[4].add(171*facteur1); coo[4].add(100*facteur1);
        coo[5].add(255*facteur1); coo[5].add(100*facteur1);
        dimension[4].add(55*facteur1); dimension[4].add(103*facteur1); 
        dimension[5].add(56*facteur1); dimension[5].add(103*facteur1); 
        
        coo[6].add(0); coo[6].add(0);
        dimension[6].add(65*facteur1); dimension[6].add(270*facteur1); 
        
        coo[8].add(173*facteur1); coo[8].add(0);
        coo[9].add(275*facteur1); coo[9].add(0);
        dimension[8].add(32*facteur1); dimension[8].add(26*facteur1); 
        dimension[9].add(32*facteur1); dimension[9].add(26*facteur1); 
        
        coo[7].add(415*facteur1); coo[7].add(0);
        coo[10].add(415*facteur1); coo[10].add(184*facteur1);
        dimension[10].add(65*facteur1); dimension[10].add(86*facteur1); 
        dimension[7].add(65*facteur1); dimension[7].add(111*facteur1); 
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
        g2d.drawImage(arbre.getImage(), 171*facteur1, 90*facteur1, arbre.getIconWidth()*facteur1, arbre.getIconHeight()*facteur1, this); 
        repaint();  
    }
    
    @Override
    public void MapsSuivante(){
        if(y_SpriteHitbox < ChangeMinY*facteur1){
            Stop(); 
            Carte.switchPanel(new Maps2(x/facteur1, AppMaxY)); 
        }else if(y_SpriteHitbox  > ChangeMaxY*facteur1){
            Stop(); 
            Carte.switchPanel(new Maps3(x/facteur1, AppMinY)); 
        }else if(x_SpriteHitbox  > ChangeMaxX*facteur1){
            Stop(); 
            Carte.switchPanel(new Maps5(AppMinX, y/facteur1)); 
        } 
    }
    
    @Override
    public AnimationSprite getMaps(){
        return new Maps1(x/facteur1, y/facteur1); 
    }
    
    public void setMap(){
        map = new ImageIcon("src/main/java/dessin/Maps/Map1.png");  
    }
    @Override
    public int getNumberClass(){
        return 1;
    }
   
}