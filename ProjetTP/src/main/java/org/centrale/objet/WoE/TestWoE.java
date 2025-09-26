/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package org.centrale.objet.WoE;

/**
 *
 * @author utaab
 */
public class TestWoE {

    public static void main(String[] args) {
        World mondeTest = new World();
        mondeTest.peon.affiche();
        mondeTest.robin.affiche();
        mondeTest.bugs1.affiche();
        mondeTest.bugs2.affiche();
        mondeTest.guillaumeT.affiche();
        mondeTest.grosbill.affiche();
        mondeTest.wolfie.affiche();
        
        System.out.println("aleatoire");
        mondeTest.creerMondeAlea();
        
        mondeTest.peon.affiche();
        mondeTest.robin.affiche();
        mondeTest.bugs1.affiche();
        mondeTest.bugs2.affiche();
        mondeTest.guillaumeT.affiche();
        mondeTest.grosbill.affiche();
        mondeTest.wolfie.affiche();
    }
}
