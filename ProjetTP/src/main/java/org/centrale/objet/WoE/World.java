/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package org.centrale.objet.WoE;
import java.util.Random;
import java.util.ArrayList;
import java.util.Iterator;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Arrays;
import java.util.List;
import java.util.StringTokenizer;
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
    
    public boolean loafFromFile(String nomFichier)
    {

        List<String> creatures = 
            new ArrayList<>(Arrays.asList("Archer", "Paysan", "Guerrier","Lapin","Loup"));
        List<String> objets = 
            new ArrayList<>(Arrays.asList("Epee", "NuageToxique", "Pizza","PotionSoin","Steroid"));
        
        File file = new File(nomFichier);
        FileReader reader=null;
        try{
            reader = new FileReader(file);
        }
        catch(IOException e){
          System.out.println("erreur de lecture du fichier");
          return false;
        }
        elementsDeJeu.clear();
        try {
            
            BufferedReader buffReader = new BufferedReader(reader);
            int x = 0;
            String s;
            while((s = buffReader.readLine()) != null){
                processLineLoading(s,creatures,objets);
            }
        }
        catch(IOException e){
          System.out.println("erreur de lecture du fichier");
          return false;
        }
        return true;
    }
    
    public void processLineLoading(String line,List<String> creatures,List<String> objets)
    {
        String separator = " ";
        
        StringTokenizer tokens = new StringTokenizer(line, separator);
        if(!tokens.hasMoreTokens())
            return;
        
        String type = tokens.nextToken();
        
        if(creatures.contains(type))
        {
            int posX=Integer.parseInt(tokens.nextToken());
            int posY=Integer.parseInt(tokens.nextToken());
            int ptVie=Integer.parseInt(tokens.nextToken());
            int degAtt=Integer.parseInt(tokens.nextToken());
            int ptPar=Integer.parseInt(tokens.nextToken());
            int pageAtt=Integer.parseInt(tokens.nextToken());
            int pagePar=Integer.parseInt(tokens.nextToken());
            
            Creature nouvelleCreature = switch (type) {
                case "Archer"-> new Archer(10, "Alex", ptVie, degAtt, ptPar, pageAtt, 2, pagePar, new Point2D(posX,posY));
                case "Paysan" -> new Paysan("Alex", ptVie, degAtt, ptPar, pageAtt, 2, pagePar, new Point2D(posX,posY));
                case "Lapin" -> new Lapin(ptVie, degAtt, ptPar, pageAtt, 2, pagePar, new Point2D(posX,posY));
                case "Guerrier" -> new Guerrier("Alex", ptVie, degAtt, ptPar, pageAtt, 2, pagePar, new Point2D(posX,posY));
                case "Loup" -> new Loup(ptVie, degAtt, ptPar, pageAtt, 2, pagePar, new Point2D(posX,posY));
                default -> new Paysan();
            };
            elementsDeJeu.add(nouvelleCreature);
        }
        else if(objets.contains(type))
        {
            int posX=Integer.parseInt(tokens.nextToken());
            int posY=Integer.parseInt(tokens.nextToken());
            int valEffet1=Integer.parseInt(tokens.nextToken());
            int valEffet2=Integer.parseInt(tokens.nextToken());
            int duree=Integer.parseInt(tokens.nextToken());
            
            Objet nouveeauObjet = switch (type) {
                case "Epee"-> new Epee(new Point2D(posX,posY),valEffet1,duree);
                case "NuageToxique" -> new NuageToxique(new Point2D(posX,posY),valEffet1);
                case "Pizza" -> new Pizza(valEffet1,new Point2D(posX,posY),duree);
                case "PotionSoin" -> new PotionSoin(new Point2D(posX,posY),valEffet1);
                case "Steroid" -> new Steroid(new Point2D(posX,posY),duree,valEffet1,valEffet2);
                default -> new PotionSoin();
            };
            elementsDeJeu.add(nouveeauObjet);
        }
        else if(type.equals("Joueur"))
        {
            int posX=Integer.parseInt(tokens.nextToken());
            int posY=Integer.parseInt(tokens.nextToken());
            int ptVie=Integer.parseInt(tokens.nextToken());
            int degAtt=Integer.parseInt(tokens.nextToken());
            int ptPar=Integer.parseInt(tokens.nextToken());
            int pageAtt=Integer.parseInt(tokens.nextToken());
            int pagePar=Integer.parseInt(tokens.nextToken());
            int nbFleches=Integer.parseInt(tokens.nextToken());
            
            Personnage persoJoueur = new Archer(nbFleches, "Legolas", ptVie, degAtt, ptPar, pageAtt, 2, pagePar, new Point2D(posX,posY));
            joueur.setPersonnage(persoJoueur);
        }
    }
    
    public boolean saveToFile(String nomFichier)
    {
        BufferedWriter bufferedWriter=null;

        try {
            bufferedWriter = new BufferedWriter(new FileWriter(nomFichier));
            // On ecrit dans le fichier
            for(ElementDeJeu e : elementsDeJeu) {
                bufferedWriter.write(elementDeJeuToString(e));
                bufferedWriter.newLine();
            }
            bufferedWriter.write("Joueur "+joueur.getPersonnage().getPos().getX()+" "+joueur.getPersonnage().getPos().getY()+" "
                    +joueur.getPersonnage().getPtVie()+" "+joueur.getPersonnage().getDegAtt()+" "+joueur.getPersonnage().getPtPar()+" "
                    +joueur.getPersonnage().getPageAtt()+" "+joueur.getPersonnage().getPagePar()+" "+((Archer)joueur.getPersonnage()).getNbFleches()+" ");
            bufferedWriter.newLine();

        }
            // on attrape l'exception si on a pas pu creer le fichier
            catch (FileNotFoundException ex) {
            }

            // on attrape l'exception si il y a un probleme lors de l'ecr
            catch (IOException ex) {
            }
        // on ferme le fichier
        finally {
            try {
                if (bufferedWriter!=null) {
                // je force l'écriture dans le fichier
                bufferedWriter.flush();
                // puis je le ferme
                bufferedWriter.close();
            }}
            catch(IOException ex)
            {
                return false;
            }
        }
        return true;
    }

    public String elementDeJeuToString(ElementDeJeu e)
    {
        if(e instanceof Creature c)
        {
            String stats = c.getPos().getX()+" "+c.getPos().getY()+" "+c.getPtVie()+" "+c.getDegAtt()+
                    " "+c.getPtPar()+" "+c.getPageAtt()+" "+c.getPagePar()+" ";
            switch (c) {
            case Archer a -> {return ("Archer " + stats); }
            case Lapin b ->  {return ("Lapin " + stats); }
            case Loup l ->  {return ("Loup " + stats); }
            case Guerrier d ->  {return ("Guerrier " + stats); }
            case Paysan s ->  {return ("Paysan " + stats); }
            default ->  {return ("Paysan " + stats); }
            }  
        }
        if(e instanceof Objet o)
        {
            String pos = o.getPos().getX()+" "+o.getPos().getY()+" ";
            switch (o) {
            case Epee s -> {return ("Epee " + pos + s.getBonusDegAtt() + " 0 " + s.getDuree()); }
            case NuageToxique n ->  {return ("NuageToxique " + pos +n.getDegAtt() + " 0 0" ); }
            case Pizza p ->  {return ("Pizza " + pos + p.getBonusPageAtt() + " 0 " + p.getDuree()); }
            case PotionSoin p ->  {return ("PotionSoin " + pos + p.getBonusPtVie() + " 0 0"); }
            case Steroid s ->  {return ("Steroid " + pos + s.getBonusDegAtt() + " " + s.getMalusPtVie() + " " + s.getDuree()); }
            default ->  {return ("PotionSoin " + " 5 0 0"); }
            }  
        }
        return "";
    }
    
    /**
     *  Créer une créature aléatoire, elle est de type aléatoire (loup, paysan, archer , ...)
     *  Elle possède une position aléatoire sur la carte ainsi qu'un nombre de hp aléatoire.
     */
    public void creerCreatureAlea(){
        Random generateur = new Random();
        
        int idClasse = generateur.nextInt(0,5);
        Creature nouvelleCreature;
        
        nouvelleCreature = switch (idClasse) {
            case 0 -> new Archer();
            case 1 -> new Paysan();
            case 2 -> new Lapin();
            case 3 -> new Guerrier();
            case 4 -> new Loup();
            default -> new Paysan();
        };
        
        nouvelleCreature.getPos().setPosition(generateur.nextInt(1,tailleX), generateur.nextInt(1,tailleY));
        nouvelleCreature.setPtVie(generateur.nextInt(2,10));
        elementsDeJeu.add(nouvelleCreature);
    }
    
    /**
     *  Créer un objet aléatoire, elle est de type aléatoire (nourriture, potionSoin, ...)
     *  Elle possède une position aléatoire sur la carte.
     */
    public void creerObjetAlea(){
        Random generateur = new Random();
        
        int idClasse = generateur.nextInt(0,3);
        Objet nouvelleObjet;
        
        nouvelleObjet = switch (idClasse) {
            case 0 -> new Epee();
            case 1 -> new PotionSoin();
            case 2 -> new Pizza();
            default -> new Steroid();
        };
        
        nouvelleObjet.getPos().setPosition(generateur.nextInt(0,tailleX), generateur.nextInt(0,tailleY));
        elementsDeJeu.add(nouvelleObjet);
    }
    
    /**
     *  Création d'un monde random, pour le moment il contient un certain nombre de potion ainsi qu'un certain nombre 
     * de créatures aléatoires
     */
    public void creerMondeAlea() {
        //Creation des créatures aléatoires
        for(int icrea=0;icrea<100;icrea++)
        {
            creerCreatureAlea();
        }
        
        //Creation des objets aléatoires
        for(int iobj=0;iobj<50;iobj++)
        {
            creerObjetAlea();
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
    }
    
    /**
     * Calcul le nombre de point de vie total des créatures du monde avec un parcours sur la taille
     * @return pv totaux
     */
    public int calculPointsDeVieTotauxTaille(){
        int pvtotaux = 0;
        for(int i=0; i<elementsDeJeu.size();i++)
        {   
            if(elementsDeJeu.get(i) instanceof Creature creature)
            {
                pvtotaux+=creature.getPtVie();
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
            if (e instanceof Creature)
            {
                pvtotaux+=((Creature)e).getPtVie();
            }
        }
        return pvtotaux;
    }
    
    /**
     *  Fonction réalisant un tour du jeu, pour le moment chaque personnage se déplace
     * et les postions consomables sont consommées
     * @return .
     */
    public boolean tourDeJeu() {
        
        System.out.println("-----------Debut tour du joueur-----------\n");
        int continuePlaying;
        continuePlaying = joueur.tourJeu();
        
        System.out.println("------------Fin tour du joueur------------\n");
        if(continuePlaying==1) return true;
        if(continuePlaying==2) return false;
        System.out.println("------------Debut tour des pnj------------\n");
        
        
        int mempvJoueur = joueur.getPersonnage().getPtVie();
        
        Random generateur = new Random();
        for(ElementDeJeu e : elementsDeJeu) {
            //deplacements
            if(e instanceof Creature creature)
            {
                deplaceSansCollisions(creature);
            }
            
            //attaques
            int attaque = generateur.nextInt(0,101);
            int seuilAttaque = 20;
            if(e instanceof Combattant c && attaque<seuilAttaque)
            {
                //attaque d'un png
                ArrayList<Creature> cibles =  this.findListeCibleCombattant(c);
                if(cibles.isEmpty())
                {
                    continue;
                }
                int targetIndex = generateur.nextInt(0,cibles.size());
                c.combattre(cibles.get(targetIndex));
        
            }
        }
        
        //remove all dead pnj
        Iterator<ElementDeJeu> iter = elementsDeJeu.iterator();
        while (iter.hasNext()) {
          ElementDeJeu e = iter.next();
          if (e instanceof Personnage p) 
          {
              if(p.getPtVie()<=0)
              {
                    iter.remove();
                    System.out.println("\nUn pnj a tue un autre pnj");
              }
          }
        }
        
        System.out.println("-------------Fin tour des pnj-------------\n");
        int pvJoueur = joueur.getPersonnage().getPtVie();
        if(pvJoueur<mempvJoueur)
        {
            System.out.println("Vous avez ete attaque par un pnj\n");
            System.out.println("Vous aviez " + mempvJoueur + " hp et vous en avez maintenant " + pvJoueur);
        }
        
        if(pvJoueur<=0)
        {
            System.out.println("Game Over, votre personnage n'a plus de points de vie");
            return false;
        }
        
        return true;
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
        
        //loop that display the elements present on the tile
        for(ElementDeJeu e : elementsDeJeu) {
            if(!p.equals(e.getPos()))
            {
              continue;  
            }

            e.display();
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
    //attention la fonction est longue à s'executer, pourrait s'accélérer en ayant une map des personnages selon leurs positions
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
    
    public ArrayList<Creature> findListeCibleCombattant(Combattant c)
    {
        ArrayList<Creature> cibles = new ArrayList<>();
        
        int portee = c.getDistAttMax();
        Point2D pos = c.getPos();
        int px=pos.getX();
        int py = pos.getY();
        
        Point2D iTile = new Point2D();
        
        for(int dy = -portee; dy <=portee;dy++)
        {
            for(int dx = -portee; dx <=portee;dx++)
            {
                iTile.setPosition(px+dx, py+dy);
                //check distance puis ajout à la liste
                if(pos.distance(iTile)<=portee && !pos.equals(iTile))
                {
                    ElementDeJeu e = findElementJeu(iTile);
                    if(e instanceof Creature ic)
                    {
                        cibles.add(ic);
                    }
                }
            }
        }
        return cibles;
    }
    
    public void removeElementDeJeu(ElementDeJeu e)
    {
        elementsDeJeu.remove(e);
    }
}
