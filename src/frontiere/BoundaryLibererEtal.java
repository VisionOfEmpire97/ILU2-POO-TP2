package frontiere;

import controleur.ControlLibererEtal;

public class BoundaryLibererEtal {
	private ControlLibererEtal controlLibererEtal;

	public BoundaryLibererEtal(ControlLibererEtal controlLibererEtal) {
		this.controlLibererEtal = controlLibererEtal;
	}

	public void libererEtal(String nomVendeur) {
		String[] donneesEtal;
		StringBuilder chaine = new StringBuilder();
		if (controlLibererEtal.isVendeur(nomVendeur)) {
			donneesEtal = controlLibererEtal.libererEtal(nomVendeur);
			String produit = donneesEtal[2];
			String quantiteInitial = donneesEtal[3];
			String quantiteVendu = donneesEtal[4];
			if (donneesEtal[0].equals("true")) {
				chaine.append("Vous avez vendu " + quantiteVendu + " sur " + quantiteInitial + " " + produit + ".");
				chaine.append("Au revoir " + nomVendeur + ", passez une bonne journée.\n");
				System.out.println(chaine.toString());
			}
		} else {
			chaine.append("Mais vous n'êtes pas inscrit sur notre marché aujourd'hui!\n");
			System.out.println(chaine.toString());
		}
	}

}
