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
public class Monstre extends Creature{
    private int pagePar;

    public Monstre() {
        super();
        this.pagePar = 1;
    }
    
    public Monstre(Monstre m) {
        super(m);
        this.pagePar = m.pagePar;
    }

    public Monstre(int ptVie, int degAtt, int ptPar, int pageAtt, int pagePar, Point2D pos) {
        super(ptVie, degAtt, ptPar, pageAtt, pos);
        this.pos = pos;
    }

    public void setPageAtt(int pageAtt) {
        this.pageAtt = pageAtt;
    }

    public int getPagePar() {
        return pagePar;
    }

    public void setPagePar(int pagePar) {
        this.pagePar = pagePar;
    }
    
    @Override
    public void affiche() {
        super.affiche();
    }
}
