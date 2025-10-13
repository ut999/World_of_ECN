/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package org.centrale.objet.WoE;

/**
 *  Représente un objet épée
 * @author utaab
 */
public class Epee extends Objet implements Utilisable {

    /**
     *
     */
    private int degAtt;
    private int duree;
    
    /**
     *
     */
    public Epee() {
        super();
        this.degAtt = 5;
        this.duree = 30;
    }
    
    /**
     *
     * @param e
     */
    public Epee(Epee e) {
        super(e);
        this.degAtt = e.degAtt;
        this.duree = e.duree;
    }

    /**
     *
     * @param pos
     * @param degAtt
     * @param duree
     */
    public Epee(Point2D pos, int degAtt, int duree) {
        super(pos);
        this.degAtt = degAtt;
        this.duree = duree;
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
    
    @Override
    public void utiliser(Creature c) {
        
    }
}
