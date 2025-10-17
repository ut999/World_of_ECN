/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package org.centrale.objet.WoE;

/**
 *
 * @author utaab
 */
public class NuageToxique extends Objet implements Deplacable, Combattant {
    /**
     *
     */
    private int degAtt;
    
    /**
     *
     */
    public NuageToxique() {
        super();
        this.degAtt = 5;
    }
    
    /**
     *
     * @param n
     */
    public NuageToxique(NuageToxique n) {
        super(n);
        this.degAtt = n.degAtt;
    }

    /**
     *
     * @param pos
     * @param degAtt
     */
    public NuageToxique(Point2D pos, int degAtt) {
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
        System.out.println("\nAffichage d'un nuage toxique");
        super.affiche();
    }
    
    /**
     * 
     */
    @Override
    public void deplacer() {
    }
    
    /**
     * 
     * @param c
     */
    @Override
    public void combattre(Creature c) {
    }
    
    @Override
    public void display() {
        System.out.print("N");
    }

    @Override
    public int getDistAttMax() {
        return 0; //un nuage toxique n'attaque que sur sa case actuelle est a donc une attaque avec une porte de 0
    }
}
