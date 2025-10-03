/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package org.centrale.objet.WoE;

import java.util.Iterator;

/**
 *
 * @author utaab
 */
public class TestWoE {

    public static void main(String[] args) {
        World mondeTest = new World();
        
        for (int nb = 100; nb<1000000; nb = nb*10) {
            
            System.out.println("\nNombre protagoniste : " + nb);
            
            mondeTest.creerMondeAlea(nb);

            //Calcul du temps iterateur
            int somme_ptVie_it = 0;
            long startTime_it = System.nanoTime();
            for(Personnage p : mondeTest.protagonistes) {
                somme_ptVie_it += p.getPtVie();
            }
            long estimatedTime_it = System.nanoTime() - startTime_it;

            System.out.println("\nSomme de point de vie : " + somme_ptVie_it);
            System.out.println("Temps ecoule, iterateur : " + estimatedTime_it*10e-6);

            //Calcul du temps get
            int somme_ptVie_get = 0;
            long startTime_get = System.nanoTime();
            for (int i = 0; i<mondeTest.protagonistes.size(); i++) {
                somme_ptVie_get += mondeTest.protagonistes.get(i).getPtVie();
            }
            long estimatedTime_get = System.nanoTime() - startTime_get;

            System.out.println("\nSomme de point de vie : " + somme_ptVie_get);      
            System.out.println("Temps ecoule, get : " + estimatedTime_get*10e-6);
        }
    }
}
