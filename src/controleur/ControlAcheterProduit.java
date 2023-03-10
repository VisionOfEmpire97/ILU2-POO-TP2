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

	
	public String[] trouverVendeur(String produit) {
		Gaulois[] vendeurs = village.rechercherVendeursProduit(produit);
		String[] etalVendantProduit = null;
		if (vendeurs != null) {
			for (int i = 0; i < vendeurs.length;i++) {
				etalVendantProduit[i] = vendeurs[i].getNom();
//				etalVendantProduit[i] =  
//						controlTrouverEtalVendeur.trouverEtalVendeur((vendeurs[i].getNom()));
			}
		}
		return etalVendantProduit;
		//TODO FINISH IT
	}
}
