/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package org.centrale.objet.WoE;
import java.util.Random;

/**
 * Classe de gestion des personnages
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

    /**
     * Constructeur de Personnage ne prenant pas de paramètres
     */
    public Personnage() {
        this.nom = "Pierre";
        this.ptVie = 100;
        this.degAtt = 10;
        this.ptPar = 2;
        this.pageAtt = 2;
        this.distAttMax = 1;
        this.pos = new Point2D();
    }

    /**
     * Constructeur copie de personnage
     * @param p personnage à copier
     */
    public Personnage(Personnage p) {
        this.nom = p.nom;
        this.ptVie = p.ptVie;
        this.degAtt = p.degAtt;
        this.ptPar = p.ptPar;
        this.pageAtt = p.pageAtt;
        this.distAttMax = p.distAttMax;
        this.pos = new Point2D(p.pos);
    }

    /**
     * Constructeur de personnage prenant chaque paramètre en entrée
     * @param nom
     * @param ptVie
     * @param degAtt
     * @param ptPar
     * @param pageAtt
     * @param distAttMax
     * @param pos
     */
    public Personnage(String nom, int ptVie, int degAtt, int ptPar, int pageAtt, int distAttMax, Point2D pos) {
        this.nom = nom;
        this.ptVie = ptVie;
        this.degAtt = degAtt;
        this.ptPar = ptPar;
        this.pageAtt = pageAtt;
        this.distAttMax = distAttMax;
        this.pos = pos;
    }

    /**
     *
     * @return
     */
    public String getNom() {
        return nom;
    }

    /**
     *
     * @param nom
     */
    public void setNom(String nom) {
        this.nom = nom;
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
    public int getDistAttMax() {
        return distAttMax;
    }

    /**
     *
     * @param distAttMax
     */
    public void setDistAttMax(int distAttMax) {
        this.distAttMax = distAttMax;
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
     * Fonction de déplacement aléatoire du personnage, il se déplace sur une case voisine (dont diagonale) ou reste sur place
     */
    public void deplace() {
        Random generateur = new Random();
        int dx = generateur.nextInt(-1,2);
        int dy = generateur.nextInt(-1,2);
        this.pos.translate(dx, dy);
    }
    
    /**
     * Fonction d'affichage d'un personnage où il donne ses informations
     */
    public void affiche()
    {
        System.out.println("Affichage de " + nom);
        System.out.println("Nombre de points de vie actuels : " + ptVie);
        pos.affiche();
    }
}
