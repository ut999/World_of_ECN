/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package org.centrale.objet.WoE;
import java.util.Random;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Iterator;
/**
 * Classe représentant le monde
 * @author Clément
 */
public class World {
    
    public LinkedList<Personnage> protagonistes;
    public ArrayList<PotionSoin> potions;

    /**
     * Construction du monde
     */
    public World() {
        protagonistes = new LinkedList<>();
        potions = new ArrayList<>();
    }
    
    /**
     *  Randomisation du monde, robin peon et bugs se déplacent sur une case aléatoire, 
     * Robin et Peon obtiennent un nom aléatoire parmis une liste de nom prédéfini
     */
    public void creerMondeAlea() {
        Random generateur = new Random();
        
        //noms aléatoires
        String[] banqueDeNoms = {
        "Alaric", "Roderic", "Gareth",
        "Wulfric", "Hadrian", "Merek ",
        "Isambard", "Cressida ", "Beatrix",
        "Gwendolyn", "Lyanna", "Verena"
        };
        
        //Initialisation des protagonistes
        int nb_protagoniste = generateur.nextInt(5,20);
        for (int i = 0; i<nb_protagoniste; i++) {
            Archer protagoniste = new Archer();
            protagoniste.setPtVie(generateur.nextInt(2,10));
            protagoniste.setPos(new Point2D(generateur.nextInt(-100,101),generateur.nextInt(-100,101)));
            protagoniste.setNom(banqueDeNoms[generateur.nextInt(banqueDeNoms.length-1)]);
            protagonistes.add(protagoniste);
        }

        //Initialisation des potions
        int nb_potion = generateur.nextInt(5,20);
        for (int i = 0; i<nb_potion; i++) {
            PotionSoin potion = new PotionSoin();
            potion.setPos(new Point2D(generateur.nextInt(-100,101),generateur.nextInt(-100,101)));
            potions.add(potion);
        }
    }
    
    public void consommerPotion() {
        
        System.out.println("\nConsommerPotion");
        
        //La fonction remove supprime la premierer occurence de la liste, donc si deux objet identique existe, erreur de memoire
        /*for (PotionSoin potion : potions) {
        if (robin.getPos().equals(potion.getPos())) {
        robin.setPtVie(potion.getPtSoin() + robin.getPtVie());
        potions.remove(potion);
        System.out.println("robin a une point de vie en plus !");
        }
        }*/
        
        
        /*for (int i = potions.size()-1; i>=0; i--) {
        if (robin.getPos().equals(potions.get(i).getPos())) {
        robin.setPtVie(potions.get(i).getPtSoin() + robin.getPtVie());
        potions.remove(i);
        System.out.println("robin gagne " + potions.get(i).getPtSoin() + " point de vie !");
        }
        }*/
        
        // Utilisation de l'iterator pour eviter l'ambiguite d'indexation lors de suppression des elements
        /*Iterator<PotionSoin> it = potions.iterator();
        while (it.hasNext()) {
        PotionSoin potion = it.next();
        if (robin.getPos().equals(potion.getPos())) {
        robin.setPtVie(potion.getPtSoin() + robin.getPtVie());
        it.remove();
        }
        }*/
    }
    
    public void tourDeJeu() {
        consommerPotion();
    }
    
    public void afficheWorld() {
        
    }
}
