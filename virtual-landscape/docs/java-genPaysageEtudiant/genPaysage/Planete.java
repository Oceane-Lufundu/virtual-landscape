/**
 Projet     : Générateur de paysages virtuels
 Initiateur : Olivier Capuozzo
              Lycée Léonard de Vinci
              77000 Melun
 Date       : 17/dec/2002
 Public     : BTS IG 1ère année

 Objectif   : Représente une "planète"
*/

package genPaysage;

import javax.swing.*;
import java.awt.*;
import java.util.*;
import java.math.*;

public class Planete extends ObjetDessin {
 private int rayon;
 private Vector sommets;

 // accesseurs
 public int     getRayon()           { return rayon; }
 public void    setRayon(int r)      { rayon=r; }
 public Vector  getSommets()         { return sommets; }
 public void    setSommets(Vector v) { sommets=v; }
 
 //constructeurs
 public Planete() { super(); } 
 
 public Planete(int x, int y, int rayon, int nbSommets, 
                Color coTrait, Color coFond, int deltaHorizon){
   super(coTrait, coFond, deltaHorizon);
   this.rayon = rayon;
   this.sommets = new Vector(nbSommets);
   double angle=0;
   double x1,y1;
   double ox, oy; // origine
   ox= rayon;
   oy= rayon;
   for (int i=0; i<nbSommets; i++) {
     x1=ox+Math.cos(angle)*rayon;
     y1=oy+Math.sin(angle)*rayon;
     sommets.add(new Point((int)Math.round(x1),(int)Math.round(y1)));  
     angle+=((2*Math.PI)/nbSommets); 
   }
   setBackground(coFond);
   setBounds(x, y, rayon*2+1, rayon*2+1);
 }
 
 // redéfinition d'une méthode héritée de JPanel
 public void setBounds(int x, int y, int w, int h) {
   super.setBounds(x, y, w, h);
   this.w=w;
   this.h=h;
   this.x=x;
 }
 
 // donne corps à la méthode abstraite héritée de ObjetDessin
 protected void dessineToi(Graphics g) {
   g.setColor(couleurTrait);
   Point p1, p2;
   // dessine le polygone
   /*
   Point p1 = (Point) sommets.get(0);
   Point p2;
   for (int i=1; i<sommets.size(); i++) {
     p2=(Point) sommets.get(i);
     g.drawLine(p1.x,p1.y, p2.x,p2.y);
     p1=p2;
   }  
   p2 = (Point) sommets.get(0);
   g.drawLine(p1.x,p1.y, p2.x,p2.y);
  */
  
   // trace les rayons.
   for (int i=0; i<sommets.size(); i++){ 
     p1=(Point) sommets.get(i);
     for (int j=i+1; j<sommets.size(); j++) 
     {
        p2=(Point) sommets.get(j);
        g.drawLine(p1.x,p1.y, p2.x,p2.y);
     } 
   }  
 }// dessineToi
 
}// Planete
