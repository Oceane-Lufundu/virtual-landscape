import { AbstractForm } from './AbstractForm.js';

/**
 * Déssine un triangle
 */
export class Neige extends AbstractForm {
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
    ordreConstruction = 50
  ) {
    super(x, y, width, height, fillColor, strokeColor, strokeWidth, pesenteur, ordreConstruction)
  }


  /**
   * Dessine la forme spécifique à cette classe
   * @param ctx contexte 2D du canvas
   */

    draw(ctx){
// Boule de Neige 1 Gauche
ctx.fillStyle = 'white'; //Couleur
ctx.beginPath();
ctx.arc(50, 725, 100, 0, 2 * Math.PI); // Emplacement de la neige
ctx.fill();
ctx.closePath();

// Boule de Neige 2
ctx.fillStyle = 'white'; //Couleur
ctx.beginPath();
ctx.arc(150, 765, 55, 0, 2 * Math.PI); // Emplacement de la neige
ctx.fill();
ctx.closePath();

// Boule de Neige 3
ctx.fillStyle = 'white'; //Couleur
ctx.beginPath();
ctx.arc(250, 755, 75, 0, 2 * Math.PI); // Emplacement de la neige
ctx.fill();
ctx.closePath();

// Boule de Neige 4
ctx.fillStyle = 'white'; //Couleur
ctx.beginPath();
ctx.arc(390, 755, 85, 0, 2 * Math.PI); // Emplacement de la neige
ctx.fill();
ctx.closePath();

// Boule de Neige 5
ctx.fillStyle = 'white'; //Couleur          
ctx.beginPath();
ctx.arc(510, 725, 100, 0, 2 * Math.PI); // Emplacement de la neige
ctx.fill();
ctx.closePath();

// Boule de Neige 6
ctx.fillStyle = 'white'; //Couleur
ctx.beginPath();
ctx.arc(677, 785, 100, 0, 2 * Math.PI); // Emplacement de la neige
ctx.fill();
ctx.closePath();

// Boule de Neige 7
ctx.fillStyle = 'white'; //Couleur
ctx.beginPath();
ctx.arc(890, 775, 155, 0, 2 * Math.PI); // Emplacement de la neige
ctx.fill();
ctx.closePath();

// Boule de Neige 8
ctx.fillStyle = 'white'; //Couleur
ctx.beginPath();
ctx.arc(1190, 765, 250, 0, 2 * Math.PI); // Emplacement de la neige
ctx.fill();
ctx.closePath();

// Boule de Neige 9 Droite
ctx.fillStyle = 'white'; //Couleur
ctx.beginPath();
ctx.arc(1400, 725, 150, 0, 2 * Math.PI); // Emplacement de la neige
ctx.fill();
ctx.closePath();
}

  /**
   * get array of forms
   * @return {[Neige,...]}
   */
  static buildForms() {
    // create a new rectangle object using the Immeuble class
    const myTriangle = new Neige(250, 70, 100, 100, 'gold', '', 2, true)
    let max = ~~(Math.random() * 5) + 5 // max in [5..10]
    let forms = []
    for (let i = 0; i < max; i++) {
      forms.push(
        new Neige(
          ~~(Math.random() * 3 * myTriangle.x + 50),
          ~~(Math.random() * myTriangle.y),
          ~~(Math.random() * 3 * myTriangle.width + 10),
          ~~(Math.random() * myTriangle.height + 10),
          myTriangle.fillColor,
          myTriangle.strokeColor,
          '',
          i % 2 === 0 // pesenteur une fois sur 2
        )
      )
    }
    // retourne un tableau d'objets de type Triangle
    return forms
  }

}
