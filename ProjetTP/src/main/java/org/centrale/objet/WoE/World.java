/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package org.centrale.objet.WoE;
import java.util.Random;
/**
 *
 * @author Clément
 */
public class World {
    public Archer robin;
    public Paysan peon;
    public Lapin bugs;

    public World() {
        robin = new Archer();
        peon = new Paysan();
        bugs = new Lapin(); 
    }
    
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
