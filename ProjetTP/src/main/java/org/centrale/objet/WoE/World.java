/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package org.centrale.objet.WoE;
import java.util.Random;
import java.util.ArrayList;
import java.util.Iterator;
/**
 * Classe représentant le monde
 * @author Clément
 */
public class World {

    /**
     *   Archer d'exemple Robin
     */
    public Archer robin;
    
    /**
     *  Paysan nommé peon
     */
    public Paysan peon;
    public Lapin bugs1;
    public Lapin bugs2;
    public Archer guillaumeT;
    public Guerrier grosbill;
    public Loup wolfie;
    public ArrayList<PotionSoin> potions;

    /**
     * Construction du monde
     */
    public World() {
        robin = new Archer();
        peon = new Paysan();
        bugs1 = new Lapin(); 
        bugs2 = new Lapin(); 
        guillaumeT = new Archer();
        grosbill = new Guerrier();
        wolfie = new Loup();
        potions = new ArrayList<PotionSoin>();
    }
    
    /**
     *  Randomisation du monde, robin peon et bugs se déplacent sur une case aléatoire, 
     * Robin et Peon obtiennent un nom aléatoire parmis une liste de nom prédéfini
     */
    public void creerMondeAlea() {
        Random generateur = new Random();
        
        //positionnements aléatoires
        robin.setPos(new Point2D(generateur.nextInt(-100,101),generateur.nextInt(-100,101)));
        peon.setPos(new Point2D(generateur.nextInt(-100,101),generateur.nextInt(-100,101)));
        bugs1.setPos(new Point2D(generateur.nextInt(-100,101),generateur.nextInt(-100,101)));
        bugs2.setPos(new Point2D(generateur.nextInt(-100,101),generateur.nextInt(-100,101)));
        guillaumeT.setPos(new Point2D(generateur.nextInt(-100,101),generateur.nextInt(-100,101)));
        grosbill.setPos(new Point2D(generateur.nextInt(-100,101),generateur.nextInt(-100,101)));
        wolfie.setPos(new Point2D(generateur.nextInt(-100,101),generateur.nextInt(-100,101)));

        //noms aléatoires
        String[] banqueDeNoms = { 
            "Alaric", "Roderic", "Gareth", 
            "Wulfric", "Hadrian", "Merek ", 
            "Isambard", "Cressida ", "Beatrix", 
            "Gwendolyn", "Lyanna", "Verena"
                };
        robin.setNom(banqueDeNoms[generateur.nextInt(banqueDeNoms.length)]);
        peon.setNom(banqueDeNoms[generateur.nextInt(banqueDeNoms.length)]);
        guillaumeT.setNom(banqueDeNoms[generateur.nextInt(banqueDeNoms.length)]);
        grosbill.setNom(banqueDeNoms[generateur.nextInt(banqueDeNoms.length)]);
        
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
        
        
        for (int i = potions.size()-1; i>=0; i--) {
            if (robin.getPos().equals(potions.get(i).getPos())) {
                robin.setPtVie(potions.get(i).getPtSoin() + robin.getPtVie());
                potions.remove(i);
                System.out.println("robin gagne " + potions.get(i).getPtSoin() + " point de vie !");
            }
        }
        
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
