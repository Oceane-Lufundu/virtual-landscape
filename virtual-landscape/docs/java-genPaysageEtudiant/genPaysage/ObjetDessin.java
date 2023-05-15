/**
 Projet     : Générateur de paysages virtuels
 Initiateur : Olivier Capuozzo
              Lycée Léonard de Vinci
              77000 Melun
 Date       : 17/dec/2002
 Public     : BTS IG 1ère année

 Objectif   : Représente un modèle pour les objets du paysage
*/



package genPaysage;

import javax.swing.*;
import java.awt.*;

abstract public class ObjetDessin extends JPanel {
 protected Color couleurTrait;
 protected Color couleurFond;
 protected int deltaHorizon; 
       // distance, en pixel, qui sépare l'objet du bas de la fenêtre
 protected int x, w, h;
       // respectivement coord. en x, largeur et hauteur de l'objet
 
 // un constructeur par défaut
 public ObjetDessin(){ 
   super();
 }
 
 // un constructeur pour initialiser certains attributs
 public ObjetDessin(Color couleurTrait, Color couleurFond, int deltaHorizon){
   super();
   this.couleurTrait=couleurTrait;
   this.couleurFond=couleurFond;
   this.deltaHorizon=deltaHorizon;
 }

 // accesseurs
 public Color getCouleurTrait() { return couleurTrait; }
 public void  setCouleurTrait(Color c) { couleurTrait=c; }
 public Color getCouleurFond() { return couleurFond; }
 public void  setCouleurFond(Color c) { couleurFond=c; }
 public int   getDeltaHorizon() { return deltaHorizon; }
 public void  setDeltaHorizon(int d) { deltaHorizon=d; }
 public int   getW() { return w; }
 public void  setW(int w) { this.w=w; setSize(w, getHeight()); }
 public int   getH() { return h; }
 public void  setH(int h) { this.h=h; setSize(getWidth(),h); }
 public int   getX() { return x; }
 public void  setX(int x) { this.x=x; setLocation(x, getLocation().y); }
 /*
 public int   getY() { return y; }
 public void  setY(int y) { this.y=y; setLocation(getLocation().x, y); }
 */

 // redéfinition d'une méthode héritée de JPanel
 protected void paintComponent(Graphics g) {
   super.paintComponent(g);
   dessineToi(g);
 }

 // redéfinition d'une méthode héritée de Object (un ancetre de JPanel)
 public String toString(){
   return "["+this.getClass().getName() + "]\t  x: "+ this.getX() + " y:" 
         + this.getY() + " w:"+this.getWidth()+ "  h:"+this.getHeight();
 }

 // méthodes spécifiques à cette classe
 public void placeToi(int horizon) {
   this.setLocation(this.getX(), horizon-this.getHeight()-deltaHorizon);
 }

 // à redéfinir par les classes descendantes
 abstract protected void dessineToi(Graphics g);
 
}
