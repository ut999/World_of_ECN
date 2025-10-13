/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package org.centrale.objet.WoE;

import java.util.Random;

/**
 * Représente un archer qui hérite de Personnage
 * 
 * @author Clément
 */
public class Archer extends Personnage implements Combattant {
    
    private int nbFleches;

    /**
     *
     */
    public Archer() {
        super();
        this.nbFleches = 10;
    }

    /**
     * 
     * @param a
     */
    public Archer(Archer a) {
        super(a);
        this.nbFleches = a.nbFleches;
    }

    /**
     *
     * @param nbFleches
     * @param nom
     * @param ptVie
     * @param degAtt
     * @param ptPar
     * @param pageAtt
     * @param distAttMax
     * @param pagePar
     * @param pos
     */
    
    public Archer(int nbFleches, String nom, int ptVie, int degAtt, int ptPar, int pageAtt, int distAttMax, int pagePar, Point2D pos) {
        super(nom, ptVie, degAtt, ptPar, pageAtt, distAttMax, pagePar, pos);
        this.nbFleches = nbFleches;
    }

    /**
     *
     * @return
     */
    public int getNbFleches() {
        return nbFleches;
    }

    /**
     *
     * @param nbFleches
     */
    public void setNbFleches(int nbFleches) {
        this.nbFleches = nbFleches;
    }
    
    /**
     * permet a l'archer de combattre une creature 
     * il frappe au corps à corps si il est à une distance de 1 de la cible
     * il frappe à distance si il est à une distance supérieure à 1 mais inférieur ou égal à sa portée de la cible et qu'il a des flèches
     * il rate son attaque si la cible est en dehors de sa portée
     * 
     * Si son attaque est possible il va effectuer un jet pour savoir si il touche son attaque
     * Si il s'agit d'une attaque au corps à corps, la cible est capable de parer une partie des dégâts de l'attaque si elle réussit un jet
     * 
     * @param c cible de l'attaque de l'archer
     */
    @Override
    public void combattre(Creature c){
        Point2D positionCible = c.getPos();
        
        int distanceCible = Math.round(this.getPos().distance(positionCible)+0.499f); //we round the distance to the upper int
        
        //attaque melee
        if(distanceCible <=1)
        {
            System.out.println("Attaque melee de l'archer : " + this.getNom());
            
            Random generateur = new Random();
            int jetAttaquant = generateur.nextInt(1, 101);
            
            System.out.println("jet de l'attaquant : " + jetAttaquant);
            System.out.println("jet maximal pour reussir l'attaque : " + this.getPageAtt());
            
            if(jetAttaquant > this.getPageAtt())
            {
                System.out.println("L'archer " + this.getNom() + " a rate son attaque");
                return;
            }
            
            System.out.println("L'archer " + this.getNom() + " a reussit son attaque");

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
        else if(distanceCible <= this.getDistAttMax())
        {
            if(nbFleches <= 0)
            {
                System.out.println("L'archer " + this.getNom() + " n'a plus de projectiles");
                return;
            }
            nbFleches--;
            //attaque distance
            System.out.println("Attaque distance de l'archer : " + this.getNom() + ", il lui reste " + nbFleches + " fleches");
            
            Random generateur = new Random();
            int jetAttaquant = generateur.nextInt(1, 101);
            
            System.out.println("jet de l'attaquant : " + jetAttaquant);
            System.out.println("jet maximal pour reussir l'attaque : " + this.getPageAtt());
            
            if(jetAttaquant > this.getPageAtt())
            {
                System.out.println("L'archer " + this.getNom() + "a rate son attaque");
                return;
            }
            
            System.out.println("L'archer " + this.getNom() + "a reussit son attaque");

            
            int degatSubit = this.getDegAtt();
            int nouveauxHP = Math.max(c.getPtVie()-degatSubit, 0);
            
            System.out.println("La cible a subit " + degatSubit + " degats");
            System.out.println("La cible avait " + c.getPtVie() + " hp et possede maintenant " + nouveauxHP + " hp");

            c.setPtVie(nouveauxHP);  
        }
        else
        {
            System.out.println("L'archer " + this.getNom() + " n'est pas a portee de cible de sa cible");
        }
    }
    
    /**
     *
     */
    @Override
    public void affiche() {
        System.out.println("\nAffichage de l'archer");
        super.affiche();
    }

}
