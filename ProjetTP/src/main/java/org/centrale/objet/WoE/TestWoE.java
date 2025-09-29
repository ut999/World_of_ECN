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
        
        /*
        //Tests Slide 5
        System.out.println("Creation du monde aleatoire");
        mondeTest.creerMondeAlea();
        
        mondeTest.peon.affiche();
        mondeTest.robin.affiche();
        
        System.out.println("Deplacements aleatoire des personages");
       
        for(int i=0;i<15;i++)
        {
             mondeTest.bugs.deplace();
             mondeTest.peon.deplace();
             mondeTest.robin.deplace();
        }
        
        mondeTest.bugs.affiche();
        mondeTest.peon.affiche();
        mondeTest.robin.affiche();
        */
        
       /*       
       //Tests Slide 8 
       
       mondeTest.robin.setNom("Robin");
       mondeTest.guillaumeT.setNom("GuillaumeT");
       mondeTest.robin.affiche();
       mondeTest.guillaumeT.affiche();
       
       System.out.println("Deplacements aleatoire des personages");
       mondeTest.robin.deplace();
       mondeTest.guillaumeT.deplace();
       
       mondeTest.robin.affiche();
       mondeTest.guillaumeT.affiche();*/
        
       
       /*       
       //Tests Slide 13
       mondeTest.peon.affiche();
       mondeTest.robin.affiche();
       mondeTest.bugs1.affiche();
       mondeTest.bugs2.affiche();
       mondeTest.guillaumeT.affiche();
       mondeTest.grosbill.affiche();
       mondeTest.wolfie.affiche();*/
       
       //Test slide 23; potion
       System.out.println("Creation du monde aleatoire");
       mondeTest.creerMondeAlea();
       
       mondeTest.robin.setPos(new Point2D(mondeTest.potions.get(0).getPos()));
       
       mondeTest.robin.affiche();
       mondeTest.potions.get(0).affiche();
       System.out.println("\nNombre de porion : " + mondeTest.potions.size());
       
       mondeTest.consommerPotion();
       
       mondeTest.robin.affiche();
       
       System.out.println("\nNombre de porion : " + mondeTest.potions.size());
    }
}
