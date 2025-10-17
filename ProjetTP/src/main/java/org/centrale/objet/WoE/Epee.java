/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package org.centrale.objet.WoE;
import java.util.Random;

/**
 *  Représente un objet épée
 * @author utaab
 */
public class Epee extends Objet implements Utilisable {

    /**
     *
     */
    private int bonusDegAtt;
    private int duree;
    
    /**
     *
     */
    public Epee() {
        super();
        Random generateur = new Random();
        this.bonusDegAtt = (generateur.nextInt(0,101) > 90 ? 100 : 2);
        this.duree = 30;
    }
    
    /**
     *
     * @param e
     */
    public Epee(Epee e) {
        super(e);
        this.bonusDegAtt = e.bonusDegAtt;
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
        this.bonusDegAtt = degAtt;
        this.duree = duree;
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
        return duree;
    }

    public void setdDurabilite(int duree) {
        this.duree = duree;
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
    public void afficheInventaire() {
        System.out.println("Epee (E)");
        System.out.println("bonus sur le point d'attaque : " + this.bonusDegAtt);
        System.out.println("duree : " + this.duree + " tour");
    }
    
    @Override
    public void utiliser(Creature c) {
        c.setDegAtt(c.getDegAtt() + this.bonusDegAtt);
    }
    
    @Override
    public int getDuree() {
        return this.duree;
    }
    
    @Override
    public boolean finDuree() {
        this.duree--;
        return (this.duree == 0);
    }
    
    @Override
    public void finEffet(Creature c) {
        c.setDegAtt(c.getDegAtt() - this.bonusDegAtt);
    }

    @Override
    public void display() {
        System.out.print("E");
    }
}
