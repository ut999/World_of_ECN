/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package org.centrale.objet.WoE;

/**
 *
 * @author utaab
 */
public class Epee extends Objet {
    public int degAtt;
    
    public Epee() {
        super();
        this.degAtt = 5;
    }
    
    public Epee(Epee e) {
        super(e);
        this.degAtt = e.degAtt;
    }
    public Epee(int degAtt) {
        super();
        this.degAtt = degAtt;
    }

    public int getDegAtt() {
        return degAtt;
    }

    public void setDegAtt(int degAtt) {
        this.degAtt = degAtt;
    }
}
