package m2i.formation.javaExercice2;

import java.util.ArrayList;
import java.util.Scanner;
import java.util.Random;

public class Tirage {
	private String nom = "Tirage anonyme";
	private ArrayList<Integer> tirage = new ArrayList<Integer>();
	
	
	// CONSTRUCTEUR 1
	public Tirage() {
		// Par d�faut, on cr�e une tirage de 5 num�ros + 1 compl�mentaire
		NouveauTirage();
	}
	
	
	// CONSTRUCTEUR 2
	public Tirage(boolean manuel) {
		// Entr�e manuelle des num�ros
		if (manuel) {
			Scanner sc = new Scanner(System.in);
			System.out.println("Entrez 5 num�ros diff�rents entre 1 et 49 :");
			
			for (int i=0; i<5; i++) {
				int numero;
				do {
					numero = sc.nextInt();
					
					if(Existe(numero))
						System.out.println("Vous avez d�j� entr� ce num�ro");
					else if(numero<1)
						System.out.println("Num�ro trop petit");
					else if(numero>49)
						System.out.println("Num�ro trop grand");
				} while ((Existe(numero)) || (numero<1) || (numero>49));
				
				tirage.add(numero);
			}
			
			System.out.println("Entrez un num�ro compl�mentaire entre 1 et 10 :");
			int numero;
			do {
				numero = sc.nextInt();
				
				if(Existe(numero))
					System.out.println("Vous avez d�j� entr� ce num�ro");
				else if(numero<1)
					System.out.println("Num�ro trop petit");
				else if(numero>10)
					System.out.println("Num�ro trop grand");
			} while ((Existe(numero)) || (numero<1) || (numero>10));
			tirage.add(numero);
		}
		
		// Par d�faut, on cr�e une tirage de 5 num�ros + 1 compl�mentaire
		else
			NouveauTirage();
	}
	
	
	// CONSTRUCTEUR 3 (param�tre : taille de tirage)
	public Tirage(int taille) {
		NouveauTirage(taille);
	}
	
	
	// CONSTRUCTEUR 4 (param�tres : taille de tirage, nom)
	public Tirage(int taille, String nom) {
		this.nom = nom;
		NouveauTirage(taille);
	}
	
	
	public String getNom() {
		return this.nom;
	}

	
	// Affiche contenu de tirage
	public void Afficher() {
		for (int i = 0; i < tirage.size()-1; i++) // Affiche la s�rie de num�ros AVANT le compl�mentaire
			if (tirage.get(i) < 10)
				System.out.print(tirage.get(i)+"   ");
			else
				System.out.print(tirage.get(i)+"  ");
		
		System.out.println("("+tirage.get(tirage.size()-1)+")"); // Affiche le num�ro compl�mentaire
	}
	
	
	// Indique si valeur existe d�j� dans la tirage
	public boolean Existe(int valeur) {
//		return this.tirage.contains(valeur);
		
		for (int elem : this.tirage)
			if (elem == valeur) return true;
		
		return false;
	}
	
	
	// Tire une s�rie de num�ros (TAILLE PAR DEFAUT = 5)
	public void TirageSerie() {
		Random rnd = new Random(); // retourne une valeur comprise entre [0;1]
		
		for (int i=0; i<5; i++) {
			int tirage;
			
			// continue de tirer de nouveaux num�ros tant que tirage est d�j� compris dans tirage
			do {
				tirage = rnd.nextInt(49)+1; // tire un num�ro entre [1;49]
			} while (Existe(tirage));
			
			this.tirage.add(tirage);
		}
	}
	
	
	// Tire une s�rie de num�ros (TAILLE DE SERIE EN PARAMETRE)
	public void TirageSerie(int taille) {
		if (taille < 1)
			throw new java.lang.Error("\n\n\tTaille trop petite, demandez au moins 2 valeurs\n");
		
		Random rnd = new Random(); // retourne une valeur comprise entre [0;1]
		
		for (int i=0; i<taille; i++) {
			int tirage;
			
			// continue de tirer de nouveaux num�ros tant que tirage est d�j� compris dans tirage
			do {
				tirage = rnd.nextInt(48)+1; // tire un num�ro entre [1;48]
			} while (Existe(tirage));
			
			this.tirage.add(tirage);
		}
	}
	
	
	// Tire un num�ro compl�mentaire absent de la tirage
	public void TirageComplementaire() {
		Random rnd = new Random(); // retourne une valeur comprise entre [0;1]
		
		int complementaire;
		do {
			complementaire = rnd.nextInt(10)+1; // tire un num�ro entre [1;10]
		} while (Existe(complementaire));
		
		tirage.add(complementaire);
	}
	
	
	// On r�initialise la tirage avec de nouvelles valeurs
	public void NouveauTirage() {
		tirage.clear(); // on vide le tirage au cas o� elle contenait d�j� des valeurs
		TirageSerie();
		TirageComplementaire();
	}
	
	
	// On r�initialise la tirage (TAILLE DE SERIE EN PARAMETRE)
	public void NouveauTirage(int taille) {
		tirage.clear(); // on vide le tirage au cas o� elle contenait d�j� des valeurs
		TirageSerie(taille-1);
		TirageComplementaire();
	}
	
}




