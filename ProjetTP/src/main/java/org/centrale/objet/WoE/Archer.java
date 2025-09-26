/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package org.centrale.objet.WoE;

/**
 *
 * @author Clément
 */
public class Archer extends Personnage {
    private int nbFleches;

    public Archer() {
        super();
        this.nbFleches = 10;
    }

    public Archer(Archer a) {
        super(a);
        this.nbFleches = a.nbFleches;
    }

    public Archer(int nbFleches, String nom, int ptVie, int degAtt, int ptPar, int pageAtt, int distAttMax, Point2D pos) {
        super(nom, ptVie, degAtt, ptPar, pageAtt, distAttMax, pos);
        this.nbFleches = nbFleches;
    }
    
    
}
