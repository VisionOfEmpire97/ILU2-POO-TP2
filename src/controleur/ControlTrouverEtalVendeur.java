package controleur;

import villagegaulois.Etal;
import villagegaulois.Village;
import personnages.*;

public class ControlTrouverEtalVendeur {
	private Village village;

	public ControlTrouverEtalVendeur(Village village) {
		this.village = village;
	}

	public Etal trouverEtalVendeur(String nomVendeur) {
		Etal etal = null;
		Gaulois vendeur = village.trouverHabitant(nomVendeur);
		if (vendeur != null) {
		etal = village.rechercherEtal(vendeur);	
		}
		return etal;
	}
}
