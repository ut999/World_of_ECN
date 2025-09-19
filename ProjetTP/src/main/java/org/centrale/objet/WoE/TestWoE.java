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
        mondeTest.bugs.affiche();
        mondeTest.peon.affiche();
        mondeTest.robin.affiche();
        
        System.out.println("aleatoire");
        mondeTest.creerMondeAlea();
        
        mondeTest.bugs.affiche();
        mondeTest.peon.affiche();
        mondeTest.robin.affiche();
    }
}
