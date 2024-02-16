import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

public class Maps8 extends AnimationSprite{
    private ImageIcon plante =  new ImageIcon("src/main/java/dessin/Maps/Elèment_Premier_Plan/plante3.png");
     
    public Maps8(int x, int y){
        super(x, y);
        taille = 33; 
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
        coo[0].add(0*facteur1); coo[0].add(117*facteur1);
        coo[1].add(0*facteur1); coo[1].add(178*facteur1);
        dimension[0].add(101*facteur1); dimension[0].add(7*facteur1);
        dimension[1].add(176*facteur1); dimension[1].add(7*facteur1);
            //descente; 
        coo[2].add(126*facteur1); coo[2].add(0*facteur1);
        coo[3].add(212*facteur1); coo[3].add(0*facteur1);
        dimension[2].add(32*facteur1); dimension[2].add(87*facteur1); 
        dimension[3].add(32*facteur1); dimension[3].add(135*facteur1);
            //seul; 
        coo[4].add(278*facteur1); coo[4].add(44*facteur1);
        coo[5].add(392*facteur1); coo[5].add(212*facteur1);
        dimension[4].add(32*facteur1); dimension[4].add(39*facteur1);
        dimension[5].add(52*facteur1); dimension[5].add(39*facteur1);
            //diagonale haut; 
        coo[6].add(91*facteur1); coo[6].add(110*facteur1);
        dimension[6].add(31*facteur1); dimension[6].add(7*facteur1); 
        coo[7].add(109*facteur1); coo[7].add(100*facteur1);
        dimension[7].add(31*facteur1); dimension[7].add(7*facteur1); 
            //diagonale bas; 
        coo[8].add(166*facteur1); coo[8].add(171*facteur1);
        dimension[8].add(31*facteur1); dimension[8].add(7*facteur1);
        coo[9].add(184*facteur1); coo[9].add(161*facteur1);
        dimension[9].add(31*facteur1); dimension[9].add(7*facteur1);
        coo[10].add(202*facteur1); coo[10].add(151*facteur1);
        dimension[10].add(32*facteur1); dimension[10].add(7*facteur1);
        
        //Pierre; 
        coo[11].add(0*facteur1); coo[11].add(68*facteur1);
        dimension[11].add(61*facteur1); dimension[11].add(9*facteur1);
        coo[12].add(49*facteur1); coo[12].add(59*facteur1);
        dimension[12].add(12*facteur1); dimension[12].add(9*facteur1);
        coo[13].add(60*facteur1); coo[13].add(24*facteur1);
        dimension[13].add(67*facteur1); dimension[13].add(9*facteur1);
        
        coo[14].add(244*facteur1); coo[14].add(144*facteur1);
        dimension[14].add(107*facteur1); dimension[14].add(9*facteur1);
        coo[15].add(339*facteur1); coo[15].add(0*facteur1);
        dimension[15].add(12*facteur1); dimension[15].add(153*facteur1);
        
        //Plante; 
        coo[16].add(370*facteur1); coo[16].add(19*facteur1);
        dimension[16].add(1*facteur1); dimension[16].add(1*facteur1);
        coo[17].add(461*facteur1); coo[17].add(19*facteur1);
        dimension[17].add(1*facteur1); dimension[17].add(1*facteur1);
        coo[18].add(451*facteur1); coo[18].add(49*facteur1);
        dimension[18].add(1*facteur1); dimension[18].add(1*facteur1);
        coo[19].add(380*facteur1); coo[19].add(49*facteur1);
        dimension[19].add(1*facteur1); dimension[19].add(1*facteur1);
        
        coo[20].add(451*facteur1); coo[20].add(105*facteur1);
        dimension[20].add(1*facteur1); dimension[20].add(1*facteur1);
        coo[21].add(380*facteur1); coo[21].add(105*facteur1);
        dimension[21].add(1*facteur1); dimension[21].add(1*facteur1);
        
        coo[22].add(370*facteur1); coo[22].add(75*facteur1);
        dimension[22].add(1*facteur1); dimension[22].add(1*facteur1);
        coo[23].add(461*facteur1); coo[23].add(75*facteur1);
        dimension[23].add(1*facteur1); dimension[23].add(1*facteur1);

        coo[25].add(370*facteur1); coo[25].add(131*facteur1);
        dimension[25].add(1*facteur1); dimension[25].add(1*facteur1);
        coo[26].add(461*facteur1); coo[26].add(131*facteur1);
        dimension[26].add(1*facteur1); dimension[26].add(1*facteur1);
        
        coo[27].add(380*facteur1); coo[27].add(161*facteur1);
        dimension[27].add(1*facteur1); dimension[27].add(1*facteur1);
        coo[28].add(451*facteur1); coo[28].add(161*facteur1);
        dimension[28].add(1*facteur1); dimension[28].add(1*facteur1);
        
        coo[29].add(370*facteur1); coo[29].add(187*facteur1);
        dimension[29].add(1*facteur1); dimension[29].add(1*facteur1);
        coo[30].add(461*facteur1); coo[30].add(187*facteur1);
        dimension[30].add(1*facteur1); dimension[30].add(1*facteur1);
        
        coo[31].add(324*facteur1); coo[31].add(200*facteur1);
        dimension[31].add(1*facteur1); dimension[31].add(1*facteur1);    
        coo[32].add(276*facteur1); coo[32].add(176*facteur1);
        dimension[32].add(1*facteur1); dimension[32].add(1*facteur1);
        coo[24].add(227*facteur1); coo[24].add(201*facteur1);
        dimension[24].add(1*facteur1); dimension[24].add(1*facteur1);

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
        g2d.drawImage(SpriteHitbox.getImage(), x_SpriteHitbox, y_SpriteHitbox, SpriteHitbox.getIconWidth()*facteur2, SpriteHitbox.getIconHeight()*facteur2, this); 
        g2d.drawImage(PoingHitboxX.getImage(), x_PoingHitbox[0], y_PoingHitbox[0], PoingHitboxX.getIconWidth()*facteur2, PoingHitboxX.getIconHeight()*facteur2, this);
        g2d.drawImage(PoingHitboxY.getImage(), x_PoingHitbox[1], y_PoingHitbox[1], PoingHitboxY.getIconWidth()*facteur2, PoingHitboxY.getIconHeight()*facteur2, this); 
        g2d.drawImage(plante.getImage(), 0, 4*facteur1, plante.getIconWidth()*facteur1, plante.getIconHeight()*facteur1, this);
        repaint(); 
    }
    
    @Override
    public AnimationSprite getMaps(){
        return new Maps8(x/facteur1, y/facteur1); 
    }
    
    @Override
    public void MapsSuivante(){
        if(x_SpriteHitbox < ChangeMinX*facteur1){
            Stop(); 
            Carte.switchPanel(new Maps6(AppMaxX, y/facteur1)); 
        }else if(y_SpriteHitbox < ChangeMinY*facteur1){
            Stop(); 
            Carte.switchPanel(new Maps7(x/facteur1, AppMaxY)); 
        }
    }
    public void setMap(){  
        map = new ImageIcon("src/main/java/dessin/Maps/Map8.png");  
    } 
    
    @Override
    public int getNumberClass(){
        return 8; 
    }
}