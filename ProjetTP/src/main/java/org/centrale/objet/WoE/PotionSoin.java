/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package org.centrale.objet.WoE;

/**
 * Objet potion de soin pouvant rendre de la vie aux créatures
 * @author utaab
 */
public class PotionSoin extends Objet {
    
    private int ptSoin;
    
    /**
     *
     */
    public PotionSoin() {
        super();
        this.ptSoin = 1;
    }
    
    /**
     *
     * @param p
     */
    public PotionSoin(PotionSoin p) {
        super(p);
        this.ptSoin = p.ptSoin;
    }

    /**
     *
     * @param pos
     * @param ptSoin
     */
    public PotionSoin(Point2D pos, int ptSoin) {
        super(pos);
        this.ptSoin = ptSoin;
    }

    /**
     *
     * @return
     */
    public int getPtSoin() {
        return ptSoin;
    }

    /**
     *
     * @param ptSoin
     */
    public void setPtSoin(int ptSoin) {
        this.ptSoin = ptSoin;
    }
    
    /**
     *
     */
    @Override
    public void affiche() {
        System.out.println("\nAffichage d'une potion");
        System.out.println("ptSoin = " + ptSoin);
        super.affiche();
    }
}