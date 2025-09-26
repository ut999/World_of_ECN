/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package org.centrale.objet.WoE;
/**
 *
 * @author Clément
 */
public class Personnage extends Creature {
    //attributes
    private String nom;
    private int distAttMax;

    public Personnage() {
        super();
        this.nom = "Pierre";
        this.distAttMax = 1;
    }
    public Personnage(Personnage p) {
        super(p);
        this.nom = p.nom;
        this.distAttMax = p.distAttMax;
    }

    public Personnage(String nom, int ptVie, int degAtt, int ptPar, int pageAtt, int distAttMax, Point2D pos) {
        super(ptVie, degAtt, ptPar, pageAtt, pos);
        this.nom = nom;
        this.distAttMax = distAttMax;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }


    public void setPageAtt(int pageAtt) {
        this.pageAtt = pageAtt;
    }

    public int getDistAttMax() {
        return distAttMax;
    }
    
    @Override
    public void affiche() {
        super.affiche();
    }
}
