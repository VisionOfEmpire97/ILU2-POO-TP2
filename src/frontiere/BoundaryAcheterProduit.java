package frontiere;

import java.util.Scanner;

import controleur.ControlAcheterProduit;
import villagegaulois.Etal;

public class BoundaryAcheterProduit {
	private Scanner scan = new Scanner(System.in);
	private ControlAcheterProduit controlAcheterProduit;

	public BoundaryAcheterProduit(ControlAcheterProduit controlAcheterProduit) {
		this.controlAcheterProduit = controlAcheterProduit;
	}

	public void acheterProduit(String nomAcheteur) {
		StringBuilder chaine = new StringBuilder();
		String produitCherche;
		String[] etalVendantProduit = null;
		if (controlAcheterProduit.verifIdentiteAcheteur(nomAcheteur)) {
			System.out.println("Quel produit voulez-vous achetez ?");
			produitCherche = scan.nextLine();
			etalVendantProduit = controlAcheterProduit.trouverVendeur(produitCherche);
				System.out.println("Chez quel commerçant voulez-vous acheter des " + produitCherche + "?");
				//TODO FINISH THIS
		} else {
			System.out.println("VOUUS NE PASSEREEEZ PAAAS");
		}
	}
}
