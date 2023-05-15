/**
 Projet     : Générateur de paysages virtuels
 Initiateur : Olivier Capuozzo
              Lycée Léonard de Vinci
              77000 Melun
 Date       : 17/dec/2002
 Public     : BTS IG 1ère année

 Objectif   : Un générateur de positionnement (layout) pour les objets de type "ObjetDessin"
*/


package genPaysage;

import java.awt.*;

public class PaysageLayout implements LayoutManager  {


  public void layoutContainer(Container parent) {
    // appelée par Swing pour gérer le positionnement de tous
    // les composants du conteneur passé en paramètre.
    Component[] composants =  parent.getComponents();
    int nbCompo= composants.length;
    Component compo;
    
    // affiche en premier les éléments d'arrière plan
    // (une technique appelée "algorithme du peintre"
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
    // Appelée lors d'ajout d'un composant associé à un nom.  
    // Ne fait rien.
  }

  public Dimension minimumLayoutSize(Container parent) {
    // Determine la taille minimum du conteneur (nommé parent)
    return parent.getSize();
  }

  public  Dimension preferredLayoutSize(Container parent) {
    // Determine la taille souhaitée du conteneur (nommé parent)
    return parent.getSize();
  }

  public void removeLayoutComponent(Component comp) {
    // Appelée lorsque le copposant spécifié est enlevé.
    // Rien à faire.
  }
 
}
