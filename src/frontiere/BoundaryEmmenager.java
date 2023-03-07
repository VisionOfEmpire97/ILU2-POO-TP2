package frontiere;

import controleur.ControlEmmenager;

public class BoundaryEmmenager {
	private ControlEmmenager controlEmmenager;

	public BoundaryEmmenager(ControlEmmenager controlEmmenager) {
		this.controlEmmenager = controlEmmenager;
	}

	public void emmenager(String nomVisiteur) {
		if (controlEmmenager.isHabitant(nomVisiteur)) {
			System.out.println(
					"Mais vous êtes déjà un habitant du village !");
		} else {
			StringBuilder question = new StringBuilder();
			question.append("Êtes-vous :\n");
			question.append("1 - un druide.\n");
			question.append("2 - un gaulois.\n");
			int choixUtilisateur = -1;
			do {
				choixUtilisateur = Clavier.entrerEntier(question.toString());
				switch (choixUtilisateur) {
				case 1:
					emmenagerDruide(nomVisiteur);
					break;

				case 2:
					emmenagerGaulois(nomVisiteur);
					break;

				default:
					System.out
							.println("Vous devez choisir le chiffre 1 ou 2 !");
					break;
				}
			} while (choixUtilisateur != 1 && choixUtilisateur != 2);
		}
	}

	private void emmenagerDruide(String nomVisiteur) {
		StringBuilder question = new StringBuilder();
		question.append("quelle est votre force ?\n");
		int forceDruide = 0;
		int forcePotionMin = 0;
		int forcePotionMax = 0;
		do {
			forceDruide = Clavier.entrerEntier(question.toString());
		} while (forceDruide < 0);
		do {
			System.out.println("quelle est la force de la potion la plus faible que vous produisez?\n");
			forcePotionMin = Clavier.entrerEntier("");
			System.out.println("quelle est la force de la potion la plus forte que vous produisez?\n");
			forcePotionMax = Clavier.entrerEntier("");
			if (forcePotionMax < forcePotionMin) {
				System.out.println("Attention druide, vous vous êtes trompé entre le minimum et le maximum!\n");
			}
		} while (forcePotionMax < forcePotionMin);
		controlEmmenager.ajouterDruide(nomVisiteur, forceDruide, forcePotionMin, forcePotionMax);
	}
	
		
	private void emmenagerGaulois(String nomVisiteur) {
		StringBuilder question = new StringBuilder();
		int force = 0;
		question.append("Bienvenue visiteur,");
		question.append(nomVisiteur);
		question.append("Quelle est votre force?\n");
		do {
			force = Clavier.entrerEntier(question.toString());
		} while (force < 0);
			
		controlEmmenager.ajouterGaulois(nomVisiteur, force);
	}
}
