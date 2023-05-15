/**
 Projet     : Générateur de paysages virtuels
 Initiateur : Olivier Capuozzo
              Lycée Léonard de Vinci
              77000 Melun
 Modifié par: Templier François
              IG12
 Date       : 17/dec/2002
 Public     : BTS IG 1ère année

 Objectif   : Représente générateur de paysages
 */



package genPaysage;

import javax.swing.*;
import java.awt.*;
import java.util.*;
import java.awt.event.*;
import java.io.*;
import java.beans.*;
import javax.swing.filechooser.*;

public class Paysage extends JFrame implements ActionListener {
  
  private JMenuItem mnQuitter;
  private JMenuItem mnSauvegarder;
  private JMenuItem mnOuvrir;
  private JMenuItem mnAPropos;
  private JMenuItem mnNouveau;
  
  public Paysage(String titre) {
    super(titre);
    // Le positionnement des objets graphiques est délégué
    // à un objet de type PaysageLayout
    getContentPane().setLayout(new PaysageLayout());
    
    // terminer l'application lorsque la fenêtre se ferme
    setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    
    // ajoute un menu
    setJMenuBar(getMenu());
   
    // une couleur de fond
    this.getContentPane().setBackground(new Color(160,160, 255));
    
    // par défaut construit un paysage "aléatoirement"
    this.init();
  }//constructeur
  
  private JMenuBar getMenu() {
    JMenuBar barreDeMenu = new JMenuBar();

    JMenu fichier = new JMenu("Fichier");
    fichier.setMnemonic(70);
    
    JMenu aPropos = new JMenu("?");
    aPropos.setMnemonic(63);
    
    this.mnNouveau = new JMenuItem("Nouveau");
    mnNouveau.setMnemonic(78);
    this.mnNouveau.addActionListener(this);
    fichier.add(this.mnNouveau);

    fichier.addSeparator();
    this.mnSauvegarder = new JMenuItem("Enregistrer sous...");
    mnSauvegarder.setMnemonic(115);
    this.mnSauvegarder.addActionListener(this);
    fichier.add(this.mnSauvegarder);

    this.mnOuvrir = new JMenuItem("Ouvrir");
    mnOuvrir.setMnemonic(79);
    this.mnOuvrir.addActionListener(this);
    fichier.add(this.mnOuvrir);

    fichier.addSeparator();
    this.mnQuitter = new JMenuItem("Quitter");
    mnQuitter.setMnemonic(81);
    this.mnQuitter.addActionListener(this);
    fichier.add(this.mnQuitter);
    
    this.mnAPropos = new JMenuItem("A propos de genPaysage");
    mnAPropos.setMnemonic(112);
    this.mnAPropos.addActionListener(this);
    aPropos.add(this.mnAPropos);
    
    barreDeMenu.add(fichier);
    barreDeMenu.add(aPropos);
    return barreDeMenu;
  }

  final private void init() {
    int x, y, w, h, nbEtages, nbFenParEtag;
    int position=490;
    Random rand = new Random();
    int alea = rand.nextInt(12) + 3; // trois au minimum
    int alea2 = rand.nextInt(3) + 1; // un au minimum
    
    // construire un nombre aléatoire d'arbres
    for (int i=0; i<alea2; i++) {
      this.getContentPane().add(new ObjetTerrestre(position, 100, 100, new Color(150,75,50),
        this.getContentPane().getBackground(), 0));
      position+=50;
    }
    // construire "aléatoirement" un nombre aléatoire d'immeubles
    for (int i=0; i<alea; i++) {
      x=rand.nextInt(350)+20;
      y=rand.nextInt(100)+20;
      h=rand.nextInt(100)+30;
      nbEtages = rand.nextInt(30)+4;
      nbFenParEtag = rand.nextInt(30)+4;
      Color couleur = 
       new Color(rand.nextInt(240)+15,rand.nextInt(240)+15,rand.nextInt(240)+15);
    
      this.getContentPane().add(
         new Immeuble(x,y,h,nbEtages,nbFenParEtag,couleur,
                      this.getContentPane().getBackground()));
    }
    // une belle planète
    this.getContentPane().add(new Planete(-40,100,200,16, Color.BLACK, 
       this.getContentPane().getBackground(), 50));
    // un beau soleil
    this.getContentPane().add(new Soleil(400, 100, 100, 16, Color.YELLOW,
       this.getContentPane().getBackground(), 125));
  }// init
  
  public void nouveauPara(int nbreImmeuble, int nbreArbre){
    this.getContentPane().removeAll(); //efface le conteneur
    this.repaint(); //le "repaint" avec la couleur de fond
    
    int x, y, w, h, nbEtages, nbFenParEtag;
    int position=490;
    Random rand = new Random();
    
    // construit le nombre d'arbres indiqué
    for (int i=0; i<nbreArbre; i++) {
      this.getContentPane().add(new ObjetTerrestre(position, 100, 100, new Color(150,75,50),
        this.getContentPane().getBackground(), 0));
      position+=50;
    }
    // construire "aléatoirement" un nombre définie d'immeubles
    for (int i=0; i<nbreImmeuble; i++) {
      x=rand.nextInt(350)+20;
      y=rand.nextInt(100)+20;
      h=rand.nextInt(100)+30;
      nbEtages = rand.nextInt(30)+4;
      nbFenParEtag = rand.nextInt(30)+4;
      Color couleur = 
       new Color(rand.nextInt(240)+15,rand.nextInt(240)+15,rand.nextInt(240)+15);
    
      this.getContentPane().add(
         new Immeuble(x,y,h,nbEtages,nbFenParEtag,couleur,
                      this.getContentPane().getBackground()));
    }
    // une belle planète
    this.getContentPane().add(new Planete(-40,100,200,16, Color.BLACK, 
       this.getContentPane().getBackground(), 50));
    // un beau soleil
    this.getContentPane().add(new Soleil(400, 100, 100, 16, Color.YELLOW,
       this.getContentPane().getBackground(), 125));
    this.validate(); //valide toutes les actions précédente
  }
  
  public void actionPerformed(ActionEvent e) {
    Object o = e.getSource();
    if (o==mnQuitter){
      this.dispose();
    }
    else if (o==mnSauvegarder){
      try{
        //cree un objet pour utiliser la sauvegarde
        JFileChooser chooser = new JFileChooser(".");
        
        //création d'un filtre grâce à une classe donnée en exemple dans les JDK
        Filtre filter = new Filtre();
        filter.addExtension("xml");
        filter.setDescription("Fichier de sauvegarde (*.xml)");
        chooser.setFileFilter(filter);

        //specifie que l'on ne veut utiliser que des fichiers
        chooser.setFileSelectionMode(JFileChooser.FILES_ONLY);
        chooser.setAcceptAllFileFilterUsed(false);
        int resultat = chooser.showSaveDialog(this); 
        if (resultat == JFileChooser.CANCEL_OPTION){ //quitter si l'on clic sur Annuler 
          return;
        }
        File nomFich = chooser.getSelectedFile(); //obtenir le nom du fichier selectionner
        if (nomFich.exists()){
          if (JOptionPane.showConfirmDialog(this, "Le fichier \""+nomFich.getName()+
                                            "\" existe déjà. Voulez-vous le remplacer ?",
                                            "genPaysage", JOptionPane.YES_NO_OPTION,
                                            JOptionPane.INFORMATION_MESSAGE)
                                            ==JOptionPane.NO_OPTION){
            return;
          }
        }
        if (nomFich == null || nomFich.equals("")){ //afficher un erreur si nom incorrect
          JOptionPane.showMessageDialog(this,
                                        "Nom de fichier incorect",
                                        "Nom de fichier incorect",
                                        JOptionPane.ERROR_MESSAGE);
        }
        else{ //sauvegarde le fichier
          XMLEncoder encod = new XMLEncoder(
                                 new BufferedOutputStream(
                                     new FileOutputStream(nomFich)));
          encod.writeObject(getContentPane());
          encod.close();
        }
      }
      catch(java.io.FileNotFoundException ex){
        System.out.println(ex);
      }
    }
    else if (o==mnOuvrir){
      try{
        //créé un objet pour utiliser la restauration d'un fichier
        JFileChooser chooser = new JFileChooser(".");
        
        //création d'un filtre grâce à une classe donnée en exemple dans les JDK
        Filtre filter = new Filtre();
        filter.addExtension("xml");
        filter.setDescription("Fichier de sauvegarde (*.xml)");
        chooser.setFileFilter(filter);
        
        //specifie que l'on ne veut utiliser que des fichiers
        chooser.setFileSelectionMode(JFileChooser.FILES_ONLY);
        chooser.setAcceptAllFileFilterUsed(false);
        int resultat = chooser.showOpenDialog(this);
        if (resultat == JFileChooser.CANCEL_OPTION){ //quitter si l'on clic sur Annuler
          return;
        }
        File nomFich = chooser.getSelectedFile(); //obtenir le nom du fichier selectionner
        if (nomFich == null || nomFich.equals("")){ //afficher un erreur si nom incorrect
          JOptionPane.showMessageDialog(this,
                                        "Nom de fichier incorect","Nom de fichier incorect",
                                        JOptionPane.ERROR_MESSAGE);
        }
        else{ //restaure le fichier
          XMLDecoder decod = new XMLDecoder(
                                 new BufferedInputStream(
                                     new FileInputStream(nomFich)));
          setContentPane((JPanel) decod.readObject());
          validate();
          decod.close();
        }
      }
      catch(java.io.FileNotFoundException ex){
        System.out.println(ex);
      }
    }
    else if (o==mnAPropos){
      Icon image = new ImageIcon("./images/ermite.jpg");
      JOptionPane.showMessageDialog(Paysage.this,
                                    "Projet de DAIGL de fin de 1er semestre\n"+
                                    "Réalisation : Templier François\n"+
                                    "Version : 1.5\n"+
                                    "Date de fin de réalisation : 02/01/2003\n"+
                                    "Copyright© Ermite Chevelu 2002-2003",
                                    "A propos de genPaysage",
                                    JOptionPane.INFORMATION_MESSAGE, image);
    }
    else if (o==mnNouveau){
      Object[] possibleValues = {"Aléatoire", "Paramétré"}; //créé un tableau
      //demande de choisir une valeur dans le tableau grâce a un menu déroulant
      Object selectedValue = JOptionPane.showInputDialog(Paysage.this, 
                                  "Choisissez le type de paysage à générer",
                                  "Nouveau paysage", JOptionPane.QUESTION_MESSAGE,
                                  null,possibleValues, possibleValues[0]);
      if (selectedValue != null){ //ne continue que si on appuie sur OK
        if (selectedValue.equals("Aléatoire")){
          this.getContentPane().removeAll(); //efface le conteneur
          this.repaint(); //le "repaint" avec la couleur de fond
          this.init(); //génère un nouveau paysage
          this.validate(); //valide toutes les actions précédente
        }
        else if (selectedValue.equals("Paramétré")){
          int nbreArbre=0;
          int nbreImmeuble=0;
          String nbre1 = JOptionPane.showInputDialog(this, "Nombre d'immeubles : (20 maximum)",
                                                    "0");
          if(nbre1 != null){
            try{
              nbreImmeuble = Integer.parseInt(nbre1);
            }
            catch(Exception exep){
              JOptionPane.showMessageDialog(Paysage.this, "Saisie incorrect !", "Erreur !",
                                            JOptionPane.WARNING_MESSAGE);
            }
          }
          else{ //arrête tout si on appuie sur Annuler
            return;
          }
          String nbre2 = JOptionPane.showInputDialog(this, "Nombre d'immeubles : (3 maximum)",
                                                    "0");
          if(nbre2 != null){
            try{
              nbreArbre = Integer.parseInt(nbre2);
            }
            catch(Exception exep){
              JOptionPane.showMessageDialog(Paysage.this, "Saisie incorrect !", "Erreur !",
                                            JOptionPane.WARNING_MESSAGE);
            }
          }
          else{ //arrête tout si on appuie sur Annuler
            return;
          }
          if (nbreImmeuble<=20 && nbreArbre<=3){
            this.nouveauPara(nbreImmeuble,nbreArbre);
          }
          else{
            JOptionPane.showMessageDialog(Paysage.this, "Saisie incorrect !", "Erreur !",
                                          JOptionPane.WARNING_MESSAGE);
          }
        }
      }
      else { //sinon annule
        return;
      }
    }
  }
  
 static public void main(String[] args) throws Exception {
    Paysage paysage = new Paysage("Paysage numérique");
    paysage.setBounds(new Rectangle(650,400));
    paysage.setVisible(true);

    /**
    XMLEncoder e = new XMLEncoder(
                    new BufferedOutputStream(
                     new FileOutputStream("paysage1.xml")));
    e.writeObject(paysage.getContentPane());
    e.close();
    
    JOptionPane.showMessageDialog(null, "Zoli, non ?");
    paysage.getContentPane().removeAll();
    paysage.validate();
    paysage.repaint();
    
 
    JOptionPane.showMessageDialog(paysage, 
      "Ce paysage a été sauvegardé sur disque (paysage1.xml)"
      +"\nNous allons maintenant le restaurer.");
      
   XMLDecoder d = new XMLDecoder(
                         new BufferedInputStream(
                              new FileInputStream("paysage1.xml")));
    paysage.setContentPane((JPanel) d.readObject());
    paysage.validate();
    d.close();       
       
    Component[] composants =  paysage.getContentPane().getComponents();
    int nbCompo= composants.length;
    String les_objets = "";
    for (int i=0; i<nbCompo; i++) {
      les_objets += composants[i].toString()+"\n";
    }  

    JOptionPane.showMessageDialog(null, "Listes des composants \n"+ les_objets);
    */
 }      
}