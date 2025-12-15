/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package org.centrale.objet.WoE;

/**
 *  Représente un paysan, hérite de personnage
 * @author Clément
 */
public class Paysan extends Personnage {

    /**
     *
     */
    public Paysan() {
        super();
    }

    /**
     *
     * @param p
     */
    public Paysan(Paysan p) {
        super(p);
    }

    /**
     *
     * @param nom
     * @param ptVie
     * @param degAtt
     * @param ptPar
     * @param pageAtt
     * @param distAttMax
     * @param pagePer
     * @param pos
     */
    public Paysan(String nom, int ptVie, int degAtt, int ptPar, int pageAtt, int distAttMax, int pagePer, Point2D pos) {
        super(nom, ptVie, degAtt, ptPar, pageAtt, distAttMax, pagePer, pos);
    }
    
    /**
     *
     */
    @Override
    public void affiche() {
        System.out.println("Paysan (P)");
        super.affiche();
    }
    
    @Override
    public void display() {
        System.out.print("F");
    }
}
