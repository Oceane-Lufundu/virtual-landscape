/**
 Projet     : G�n�rateur de paysages virtuels
 Initiateur : Olivier Capuozzo
              Lyc�e L�onard de Vinci
              77000 Melun
 Date       : 17/dec/2002
 Public     : BTS IG 1�re ann�e

 Objectif   : Un g�n�rateur de positionnement (layout) pour les objets de type "ObjetDessin"
*/


package genPaysage;

import java.awt.*;

public class PaysageLayout implements LayoutManager  {


  public void layoutContainer(Container parent) {
    // appel�e par Swing pour g�rer le positionnement de tous
    // les composants du conteneur pass� en param�tre.
    Component[] composants =  parent.getComponents();
    int nbCompo= composants.length;
    Component compo;
    
    // affiche en premier les �l�ments d'arri�re plan
    // (une technique appel�e "algorithme du peintre"
    for (int i=0; i<nbCompo; i++) {
      compo = composants[i];
      if (compo instanceof Soleil) {
        ((ObjetDessin) compo).placeToi(parent.getHeight());
        //System.out.println(compo);
      }  
    }
    for (int i=0; i<nbCompo; i++) {
      compo = composants[i];
      if (compo instanceof Planete) {
        ((ObjetDessin) compo).placeToi(parent.getHeight());
        //System.out.println(compo);
      }  
    }
    for (int i=0; i<nbCompo; i++) {
      compo = composants[i];
      if (compo instanceof Immeuble) {
        ((ObjetDessin) compo).placeToi(parent.getHeight());
        //System.out.println(compo);
      }  
    }
    for (int i=0; i<nbCompo; i++) {
     compo = composants[i];
     if (compo instanceof ObjetTerrestre) {
        ((ObjetDessin) compo).placeToi(parent.getHeight());
        //System.out.println(compo);
      }  
    }
  }

  public void addLayoutComponent(String name, Component comp) {
    // Appel�e lors d'ajout d'un composant associ� � un nom.  
    // Ne fait rien.
  }

  public Dimension minimumLayoutSize(Container parent) {
    // Determine la taille minimum du conteneur (nomm� parent)
    return parent.getSize();
  }

  public  Dimension preferredLayoutSize(Container parent) {
    // Determine la taille souhait�e du conteneur (nomm� parent)
    return parent.getSize();
  }

  public void removeLayoutComponent(Component comp) {
    // Appel�e lorsque le copposant sp�cifi� est enlev�.
    // Rien � faire.
  }
 
}
