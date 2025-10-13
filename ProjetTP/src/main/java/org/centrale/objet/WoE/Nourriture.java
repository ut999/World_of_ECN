/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package org.centrale.objet.WoE;
import java.util.Random;

/**
 *
 * @author utaab
 */
public abstract class Nourriture extends Objet implements Utilisable {
    
    private int nbTour;

    public Nourriture() {
        super();
        Random generateur = new Random();
        this.nbTour = generateur.nextInt(1, 10);
    }

    public Nourriture(Nourriture n) {
        super(n);
        this.nbTour = n.nbTour;
    }

    public Nourriture(Point2D pos, int nbTour) {
        super(pos);
        this.nbTour = nbTour;
    }

    public int getNbTour() {
        return nbTour;
    }

    public void setNbTour(int nbTour) {
        this.nbTour = nbTour;
    }
    
    @Override
    public void utiliser(Creature c) {
        
    }
}
