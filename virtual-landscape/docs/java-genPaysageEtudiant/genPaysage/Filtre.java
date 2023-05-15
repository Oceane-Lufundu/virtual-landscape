/**
 Projet     : G�n�rateur de paysages virtuels
 Source     : Exemple tir� du JDK et all�g�
              pour repondre � mes besoin
 Modifi� par: Templier Fran�ois
              IG12
 Date       : 02/jan/2003
 Public     : BTS IG 1�re ann�e

 Objectif   : Cr�ation d'un filtre lors de
              la sauvegarde/restauration
 */

package genPaysage;

import java.io.File;
import java.util.Hashtable;
import javax.swing.*;
import javax.swing.filechooser.*;

public class Filtre extends FileFilter {
  
  // attributs
  private Hashtable filters = null;
  private String description = null;
  private String fullDescription = null;
  
  // constructeur par defaut
  public Filtre() {
    this.filters = new Hashtable();
  }
  
  // constructeur
  public Filtre(String extension, String description) {
    this();
    addExtension(extension);
    setDescription(description);
  }
  
  public boolean accept(File f) {
    if(f != null) {
      if(f.isDirectory()) {
        return true;
      }
      String extension = getExtension(f);
      if(extension != null && filters.get(getExtension(f)) != null) {
        return true;
      };
    }
    return false;
  }
    
  public String getExtension(File f) {
    if(f != null) {
      String filename = f.getName();
      int i = filename.lastIndexOf('.');
      if(i>0 && i<filename.length()-1) {
        return filename.substring(i+1).toLowerCase();
      };
    }
    return null;
  }
    
  public void addExtension(String extension) {
    filters.put(extension.toLowerCase(), this);
  }
    
  public String getDescription() {
    fullDescription = description;
    return fullDescription;
  }
    
  public void setDescription(String description) {
    this.description = description;
  }
}