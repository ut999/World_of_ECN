/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package org.centrale.objet.WoE;

/**
 *  Représente un objet
 * @author utaab
 */
public abstract class Objet extends ElementDeJeu {
    
    public Objet() {
        super();
    }
    
    public Objet(Objet o) {
        super(o);
    }
    
    public Objet(Point2D pos) {
        super(pos);
    }
    
    public abstract void afficheInventaire();
}
