import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

public class Maps3 extends AnimationSprite{
    private ImageIcon arbre = new ImageIcon("src/main/java/dessin/Maps/Elèment_Premier_Plan/arbre3.png"); 
    
    public Maps3(int x, int y){
        super(x, y);
        taille = 22; 
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
        //Pierre; 
        coo[0].add(107*facteur1); coo[0].add(0*facteur1);
        coo[1].add(267*facteur1); coo[1].add(0*facteur1);
        dimension[0].add(108*facteur1); dimension[0].add(9*facteur1);
        dimension[1].add(108*facteur1); dimension[1].add(9*facteur1);
        
        coo[2].add(203*facteur1); coo[2].add(0*facteur1);
        coo[3].add(267*facteur1); coo[3].add(0*facteur1);
        dimension[2].add(12*facteur1); dimension[2].add(36*facteur1); 
        dimension[3].add(12*facteur1); dimension[3].add(36*facteur1);
        
        coo[4].add(148*facteur1); coo[4].add(27*facteur1);
        coo[5].add(267*facteur1); coo[5].add(27*facteur1);
        dimension[4].add(67*facteur1); dimension[4].add(9*facteur1);
        dimension[5].add(67*facteur1); dimension[5].add(9*facteur1);
        
        coo[6].add(148*facteur1); coo[6].add(27*facteur1);
        coo[7].add(322*facteur1); coo[7].add(27*facteur1);
        dimension[6].add(12*facteur1); dimension[6].add(54*facteur1); 
        dimension[7].add(12*facteur1); dimension[7].add(54*facteur1); 
        
        coo[8].add(0*facteur1); coo[8].add(72*facteur1);
        coo[9].add(322*facteur1); coo[9].add(72*facteur1);
        dimension[8].add(160*facteur1); dimension[8].add(9*facteur1);
        dimension[9].add(160*facteur1); dimension[9].add(9*facteur1);
        
        //Arbre; 
        coo[10].add(0*facteur1); coo[10].add(0*facteur1);
        coo[11].add(415*facteur1); coo[11].add(0*facteur1);
        dimension[10].add(65*facteur1); dimension[10].add(19*facteur1);
        dimension[11].add(65*facteur1); dimension[11].add(19*facteur1);
        
        coo[12].add(181*facteur1); coo[12].add(104*facteur1);
        coo[13].add(267*facteur1); coo[13].add(104*facteur1);
        dimension[12].add(32*facteur1); dimension[12].add(7*facteur1); 
        dimension[13].add(32*facteur1); dimension[13].add(7*facteur1);
        
        coo[14].add(0*facteur1); coo[14].add(117*facteur1);
        coo[15].add(283*facteur1); coo[15].add(117*facteur1);
        dimension[14].add(197*facteur1); dimension[14].add(7*facteur1);
        dimension[15].add(197*facteur1); dimension[15].add(7*facteur1);
        
        coo[16].add(0*facteur1); coo[16].add(176*facteur1);
        coo[17].add(283*facteur1); coo[17].add(176*facteur1);
        dimension[16].add(197*facteur1); dimension[16].add(7*facteur1); 
        dimension[17].add(197*facteur1); dimension[17].add(7*facteur1); 
        
        //Bois; 
        coo[18].add(147*facteur1); coo[18].add(208*facteur1);
        coo[19].add(289*facteur1); coo[19].add(208*facteur1);
        dimension[18].add(46*facteur1); dimension[18].add(4*facteur1);
        dimension[19].add(46*facteur1); dimension[19].add(4*facteur1);
        
        coo[20].add(94*facteur1); coo[20].add(228*facteur1);
        coo[21].add(332*facteur1); coo[21].add(228*facteur1);
        dimension[20].add(54*facteur1); dimension[20].add(4*facteur1); 
        dimension[21].add(54*facteur1); dimension[21].add(4*facteur1); 
        
    }
   
    @Override
    public void paintComponent(Graphics g){
        super.paintComponent(g);
        Graphics2D g2d = (Graphics2D) g;
        RemplirCoordonee(); 
        for(int i=0; i<collision.length; i++){
            g2d.setColor(Color.red);
            g2d.drawImage(collision[i], coo[i].get(0), coo[i].get(1), dimension[i].get(0), dimension[i].get(1), this);                 
        }
        
        g2d.drawImage(map.getImage(), 0, 0, map.getIconWidth()*facteur1, map.getIconHeight()*facteur1, this);
        g2d.drawImage(sprite.getImage(), x, y, sprite.getIconWidth()*(facteur2), sprite.getIconHeight()*(facteur2), this);
        g2d.drawImage(arbre.getImage(), 0*facteur1, 94*facteur1, arbre.getIconWidth()*facteur1, arbre.getIconHeight()*facteur1, this); 
        repaint();  
    }
    
    @Override
     public void MapsSuivante(){
        if(y_SpriteHitbox  < ChangeMinY*facteur1){
            Stop(); 
            Carte.switchPanel(new Maps1(x/facteur1, AppMaxY));
        }else if(x_SpriteHitbox  > ChangeMaxX*facteur1){
            Stop(); 
            Carte.switchPanel(new Maps6(AppMinX, y/facteur1));
        }
    }
    
    @Override
    public AnimationSprite getMaps(){
        return new Maps3(x/facteur1, y/facteur1); 
    }
    
    public void setMap(){
        map = new ImageIcon("src/main/java/dessin/Maps/Map3.png");  
    }
    
    @Override
    public int getNumberClass(){
        return 3; 
    }
}