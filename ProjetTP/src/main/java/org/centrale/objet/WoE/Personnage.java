/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package org.centrale.objet.WoE;
import java.util.Random;

/**
 *
 * @author Clément
 */
public class Personnage {
    //attributes
    private String nom;
    private int ptVie;
    private int degAtt;
    private int ptPar;
    private int pageAtt;
    private int distAttMax;
    private Point2D pos;

    public Personnage() {
        this.nom = "Pierre";
        this.ptVie = 100;
        this.degAtt = 10;
        this.ptPar = 2;
        this.pageAtt = 2;
        this.distAttMax = 1;
        this.pos = new Point2D();
    }
    public Personnage(Personnage p) {
        this.nom = p.nom;
        this.ptVie = p.ptVie;
        this.degAtt = p.degAtt;
        this.ptPar = p.ptPar;
        this.pageAtt = p.pageAtt;
        this.distAttMax = p.distAttMax;
        this.pos = new Point2D(p.pos);
    }

    public Personnage(String nom, int ptVie, int degAtt, int ptPar, int pageAtt, int distAttMax, Point2D pos) {
        this.nom = nom;
        this.ptVie = ptVie;
        this.degAtt = degAtt;
        this.ptPar = ptPar;
        this.pageAtt = pageAtt;
        this.distAttMax = distAttMax;
        this.pos = pos;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
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

    public void setPageAtt(int pageAtt) {
        this.pageAtt = pageAtt;
    }

    public int getDistAttMax() {
        return distAttMax;
    }

    public void setDistAttMax(int distAttMax) {
        this.distAttMax = distAttMax;
    }

    public Point2D getPos() {
        return pos;
    }

    public void setPos(Point2D pos) {
        this.pos = pos;
    }
    
    public void deplace() {
        Random generateur = new Random();
        int dx = generateur.nextInt(-1,2);
        int dy = generateur.nextInt(-1,2);
        this.pos.translate(dx, dy);
    }
    
    public void affiche()
    {
        System.out.println("Affichage de " + nom);
        System.out.println("Nombre de points de vie actuels : " + ptVie);
        System.out.println("Position :");
        pos.affiche();
    }
}
