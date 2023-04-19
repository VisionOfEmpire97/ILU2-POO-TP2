package controleur;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import personnages.Chef;
import personnages.Gaulois;
import villagegaulois.Village;

class ControlLibererEtalTest {
	private Village village;
	private ControlTrouverEtalVendeur controlTrouverEtalVendeur;
	private ControlPrendreEtal controlPrendreEtal;
	private ControlVerifierIdentite controlVerifierIdentite;
	
	
	@BeforeEach
	public void initialiserSituation() {
		final Chef abraracourcix;
		final Gaulois asterix;
		System.out.println("Initialisation...");
		village = new Village("le village des irréductibles", 10, 5);
		asterix = new Gaulois("Astérix", 8);
		abraracourcix = new Chef("Abraracourcix", 10, village);
		village.setChef(abraracourcix);	
		village.ajouterHabitant(asterix);
	}
	
	@Test
	void testControlLibererEtal() {
		ControlLibererEtal controlLibererEtal = new ControlLibererEtal(controlTrouverEtalVendeur);
		assertNotNull(controlLibererEtal,"constructeur is not null");
	}
	
	@Test
	void testIsVendeur() {
		ControlVerifierIdentite controlVerifierIdentite = new ControlVerifierIdentite(village);
		ControlPrendreEtal controlPrendreEtal = new ControlPrendreEtal(controlVerifierIdentite, village);
		ControlLibererEtal controlLibererEtal = new ControlLibererEtal(controlTrouverEtalVendeur);
		controlPrendreEtal.prendreEtal("Astérix", "baies", 50);
	}

}
