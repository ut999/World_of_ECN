/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package org.centrale.objet.WoE;

/**
 *  Représente une case en 2D sur la carte
 * @author utaab
 */
public class Point2D {
    private int x;
    private int y;

    /**
     *
     * @param x
     * @param y
     */
    public Point2D(int x, int y) {
        this.x = x;
        this.y = y;
    }

    /**
     *
     * @param p
     */
    public Point2D(Point2D p) {
        this.x = p.x;
        this.y = p.y;
    }
    
    /**
     *
     */
    public Point2D() {
        this.x = 0;
        this.y = 0;
    }

    /**
     *
     * @return
     */
    public int getX() {
        return x;
    }

    /**
     *
     * @param x
     */
    public void setX(int x) {
        this.x = x;
    }

    /**
     *
     * @return
     */
    public int getY() {
        return y;
    }

    /**
     *
     * @param y
     */
    public void setY(int y) {
        this.y = y;
    }
    
    /**
     *
     * @param x
     * @param y
     */
    public void setPosition(int x, int y) {
        this.x = x;
        this.y = y;
    }
    
    /**
     *
     * @param p
     * @return
     */
    public boolean equals(Point2D p) {
        return (this.x == p.x && 
                this.y == p.y);
    }

    /**
     *
     * @param dx
     * @param dy
     */
    public void translate(int dx, int dy) {
        this.x = x + dx;
        this.y = y + dy;
    }
    
    /**
     *
     */
    public void affiche() {
        System.out.println(
                "Position :\nx = " + x + 
                "\ny = " + y);
    }
    
    /**
     *
     * @param p
     * @return
     */
    public float distance(Point2D p) {
        int dist_x = this.x - p.x;
        int dist_y = this.y - p.y;
        return (float) Math.sqrt(dist_x*dist_x + dist_y*dist_y);
    }
}