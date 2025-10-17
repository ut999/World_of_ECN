/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package org.centrale.objet.WoE;

/**
 * Objet potion de soin pouvant rendre de la vie aux créatures
 * @author utaab
 */
public class PotionSoin extends Objet implements Utilisable {
    
    private int bonusPtVie;
    
    /**
     *
     */
    public PotionSoin() {
        super();
        this.bonusPtVie = 1;
    }
    
    /**
     *
     * @param p
     */
    public PotionSoin(PotionSoin p) {
        super(p);
        this.bonusPtVie = p.bonusPtVie;
    }

    /**
     *
     * @param pos
     * @param ptSoin
     * @param duree
     */
    public PotionSoin(Point2D pos, int bonusPtVie) {
        super(pos);
        this.bonusPtVie = bonusPtVie;
    }

    /**
     *
     * @return
     */
    public int getBonusPtVie() {
        return bonusPtVie;
    }

    /**
     *
     * @param ptSoin
     */
    public void setBonusPtVie(int bonusPtVie) {
        this.bonusPtVie = bonusPtVie;
    }

    /**
     *
     */
    @Override
    public void affiche() {
        System.out.println("\nAffichage d'une potion");
        System.out.println("ptSoin = " + bonusPtVie);
        super.affiche();
    }
    
    @Override
    public void utiliser(Creature c) {
        c.setPtVie(c.getPtVie() + this.bonusPtVie);
    }
    
    @Override
    public int getDuree() {
        return 1;
    }
    
    @Override
    public boolean finDuree() {
        return true;
    }
    
    @Override
    public void finEffet(Creature c) {
    }
    
    @Override
    public void afficheInventaire() {
        System.out.println("Potion soin");
        System.out.println("Gagne des points de vie : " + this.bonusPtVie);
    }
    
    @Override
    public void display() {
        System.out.print("H");
    }
}