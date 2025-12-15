/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package org.centrale.objet.WoE;

import java.util.ArrayList;
import java.util.Arrays;

/**
 * Classe main servant à faire des tests sur le projet
 * @author utaab
 */
public class TestWoE {

    /**
     *  Méthode main servant à faire des tests sur le projet
     * @param args
     */
    public static void main(String[] args) {
        World mondeTest = new World();
       mondeTest.creerMondeAlea();
       while(mondeTest.tourDeJeu())
       {
            
       }
    }
    
    public static int lectureHP(boolean erreur) throws NumberFormatException
    {
        String inputString = erreur?"200hp":"200";
        return Integer.parseInt(inputString);
    }
}


