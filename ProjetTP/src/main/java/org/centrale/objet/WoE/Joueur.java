/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package org.centrale.objet.WoE;

import java.util.Scanner;
import java.util.ArrayList;
import java.util.List;
import java.util.Arrays;

/**
 *
 * @author Clément
 */
public class Joueur {
    
    private Personnage personnage;

    public Personnage getPersonnage() {
        return personnage;
    }

    public void setPersonnage(Personnage personnage) {
        this.personnage = personnage;
    }

    public World getWorld() {
        return world;
    }

    public void setWorld(World world) {
        this.world = world;
    }
    private World world;
    public Joueur()
    {
        personnage = null;
        world = null;
    }
    
    public Joueur( Personnage personnage, World world)
    {
        this.personnage = personnage;
        this.world = world;
    }
    
    public boolean tourJeu(int numero)
    {
        System.out.println("Tour du joueur n " + numero );
        
        world.displayZone(personnage.getPos(), 8);
        
        System.out.println("Selectionner une action, 'C' : Combat, 'D' Deplacer, 'I' Inventaire, 'Q' Quitter");
        
        Scanner sc = new Scanner(System.in);
        String action = "";
        
        List<String> actionsPossible = 
                new ArrayList<>(Arrays.asList("C", "c", "D", "d", "I", "i","Q","q"));
        while(!actionsPossible.contains(action))
        {
            action = sc.nextLine();
            switch (action) {
                case "D", "d" -> deplacementJoueur(sc);
                case "C", "c" -> combatJoueur(sc);
                case "I", "i" -> combatJoueur(sc);
                case "Q", "q" -> {
                    return false;
                }
                default -> System.out.println("Erreur de l'input, veuillez ecrire D, C, I ou Q");
            }
        }
        
        return true;
    }
    
    public void ouvrirInventaireJoueur(Scanner sc)
    {
        System.out.println("Ouverture Inventaire");
    }
    
    public void combatJoueur(Scanner sc)
    {
        System.out.println("Choisissez une tile a combattre");
        
        Point2D delta = new Point2D();
        inputCase(sc,delta);
        
        int dx = delta.getX();
        int dy = delta.getY();
        
    }
    
    public void deplacementJoueur(Scanner sc)
    {
        System.out.println("Choisissez votre deplacement avec une chaine de ZQSD (ex: ZZQ = haut haut bas)");
        
        Point2D delta = new Point2D();
        Point2D posMem = new Point2D(personnage.getPos());
        
        boolean flagCorrectDeplacement = false;
        while(!flagCorrectDeplacement)
        {
            flagCorrectDeplacement = true;
            inputCase(sc,delta);
            int dx = delta.getX();
            int dy = delta.getY();
        
            personnage.getPos().translate(dx, dy);
            
            if(!world.estPositionCreatureLegit(personnage))
            {
                flagCorrectDeplacement = false;
                personnage.getPos().setPosition(posMem.getX(),posMem.getY());
                System.out.println("La case donnee est soit en dehors de la map, soit deja occupee par une autre creature");
            }
        }

    }
    
    public void inputCase(Scanner sc, Point2D delta)
    {
        boolean flagCorrectMovement = false;
        
        while(!flagCorrectMovement)
        {
            flagCorrectMovement = true;
            delta.setPosition(0, 0);
            String deplacement = sc.nextLine();
            
            
            //we read each char of the string and break and ask a new input if a char isn't legit
            OUTER:
            for (int ic = 0; ic < deplacement.length(); ic++) {
                char c = deplacement.charAt(ic);
                switch (c) {
                    case 'Z', 'z' -> delta.translate(0, -1);
                    case 'Q', 'q' -> delta.translate(-1, 0);
                    case 'S', 's' -> delta.translate(0, 1);
                    case 'D', 'd' -> delta.translate(1, 0);
                    default -> {
                        flagCorrectMovement = false;
                        break OUTER;
                    }
                }
            }
            if(!flagCorrectMovement)
            {
                System.out.println("Mauvaise selection de case, il l'input doit etre dans le format 'ZQQSSSSDDDDD' et ne contenir aucun autre characteres");
            }
        }
    }
}
