/**
 Projet     : G�n�rateur de paysages virtuels
 Initiateur : Olivier Capuozzo
              Lyc�e L�onard de Vinci
              77000 Melun
 Date       : 17/dec/2002
 Public     : BTS IG 1�re ann�e

 Objectif   : Repr�sente un "immeuble"
*/



package genPaysage;

import javax.swing.*;
import java.awt.*;

public class Immeuble extends ObjetDessin {
 private int nbEtages;
 private int nbFenParEtag;

 // constructeurs
 public Immeuble( ) { super(); }

 public Immeuble(int x, int w, int h, int nbEtages, 
                 int nbFenParEtag, Color coTrait, Color coFond ){
   super(coTrait, coFond, 0);
   // attributs sp�cifiques
   this.nbEtages = nbEtages;
   this.nbFenParEtag=nbFenParEtag;
   int ecart = (int) Math.round(h/(double) nbEtages);
   this.h=ecart*nbEtages +1;

   ecart = (int) Math.round(w/ (double) nbFenParEtag);
   this.w=ecart*nbFenParEtag +1;

   // affecte les propri�t�s x, y, width et height de l'objet (un panel)
   setBounds(x, 0, this.w, this.h);
 
 } 
 
 // red�finition d'une m�thode h�rit�e de JPanel
 public void setBounds(int x, int y, int w, int h) {
   super.setBounds(x, y, w, h);
   this.x=x;   
 }
 
 // accesseur
 public int getNbEtages() { return nbEtages; }
 public void setNbEtages(int v) { nbEtages=v; }
 
 public int getNbFenParEtag() { return nbFenParEtag; }
 public void setNbFenParEtag(int v) { nbFenParEtag=v; }
 
 // donne corps � la m�thode abstraite h�rit�e de ObjetDessin
 protected void dessineToi(Graphics g) {
   g.setColor(couleurTrait);
   g.fillRect(0,0,this.getWidth()-1,this.getHeight()-1);
   g.setColor(Color.black);
   g.drawRect(0,0,this.getWidth()-1,this.getHeight()-1);
   
   int ecart = (int) Math.round((getHeight()-1)/(double) nbEtages);
   
   for (int i=1; i<nbEtages; i++) {
     g.drawLine(0,i*ecart,this.getWidth()-1,i*ecart);
   }  
   
   ecart = (int) Math.round((getWidth()-1)/ (double) nbFenParEtag);
   for (int i=1; i<nbFenParEtag; i++) {
     g.drawLine(i*ecart,0,i*ecart,getHeight()-1);
   }  
   //System.out.println("w:"+this.getWidth()+ "  h:"+this.getHeight());
 }

 // red�finition
 public String toString(){
   return super.toString() + " etages:"+ nbEtages+ " fen:"+nbFenParEtag;
 }

}
