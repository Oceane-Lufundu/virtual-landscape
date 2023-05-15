/**
 Projet      : G�n�rateur de paysages virtuels
 R�alis� par : Templier Fran�ois
               IG12
               Lyc�e L�onard de Vinci
               77000 Melun
 Date        : 30/dec/2002
 Public      : BTS IG 1�re ann�e

 Objectif    : Repr�sente un "objet terrestre"
*/

package genPaysage;

import javax.swing.*;
import java.awt.*;

public class ObjetTerrestre extends ObjetDessin {
  
  // attributs
  private int tailleCont;
  
  // accesseurs
  public int     getTailleCont ()               { return tailleCont;          }
  public void    setTailleCont (int tailleCont) { this.tailleCont=tailleCont; }
  
  // constructeur par defaut
  public ObjetTerrestre(){
    super();
  }
  
  // constructeur
  public ObjetTerrestre(int x, int y, int tailleCont, Color coTrait, Color coFond, int deltaHorizon){
    super(coTrait, coFond, deltaHorizon);
    this.tailleCont = tailleCont;
    setBackground(coFond);
    setBounds(x, y, tailleCont/2, tailleCont);
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
    g.fillRect(20,25,10,75);
    g.setColor(Color.GREEN);
    g.fillOval(5,40,25,25);
    g.fillOval(20,40,25,25);
    g.fillOval(12,25,26,26);
    g.fillOval(25,25,25,25);
    g.fillOval(0,25,25,25);
    g.fillOval(12,15,26,26);
  }
}