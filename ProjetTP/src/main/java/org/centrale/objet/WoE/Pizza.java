/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package org.centrale.objet.WoE;

/**
 *
 * @author utaab
 */
public class Pizza extends Nourriture {
    
    private int bonusPageAtt;

    public Pizza() {
        super();
        this.bonusPageAtt = 50;
    }

    public Pizza(int bonusPageAtt, Nourriture n) {
        super(n);
        this.bonusPageAtt = bonusPageAtt;
    }

    public Pizza(int bonusPageAtt, Point2D pos, int duree) {
        super(pos, duree);
        this.bonusPageAtt = bonusPageAtt;
    }

    public int getBonusPageAtt() {
        return bonusPageAtt;
    }

    public void setBonusPageAtt(int bonusPageAtt) {
        this.bonusPageAtt = bonusPageAtt;
    }
    
    @Override
    public void utiliser(Creature c) {
        c.setPageAtt(c.getPageAtt() + this.bonusPageAtt);
    }
    
    @Override
    public void finEffet(Creature c) {
        c.setPageAtt(c.getPageAtt() - this.bonusPageAtt);
    }
    
    @Override
    public void afficheInventaire() {
        System.out.println("Pizza (P)");
        System.out.println("bonus sur le pourcentage de reussite d'une attaque : " + this.bonusPageAtt);
        System.out.println("duree : " + super.getDuree() + " tour");
    }
    
    @Override
    public void display() {
        System.out.print("P");
    }
}
