/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package org.centrale.objet.WoE;

/**
 *
 * @author utaab
 */
public class PotionSoin extends Objet {
    
    private int ptSoin;
    
    public PotionSoin() {
        super();
        this.ptSoin = 1;
    }
    
    public PotionSoin(PotionSoin p) {
        super(p);
        this.ptSoin = p.ptSoin;
    }

    public PotionSoin(int poids, int ptSoin) {
        super(poids);
        this.ptSoin = ptSoin;
    }

    public int getPtSoin() {
        return ptSoin;
    }

    public void setPtSoin(int ptSoin) {
        this.ptSoin = ptSoin;
    }
    
    
}