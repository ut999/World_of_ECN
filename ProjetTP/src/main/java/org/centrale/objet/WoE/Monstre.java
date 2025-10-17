/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package org.centrale.objet.WoE;
import java.util.Random;

/**
 * Classe représentant un monstre, hérite de Créature
 * @author utaab
 */
public abstract class Monstre extends Creature{
    
    /**
     *
     */
    public Monstre() {
        super();
    }
    
    /**
     *
     * @param m
     */
    public Monstre(Monstre m) {
        super(m);
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
    public Monstre(int ptVie, int degAtt, int ptPar, int pageAtt, int distAttMax, int pagePar, Point2D pos) {
        super(ptVie, degAtt, ptPar, pageAtt, distAttMax, pagePar, pos);
    }

    /**
     *
     */
    @Override
    public void affiche() {
        super.affiche();
    }
}
