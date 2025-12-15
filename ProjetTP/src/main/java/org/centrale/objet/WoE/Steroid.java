/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package org.centrale.objet.WoE;

/**
 *
 * @author utaab
 */
public class Steroid extends Nourriture {
    
    private int bonusDegAtt;
    private int malusPtVie;

    public Steroid() {
        super();
        this.bonusDegAtt = 3;
        this.malusPtVie = -1;
    }

    public Steroid(Steroid s) {
        super(s);
        this.bonusDegAtt = s.bonusDegAtt;
        this.malusPtVie = s.malusPtVie;
    }

    public Steroid(Point2D pos, int duree, int bonusDegAtt, int malusPtVie) {
        super(pos, duree);
        this.bonusDegAtt = bonusDegAtt;
        this.malusPtVie = malusPtVie;
    }

    public int getBonusDegAtt() {
        return bonusDegAtt;
    }

    public void setBonusDegAtt(int bonusDegAtt) {
        this.bonusDegAtt = bonusDegAtt;
    }   

    public int getMalusPtVie() {
        return malusPtVie;
    }

    public void setMalusPtVie(int malusPtVie) {
        this.malusPtVie = malusPtVie;
    }
    
    @Override
    public void utiliser(Creature c) {
        c.setDegAtt(c.getDegAtt() + this.bonusDegAtt);
        c.setPtVie(c.getPtVie() + this.malusPtVie);
    }
    
    @Override
    public void finEffet(Creature c) {
        c.setDegAtt(c.getDegAtt() - this.bonusDegAtt);
        c.setPtVie(c.getPtVie() - this.malusPtVie);
    }
    
    @Override
    public void afficheInventaire() {
        System.out.println("Steroid (S)");
        System.out.println("bonus de point d'attaque : " + this.bonusDegAtt);
        System.out.println("malus de point vie : " + this.malusPtVie);
        System.out.println("duree : " + super.getDuree() + " tour");
    }
    
    @Override
    public void display() {
        System.out.print("S");
    }
}
