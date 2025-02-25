package controleur;

import personnages.Gaulois;
import villagegaulois.Etal;
import villagegaulois.Village;

public class ControlAcheterProduit {
	private Village village;
	private ControlTrouverEtalVendeur controlTrouverEtalVendeur;
	private ControlVerifierIdentite controlVerifierIdentite;

	public ControlAcheterProduit(ControlVerifierIdentite controlVerifierIdentite,
			ControlTrouverEtalVendeur controlTrouverEtalVendeur,
			Village village) {
		this.village = village;
		this.controlVerifierIdentite = controlVerifierIdentite;
		this.controlTrouverEtalVendeur = controlTrouverEtalVendeur;
	}

	public boolean verifIdentiteAcheteur(String nomAcheteur) {
		return controlVerifierIdentite.verifierIdentite(nomAcheteur);
	}
	
	public boolean marcheIsEmpty() {
		return ((village.donnerEtatMarche()).length == 0);
	}

	
	public Etal[] trouverVendeur(String produit) throws NullPointerException {
		Gaulois[] vendeurs = village.rechercherVendeursProduit(produit);
		String[] nomVendeurs = new String[vendeurs.length + 1];
		Etal[] etalVendantProduit = new Etal[vendeurs.length + 1];
		if (vendeurs != null) {
			for (int i = 0; i < vendeurs.length;i++) {
				nomVendeurs[i] = vendeurs[i].getNom();
				etalVendantProduit[i] =  controlTrouverEtalVendeur.trouverEtalVendeur(nomVendeurs[i]);
			}
		}
		return etalVendantProduit;
	}
	public int acheterProduit(Etal etalChoisi,int qteVoulue) {
		return etalChoisi.acheterProduit(qteVoulue);
	}
}
