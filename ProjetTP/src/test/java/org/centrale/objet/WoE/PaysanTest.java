/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit5TestClass.java to edit this template
 */
package org.centrale.objet.WoE;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

/**
 *
 * @author utaab
 */
public class PaysanTest {
    
    public PaysanTest() {
    }
    
    @BeforeAll
    public static void setUpClass() {
    }
    
    @AfterAll
    public static void tearDownClass() {
    }
    
    @BeforeEach
    public void setUp() {
    }
    
    @AfterEach
    public void tearDown() {
    }

    /**
     * Test of affiche method, of class Paysan.
     */
    @Test
    public void testAffiche() {
        System.out.println("affiche");
        Paysan instance = new Paysan();
        instance.affiche();
    }

    /**
     * Test of display method, of class Paysan.
     */
    @Test
    public void testDisplay() {
        System.out.println("display");
        Paysan instance = new Paysan();
        instance.display();
    }
    
}
