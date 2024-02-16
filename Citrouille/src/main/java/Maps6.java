import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

public class Maps6 extends AnimationSprite{
    private ImageIcon plante  = new ImageIcon("src/main/java/dessin/Maps/Elèment_Premier_Plan/plante1.png"); 
    private ImageIcon arbre = new ImageIcon("src/main/java/dessin/Maps/Elèment_Premier_Plan/ArbreMarron.png"); 
    private ImageIcon arbre1 = new ImageIcon("src/main/java/dessin/Maps/Elèment_Premier_Plan/arbre6.png");
     
    public Maps6(int x, int y){
        super(x, y);
        taille = 46; 
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
        //Pierre;
        coo[0].add(0*facteur1); coo[0].add(72*facteur1);
        coo[1].add(51*facteur1); coo[1].add(45*facteur1);
        dimension[0].add(63*facteur1); dimension[0].add(9*facteur1);
        dimension[1].add(12*facteur1); dimension[1].add(36*facteur1);
         
        coo[2].add(51*facteur1); coo[2].add(45*facteur1);
        coo[3].add(117*facteur1); coo[3].add(0*facteur1);
        dimension[2].add(78*facteur1); dimension[2].add(9*facteur1); 
        dimension[3].add(12*facteur1); dimension[3].add(54*facteur1);
        
        coo[4].add(352*facteur1); coo[4].add(0*facteur1);
        coo[5].add(352*facteur1); coo[5].add(41*facteur1);
        dimension[4].add(12*facteur1); dimension[4].add(50*facteur1);
        dimension[5].add(45*facteur1); dimension[5].add(9*facteur1);
         
        coo[6].add(385*facteur1); coo[6].add(41*facteur1);
        dimension[6].add(12*facteur1); dimension[6].add(36*facteur1); 
        coo[7].add(385*facteur1); coo[7].add(68*facteur1);
        dimension[7].add(95*facteur1); dimension[7].add(9*facteur1); 
        
        //Plante; 
        coo[8].add(171*facteur1); coo[8].add(36*facteur1);
        coo[9].add(284*facteur1); coo[9].add(62*facteur1);
        dimension[9].add(25*facteur1); dimension[9].add(7*facteur1);
        dimension[8].add(25*facteur1); dimension[8].add(7*facteur1);
        
        coo[10].add(38*facteur1); coo[10].add(228*facteur1);
        dimension[10].add(25*facteur1); dimension[10].add(7*facteur1);
        coo[11].add(150*facteur1); coo[11].add(255*facteur1);
        dimension[11].add(25*facteur1); dimension[11].add(7*facteur1);
        coo[12].add(323*facteur1); coo[12].add(242*facteur1);
        dimension[12].add(25*facteur1); dimension[12].add(7*facteur1);
        coo[13].add(425*facteur1); coo[13].add(226*facteur1);
        dimension[13].add(25*facteur1); dimension[13].add(7*facteur1);
        
        //Arbre; 
        coo[14].add(230*facteur1); coo[14].add(167*facteur1);
        dimension[14].add(32*facteur1); dimension[14].add(1*facteur1);
        
        coo[15].add(0*facteur1); coo[15].add(0*facteur1);
        dimension[15].add(55*facteur1); dimension[15].add(19*facteur1);
        
        coo[16].add(0*facteur1); coo[16].add(117*facteur1);
        dimension[16].add(92*facteur1); dimension[16].add(7*facteur1);
        coo[17].add(0*facteur1); coo[17].add(176*facteur1);
        dimension[17].add(92*facteur1); dimension[17].add(7*facteur1);
        
        coo[18].add(401*facteur1); coo[18].add(117*facteur1);
        dimension[18].add(80*facteur1); dimension[18].add(7*facteur1);
        coo[19].add(398*facteur1); coo[19].add(178*facteur1);
        dimension[19].add(82*facteur1); dimension[19].add(7*facteur1);
        
        //Diagonale bas droite; 
        coo[20].add(91*facteur1); coo[20].add(179*facteur1);
        dimension[20].add(27*facteur1); dimension[20].add(7*facteur1);
        coo[21].add(111*facteur1); coo[21].add(182*facteur1);
        dimension[21].add(27*facteur1); dimension[21].add(7*facteur1);
        coo[22].add(131*facteur1); coo[22].add(185*facteur1);
        dimension[22].add(32*facteur1); dimension[22].add(7*facteur1);
        
        //Diagonale haut droite; 
        coo[23].add(91*facteur1); coo[23].add(114*facteur1);
        dimension[23].add(24*facteur1); dimension[23].add(7*facteur1);
        coo[24].add(111*facteur1); coo[24].add(111*facteur1);
        dimension[24].add(24*facteur1); dimension[24].add(7*facteur1);
        coo[25].add(131*facteur1); coo[25].add(108*facteur1);
        dimension[25].add(24*facteur1); dimension[25].add(7*facteur1);
        coo[26].add(151*facteur1); coo[26].add(105*facteur1);
        dimension[26].add(24*facteur1); dimension[26].add(7*facteur1);
        coo[27].add(171*facteur1); coo[27].add(102*facteur1);
        dimension[27].add(24*facteur1); dimension[27].add(7*facteur1);
        coo[28].add(191*facteur1); coo[28].add(99*facteur1);
        dimension[28].add(24*facteur1); dimension[28].add(7*facteur1);
        coo[29].add(211*facteur1); coo[29].add(96*facteur1);
        dimension[29].add(24*facteur1); dimension[29].add(7*facteur1);
        
        //Arbre centre; 
        coo[30].add(231*facteur1); coo[30].add(93*facteur1);
        dimension[30].add(32*facteur1); dimension[30].add(7*facteur1);
        coo[31].add(230*facteur1); coo[31].add(200*facteur1);
        dimension[31].add(32*facteur1); dimension[31].add(7*facteur1);
        
        //Diagonale haut gauche; 
        coo[32].add(259*facteur1); coo[32].add(96*facteur1);
        dimension[32].add(24*facteur1); dimension[32].add(7*facteur1);
        coo[33].add(279*facteur1); coo[33].add(99*facteur1);
        dimension[33].add(24*facteur1); dimension[33].add(7*facteur1);
        coo[34].add(299*facteur1); coo[34].add(102*facteur1);
        dimension[34].add(24*facteur1); dimension[34].add(7*facteur1);
        coo[35].add(319*facteur1); coo[35].add(105*facteur1);
        dimension[35].add(24*facteur1); dimension[35].add(7*facteur1);
        coo[36].add(339*facteur1); coo[36].add(108*facteur1);
        dimension[36].add(24*facteur1); dimension[36].add(7*facteur1);
        coo[37].add(359*facteur1); coo[37].add(111*facteur1);
        dimension[37].add(24*facteur1); dimension[37].add(7*facteur1);
        coo[38].add(379*facteur1); coo[38].add(114*facteur1);
        dimension[38].add(24*facteur1); dimension[38].add(7*facteur1);
        
        //Diagonale bas centre; 
        coo[39].add(190*facteur1); coo[39].add(194*facteur1);
        dimension[39].add(24*facteur1); dimension[39].add(7*facteur1);
        coo[40].add(210*facteur1); coo[40].add(197*facteur1);
        dimension[40].add(24*facteur1); dimension[40].add(7*facteur1);
        coo[41].add(261*facteur1); coo[41].add(197*facteur1);
        dimension[41].add(24*facteur1); dimension[41].add(7*facteur1);
        coo[42].add(281*facteur1); coo[42].add(194*facteur1);
        dimension[42].add(24*facteur1); dimension[42].add(7*facteur1);
        
        //Diagonale bas droite; 
        coo[43].add(329*facteur1); coo[43].add(187*facteur1);
        dimension[43].add(32*facteur1); dimension[43].add(7*facteur1);
        coo[44].add(354*facteur1); coo[44].add(184*facteur1);
        dimension[44].add(24*facteur1); dimension[44].add(7*facteur1);
        coo[45].add(374*facteur1); coo[45].add(181*facteur1);
        dimension[45].add(24*facteur1); dimension[45].add(7*facteur1);
    
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
        g2d.drawImage(arbre.getImage(), 230*facteur1, 129*facteur1, arbre.getIconWidth()*facteur1, arbre.getIconHeight()*facteur1, this); 
        g2d.drawImage(plante.getImage(), 33*facteur1, 16*facteur1, plante.getIconWidth()*facteur1, plante.getIconHeight()*facteur1, this); 
        g2d.drawImage(arbre1.getImage(), 0, 83*facteur1, arbre1.getIconWidth()*facteur1, arbre1.getIconHeight()*facteur1, this); 
        repaint(); 
    }
    
    @Override
    public AnimationSprite getMaps(){
        return new Maps6(x/facteur1, y/facteur1); 
    }
    
    @Override
    public void MapsSuivante(){
        if(x_SpriteHitbox  < ChangeMinX*facteur1){
            Stop(); 
            Carte.switchPanel(new Maps3(AppMaxX, y/facteur1)); 
        }else if(y_SpriteHitbox  < ChangeMinY*facteur1){
            Stop(); 
            Carte.switchPanel(new Maps5(x/facteur1, AppMaxY)); 
        }else if(x_SpriteHitbox  > ChangeMaxX*facteur1){
            Stop(); 
            Carte.switchPanel(new Maps8(AppMinX, y/facteur1)); 
        }
    }
    public void setMap(){  
        map = new ImageIcon("src/main/java/dessin/Maps/Map6.png");  
    }   
    
    @Override
    public int getNumberClass(){
        return 6; 
    }
}