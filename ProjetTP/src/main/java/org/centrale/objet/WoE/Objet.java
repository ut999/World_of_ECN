/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package org.centrale.objet.WoE;

/**
 *
 * @author utaab
 */
public class Objet {
    
    public int poids;
    
    public Objet() {
        this.poids = 1;
    }
    
    public Objet(Objet o) {
        this.poids = o.poids;
    }
    
    public Objet(int poids) {
        this.poids = poids;
    }

    public int getPoids() {
        return poids;
    }

    public void setPoids(int poids) {
        this.poids = poids;
    }
    
    
}
