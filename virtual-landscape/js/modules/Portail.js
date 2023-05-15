import { AbstractForm } from './AbstractForm.js';

/**
 * Déssine un triangle
 */
export class Portail extends AbstractForm {
  // add default values to avoid errors on empty arguments
  constructor(
    x = 0,
    y = 0,
    width = 0,
    height = 0,
    fillColor = '',
    strokeColor = '',
    strokeWidth = 2,
    pesenteur = false,
    ordreConstruction = 2
  ) {
    super(x, y, width, height, fillColor, strokeColor, strokeWidth, pesenteur, ordreConstruction)
  }


  /**
   * Dessine la forme spécifique à cette classe
   * @param ctx contexte 2D du canvas
   */

draw(ctx){
 
//Création de dégrader
var gradient1 = ctx.createRadialGradient(790, 390, 0, 790, 390, 479);
gradient1.addColorStop(1, '#651FFF');//couleur n1 (le grand cercle)
gradient1.addColorStop(0.5, '#FF00FF'); // couleur n2 
gradient1.addColorStop(0.4, '#66FFFF');// couleur n3 du millieu

ctx.beginPath()
ctx.strokeStyle= this.StrokeColor
ctx.fillStyle= this.fillColor
ctx.fillStyle = gradient1; // application du dégrader
ctx.arc(790, 390, 479, 0, 2 * Math.PI);// position du cercle
ctx.fill();
ctx.closePath();
}

  /**
   * get array of forms
   * @return {[Portail,...]}
   */
  static buildForms() {
    // create a new rectangle object using the Immeuble class
    const myportail = new Portail(0, 10, 0, 0, '', '', 2, false)
    let forms = [myportail]
  
    // retourne un tableau d'objets de type Triangle
    return forms
  }

}
