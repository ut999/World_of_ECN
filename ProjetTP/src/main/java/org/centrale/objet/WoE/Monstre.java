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
public class Monstre {
    private int ptVie;
    private int degAtt;
    private int ptPar;
    private int pageAtt;
    private int pagePar;
    private Point2D pos;

    /**
     * Constructeur prenant chaque paramètre en entrée
     *
     * @param ptVie
     * @param degAtt
     * @param ptPar
     * @param pageAtt
     * @param pagePar
     * @param pos
     */
    public Monstre(int ptVie, int degAtt, int ptPar, int pageAtt, int pagePar, Point2D pos) {
        this.ptVie = ptVie;
        this.degAtt = degAtt;
        this.ptPar = ptPar;
        this.pageAtt = pageAtt;
        this.pagePar = pagePar;
        this.pos = pos;
    }
    
    /**
     * Constructeur copie
     * @param m
     */
    public Monstre(Monstre m) {
        this.ptVie = m.ptVie;
        this.degAtt = m.degAtt;
        this.ptPar = m.ptPar;
        this.pageAtt = m.pageAtt;
        this.pagePar = m.pagePar;
        this.pos = m.pos;
    }
    
    /**
     * Constructeur sans parapètre
     */
    public Monstre() {
        this.ptVie = 100;
        this.degAtt = 20;
        this.ptPar = 1;
        this.pageAtt = 1;
        this.pagePar = 1;
        this.pos = new Point2D(0,10);
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
     * Fonction de déplacement d'une case aléatoire, le monstre peut rester sur place
     */
    public void deplace() {
        Random generateur = new Random();
        int dx = generateur.nextInt(-1,2);
        int dy = generateur.nextInt(-1,2);
        this.pos.translate(dx, dy);
    }
    
    /**
     * Fonction d'affichage des caractéristiques du monstre
     */
    public void affiche() {
        System.out.println(
                "Monstre :\nptVie = " + this.ptVie +
                "\ndegAtt = " + this.degAtt +
                "\nptPar = " + this.ptPar +
                "\npageAtt = " + this.pageAtt +
                "\npagePar = " + this.pagePar);
        pos.affiche();
    }
}
