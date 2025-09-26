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
public class Creature {
    
    private int ptVie;
    private int degAtt;
    private int ptPar;
    private int pageAtt;
    private int pagePar;
    private Point2D pos;

    public Creature() {
        this.ptVie = 100;
        this.degAtt = 10;
        this.ptPar = 5;
        this.pageAtt = 90;
        this.pagePar = 60;
        this.pos = new Point2D(0,0);
    }
    
    public Creature(Creature c) {
        this.ptVie = c.ptVie;
        this.degAtt = c.degAtt;
        this.ptPar = c.ptPar;
        this.pageAtt = c.pageAtt;
        this.pos = c.pos;
    }
    
    public Creature(int ptVie, int degAtt, int ptPar, int pageAtt, int pagePar, Point2D pos) {
        this.ptVie = ptVie;
        this.degAtt = degAtt;
        this.ptPar = ptPar;
        this.pageAtt = pageAtt;
        this.pagePar = pagePar;
        this.pos = pos;
    }

    public int getPtVie() {
        return ptVie;
    }

    public void setPtVie(int ptVie) {
        this.ptVie = ptVie;
    }

    public int getDegAtt() {
        return degAtt;
    }

    public void setDegAtt(int degAtt) {
        this.degAtt = degAtt;
    }

    public int getPtPar() {
        return ptPar;
    }

    public void setPtPar(int ptPar) {
        this.ptPar = ptPar;
    }

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
    
    public Point2D getPos() {
        return pos;
    }

    public void setPos(Point2D pos) {
        this.pos = pos;
    }

    public void deplace() {
        Random generateur = new Random();
        int dx = generateur.nextInt(-1, 2);
        int dy = generateur.nextInt(-1, 2);
        this.pos.translate(dx, dy);
    }

    public void affiche() {
        System.out.println("Nombre de points de vie actuels : " + ptVie);
        pos.affiche();
    }
    
}
