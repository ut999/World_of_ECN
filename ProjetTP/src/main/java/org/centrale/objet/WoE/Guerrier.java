/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package org.centrale.objet.WoE;

/**
 *
 * @author utaab
 */
public class Guerrier extends Personnage {
    
    public Guerrier() {
        super();
    }

    public Guerrier(Paysan p) {
        super(p);
    }

    public Guerrier(String nom, int ptVie, int degAtt, int ptPar, int pageAtt, int distAttMax, Point2D pos) {
        super(nom, ptVie, degAtt, ptPar, pageAtt, distAttMax, pos);
    }
    
    public void combattre(Creature c){
    }
}
