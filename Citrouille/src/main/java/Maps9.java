import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

public class Maps9 extends AnimationSprite{
    private ImageIcon plante =  new ImageIcon("src/main/java/dessin/Maps/Elèment_Premier_Plan/plante4.png");
     
    public Maps9(int x, int y){
        super(x, y);
        taille = 26; 
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
        //Arbre; 
        coo[0].add(0*facteur1); coo[0].add(251*facteur1);
        coo[1].add(294*facteur1); coo[1].add(251*facteur1);
        dimension[0].add(185*facteur1); dimension[0].add(7*facteur1);
        dimension[1].add(186*facteur1); dimension[1].add(7*facteur1);
            //descente; 
        coo[2].add(184*facteur1); coo[2].add(0*facteur1);
        coo[3].add(265*facteur1); coo[3].add(0*facteur1);
        dimension[2].add(32*facteur1); dimension[2].add(89*facteur1); 
        dimension[3].add(32*facteur1); dimension[3].add(89*facteur1);
            //couple; 
        coo[4].add(71*facteur1); coo[4].add(97*facteur1);
        coo[5].add(79*facteur1); coo[5].add(163*facteur1);
        dimension[4].add(51*facteur1); dimension[4].add(17*facteur1);
        dimension[5].add(51*facteur1); dimension[5].add(17*facteur1);    
        coo[6].add(254*facteur1); coo[6].add(177*facteur1);
        dimension[6].add(51*facteur1); dimension[6].add(17*facteur1); 
            //solo; 
        coo[7].add(80*facteur1); coo[7].add(91*facteur1);
        dimension[7].add(32*facteur1); dimension[7].add(6*facteur1); 
        coo[8].add(88*facteur1); coo[8].add(157*facteur1);
        dimension[8].add(32*facteur1); dimension[8].add(6*facteur1);
        coo[9].add(263*facteur1); coo[9].add(171*facteur1);
        dimension[9].add(32*facteur1); dimension[9].add(6*facteur1);
        
        //Plante petite; 
        coo[10].add(20*facteur1); coo[10].add(232*facteur1);
        dimension[10].add(1*facteur1); dimension[10].add(1*facteur1);
        coo[11].add(73*facteur1); coo[11].add(232*facteur1);
        dimension[11].add(1*facteur1); dimension[11].add(1*facteur1);
        coo[12].add(126*facteur1); coo[12].add(232*facteur1);
        dimension[12].add(1*facteur1); dimension[12].add(1*facteur1);
        coo[13].add(179*facteur1); coo[13].add(232*facteur1);
        dimension[13].add(1*facteur1); dimension[13].add(1*facteur1);
        coo[14].add(300*facteur1); coo[14].add(233*facteur1);
        dimension[14].add(1*facteur1); dimension[14].add(1*facteur1);
        coo[15].add(353*facteur1); coo[15].add(233*facteur1);
        dimension[15].add(1*facteur1); dimension[15].add(1*facteur1);
        coo[16].add(406*facteur1); coo[16].add(233*facteur1);
        dimension[16].add(1*facteur1); dimension[16].add(1*facteur1);
        coo[17].add(459*facteur1); coo[17].add(233*facteur1);
        dimension[17].add(1*facteur1); dimension[17].add(1*facteur1);
   
        //Plante grande; 
        coo[18].add(36*facteur1); coo[18].add(189*facteur1);
        dimension[18].add(11*facteur1); dimension[18].add(2*facteur1);
        
        coo[19].add(156*facteur1); coo[19].add(169*facteur1);
        dimension[19].add(11*facteur1); dimension[19].add(2*facteur1);
        
        coo[20].add(134*facteur1); coo[20].add(98*facteur1);
        dimension[20].add(11*facteur1); dimension[20].add(2*facteur1);
        
        coo[21].add(311*facteur1); coo[21].add(169*facteur1);
        dimension[21].add(11*facteur1); dimension[21].add(2*facteur1);
        
        coo[22].add(376*facteur1); coo[22].add(179*facteur1);
        dimension[22].add(11*facteur1); dimension[22].add(2*facteur1);
        
        coo[23].add(441*facteur1); coo[23].add(169*facteur1);
        dimension[23].add(11*facteur1); dimension[23].add(2*facteur1);
        
        coo[24].add(341*facteur1); coo[24].add(99*facteur1);
        dimension[24].add(11*facteur1); dimension[24].add(2*facteur1);
       
        coo[25].add(403*facteur1); coo[25].add(91*facteur1);
        dimension[25].add(11*facteur1); dimension[25].add(2*facteur1);  
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
        g2d.drawImage(plante.getImage(), 0, 47*facteur1, plante.getIconWidth()*facteur1, plante.getIconHeight()*facteur1, this);
        
        repaint(); 
    }
    
    @Override
    public AnimationSprite getMaps(){
        return new Maps9(x/facteur1, y/facteur1); 
    }
    
    @Override
    public void MapsSuivante(){
        if(y_SpriteHitbox > ChangeMaxY*facteur1){
            Stop(); 
            Carte.switchPanel(new Maps7(x/facteur1, AppMinY)); 
        }else if(x_SpriteHitbox < ChangeMinX*facteur1){
            Stop(); 
            Carte.switchPanel(new Maps4(AppMaxX, y/facteur1)); 
        }
    }
    public void setMap(){  
        map = new ImageIcon("src/main/java/dessin/Maps/Map9.png");  
    }   
    
    public int getNumberClass(){
        return 9; 
    }
}