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
    
    public int ptVie;
    public int degAtt;
    public int ptPar;
    public int pageAtt;
    public Point2D pos;

    public Creature() {
        this.ptVie = 100;
        this.degAtt = 10;
        this.ptPar = 1;
        this.pageAtt = 1;
        this.pos = new Point2D(0,0);
    }
    
    public Creature(Creature c) {
        this.ptVie = c.ptVie;
        this.degAtt = c.degAtt;
        this.ptPar = c.ptPar;
        this.pageAtt = c.pageAtt;
        this.pos = c.pos;
    }
    
    public Creature(int ptVie, int degAtt, int ptPar, int pageAtt, Point2D pos) {
        this.ptVie = ptVie;
        this.degAtt = degAtt;
        this.ptPar = ptPar;
        this.pageAtt = pageAtt;
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
