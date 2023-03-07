package frontiere;

import java.util.Scanner;

import controleur.ControlPrendreEtal;
import controleur.ControlVerifierIdentite;

public class BoundaryPrendreEtal {
	private ControlPrendreEtal controlPrendreEtal;
	private Scanner scan = new Scanner(System.in);

	public BoundaryPrendreEtal(ControlPrendreEtal controlChercherEtal) {
		this.controlPrendreEtal = controlChercherEtal;
	}

	public void prendreEtal(String nomVendeur) {
		if (controlPrendreEtal.verifierIdentite(nomVendeur)) {
			System.out.println("Bonjour"  + nomVendeur + "je vais regarder " + 
					" si je peux vous trouver un étal");	
			if (controlPrendreEtal.resteEtals()) {
				installerVendeur(nomVendeur);
			} else {
				System.out.println("Désolé" + nomVendeur +
						"je n'ai plus d'étal non occupé");
			}
		} else {
			System.out.println("Je suis désolé" + nomVendeur + "je vais regarder" + 
					"si je peux vous trouver un étal");
		}
	}

	private void installerVendeur(String nomVendeur) {
		System.out.println("C'est parfait, il me reste un étal pour vous!\n");
		System.out.println("Il me faudrait quelques renseignements: \n");
		System.out.println("quel produit souhaitez vous vendre ?");
		String produit = scan.next();
		int nbProduits = 0;
		do {
			System.out.println("combien souhaitez vous en vendre?");
			nbProduits = scan.nextInt();
		} while (nbProduits <= 0);
		int numeroEtal = controlPrendreEtal.prendreEtal(nomVendeur, produit, nbProduits);
		if (numeroEtal != -1) {
			System.out.println("Le vendeur " + nomVendeur + " s'est installé à l'étal n°" + numeroEtal);
		};
	}
	
}
