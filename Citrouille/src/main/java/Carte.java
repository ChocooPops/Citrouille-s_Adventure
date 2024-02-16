import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public final class Carte extends JFrame {
    private static Carte frame = new Carte(); 
    private static AnimationSprite MapActuelle; 
    private int weight;
    private int hight;
    private int facteur; 
    private JButton[] bouton; 
    private JPanel[] panel_secondaire;
    private JPanel panelBack; 
    private int nb_taille = 5; 
    private int taille; 
    private static JFrame dimensionFenetre; 
    public Carte(){
        setDimensionFenetre(); 
         
    }
    //Definit les caracteristiques de la fenetre "dimensionFenetre" qui sera un Menu pour regler les dimension de la fenetre principal "frame"; 
    public void setDimensionFenetre(){
        setTaille(); 
        Carte.dimensionFenetre = new JFrame(); 
        Carte.dimensionFenetre.setSize(weight, hight); 
        Carte.dimensionFenetre.setResizable(false); 
        Carte.dimensionFenetre.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); 
        Carte.dimensionFenetre.setLocationRelativeTo(null);
        Carte.dimensionFenetre.getContentPane().add(definePanel()); 
        Carte.dimensionFenetre.setUndecorated(true);
        Carte.dimensionFenetre.setFocusable(true);
        Carte.dimensionFenetre.requestFocus(); 
        actionBouton();
        Close();
    }
    //Ajouter une action clavier au Menu des reglages dimensions; 
    public void Close(){
        Carte.dimensionFenetre.addKeyListener(new KeyAdapter(){
            @Override
            public void keyPressed(KeyEvent e){
                if(e.getKeyCode() == KeyEvent.VK_ESCAPE){               //Si la meme touche utiliser pour ouvrir cette fenetre dans la classe AnimationSprite est appuyee lorsqu'elle est ouverte, alors DimensionFenetre est fermee; 
                    if(Carte.getFenetreDimension().isVisible()){
                        Carte.dimensionFenetre.setVisible(false);
                        Carte.dimensionFenetre.dispose();
                    }
                }
            }
        });
    }
    //Adapet la taille du Menu DimensionFenetre selon la taille de la fenetre (get la valeur static du facteur de la class AnimationSprite pour ajuster en fonction); 
    public void setTaille(){
        facteur = AnimationSprite.getFacteur()-1; 
        weight = 250 * facteur; 
        hight = 151 * facteur;
    }
    //Methode static utilisee dans les class filles d'AnimationSprite pour changer de Map lorsque le Sprite touche les bords de la fenetre; 
    public static void switchPanel(AnimationSprite newMap) {
        MapActuelle = newMap;               //Actualise la variable MapActuelle qui va contenir la nouvel class fille d'AnimationSpite qui sera afficher dans la fenetre; 
        frame.getContentPane().removeAll(); 
        frame.getContentPane().add(MapActuelle);    //Actualise l'affichage; 
        frame.MapActuelle.setFocusable(true);
        frame.MapActuelle.requestFocus();
        frame.pack();                                   //Redimensionne l'affichage; 
    }
    
    //Methode servant a reinitialiser la taille de la fenetre apres q'une option ait ete choisi dans le Menu DimensionFenetre; 
    public void Pack(int taille){
        AnimationSprite.setFacteur(taille);
        frame.getContentPane().removeAll(); 
        frame.getContentPane().add(MapActuelle.getMaps());
        frame.pack();
        frame.setLocationRelativeTo(null);
        dimensionFenetre.setVisible(false);
        setDimensionFenetre();  //Redefinir le Menu DimensionFenetre en le reinitialisant et en changeant ses dimensions; 
    }
    //Methode static qui sera utilise par la class AnimationSprite pour afficher le Menu DimensionFenetre; 
    public static JFrame getFenetreDimension(){
        return dimensionFenetre; 
    }

    //DESIGNE DE LA FENETRE DES DIMENSIONS; 
    public void setBouton(){
        bouton = new JButton[nb_taille]; //Tableau de bouton => plus simple + plus rapide;
        Color c; 
        c = Color.decode("#68c719");
        for(int i=0; i<nb_taille; i++){ //initialise le tableau de Bouton dans une boucle; 
            bouton[i] = new JButton(); 
            bouton[i].setBorder(null);
            bouton[i].setBackground(c);
            bouton[i].setOpaque(false);
        }
        //Ajoute une image specifique a tous les boutons;
        ImageIcon imageIcon = new ImageIcon("src/main/java/dessin/FenetreDimension/bouton1.png"); 
        Image image = imageIcon.getImage().getScaledInstance(imageIcon.getIconWidth()*facteur, imageIcon.getIconHeight()*facteur, Image.SCALE_SMOOTH);
        bouton[0].setIcon(new ImageIcon(image));
        
        imageIcon = new ImageIcon("src/main/java/dessin/FenetreDimension/bouton2.png"); 
        image = imageIcon.getImage().getScaledInstance(imageIcon.getIconWidth()*facteur, imageIcon.getIconHeight()*facteur, Image.SCALE_SMOOTH);
        bouton[1].setIcon(new ImageIcon(image));
        
        imageIcon = new ImageIcon("src/main/java/dessin/FenetreDimension/bouton3.png"); 
        image = imageIcon.getImage().getScaledInstance(imageIcon.getIconWidth()*facteur, imageIcon.getIconHeight()*facteur, Image.SCALE_SMOOTH);
        bouton[2].setIcon(new ImageIcon(image));
        
        imageIcon = new ImageIcon("src/main/java/dessin/FenetreDimension/bouton4.png"); 
        image = imageIcon.getImage().getScaledInstance(imageIcon.getIconWidth()*facteur, imageIcon.getIconHeight()*facteur, Image.SCALE_SMOOTH);
        bouton[3].setIcon(new ImageIcon(image));
        
        imageIcon = new ImageIcon("src/main/java/dessin/FenetreDimension/bouton5.png"); 
        image = imageIcon.getImage().getScaledInstance(imageIcon.getIconWidth()*facteur, imageIcon.getIconHeight()*facteur, Image.SCALE_SMOOTH);
        bouton[4].setIcon(new ImageIcon(image));
    }
    //Definir le Panel secondaire qui contiendra tous les boutons; 
    public JPanel definePanel(){
        setBouton(); 
        design1(); 
        panel_secondaire = new JPanel[nb_taille]; //Tableau de Panel => plus simple + plus rapide; 
        for(int i=0; i<nb_taille; i++){
            panel_secondaire[i] = new JPanel(); 
            panel_secondaire[i].setOpaque(false);
            panel_secondaire[i].setLayout(new FlowLayout(FlowLayout.CENTER, 0, 10)); //Layout FlowLayout => Centrer tous les boutons + personnaliser leur taille; 
        }
        for(int i=0; i<nb_taille; i++){           //Ajout de chaque bouton dans chaque panel secondaire;           
            panel_secondaire[i].add(bouton[i]); 
        }
        for(int i=0; i<nb_taille; i++){
            panelBack.add(panel_secondaire[i]);    //Ajout de tous les panels seondaires dans le panel principal; 
        }
        
        return panelBack; 
    }
    //DESIGN MAPS1; 
    public void design1(){
        panelBack = new JPanel(){
            protected void paintComponent(Graphics g){
                super.paintComponents(g);
                ImageIcon image; 
                //Ajoute une image comme background dans le panelBack selon la map actuellement affichee dans la fenetre (element simplement visuel pour garder une coherence entre les couleurs); 
                switch(MapActuelle.getNumberClass()){
                    case 1 : image = new ImageIcon("src/main/java/dessin/FenetreDimension/Ecran1.png"); 
                        break; 
                    case 2 : image = new ImageIcon("src/main/java/dessin/FenetreDimension/Ecran2.png");
                        break; 
                    case 3 : image = new ImageIcon("src/main/java/dessin/FenetreDimension/Ecran3.png");
                        break; 
                    case 4 : image = new ImageIcon("src/main/java/dessin/FenetreDimension/Ecran4.png"); 
                        break; 
                    case 5 : image = new ImageIcon("src/main/java/dessin/FenetreDimension/Ecran5.png");
                        break; 
                    case 6 : image = new ImageIcon("src/main/java/dessin/FenetreDimension/Ecran6.png");
                        break;
                    case 7 : image = new ImageIcon("src/main/java/dessin/FenetreDimension/Ecran7.png");
                        break; 
                    case 8 : image = new ImageIcon("src/main/java/dessin/FenetreDimension/Ecran8.png");
                        break; 
                    case 9 : image = new ImageIcon("src/main/java/dessin/FenetreDimension/Ecran9.png");
                        break; 
                    default : image = new ImageIcon("src/main/java/dessin/FenetreDimension/Ecran1.png");
                        break; 
                }
                g.drawImage(image.getImage(),0, 0, Carte.dimensionFenetre.getWidth(), Carte.dimensionFenetre.getHeight(), this); 
            }
        };  
        panelBack.setLayout(new GridLayout(nb_taille, 1, 0, 0)); 
    }
    //Definit les caracteristiques de la fenetre principal "frame" ou sera afficher tout les elements du jeu;
    public static void setVisible(){
        MapActuelle = new Maps8(234, 225); 
        frame.getContentPane().add(MapActuelle); 
        frame.setResizable(false); 
        frame.setTitle("The Ezougla's Adventure");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); 
        frame.pack(); 
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);    
    }
    
        //Ajouter les actions de clique pour tous les boutons; 
    public void actionBouton(){
        bouton[0].addActionListener((ActionEvent e) -> {
            taille = 2;
            Pack(taille); 
        });
        bouton[1].addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e) {
               taille = 3;  
               Pack(taille); 
            }
        });
        bouton[2].addActionListener((ActionEvent e) -> {
            taille = 4;
            Pack(taille); 
        });
        bouton[3].addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e) {
                taille = 5;  
                Pack(taille); 
            }
        });
        bouton[4].addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e) {
                taille = 2;  
                Pack(taille); 
                GraphicsDevice device = GraphicsEnvironment.getLocalGraphicsEnvironment().getDefaultScreenDevice();
                device.setFullScreenWindow(frame);
                frame.pack();
                Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
                System.out.println(screenSize);
            }   
        });
        //Ajoute les actions de souris donner une impression d'animation pour le bouton;
        bouton[0].addMouseListener(new MouseAdapter(){
            @Override
            public void mouseEntered(MouseEvent e){ //Change l'image du bouton en cas de contact entre la souris et ce dernier => Image d'un bouton enfonce; 
                ImageIcon imageIcon = new ImageIcon("src/main/java/dessin/FenetreDimension/bouton10.png"); 
                Image image = imageIcon.getImage().getScaledInstance(imageIcon.getIconWidth()*facteur, imageIcon.getIconHeight()*facteur, Image.SCALE_SMOOTH);
                bouton[0].setIcon(new ImageIcon(image));
            } 
            @Override
            public void mouseExited(MouseEvent e){  //Change l'image du bouton en cas d'absence de contact entre le souris et ce dernier => Image d'un bouton relache;
                ImageIcon imageIcon = new ImageIcon("src/main/java/dessin/FenetreDimension/bouton1.png"); 
                Image image = imageIcon.getImage().getScaledInstance(imageIcon.getIconWidth()*facteur, imageIcon.getIconHeight()*facteur, Image.SCALE_SMOOTH);
                bouton[0].setIcon(new ImageIcon(image));
            } 
        }); 
        bouton[1].addMouseListener(new MouseAdapter(){
            @Override
            public void mouseEntered(MouseEvent e){
                ImageIcon imageIcon = new ImageIcon("src/main/java/dessin/FenetreDimension/bouton20.png"); 
                Image image = imageIcon.getImage().getScaledInstance(imageIcon.getIconWidth()*facteur, imageIcon.getIconHeight()*facteur, Image.SCALE_SMOOTH);
                bouton[1].setIcon(new ImageIcon(image));
            } 
            @Override
            public void mouseExited(MouseEvent e){
                ImageIcon imageIcon = new ImageIcon("src/main/java/dessin/FenetreDimension/bouton2.png"); 
                Image image = imageIcon.getImage().getScaledInstance(imageIcon.getIconWidth()*facteur, imageIcon.getIconHeight()*facteur, Image.SCALE_SMOOTH);
                bouton[1].setIcon(new ImageIcon(image));
            } 
        }); 
        bouton[2].addMouseListener(new MouseAdapter(){
            @Override
            public void mouseEntered(MouseEvent e){
                ImageIcon imageIcon = new ImageIcon("src/main/java/dessin/FenetreDimension/bouton30.png"); 
                Image image = imageIcon.getImage().getScaledInstance(imageIcon.getIconWidth()*facteur, imageIcon.getIconHeight()*facteur, Image.SCALE_SMOOTH);
                bouton[2].setIcon(new ImageIcon(image));
            } 
            @Override
            public void mouseExited(MouseEvent e){
                ImageIcon imageIcon = new ImageIcon("src/main/java/dessin/FenetreDimension/bouton3.png"); 
                Image image = imageIcon.getImage().getScaledInstance(imageIcon.getIconWidth()*facteur, imageIcon.getIconHeight()*facteur, Image.SCALE_SMOOTH);
                bouton[2].setIcon(new ImageIcon(image));
            } 
        }); 
        bouton[3].addMouseListener(new MouseAdapter(){
            @Override
            public void mouseEntered(MouseEvent e){
                ImageIcon imageIcon = new ImageIcon("src/main/java/dessin/FenetreDimension/bouton40.png"); 
                Image image = imageIcon.getImage().getScaledInstance(imageIcon.getIconWidth()*facteur, imageIcon.getIconHeight()*facteur, Image.SCALE_SMOOTH);
                bouton[3].setIcon(new ImageIcon(image));
            } 
            @Override
            public void mouseExited(MouseEvent e){
                ImageIcon imageIcon = new ImageIcon("src/main/java/dessin/FenetreDimension/bouton4.png"); 
                Image image = imageIcon.getImage().getScaledInstance(imageIcon.getIconWidth()*facteur, imageIcon.getIconHeight()*facteur, Image.SCALE_SMOOTH);
                bouton[3].setIcon(new ImageIcon(image));
            } 
        }); 
        bouton[4].addMouseListener(new MouseAdapter(){
            @Override
            public void mouseEntered(MouseEvent e){
                ImageIcon imageIcon = new ImageIcon("src/main/java/dessin/FenetreDimension/bouton50.png"); 
                Image image = imageIcon.getImage().getScaledInstance(imageIcon.getIconWidth()*facteur, imageIcon.getIconHeight()*facteur, Image.SCALE_SMOOTH);
                bouton[4].setIcon(new ImageIcon(image));
            } 
            @Override
            public void mouseExited(MouseEvent e){
                ImageIcon imageIcon = new ImageIcon("src/main/java/dessin/FenetreDimension/bouton5.png"); 
                Image image = imageIcon.getImage().getScaledInstance(imageIcon.getIconWidth()*facteur, imageIcon.getIconHeight()*facteur, Image.SCALE_SMOOTH);
                bouton[4].setIcon(new ImageIcon(image));
            } 
        }); 
    } 
}
