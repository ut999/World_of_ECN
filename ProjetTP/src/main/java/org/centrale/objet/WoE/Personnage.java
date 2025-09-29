/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package org.centrale.objet.WoE;
/**
 * Classe de gestion des personnages
 * @author Clément
 */
public class Personnage extends Creature {
    //attributes
    private String nom;
    private int distAttMax;

    /**
     * Constructeur de Personnage ne prenant pas de paramètres
     */
    public Personnage() {
        super();
        this.nom = "Pierre";
        this.distAttMax = 1;
    }

    /**
     * Constructeur copie de personnage
     * @param p personnage à copier
     */
    public Personnage(Personnage p) {
        super(p);
        this.nom = p.nom;
        this.distAttMax = p.distAttMax;
    }

    /**
     * Constructeur de personnage prenant chaque paramètre en entrée
     * @param nom
     * @param ptVie
     * @param degAtt
     * @param ptPar
     * @param pageAtt
     * @param pagePar
     * @param distAttMax
     * @param pos
     */
    public Personnage(String nom, int ptVie, int degAtt, int ptPar, int pageAtt, int distAttMax, int pagePar, Point2D pos) {
        super(ptVie, degAtt, ptPar, pageAtt, pagePar, pos);
        this.nom = nom;
        this.distAttMax = distAttMax;
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

    public int getDistAttMax() {
        return distAttMax;
    }

    public void setDistAttMax(int distAttMax) {
        this.distAttMax = distAttMax;
    }
    
    @Override
    public void affiche() {
        super.affiche();
    }
}
