/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package org.centrale.objet.WoE;

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
}
