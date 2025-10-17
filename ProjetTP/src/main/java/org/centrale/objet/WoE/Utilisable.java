/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package org.centrale.objet.WoE;

/**
 *
 * @author utaab
 */
public interface Utilisable {
    
    public void utiliser(Creature c);
    
    public int getDuree();
    
    public Point2D getPos();
    
    public boolean finDuree();
    
    public void finEffet(Creature c);
    
    public void afficheInventaire();
}
