package m2i.formation.javaExercice2;

import java.util.ArrayList;
import java.util.Scanner;
import java.util.Random;

public class Tirage {
	private String nom = "Tirage anonyme";
	private ArrayList<Integer> tirage = new ArrayList<Integer>();
	
	
	// CONSTRUCTEUR 1
	public Tirage() {
		// Par défaut, on crée une tirage de 5 numéros + 1 complémentaire
		NouveauTirage();
	}
	
	
	// CONSTRUCTEUR 2
	public Tirage(boolean manuel) {
		// Entrée manuelle des numéros
		if (manuel) {
			Scanner sc = new Scanner(System.in);
			System.out.println("Entrez 5 numéros différents entre 1 et 49 :");
			
			for (int i=0; i<5; i++) {
				int numero;
				do {
					numero = sc.nextInt();
					
					if(Existe(numero))
						System.out.println("Vous avez déjà entré ce numéro");
					else if(numero<1)
						System.out.println("Numéro trop petit");
					else if(numero>49)
						System.out.println("Numéro trop grand");
				} while ((Existe(numero)) || (numero<1) || (numero>49));
				
				tirage.add(numero);
			}
			
			System.out.println("Entrez un numéro complémentaire entre 1 et 10 :");
			int numero;
			do {
				numero = sc.nextInt();
				
				if(Existe(numero))
					System.out.println("Vous avez déjà entré ce numéro");
				else if(numero<1)
					System.out.println("Numéro trop petit");
				else if(numero>10)
					System.out.println("Numéro trop grand");
			} while ((Existe(numero)) || (numero<1) || (numero>10));
			tirage.add(numero);
		}
		
		// Par défaut, on crée une tirage de 5 numéros + 1 complémentaire
		else
			NouveauTirage();
	}
	
	
	// CONSTRUCTEUR 3 (paramètre : taille de tirage)
	public Tirage(int taille) {
		NouveauTirage(taille);
	}
	
	
	// CONSTRUCTEUR 4 (paramètres : taille de tirage, nom)
	public Tirage(int taille, String nom) {
		this.nom = nom;
		NouveauTirage(taille);
	}
	
	
	public String getNom() {
		return this.nom;
	}

	
	// Affiche contenu de tirage
	public void Afficher() {
		for (int i = 0; i < tirage.size()-1; i++) // Affiche la série de numéros AVANT le complémentaire
			if (tirage.get(i) < 10)
				System.out.print(tirage.get(i)+"   ");
			else
				System.out.print(tirage.get(i)+"  ");
		
		System.out.println("("+tirage.get(tirage.size()-1)+")"); // Affiche le numéro complémentaire
	}
	
	
	// Indique si valeur existe déjà dans la tirage
	public boolean Existe(int valeur) {
//		return this.tirage.contains(valeur);
		
		for (int elem : this.tirage)
			if (elem == valeur) return true;
		
		return false;
	}
	
	
	// Tire une série de numéros (TAILLE PAR DEFAUT = 5)
	public void TirageSerie() {
		Random rnd = new Random(); // retourne une valeur comprise entre [0;1]
		
		for (int i=0; i<5; i++) {
			int tirage;
			
			// continue de tirer de nouveaux numéros tant que tirage est déjà compris dans tirage
			do {
				tirage = rnd.nextInt(49)+1; // tire un numéro entre [1;49]
			} while (Existe(tirage));
			
			this.tirage.add(tirage);
		}
	}
	
	
	// Tire une série de numéros (TAILLE DE SERIE EN PARAMETRE)
	public void TirageSerie(int taille) {
		if (taille < 1)
			throw new java.lang.Error("\n\n\tTaille trop petite, demandez au moins 2 valeurs\n");
		
		Random rnd = new Random(); // retourne une valeur comprise entre [0;1]
		
		for (int i=0; i<taille; i++) {
			int tirage;
			
			// continue de tirer de nouveaux numéros tant que tirage est déjà compris dans tirage
			do {
				tirage = rnd.nextInt(48)+1; // tire un numéro entre [1;48]
			} while (Existe(tirage));
			
			this.tirage.add(tirage);
		}
	}
	
	
	// Tire un numéro complémentaire absent de la tirage
	public void TirageComplementaire() {
		Random rnd = new Random(); // retourne une valeur comprise entre [0;1]
		
		int complementaire;
		do {
			complementaire = rnd.nextInt(10)+1; // tire un numéro entre [1;10]
		} while (Existe(complementaire));
		
		tirage.add(complementaire);
	}
	
	
	// On réinitialise la tirage avec de nouvelles valeurs
	public void NouveauTirage() {
		tirage.clear(); // on vide le tirage au cas où elle contenait déjà des valeurs
		TirageSerie();
		TirageComplementaire();
	}
	
	
	// On réinitialise la tirage (TAILLE DE SERIE EN PARAMETRE)
	public void NouveauTirage(int taille) {
		tirage.clear(); // on vide le tirage au cas où elle contenait déjà des valeurs
		TirageSerie(taille-1);
		TirageComplementaire();
	}
	
}




