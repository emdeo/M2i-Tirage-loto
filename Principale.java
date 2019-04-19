package m2i.formation.javaExercice2;

import java.util.ArrayList;
import java.util.Random;

public class Principale {

	public static void main(String[] args) {
		
		Grille g = new Grille();
		
		g.Ajouter(new Tirage());
		g.Ajouter(new Tirage());
		g.Ajouter(new Tirage(true));
		
		g.Afficher();
	}

}
