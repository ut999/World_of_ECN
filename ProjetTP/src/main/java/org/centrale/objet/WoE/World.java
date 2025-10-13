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
     * Conteneur listant l'ensemble des objets du monde
     */
    public ArrayList<Objet> objets;
    
    /**
     *  Conteneur listant l'ensemble des créatures du monde
     */
    public ArrayList<Creature> creatures;

    /**
     * Taille selon l'axe X du monde, il s'étend de la case 0 à tailleX-1
     */
    static final public int tailleX = 50;

    /**
     *  Taille selon l'axe Y du monde, il s'étend de la case 0 à tailleY-1
     */
    static final public int tailleY = 50;
    
    /**
     * Construction du monde
     */
    public World() {        
        objets = new ArrayList<>();
        creatures = new ArrayList<>();
    }
    
    /**
     *  Créer une créature aléatoire, elle est de type aléatoire (loup, paysan, archer , ...)
     *  Elle possède une position aléatoire sur la carte ainsi qu'un nombre de hp aléatoire.
     */
    public void creerCreatureAlea(){
        Random generateur = new Random();
        
        int idClasse = generateur.nextInt(0,5);
        Creature nouvelleCreature = null;
        
        switch(idClasse){
   
            case 0: 
                //System.out.println("creation Archer");
                nouvelleCreature = new Archer();
                break;
            case 1:
                //System.out.println("creation Paysan");
                nouvelleCreature = new Paysan();
                break;

            case 2:
                //System.out.println("creation Lapin");
                nouvelleCreature = new Lapin();
                break;

            case 3:
                //System.out.println("creation Guerrier");
                nouvelleCreature = new Guerrier();
                break;

            case 4:
                //System.out.println("creation Loup");
                nouvelleCreature = new Loup();
                break;
                
            default:
                nouvelleCreature = new Paysan();
                break;
        }
        
        nouvelleCreature.getPos().setPosition(generateur.nextInt(0,tailleX), generateur.nextInt(0,tailleY));
        nouvelleCreature.setPtVie(generateur.nextInt(2,10));
        creatures.add(nouvelleCreature);
    }
    
    /**
     *  Création d'un monde random, pour le moment il contient un certain nombre de potion ainsi qu'un certain nombre 
     * de créatures aléatoires
     */
    public void creerMondeAlea() {
        Random generateur = new Random();
        
        //Creation des créatures aléatoires
        for(int icrea=0;icrea<100;icrea++)
        {
            creerCreatureAlea();
        }
        
        /*

        //noms aléatoires
        String[] banqueDeNoms = { 
            "Alaric", "Roderic", "Gareth", 
            "Wulfric", "Hadrian", "Merek ", 
            "Isambard", "Cressida ", "Beatrix", 
            "Gwendolyn", "Lyanna", "Verena"
                };
        robin.setNom(banqueDeNoms[generateur.nextInt(banqueDeNoms.length)]);
        */
        
        //Initialisation des potions
        int nb_potion = generateur.nextInt(5,20);
        for (int i = 0; i<nb_potion; i++) {
            PotionSoin potion = new PotionSoin();
            potion.setPos(new Point2D(generateur.nextInt(-100,101),generateur.nextInt(-100,101)));
            objets.add(potion);
        }
    }
    
    /**
     *  Fonction permettant de consommer les potions sur lesquels un personnage est posé
     */
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
        
        /*
        
        for (int i = potions.size()-1; i>=0; i--) {
            if (robin.getPos().equals(potions.get(i).getPos())) {
                robin.setPtVie(potions.get(i).getPtSoin() + robin.getPtVie());
                potions.remove(i);
                System.out.println("robin gagne " + potions.get(i).getPtSoin() + " point de vie !");
            }
        }
        */
        
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
    
    /**
     * Calcul le nombre de point de vie total des créatures du monde avec un parcours sur la taille
     * @return pv totaux
     */
    public int calculPointsDeVieTotauxTaille(){
        int pvtotaux = 0;
        for(int i=0; i<creatures.size();i++)
        {   
            pvtotaux+=creatures.get(i).getPtVie();
        }
        return pvtotaux;
    }
    
    /**
     * Calcul le nombre de point de vie total des créatures du monde avec un parcours par itérateur
     * @return pv totaux
     */
    public int calculPointsDeVieTotauxIter(){
        int pvtotaux = 0;
        for(Creature c : creatures) {
            pvtotaux+=c.getPtVie();
        }
        return pvtotaux;
    }
    
    /**
     *  Fonction réalisant un tour du jeu, pour le moment chaque personnage se déplace
     * et les postions consomables sont consommées.
     */
    public void tourDeJeu() {
        
        for(Creature c : creatures) {
            deplaceSansCollisions(c);
        }
        consommerPotion();
    }
    
    /**
     *  Affiche le monde
     */
    public void afficheWorld() {
        for(Creature c : creatures) {
            c.affiche();
        }
        for(Objet o : objets){
            o.affiche();
        }
    }
    
    //la strategie que l'on decide de faire pour les deplacements aleatoires c'est que lors de world possède 
    //une fonction déplacement sécurisé qui prend en entrée une creature et applique sa fonction deplacement 
    //de sorte à éviter les collisions
    //on note où se déplace la créature et si elle va sur une case libre on lui demande de se redéplacer
    //renvoie aussi faux si la case est en dehors du monde

    /**
     *  Fonction vérifiant qu'une créature est seule sur sa case
     * Vérifie aussi que la créature est seule sur sa nouvelle case
     * @param c créature dont on vérifie si elle est seule ou pas
     * @return boolean vrai si la créature est seule sur sa case
     */
    public boolean estCreatureSeuleSurCase(Creature c){
        int cx = c.getPos().getX();
        int cy = c.getPos().getY();
        
        if(cx<0 || cx>=World.tailleX || cy < 0 || cy >= World.tailleY)
        {
            return false;
        }
        
        for(Creature icreature:creatures)
        {
            if(icreature.getPos().equals(c.getPos()) && c!=icreature)
            {
                return false;
            }
        }
        return true;
    }
    
    /**
     *  Déplace une créature avec sa fonction de déplacement en s'assurant qu'elle est seule sur na nouvelle case 
     * et que sa nouvelle case est bien dans le monde
     * @param c
     */
    public void deplaceSansCollisions(Creature c){
        Point2D posMem = c.getPos();
        
        //si la nouvelle case est occupée on refait un moove random, on s'arrète après 10 moves pour éviter boucle infini
        
        int limiteTentativesDeplacement = 10;
        for(int iTentative = 0; iTentative<=limiteTentativesDeplacement; iTentative++)
        {
                c.deplacer();
                if(!estCreatureSeuleSurCase(c))
                {
                    System.out.println("Collision ou sortie de carte detectee en x:" + 
                            c.getPos().getX() + " y : " + c.getPos().getY());
                    c.setPos(posMem);
                }
                else
                {
                    return;
                }
        }
    }
}
