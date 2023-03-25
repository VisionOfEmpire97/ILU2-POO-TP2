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

	
	public Etal[] trouverVendeur(String produit) {
		Gaulois[] vendeurs = village.rechercherVendeursProduit(produit);
		String[] nomVendeurs = null;
		Etal[] etalVendantProduit = null;
		if (vendeurs != null) {
			for (int i = 0; i < vendeurs.length;i++) {
				nomVendeurs[i] = vendeurs[i].getNom();
				etalVendantProduit[i] =  controlTrouverEtalVendeur.trouverEtalVendeur(nomVendeurs[i]);
			}
		}
		return etalVendantProduit;
	}
	public int acheterProduit(int qteVoulue) {
		int qteAchetee = 0;
		//TODO FINIR DIMPLEMENTER çà
		return qteAchetee;
	}
}
