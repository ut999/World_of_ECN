/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package org.centrale.objet.WoE;

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
        
       //Test slide 23; potion
       /*
       System.out.println("Creation du monde aleatoire");
       mondeTest.creerMondeAlea();
       
       mondeTest.robin.setPos(new Point2D(mondeTest.potions.get(0).getPos()));
       
       mondeTest.robin.affiche();
       mondeTest.potions.get(0).affiche();
       System.out.println("\nNombre de porion : " + mondeTest.potions.size());
       
       mondeTest.consommerPotion();
       
       mondeTest.robin.affiche();
       
       System.out.println("\nNombre de porion : " + mondeTest.potions.size());
       */
       /*
       
       int nbPersos = 100;
       
       System.out.println("Creation des " + nbPersos + " personnages : ");
       for(int i=0;i<nbPersos;i++)
       {
           mondeTest.ajouterPersoAlea();
       }       
       System.out.println("\ncalcul avec taille");
       long debutTaille = System.nanoTime();
       int pvtotTaille = mondeTest.calculPointsDeVieTotauxTaille();
       long finTaille = System.nanoTime();
       System.out.println("temps iter en ms : " + (finTaille-debutTaille)*10E-6);
       
       System.out.println("\ncalcul avec iteration");
       long debutIt = System.nanoTime();
       int pvtotIter = mondeTest.calculPointsDeVieTotauxIter();
       long finIt = System.nanoTime();
       System.out.println("temps iter en ms : " + (finIt-debutIt)*10E-6);
       */
       mondeTest.creerMondeAlea();
       
       /*
       
       try {           
            Archer archer = new Archer();
            archer = null;
            int ptDeVie = archer.getPtVie();
       }
       catch (NullPointerException exception) { 
           System.out.println(exception);
       }
       finally{
           System.out.println("Finally");
       }
       
        try {           
            int number = 5/0;
        }
        catch (ArithmeticException exception) { 
           System.out.println(exception);
        }
       */
       
       /*
       int vieMaxPersonnage = -1;
       boolean erreur = true;
       while(vieMaxPersonnage==-1)
       {
            try {
                vieMaxPersonnage = lectureHP(erreur);
                System.out.println("reussite de la lecture");
            }
            catch (NumberFormatException exception) { 
               System.out.println("echec de la lecture : " + exception);
               erreur = false;
            }
       }
       System.out.println("Vie Max Personnage : " + vieMaxPersonnage);
       
       */
       mondeTest.tourDeJeu();
    }
    
    public static int lectureHP(boolean erreur) throws NumberFormatException
    {
        String inputString = erreur?"200hp":"200";
        return Integer.parseInt(inputString);
    }
}


