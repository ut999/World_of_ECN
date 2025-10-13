/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package org.centrale.objet.WoE;

/**
 *
 * @author utaab
 */
public abstract class ElementDeJeu {
    
    private Point2D pos;

    public ElementDeJeu() {
        this.pos = new Point2D(0,0);
    }
    
    public ElementDeJeu(ElementDeJeu e) {
        this.pos = e.pos;
    }
    
    public ElementDeJeu(Point2D pos) {
        this.pos = pos;
    }

    /**
     *
     * @return
     */
    public Point2D getPos() {
        return pos;
    }

    /**
     *
     * @param pos
     */
    public void setPos(Point2D pos) {
        this.pos = pos;
    }

    /**
     *
     */
    public void affiche() {
        pos.affiche();
    }
    
}
