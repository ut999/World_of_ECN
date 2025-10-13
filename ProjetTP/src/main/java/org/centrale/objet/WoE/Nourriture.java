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
    
    private int duree;

    public Nourriture() {
        super();
        Random generateur = new Random();
        this.duree = generateur.nextInt(5, 20);
    }

    public Nourriture(Nourriture n) {
        super(n);
        this.duree = n.duree;
    }

    public Nourriture(Point2D pos, int duree) {
        super(pos);
        this.duree = duree;
    }

    public int getduree() {
        return duree;
    }

    public void setduree(int duree) {
        this.duree = duree;
    }
    
    @Override
    public void utiliser(Creature c) {
        
    }
}
