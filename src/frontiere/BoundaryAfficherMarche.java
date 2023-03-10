package frontiere;

import controleur.ControlAfficherMarche;

public class BoundaryAfficherMarche {
	private ControlAfficherMarche controlAfficherMarche;

	public BoundaryAfficherMarche(ControlAfficherMarche controlAfficherMarche) {
		this.controlAfficherMarche = controlAfficherMarche;
	}

	public void afficherMarche(String nomAcheteur) {
		String[] infosMarche;
		StringBuilder chaine = new StringBuilder();
		infosMarche = controlAfficherMarche.donnerInfosMarche();
		int i = 0;
		if (infosMarche.length == 0) {
			chaine.append("Le marché est vide, revenz plus tard");
		} else {
			chaine.append( nomAcheteur + ", vous trouverez au marché : \n");
			while ( i < infosMarche.length) {
				String vendeur = infosMarche[i];
				i++;
				String quantite = infosMarche[i];
				i++;
				String produit = infosMarche[i];
				i++;
				chaine.append("- " + vendeur + " qui vend " + quantite + " " + produit);
				chaine.append("\n");
			}
		}
		System.out.println(chaine.toString());
	}
}
