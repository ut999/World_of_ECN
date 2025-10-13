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
    private int bonusDegAtt;
    private int durabilite;
    
    /**
     *
     */
    public Epee() {
        super();
        this.bonusDegAtt = 5;
        this.durabilite = 20;
    }
    
    /**
     *
     * @param e
     */
    public Epee(Epee e) {
        super(e);
        this.bonusDegAtt = e.bonusDegAtt;
        this.durabilite = e.durabilite;
    }

    /**
     *
     * @param pos
     * @param degAtt
     * @param duree
     */
    public Epee(Point2D pos, int degAtt, int duree) {
        super(pos);
        this.bonusDegAtt = degAtt;
        this.durabilite = duree;
    }

    /**
     *
     * @return
     */
    public int getBonusDegAtt() {
        return bonusDegAtt;
    }

    /**
     *
     * @param degAtt
     */
    public void setBonusDegAtt(int degAtt) {
        this.bonusDegAtt = degAtt;
    }

    public int getDurabilite() {
        return durabilite;
    }

    public void setdDurabilite(int duree) {
        this.durabilite = duree;
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
        c.setDegAtt(c.getDegAtt() + this.bonusDegAtt);
    }
    
    @Override
    public int getDuree() {
        return this.durabilite;
    }
    
    @Override
    public boolean finDuree() {
        //decrementer a chaque combat qu lieu de chaque tour
        return (this.durabilite == 0);
    }
    
    @Override
    public void finEffet(Creature c) {
        c.setDegAtt(c.getDegAtt() - this.bonusDegAtt);
    }
}
