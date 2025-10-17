/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package org.centrale.objet.WoE;
import java.util.Random;

/**
 *  Représente l'ensemble des créatures
 * @author utaab
 */
public abstract class Creature extends ElementDeJeu implements Deplacable {
    
    private int ptVie;
    private int degAtt;
    private int ptPar;
    private int pageAtt;
    private int pagePar;
    
    private int distAttMax;

    public int getDistAttMax() {
        return distAttMax;
    }

    public void setDistAttMax(int distAttMax) {
        this.distAttMax = distAttMax;
    }

    /**
     *
     */
    public Creature() {
        super();
        this.ptVie = 100;
        this.degAtt = 10;
        this.ptPar = 5;
        this.pageAtt = 90;
        this.pagePar = 60;
        this.distAttMax=1;
    }
    
    /**
     *
     * @param c
     */
    public Creature(Creature c) {
        super(c);
        this.ptVie = c.ptVie;
        this.degAtt = c.degAtt;
        this.ptPar = c.ptPar;
        this.pageAtt = c.pageAtt;
        this.distAttMax = c.distAttMax;
    }
    
    /**
     *
     * @param ptVie
     * @param degAtt
     * @param ptPar
     * @param pageAtt
     * @param distAttMax
     * @param pagePar
     * @param pos
     */
    public Creature(int ptVie, int degAtt, int ptPar, int pageAtt, int distAttMax, int pagePar, Point2D pos) {
        super(pos);
        this.ptVie = ptVie;
        this.degAtt = degAtt;
        this.ptPar = ptPar;
        this.distAttMax = distAttMax;
        this.pageAtt = pageAtt;
        this.pagePar = pagePar;
    }

    /**
     *
     * @return
     */
    public int getPtVie() {
        return ptVie;
    }

    /**
     *
     * @param ptVie
     */
    public void setPtVie(int ptVie) {
        this.ptVie = ptVie;
    }

    /**
     *
     * @return
     */
    public int getDegAtt() {
        return degAtt;
    }

    /**
     *
     * @param degAtt
     */
    public void setDegAtt(int degAtt) {
        this.degAtt = degAtt;
    }

    /**
     *
     * @return
     */
    public int getPtPar() {
        return ptPar;
    }

    /**
     *
     * @param ptPar
     */
    public void setPtPar(int ptPar) {
        this.ptPar = ptPar;
    }

    /**
     *
     * @return
     */
    public int getPageAtt() {
        return pageAtt;
    }
    
    /**
     *
     * @param pageAtt
     */
    public void setPageAtt(int pageAtt) {
        this.pageAtt = pageAtt;
    }

        /**
     *
     * @return
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
    
    /**
     * 
     */
    @Override
    public void affiche() {
        System.out.println("Nombre de points de vie actuels : " + ptVie);
        super.affiche();
    }

    /**
     *
     */
    @Override
    public void deplacer() {
        Random generateur = new Random();
        int dx = generateur.nextInt(-1, 2);
        int dy = generateur.nextInt(-1, 2);
        this.getPos().translate(dx, dy);
    }    
}
