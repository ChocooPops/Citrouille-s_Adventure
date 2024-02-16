import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

public final class Maps4 extends AnimationSprite{
    private ImageIcon [] glace; 
    private ImageIcon arbre = new ImageIcon("src/main/java/dessin/Maps/Elèment_Premier_Plan/arbre4.png");
      
    public Maps4(int x, int y){
        super(x, y);
        taille = 11; 
        setMap();
        setPreferredSize(new Dimension(map.getIconWidth()*facteur1, map.getIconHeight()*facteur1)); 
        collision = new Image[taille]; 
        setImageCollision(taille); 
 
        //Collision; 
        RemplirCoordonee();  
        setGlace();
    }

    private void setGlace(){
        glace = new ImageIcon[2]; 
        glace[0] = new ImageIcon("src/main/java/dessin/Maps/Elèment_Premier_Plan/glace1.png"); 
        glace[1] = new ImageIcon("src/main/java/dessin/Maps/Elèment_Premier_Plan/glace2.png");
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
        coo[0].add(0*facteur1); coo[0].add(97*facteur1);
        coo[1].add(0*facteur1); coo[1].add(161*facteur1);
        dimension[0].add(93*facteur1); dimension[0].add(7*facteur1);
        dimension[1].add(93*facteur1); dimension[1].add(7*facteur1);
        
        coo[2].add(144*facteur1); coo[2].add(32*facteur1);
        coo[3].add(284*facteur1); coo[3].add(32*facteur1);
        dimension[2].add(51*facteur1); dimension[2].add(33*facteur1); 
        dimension[3].add(51*facteur1); dimension[3].add(33*facteur1);
        
        coo[4].add(380*facteur1); coo[4].add(158*facteur1);
        coo[5].add(224*facteur1); coo[5].add(133*facteur1);
        dimension[4].add(51*facteur1); dimension[4].add(33*facteur1);
        dimension[5].add(32*facteur1); dimension[5].add(7*facteur1);
        
        //Glace; 
        coo[6].add(376*facteur1); coo[6].add(84*facteur1);
        dimension[6].add(86*facteur1); dimension[6].add(7*facteur1); 
        
        coo[7].add(191*facteur1); coo[7].add(227*facteur1);
        coo[8].add(251*facteur1); coo[8].add(227*facteur1);
        dimension[7].add(38*facteur1); dimension[7].add(7*facteur1); 
        dimension[8].add(38*facteur1); dimension[8].add(7*facteur1);
        
        //Hauteur; 
        
        //Arbre; 
        coo[9].add(0*facteur1); coo[9].add(241*facteur1);
        coo[10].add(295*facteur1); coo[10].add(241*facteur1);
        dimension[9].add(182*facteur1); dimension[9].add(29*facteur1);
        dimension[10].add(185*facteur1); dimension[10].add(29*facteur1);
    
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
        g2d.drawImage(glace[0].getImage(), 192*facteur1, 194*facteur1, glace[0].getIconWidth()*facteur1, glace[0].getIconHeight()*facteur1, this); 
        g2d.drawImage(glace[1].getImage(), 376*facteur1, 62*facteur1, glace[1].getIconWidth()*facteur1, glace[1].getIconHeight()*facteur1, this); 
        g2d.drawImage(arbre.getImage(), 0, 22*facteur1, arbre.getIconWidth()*facteur1, arbre.getIconHeight()*facteur1, this); 
        repaint(); 
    }
    
    @Override
    public AnimationSprite getMaps(){
        return new Maps4(x/facteur1, y/facteur1);  
    }
    
    @Override
    public void MapsSuivante(){
        if(x_SpriteHitbox  < ChangeMinX*facteur1){
            Stop(); 
            Carte.switchPanel(new Maps2(AppMaxX, y/facteur1)); 
        }else if(y_SpriteHitbox  > ChangeMaxY*facteur1){
            Stop(); 
            Carte.switchPanel(new Maps5(x/facteur1, AppMinY)); 
        }else if(x_SpriteHitbox  > ChangeMaxX*facteur1){
            Stop(); 
            Carte.switchPanel(new Maps9(AppMinX, y/facteur1)); 
        } 
    }
    public void setMap(){  
        map = new ImageIcon("src/main/java/dessin/Maps/Map4.png");  
    }  
    @Override
    public int getNumberClass(){
        return 4; 
    }
}