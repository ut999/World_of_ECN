/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package org.centrale.objet.WoE;
import java.util.Random;
/**
 * Classe représentant le monde
 * @author Clément
 */
public class World {

    /**
     *   Archer d'exemple Robin
     */
    public Archer robin;
    
    public Archer guillaumeT;
    
    /**
     *  Paysan nommé peon
     */
    public Paysan peon;

    /**
     * Lapin nommé bugs
     */
    public Lapin bugs;

    /**
     * Construction du monde
     */
    public World() {
        robin = new Archer();
        peon = new Paysan();
        bugs = new Lapin(); 
        
        guillaumeT = new Archer(robin);
    }
    
    /**
     *  Randomisation du monde, robin peon et bugs se déplacent sur une case aléatoire, 
     * Robin et Peon obtiennent un nom aléatoire parmis une liste de nom prédéfini
     */
    public void creerMondeAlea()
    {
        Random generateur = new Random();
        
        //positionnements aléatoires
        robin.setPos(new Point2D(generateur.nextInt(-100,101),generateur.nextInt(-100,101)));
        peon.setPos(new Point2D(generateur.nextInt(-100,101),generateur.nextInt(-100,101)));
        bugs.setPos(new Point2D(generateur.nextInt(-100,101),generateur.nextInt(-100,101)));
        
        //noms aléatoires
        String[] banqueDeNoms = { 
            "Alaric", "Roderic", "Gareth", 
            "Wulfric", "Hadrian", "Merek ", 
            "Isambard", "Cressida ", "Beatrix", 
            "Gwendolyn", "Lyanna", "Verena"
                };
        robin.setNom(banqueDeNoms[generateur.nextInt(13)]);
        peon.setNom(banqueDeNoms[generateur.nextInt(13)]);
    }
}
