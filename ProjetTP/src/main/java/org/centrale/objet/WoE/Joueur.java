/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package org.centrale.objet.WoE;
import java.util.Iterator;
import java.util.Scanner;
import java.util.ArrayList;
import java.util.List;
import java.util.Arrays;

/**
 *
 * @author Clément
 */
public class Joueur {
    
    private Personnage personnage;
    private ArrayList<Utilisable> effets;
    private ArrayList<Utilisable> inventaire;

    public Personnage getPersonnage() {
        return personnage;
    }

    public void setPersonnage(Personnage personnage) {
        this.personnage = personnage;
    }

    public ArrayList<Utilisable> getEffets() {
        return effets;
    }

    public void setEffets(ArrayList<Utilisable> effets) {
        this.effets = effets;
    }

    public ArrayList<Utilisable> getInventaire() {
        return inventaire;
    }

    public void setInventaire(ArrayList<Utilisable> inventaire) {
        this.inventaire = inventaire;
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
        this.effets = new ArrayList<>();
        this.inventaire = new ArrayList<>();
        world = null;
    }
    
    public Joueur( Personnage personnage, World world)
    {
        this.personnage = personnage;
        this.effets = new ArrayList<>();
        this.inventaire = new ArrayList<>();
        this.world = world;
    }
    
    public boolean tourJeu()
    {
        updateEffets();
        
        System.out.println("\n| Legende |");
        System.out.println("A : archer");
        System.out.println("E : epee");
        System.out.println("G : geurrier");
        System.out.println("J : joueur");
        System.out.println("L : lapin");
        System.out.println("W : loup");
        System.out.println("N : nuage toxique");
        System.out.println("F : paysan");
        System.out.println("P : pizza");
        System.out.println("H : PointSoin");
        System.out.println("S : steroid");
        
        System.out.println("\n| Map |");
        world.displayZone(personnage.getPos(), 8);
        
        //afficher les donnees du personnage
        System.out.println("\n| Status |");
        System.out.println("HP : " + this.personnage.getPtVie()); 
        System.out.println("Att : " + this.personnage.getDegAtt());
        System.out.println("Att% : " + this.personnage.getPageAtt()); 
        System.out.println("Def : " + this.personnage.getPtPar());
        System.out.println("Def% : " + this.personnage.getPagePar());
        System.out.println("Range : " + this.personnage.getDistAttMax());
        
        System.out.println("\nSelectionner une action, 'C' : Combat, 'D' Deplacer, 'I' Inventaire, 'Q' Quitter");
        
        Scanner sc = new Scanner(System.in);
        String action = "";
        
        List<String> actionsPossible = 
                new ArrayList<>(Arrays.asList("C", "c", "D", "d", "I", "i","Q","q"));
        while(!actionsPossible.contains(action))
        {
            action = sc.nextLine();
            switch (action) {
                case "D", "d" -> deplacementJoueur(sc);
                case "C", "c" -> {if(!combatJoueur(sc))
                {
                    return tourJeu(); 
                }}
                case "I", "i" -> ouvrirInventaireJoueur(sc);
                case "Q", "q" -> {
                    return false;
                }
                default -> System.out.println("Erreur de l'input, veuillez ecrire D, C, I ou Q");
            }
        }
        
        return true;
    }
    
    public void stockerUtilisable(Utilisable u) {
        inventaire.add(u);
    }
    
    public void activeUtilisable(int i) {
        Utilisable u = inventaire.get(i);
        effets.add(u);
        u.utiliser(this.personnage);
        inventaire.remove(i);
    }
    
    public void updateEffets() {
        Iterator<Utilisable> it = this.effets.iterator();
        while (it.hasNext()) {
            Utilisable u = it.next();
            if (u.finDuree()) {
                u.finEffet(this.personnage);
                it.remove();
            }
        }
    }
    
    public void ouvrirInventaireJoueur(Scanner sc)
    {
        if (this.inventaire.isEmpty()) {
            System.out.println("L'inventaire est vide ! Vous passez un tour.");
        } else {
            System.out.println("Ouverture Inventaire : ");
            int i = 0;

            //afficher l'inventaire
            for(Utilisable u : this.inventaire)
            {
                System.out.println("\n| Objet n" + i + " |");
                u.afficheInventaire();
                ++i;
            }

            int targetIndex = -2;
            while(targetIndex < -1 || targetIndex > this.inventaire.size())
            {
                System.out.println("\nChoisissez un item entre 0 et " + (this.inventaire.size()-1) + " ou -1 pour quitter l'inventaire");
                targetIndex = sc.nextInt();
            }
            if (targetIndex != -1) {activeUtilisable(targetIndex);}
        }
    }
    
    public boolean combatJoueur(Scanner sc)
    {
        ArrayList<Creature> cibles =  world.findListeCibleCombattant((Combattant)personnage);
        if(cibles.isEmpty())
        {
            System.out.println("Aucune cible a portee, portee du personnage : " + personnage.getDistAttMax());
            return false;
        }
        
        System.out.println("Liste des " + cibles.size() +" cibles a portee");
        
        int i = 0;
        for(Creature c : cibles)
        {
            System.out.println("\n| Cible n" + i + "|");
            c.affiche();
            ++i;
        }
        
        int targetIndex = -1;
        while(targetIndex < 0 || targetIndex >= cibles.size())
        {
            System.out.println("\nChoisissez une cible entre 0 et " + (cibles.size()-1));
            targetIndex = sc.nextInt();
        }
        ((Combattant)personnage).combattre(cibles.get(targetIndex));
        
        if(cibles.get(targetIndex).getPtVie()<=0)
        {
            world.removeElementDeJeu(cibles.get(targetIndex));
        }
        
        return true;
        /*
        System.out.println("Choisissez une tile a combattre");
        
        boolean flagCorrectAttack = false;
        while(!flagCorrectAttack)
        {            
            Point2D ciblePos = new Point2D();
            Point2D positionPersonnage = personnage.getPos();
            inputCase(sc,ciblePos);

            ciblePos.translate(positionPersonnage.getX(), positionPersonnage.getY());
            
            ElementDeJeu cible = world.findElementJeu(ciblePos);
            
            if(cible instanceof Creature creature)
            {
                ((Combattant)personnage).combattre(creature);
            }
        }
        
        */
    }
    
    public void deplacementJoueur(Scanner sc)
    {
        System.out.println("Choisissez votre deplacement avec une chaine de ZQSD (ex: ZZQ = haut haut bas)");
        
        Point2D delta = new Point2D();
        Point2D posMem = new Point2D(personnage.getPos());
        
        boolean flagCorrectDeplacement = false;
        while(!flagCorrectDeplacement)
        {
            flagCorrectDeplacement = true;
            inputCase(sc,delta);
            int dx = delta.getX();
            int dy = delta.getY();
        
            personnage.getPos().translate(dx, dy);
            
            if(!world.estPositionCreatureLegit(personnage))
            {
                flagCorrectDeplacement = false;
                personnage.getPos().setPosition(posMem.getX(),posMem.getY());
                System.out.println("La case donnee est soit en dehors de la map, soit deja occupee par une autre creature");
            }
        }

    }
    
    public void inputCase(Scanner sc, Point2D delta)
    {
        boolean flagCorrectMovement = false;
        
        while(!flagCorrectMovement)
        {
            flagCorrectMovement = true;
            delta.setPosition(0, 0);
            String deplacement = sc.nextLine();
            
            
            //we read each char of the string and break and ask a new input if a char isn't legit
            OUTER:
            for (int ic = 0; ic < deplacement.length(); ic++) {
                char c = deplacement.charAt(ic);
                switch (c) {
                    case 'Z', 'z' -> delta.translate(0, -1);
                    case 'Q', 'q' -> delta.translate(-1, 0);
                    case 'S', 's' -> delta.translate(0, 1);
                    case 'D', 'd' -> delta.translate(1, 0);
                    default -> {
                        flagCorrectMovement = false;
                        break OUTER;
                    }
                }
            }
            if(!flagCorrectMovement)
            {
                System.out.println("Mauvaise selection de case, il l'input doit etre dans le format 'ZQQSSSSDDDDD' et ne contenir aucun autre characteres");
            }
        }
    }
}
