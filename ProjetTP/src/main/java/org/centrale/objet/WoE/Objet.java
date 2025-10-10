/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package org.centrale.objet.WoE;

/**
 *  Représente un objet
 * @author utaab
 */
public class Objet {
    
    private Point2D pos;
    
    public Objet() {
        this.pos = new Point2D(0,0);
    }
    
    public Objet(Objet o) {
        this.pos = o.pos;
    }
    
    public Objet(Point2D pos) {
        this.pos = pos;
    }

    public Point2D getPos() {
        return pos;
    }

    public void setPos(Point2D pos) {
        this.pos = pos;
    }
    
    public void affiche() {
        pos.affiche();
    }
}
