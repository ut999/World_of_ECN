/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package org.centrale.objet.WoE;

import java.util.Scanner;

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
    
    public void tourJeu(int numero)
    {
        System.out.println("Tour du joueur n°" + numero );
        System.out.println("Selectionner une action, 'C' : Combat, 'D' Deplacer");
        
        Scanner sc = new Scanner(System.in);
        String action = "";
        while(!(action.equals("D")||action.equals("C")))
        {
            action = sc.nextLine();
            if(action.equals("D"))
            {
                deplacementJoueur(sc);
            }
            else if(action.equals("C"))
            {
                combatJoueur(sc);
            }
            else{
                System.out.println("Erreur de l'input, veuillez écrire D ou C");
            }
        }
    }
    
    
    
    public void combatJoueur(Scanner sc)
    {
        world.displayZone(personnage.getPos(), 8);
        System.out.println("Choisissez une tile ou vous déplacer");
        
        String action = sc.nextLine();
    }
    
    public void deplacementJoueur(Scanner sc)
    {
        world.displayZone(personnage.getPos(), 8);
        System.out.println("Choisissez une tile ou vous déplacer");
        
        String action = sc.nextLine();
    }
}
