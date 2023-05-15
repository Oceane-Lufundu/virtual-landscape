import { AbstractForm } from './AbstractForm.js';

/**
 * Déssine un triangle
 */
export class Maison extends AbstractForm {
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
    ordreConstruction = 100
  ) {
    super(x, y, width, height, fillColor, strokeColor, strokeWidth, pesenteur, ordreConstruction)
  }


  /**
   * Dessine la forme spécifique à cette classe
   * @param ctx contexte 2D du canvas
   */

draw(ctx){
//création de dégrader toit et mur
var gradient = ctx.createLinearGradient(400, 450, 790, 400, 450, 0);
gradient.addColorStop(1, '#000099');
gradient.addColorStop(0, '#000066');

// Le mur avant 
ctx.fillStyle = gradient; // couleur du mur
ctx.fillRect(400, 450, 800, 300); // emplacement du mur

//toit de la maison
ctx.beginPath();
ctx.moveTo(790, 250);
ctx.lineTo(400, 450);
ctx.lineTo(400, 450);
ctx.lineTo(1200, 450);
ctx.lineTo(790, 250);
ctx.stroke()
ctx.fillStyle = gradient; // Couleur
ctx.fill();
ctx.closePath();



// La porte Principale
ctx.fillStyle = '#E65100'; // Couleur de la porte
ctx.fillRect(700, 610, 150, 140); // emplacement de la porte

// La fenêtre n1 Gauche 
ctx.fillStyle = '#651FFF';
ctx.beginPath();
ctx.fillRect(570, 600, 50, 70);
ctx.moveTo(595 - 25, 635);
ctx.lineTo(595 + 25, 635 );
ctx.strokeStyle = "#fff";
ctx.lineWidth = 2;
ctx.stroke();
ctx.fill()
ctx.closePath();

// La fenêtre n2 Gauche 
ctx.fillStyle = '#651FFF';
ctx.beginPath();
ctx.fillRect(470, 600, 50, 70);
ctx.moveTo(470 + 25, 600);
ctx.lineTo(470 + 25, 670 );
ctx.strokeStyle = "#fff";
ctx.lineWidth = 2;
ctx.stroke();
ctx.fill()
ctx.closePath();

// La fenêtre n2 Droite 
ctx.fillStyle = '#651FFF';
ctx.beginPath();
ctx.fillRect(990, 600, 50, 70);
ctx.moveTo(1015 - 25, 635);
ctx.lineTo(1015 + 25, 635 );
ctx.strokeStyle = "#fff";
ctx.lineWidth = 2;
ctx.stroke();
ctx.fill()
ctx.closePath();

// La fenêtre n1 Droite 
ctx.fillStyle = '#651FFF';
ctx.beginPath();
ctx.fillRect(890, 600, 50, 70);
ctx.moveTo(915 - 25, 635);
ctx.lineTo(915 + 25, 635 );
ctx.strokeStyle = "#fff";
ctx.lineWidth = 2;
ctx.stroke();
ctx.fill()
ctx.closePath();

//dégradé Fenêtre Ronde
var gradient4 = ctx.createRadialGradient(780, 500, 25, 780, 500, 35);
gradient4.addColorStop(0, '#66FFFF');
gradient4.addColorStop(1, '#0055FF');

//Fenêtre Ronde n4
ctx.fillStyle = gradient4;
ctx.beginPath();
ctx.arc(780, 500, 35, 0, 2 * Math.PI);
ctx.lineTo(745, 500 );
ctx.lineTo(745, 500 );
ctx.moveTo(780,500);
ctx.fill()
ctx.stroke()
ctx.closePath();
}

  /**
   * get array of forms
   * @return {[Maison,...]}
   */
  static buildForms() {
    // create a new rectangle object using the Immeuble class
    const myTriangle = new Maison(250, 70, 100, 100, 'gold', '', 2, true)
    let max = ~~(Math.random() * 5) + 5 // max in [5..10]
    let forms = []
    for (let i = 0; i < max; i++) {
      forms.push(
        new Maison(
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
