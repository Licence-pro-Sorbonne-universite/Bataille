import java.util.ArrayList;
import java.util.*;
import java.util.Collections;

public class Bataille {

	public static void main(String[] args) {
		
		//Ajouter un paquet de carte qui a toutes les cartes du paquet
	
		    ArrayList<Carte> paquetCartes = new ArrayList<Carte>();
		    for (int couleur = 0; couleur <= 3; couleur++) {
		      for (int valeur = 1; valeur <= 13; valeur++) {
		    	  paquetCartes.add(new Carte(valeur, couleur));
		      }
            System.out.println(paquetCartes.toString());  //Vérification
		}
		    
		//Mélanger le paquet, remplace Math random 
		Collections.shuffle(paquetCartes);
		    
		//Créer les deux paquets 
		ArrayList<Carte> paquet1 = new ArrayList<Carte>();
		ArrayList<Carte> paquet2 = new ArrayList<Carte>();    

		//Distribuer les cartes 
		for (int i=0; i< paquetCartes.size() / 2; i++) {
			paquet1.add(paquetCartes.get(i));
			paquet2.add(paquetCartes.get(i + paquetCartes.size() / 2));
		}
		System.out.println(paquet1.toString()); //Vérification
		System.out.println(paquet2.toString()); //Vérification
		
		//Ajouter 2 joueurs 
		Joueur joueur1 = new Joueur(paquet1);
		Joueur joueur2 = new Joueur(paquet2);
				
		// La partie 
		jouerPartie(joueur1, joueur2);
		int points1 = joueur1.getPoints();
		int points2 = joueur2.getPoints();

		if(points1 > points2) {
			System.out.println("Le " + joueur1.toString() + " mène avec " + points1 + " points");		
		
		}else {
			System.out.println("Le " + joueur2.toString() + " mène avec " + points2 + " points");		

		}
				
	}
	
	
	
	public static void jouerPartie(Joueur joueur1, Joueur joueur2) {
		while (joueur1.resteDansPaquet() == true && joueur2.resteDansPaquet() == true) {
			
			Carte carteJ1 = joueur1.tireCarte();
			Carte carteJ2 = joueur2.tireCarte();
			
			//Comparaison des cartes tirées 
			if(carteJ1.comparerA(carteJ2) == 1) {
				joueur1.ajouteCarte(carteJ1, carteJ2);
				System.out.println("Joueur 1 gagne cette manche");

				
			}else if (carteJ1.comparerA(carteJ2) == -1) {
				
				joueur2.ajouteCarte(carteJ2, carteJ1);
				System.out.println("Joueur 2 gagne cette manche");
				
			}else if (carteJ1.comparerA(carteJ2) == 0){
				//Bataille
				System.out.println("Bataille!");
				
			}
			
		}
	}
	
	public static void bataille(Joueur joueur1, Joueur joueur2 ) {
		//Vérifier si encore des cartes dans le tas 
		//Retirer des cartes
		//Les comparer 
		if(joueur1.resteDansPaquet() == true && joueur2.resteDansPaquet() == true) {
			Carte carteJ1 = joueur1.tireCarte();
			Carte carteJ2 = joueur2.tireCarte();
			
			//Comparaison des cartes tirées 
			if(carteJ1.comparerA(carteJ2) == 1) {
				joueur1.ajouteCarte(carteJ1, carteJ2);
				
			}else if (carteJ1.comparerA(carteJ2) == -1) {
				
				joueur2.ajouteCarte(carteJ2, carteJ1);
				
			}else if (carteJ1.comparerA(carteJ2) == 0){
				joueur1.ajouteCarteEgalite(carteJ1);
				joueur1.ajouteCarteEgalite(carteJ2);
				System.out.println("Egalité, les cartes sont remises dans chaque paquet respectif");
			}
		}
	}

}
