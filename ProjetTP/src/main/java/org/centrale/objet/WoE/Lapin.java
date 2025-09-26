/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package org.centrale.objet.WoE;

/**
 *
 * @author utaab
 */
public class Lapin extends Monstre {

    public Lapin() {
        super();
    }
    
    public Lapin(Lapin l) {
        super(l);
    }

    public Lapin(int ptVie, int degAtt, int ptPar, int pageAtt, int pagePar, Point2D pos) {
        super(ptVie, degAtt, ptPar, pageAtt, pagePar, pos);
    }
    
    @Override
    public void affiche() {
        System.out.println("\nAffichage du loup");
        super.affiche();
    }
}
