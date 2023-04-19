package controleur;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import personnages.Chef;
import personnages.Gaulois;
import villagegaulois.Village;

class ControlTrouverEtalVendeurTest {
	private Village village;
	private ControlPrendreEtal controlPrendreEtal;
	private ControlVerifierIdentite controlVerifierIdentite;
	
	@BeforeEach
	public void initialiserSituation() {
		final Chef abraracourcix;
		System.out.println("Initialisation...");
		village = new Village("le village des irréductibles", 10, 5);
		abraracourcix = new Chef("Abraracourcix", 10, village);
		village.setChef(abraracourcix);
	}
	
	@Test
	void testControlTrouverEtalVendeur() {
		ControlTrouverEtalVendeur controlTrouverEtalVendeur = new ControlTrouverEtalVendeur(village);
		assertNotNull(controlTrouverEtalVendeur, "constructeur is not null");
	}
	@Test
	void testTrouverEtalVendeur() {
		ControlTrouverEtalVendeur controlTrouverEtalVendeur = new ControlTrouverEtalVendeur(village);
		ControlPrendreEtal controlPrendreEtal = new ControlPrendreEtal(controlVerifierIdentite, village);
		Gaulois bonemine = new Gaulois("Bonemine", 4);
		village.ajouterHabitant(bonemine);
		controlPrendreEtal.prendreEtal("Bonemine", "truites", 50);
		assertEquals("true",(controlTrouverEtalVendeur.trouverEtalVendeur("Bonemine").etatEtal())[0]);
		assertEquals("Bonemine",(controlTrouverEtalVendeur.trouverEtalVendeur("Bonemine").etatEtal())[1]);
		assertEquals("truites",(controlTrouverEtalVendeur.trouverEtalVendeur("Bonemine").etatEtal())[2]);
		assertNotEquals("Astérix",(controlTrouverEtalVendeur.trouverEtalVendeur("Bonemine").etatEtal())[1]);
	}

}
