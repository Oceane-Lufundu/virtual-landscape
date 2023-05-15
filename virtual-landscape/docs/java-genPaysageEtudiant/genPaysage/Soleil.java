/**
 Projet      : G�n�rateur de paysages virtuels
 R�alis� par : Templier Fran�ois
               IG12
               Lyc�e L�onard de Vinci
               77000 Melun
 Date        : 29/dec/2002
 Public      : BTS IG 1�re ann�e

 Objectif    : Repr�sente un "soleil"
*/

package genPaysage;

import javax.swing.*;
import java.awt.*;
import java.util.*;
import java.math.*;

public class Soleil extends ObjetDessin {
  
  // attributs
  private int diametre;
  private Vector sommets;
  
  // accesseurs
  public int     getDiametre ()             { return diametre;        }
  public void    setDiametre (int diametre) { this.diametre=diametre; }
  public Vector  getSommets()               { return sommets;         }
  public void    setSommets(Vector v)       { sommets=v;              }
  
  // constructeur par defaut
  public Soleil(){
    super();
  }
  
  // constructeur
  public Soleil(int x, int y, int diametre, int nbSommets,
                Color coTrait, Color coFond, int deltaHorizon){
    super(coTrait, coFond, deltaHorizon);
    this.diametre = diametre;
    this.sommets = new Vector(nbSommets);
    double angle=0;
    double x1,y1;
    double ox, oy; // origine
    ox= diametre;
    oy= diametre;
    for (int i=0; i<nbSommets; i++) {
      x1=ox+Math.cos(angle)*diametre;
      y1=oy+Math.sin(angle)*diametre;
      sommets.add(new Point((int)Math.round(x1),(int)Math.round(y1)));  
      angle+=((2*Math.PI)/nbSommets); 
    }
    setBackground(coFond);
    setBounds(x, y, diametre*2, diametre*2);
  }
  
  // red�finition d'une m�thode h�rit�e de JPanel
  public void setBounds(int x, int y, int w, int h) {
   super.setBounds(x, y, w, h);
   this.w=w;
   this.h=h;
   this.x=x;
  }
  
  // donne corps � la m�thode abstraite h�rit�e de ObjetDessin
  protected void dessineToi(Graphics g) {
    g.setColor(couleurTrait);
    Point p1;
    g.fillOval(50, 50, diametre, diametre);
    
    for (int i=0; i<sommets.size(); i++){ 
      p1=(Point) sommets.get(i);
      g.drawLine(50+diametre/2,50+diametre/2,p1.x,p1.y);
    }
    
  }
}