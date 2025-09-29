/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package org.centrale.objet.WoE;
import java.util.Random;

/**
 * Classe représentant un monstre
 * @author utaab
 */
public class Monstre extends Creature{
    
    public Monstre() {
        super();
    }
    
    public Monstre(Monstre m) {
        super(m);
    }

    public Monstre(int ptVie, int degAtt, int ptPar, int pageAtt, int pagePar, Point2D pos) {
        super(ptVie, degAtt, ptPar, pageAtt, pagePar, pos);
    }

    @Override
    public void affiche() {
        super.affiche();
    }
}
