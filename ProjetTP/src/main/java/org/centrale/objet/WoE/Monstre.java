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
    private int pagePar;

    public Monstre() {
        super();
        this.pagePar = 1;
    }
    
    /**
     * Constructeur copie
     * @param m
     */
    public Monstre(Monstre m) {
        super(m);
        this.pagePar = m.pagePar;
    }

    public Monstre(int ptVie, int degAtt, int ptPar, int pageAtt, int pagePar, Point2D pos) {
        super(ptVie, degAtt, ptPar, pageAtt, pos);
        this.pagePar = pagePar;
    }

    /**
     *
     * @return pagePar
     */
    public int getPagePar() {
        return pagePar;
    }

    /**
     *
     * @param pagePar
     */
    public void setPagePar(int pagePar) {
        this.pagePar = pagePar;
    }
    
    @Override
    public void affiche() {
        super.affiche();
    }
}
