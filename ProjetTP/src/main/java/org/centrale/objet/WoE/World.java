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
     *  Conteneur listant l'ensemble des éléments du jeu
     */
    public ArrayList<ElementDeJeu> elementsDeJeu;
    
    public Joueur joueur;

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
        elementsDeJeu = new ArrayList<>();
    }
    
    /**
     *  Créer une créature aléatoire, elle est de type aléatoire (loup, paysan, archer , ...)
     *  Elle possède une position aléatoire sur la carte ainsi qu'un nombre de hp aléatoire.
     */
    public void creerCreatureAlea(){
        Random generateur = new Random();
        
        int idClasse = generateur.nextInt(0,5);
        Creature nouvelleCreature;
        
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
        elementsDeJeu.add(nouvelleCreature);
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
        
        Personnage persoJoueur = new Archer();
        joueur = new Joueur(persoJoueur, this);
        
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
            elementsDeJeu.add(potion);
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
        for(int i=0; i<elementsDeJeu.size();i++)
        {   
            if(elementsDeJeu.get(i) instanceof Creature)
            {
                pvtotaux+=((Creature)elementsDeJeu.get(i)).getPtVie();
            }
        }
        return pvtotaux;
    }
    
    /**
     * Calcul le nombre de point de vie total des créatures du monde avec un parcours par itérateur
     * @return pv totaux
     */
    public int calculPointsDeVieTotauxIter(){
        int pvtotaux = 0;
        for(ElementDeJeu e : elementsDeJeu) {
            if(e instanceof Creature)
            {
                pvtotaux+=((Creature)e).getPtVie();
            }
        }
        return pvtotaux;
    }
    
    /**
     *  Fonction réalisant un tour du jeu, pour le moment chaque personnage se déplace
     * et les postions consomables sont consommées.
     */
    public boolean tourDeJeu() {
        
        boolean continuePlaying;
        continuePlaying = joueur.tourJeu(1);
        
        for(ElementDeJeu e : elementsDeJeu) {
            if(e instanceof Creature)
            {
                deplaceSansCollisions((Creature)e);
            }
        }
        consommerPotion();
        
        return continuePlaying;
    }
    
    /**
     *  Affiche le monden on séoare affiche qui donne juste les infos en texte et display qui montre de façon visuelle et belle le monde
     */
    public void afficheWorld() {
        for(ElementDeJeu e : elementsDeJeu){
            e.affiche();
        }
    }
    
    public void displayTile(Point2D p) {
        
        int cx = p.getX();
        int cy = p.getY();
        if(cx<0 || cx>=World.tailleX || cy < 0 || cy >= World.tailleY)
        {
            System.out.print("X");
            return;
        }
        if(p.equals(joueur.getPersonnage().getPos()))
        {
            System.out.print("J");
            return;
        }
        for(ElementDeJeu e : elementsDeJeu) {
            if(!p.equals(e.getPos()))
            {
              continue;  
            }
            if(e instanceof Archer)
            {
                System.out.print("A");
                return;
            }
            if(e instanceof Guerrier)
            {
                System.out.print("G");
                return;
            }
            if(e instanceof Paysan)
            {
                System.out.print("F");
                return;
            }
            if(e instanceof Loup)
            {
                System.out.print("W");
                return;
            }
            if(e instanceof Lapin)
            {
                System.out.print("L");
                return;
            }
            if(e instanceof PotionSoin)
            {
                System.out.print("H");
                return;
            }
            if(e instanceof Epee)
            {
                System.out.print("E");
                return;
            }
            if(e instanceof NuageToxique)
            {
                System.out.print("N");
                return;
            }
            if(e instanceof Steroid)
            {
                System.out.print("S");
                return;
            }
            if(e instanceof Pizza)
            {
                System.out.print("P");
                return;
            }
            System.out.print("E");
            return;
        }
        
        System.out.print(" ");
    }
    
    void displayZone(Point2D p, int rayon)
    {
        int px = p.getX();
        int py = p.getY();
        
        //deplacement de la zone selectionne si le point de centre est trop proche d'un bord, on essaie d'avoir au plus 2 rangees de X
        
        px = Math.max(px, rayon-2);
        px = Math.min(px, tailleX-rayon+1);
        
        py = Math.max(py, rayon-2);
        py = Math.min(py, tailleY-rayon+1);
        
        //affichage
        Point2D tileActuelle= new Point2D();
        
        System.out.print(" ");
        for(int dy = -rayon-1; dy <=rayon;dy++)
        {
            System.out.print("- ");
        }
        System.out.println(" ");
        for(int dy = -rayon; dy <=rayon;dy++)
        {
            System.out.print("|");
            for(int dx = -rayon; dx <=rayon;dx++)
            {
                tileActuelle.setPosition(px,py);
                tileActuelle.translate(dx,dy);
                displayTile(tileActuelle);
                
                System.out.print(" ");
            }
            System.out.print("|");
            System.out.println();
        }
        for(int dy = -rayon-1; dy <=rayon;dy++)
        {
            System.out.print("- ");
        }
        System.out.println();
    }
    
    //la strategie que l'on decide de faire pour les deplacements aleatoires c'est que lors de world possède 
    //une fonction déplacement sécurisé qui prend en entrée une creature et applique sa fonction deplacement 
    //de sorte à éviter les collisions
    //on note où se déplace la créature et si elle va sur une case libre on lui demande de se redéplacer
    //renvoie aussi faux si la case est en dehors du monde

    /**
     *  Fonction vérifiant qu'une créature est seule sur sa case ainsi qu'elle soit bien dans les coordonnées du monde
     * @param c créature dont on vérifie si elle est seule ou pas
     * @return boolean vrai si la créature est seule sur sa case
     */
    public boolean estPositionCreatureLegit(Creature c){
        int cx = c.getPos().getX();
        int cy = c.getPos().getY();
        
        if(cx<0 || cx>=World.tailleX || cy < 0 || cy >= World.tailleY)
        {
            return false;
        }
        
        for(ElementDeJeu e : elementsDeJeu)
        {
            if(e.getPos().equals(c.getPos()) && c!=e && e instanceof Creature)
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
                if(!estPositionCreatureLegit(c))
                {
                    //System.out.println("Collision ou sortie de carte detectee en x:" + 
                    //        c.getPos().getX() + " y : " + c.getPos().getY());
                    c.setPos(posMem);
                }
                else
                {
                    return;
                }
        }
    }
    
    //renvoie l'élément de jeu présent sur une case, renvoie null si il n'y en a pas
    //attention la fonction est longue à s'executer
    public ElementDeJeu findElementJeu(Point2D p)
    {
        for(ElementDeJeu e : elementsDeJeu) {
            if(p.equals(e.getPos()))
            {
              return e;
            }
        }
        return null;
    }
}
