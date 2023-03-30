package frontiere;

import java.util.Scanner;

import controleur.ControlAcheterProduit;
import villagegaulois.Etal;

public class BoundaryAcheterProduit {
	private Scanner scan = new Scanner(System.in);
	private ControlAcheterProduit controlAcheterProduit;
	//private BoundaryAfficherMarche boundaryAfficherMarche;

	public BoundaryAcheterProduit(ControlAcheterProduit controlAcheterProduit) {
		this.controlAcheterProduit = controlAcheterProduit;
	}
	 public StringBuilder afficherOptionsAchat(String produitCherche, Etal[] etalVendantProduit) {
		 System.out.println("Chez quel commerçant voulez-vous acheter des " + produitCherche + "?");
		 StringBuilder chaine = new StringBuilder();
		 for (int i = 0; i < etalVendantProduit.length && etalVendantProduit[i] != null; i++) {
				chaine.append(i + " - " + etalVendantProduit[i].getVendeur().getNom() + "\n");
			}
		 return chaine;
	}
	public void acheterProduit(String nomAcheteur) {
		String produitCherche;
		int qteCherchee = -1;
		int etalChoisi = -1;
		Etal[] etalVendantProduit = null;
		//boundaryAfficherMarche.afficherMarche(nomAcheteur);
		if (controlAcheterProduit.verifIdentiteAcheteur(nomAcheteur) && !(controlAcheterProduit.marcheIsEmpty())) {
			do {
				System.out.println("Quel produit voulez-vous achetez ?");
				produitCherche = scan.nextLine();
				try {
					etalVendantProduit = controlAcheterProduit.trouverVendeur(produitCherche);
				} catch (NullPointerException e) {
					System.err.println("Personne ne vend se produit, désolé");
					e.printStackTrace();
				}	
			} while (etalVendantProduit == null) ;
			System.out.println(afficherOptionsAchat(produitCherche, etalVendantProduit));
			while (etalChoisi < 0 || etalChoisi >= etalVendantProduit.length) {
				System.out.println("Choisissez un numéro valide entre 0 et " + (etalVendantProduit.length - 1));
				etalChoisi = scan.nextInt();
			}
			System.out.println(nomAcheteur + " se déplace vers l'étal du vendeur " 
					+ etalVendantProduit[etalChoisi].getVendeur().getNom());
			while (qteCherchee < 0) {
				System.out.println("Combien de " + produitCherche + " souhatiez vous acheter ?");
				qteCherchee = scan.nextInt();
			}
			System.out.println(nomAcheteur + " a acheté " 
					+ controlAcheterProduit.acheterProduit(etalVendantProduit[etalChoisi],qteCherchee) + " à "
					+ etalVendantProduit[etalChoisi].getVendeur().getNom());
		} else {
			System.out.println("VOUUS NE PASSEREEEZ PAAAS");
		}
	}
}

