/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package org.centrale.objet.WoE;

/**
 *  Représente un objet épée
 * @author utaab
 */
public class Epee extends Objet {

    /**
     *
     */
    public int degAtt;
    
    /**
     *
     */
    public Epee() {
        super();
        this.degAtt = 5;
    }
    
    /**
     *
     * @param e
     */
    public Epee(Epee e) {
        super(e);
        this.degAtt = e.degAtt;
    }

    /**
     *
     * @param pos
     * @param degAtt
     */
    public Epee(Point2D pos, int degAtt) {
        super(pos);
        this.degAtt = degAtt;
    }

    /**
     *
     * @return
     */
    public int getDegAtt() {
        return degAtt;
    }

    /**
     *
     * @param degAtt
     */
    public void setDegAtt(int degAtt) {
        this.degAtt = degAtt;
    }
    
    /**
     *
     */
    @Override
    public void affiche() {
        System.out.println("\nAffichage d'un epee");
        super.affiche();
    }
}
