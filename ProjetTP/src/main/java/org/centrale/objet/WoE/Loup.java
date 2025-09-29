/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package org.centrale.objet.WoE;

import java.util.Random;

/**
 * Représente un monstre loup
 * @author utaab
 */
public class Loup extends Monstre {
    
    /**
     *
     */
    public Loup() {
        super();
    }
    
    /**
     *
     * @param l
     */
    public Loup(Loup l) {
        super(l);
    }

    /**
     *
     * @param ptVie
     * @param degAtt
     * @param ptPar
     * @param pageAtt
     * @param pagePar
     * @param pos
     */
    public Loup(int ptVie, int degAtt, int ptPar, int pageAtt, int pagePar, Point2D pos) {
        super(ptVie, degAtt, ptPar, pageAtt, pagePar, pos);
    }
    
     /**
     * permet de combattre une creature 
     * il frappe au corps à corps si il est à une distance de 1 de la cible
     * il rate son attaque si la cible est en dehors de sa portée
     * 
     * Si son attaque est possible il va effectuer un jet pour savoir si il touche son attaque
     * la cible est capable de parer une partie des dégâts de l'attaque si elle réussit un jet
     * 
     * @param c cible de l'attaque de l'archer
     */
    public void combattre(Creature c){
        Point2D positionCible = c.getPos();
        
        int distanceCible = Math.round(this.getPos().distance(positionCible)+0.499f); //we round the distance to the upper int
        
        //attaque melee
        if(distanceCible <=1)
        {
            System.out.println("Attaque melee du loup");
            
            Random generateur = new Random();
            int jetAttaquant = generateur.nextInt(1, 101);
            
            System.out.println("jet de l'attaquant : " + jetAttaquant);
            System.out.println("jet maximal pour reussir l'attaque : " + this.getPageAtt());
            
            if(jetAttaquant > this.getPageAtt())
            {
                System.out.println("Le loup a rate son attaque");
                return;
            }
            
            System.out.println("Le loup a reussit son attaque");

            int jetDefenseur = generateur.nextInt(1, 101);

            System.out.println("jet du defenseur : " + jetDefenseur);
            System.out.println("jet maximal pour reussir la defense : " + c.getPagePar());

            boolean paradeReussit = jetDefenseur<=c.getPagePar();
            int degatSubit = this.getDegAtt() - (paradeReussit?c.getPtPar():0);
            int nouveauxHP = Math.max(c.getPtVie()-degatSubit, 0);
            
            System.out.println("La cible a " + (paradeReussit?"reussit":"rate") + " sa parade "+
                    (paradeReussit?"ce qui reduit les degats subis de "+ c.getPtPar() + " degats":"")
                    + " et a subit " + degatSubit + " degats");
            System.out.println("La cible avait " + c.getPtVie() + " hp et possede maintenant " + nouveauxHP + " hp");

            c.setPtVie(nouveauxHP);   
            
        }

        else
        {
            System.out.println("Le loup n'est pas a portee de cible de sa cible");
        }
    }

    /**
     *
     */
    @Override
    public void affiche() {
        System.out.println("\nAffichage du loup");
        super.affiche();
    }
}
