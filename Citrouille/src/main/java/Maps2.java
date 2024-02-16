import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

public final class Maps2 extends AnimationSprite{
    private ImageIcon arbre = new ImageIcon("src/main/java/dessin/Maps/Elèment_Premier_Plan/ArbreViolet.png"); 
    private ImageIcon arbre2 = new ImageIcon("src/main/java/dessin/Maps/Elèment_Premier_Plan/arbre2.png"); 
    
    public Maps2(int x, int y){
        super(x, y);
        taille = 28; 
        setMap();
        setPreferredSize(new Dimension(map.getIconWidth()*facteur1, map.getIconHeight()*facteur1)); 
        collision = new Image[taille]; 
        setImageCollision(taille); 
        
        //Collision; 
        RemplirCoordonee();  
        setFocusable(true);
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
        coo[0].add(173*facteur1); coo[0].add(193*facteur1);
        coo[1].add(275*facteur1); coo[1].add(193*facteur1);
        dimension[0].add(32*facteur1); dimension[0].add(77*facteur1);
        dimension[1].add(32*facteur1); dimension[1].add(77*facteur1);
        
        coo[2].add(134*facteur1); coo[2].add(193*facteur1);
        coo[3].add(275*facteur1); coo[3].add(193*facteur1);
        dimension[2].add(71*facteur1); dimension[2].add(7*facteur1); 
        dimension[3].add(70*facteur1); dimension[3].add(7*facteur1); 
        
        //Arbre gauche;
        coo[4].add(134*facteur1); coo[4].add(65*facteur1);
        dimension[4].add(32*facteur1); dimension[4].add(125*facteur1);
        
        coo[5].add(134*facteur1); coo[5].add(65*facteur1);
        dimension[5].add(63*facteur1); dimension[5].add(7*facteur1);
        
        coo[6].add(183*facteur1); coo[6].add(0*facteur1);
        dimension[6].add(32*facteur1); dimension[6].add(65*facteur1);
        
        //Arbre droite; 
        coo[7].add(313*facteur1); coo[7].add(161*facteur1);
        dimension[7].add(32*facteur1); dimension[7].add(39*facteur1);
        
        coo[8].add(313*facteur1); coo[8].add(161*facteur1);
        dimension[8].add(167*facteur1); dimension[8].add(7*facteur1);
        
        coo[9].add(265*facteur1); coo[9].add(0*facteur1);
        dimension[9].add(32*facteur1); dimension[9].add(65*facteur1);
        
        coo[10].add(282*facteur1); coo[10].add(65*facteur1);
        dimension[10].add(63*facteur1); dimension[10].add(7*facteur1);
        
        coo[11].add(313*facteur1); coo[11].add(65*facteur1);
        dimension[11].add(32*facteur1); dimension[11].add(39*facteur1);
        
        coo[12].add(313*facteur1); coo[12].add(97*facteur1);
        dimension[12].add(167*facteur1); dimension[12].add(7*facteur1);
        
        //Pierre RIP droite;
        coo[13].add(366*facteur1); coo[13].add(8*facteur1);
        coo[14].add(443*facteur1); coo[14].add(8*facteur1);
        dimension[13].add(12*facteur1); dimension[13].add(54*facteur1);
        dimension[14].add(12*facteur1); dimension[14].add(54*facteur1);
        
        coo[15].add(366*facteur1); coo[15].add(8*facteur1);
        dimension[15].add(89*facteur1); dimension[15].add(9*facteur1); 
        
        coo[16].add(366*facteur1); coo[16].add(53*facteur1);
        dimension[16].add(34*facteur1); dimension[16].add(9*facteur1); 
        
        coo[17].add(421*facteur1); coo[17].add(53*facteur1);
        dimension[17].add(34*facteur1); dimension[17].add(9*facteur1); 
        
        //Pierre gauche; 
        coo[18].add(0*facteur1); coo[18].add(182*facteur1);
        coo[19].add(83*facteur1); coo[19].add(182*facteur1);
        dimension[18].add(52*facteur1); dimension[18].add(9*facteur1);
        dimension[19].add(52*facteur1); dimension[19].add(9*facteur1);
        
        coo[20].add(40*facteur1); coo[20].add(119*facteur1);
        dimension[20].add(12*facteur1); dimension[20].add(72*facteur1); 
        
        coo[21].add(40*facteur1); coo[21].add(0*facteur1);
        dimension[21].add(12*facteur1); dimension[21].add(74*facteur1); 
        
        coo[22].add(83*facteur1); coo[22].add(0*facteur1);
        dimension[22].add(12*facteur1); dimension[22].add(191*facteur1); 
        
        coo[24].add(0*facteur1); coo[24].add(65*facteur1);
        coo[25].add(0*facteur1); coo[25].add(118*facteur1);
        dimension[24].add(52*facteur1); dimension[24].add(9*facteur1);
        dimension[25].add(52*facteur1); dimension[25].add(9*facteur1);
        
        //Arbre vert; 
        coo[23].add(224*facteur1); coo[23].add(145*facteur1);
        dimension[23].add(32*facteur1); dimension[23].add(1*facteur1); 
        
        //Arbre bas; 
        coo[26].add(0*facteur1); coo[26].add(246*facteur1);
        coo[27].add(415*facteur1); coo[27].add(246*facteur1);
        dimension[26].add(65*facteur1); dimension[26].add(24*facteur1); 
        dimension[27].add(65*facteur1); dimension[27].add(24*facteur1); 
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
        g2d.drawImage(arbre.getImage(), 224*facteur1, 107*facteur1, arbre.getIconWidth()*facteur1, arbre.getIconHeight()*facteur1, this);
        g2d.drawImage(arbre2.getImage(), 0, 55*facteur1, arbre2.getIconWidth()*facteur1, arbre2.getIconHeight()*facteur1, this);
        repaint(); 
    }

    @Override
    public void MapsSuivante(){
        if(y_SpriteHitbox  > ChangeMaxY*facteur1){ 
            Stop(); 
            Carte.switchPanel(new Maps1(x/facteur1, AppMinY)); 
        }else if(x_SpriteHitbox  > ChangeMaxX*facteur1){
            Stop(); 
            Carte.switchPanel(new Maps4(AppMinX, y/facteur1)); 
        }
    }
    
    @Override
    public AnimationSprite getMaps(){
        return new Maps2(x/facteur1, y/facteur1); 
    }
    
    public void setMap(){  
        map = new ImageIcon("src/main/java/dessin/Maps/Map2.png");  
    }

    @Override
    public int getNumberClass(){
        return 2; 
    }
}