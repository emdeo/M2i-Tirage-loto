package m2i.formation.javaExercice2;

import java.util.ArrayList;

public class Grille {
	private ArrayList<Tirage> grilleLoto = new ArrayList<Tirage>();
	
	// CONSTRUCTEUR 1
	public Grille() {
		// Vide
	}
	
	// CONSTRUCTEUR 2 (tirage en paramètre)
	public Grille(ArrayList<Tirage> grilleLoto) {
		this.grilleLoto = grilleLoto;
	}
	
	public Tirage getIndex(int pos) {
		return grilleLoto.get(pos);
	}
	
	public void Ajouter(Tirage t) {
		this.grilleLoto.add(t);
	}
	
	public void Afficher() {
		System.out.println("Une grille Loto :");
		for (Tirage elem : grilleLoto)
			elem.Afficher();
	}
}
