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
					System.out.println("Bienvenu villageois"+nomVisiteur);
					 StringBuilder question2 = new StringBuilder();
					question2.append("Quelle est votre force :\n");
					int forceDruide= Clavier.entrerEntier(question2.toString());
				default:
					System.out
							.println("Vous devez choisir le chiffre 1 ou 2 !");
					break;
				}
			} while (choixUtilisateur != 1 && choixUtilisateur != 2);
		}
	}

	private void emmenagerDruide(String nomVisiteur) {
		System.out.println("Bienvenu deruide"+nomVisiteur);
		StringBuilder question3 = new StringBuilder();
		question3.append("Quelle est votre force :\n");
		int forceDruide= Clavier.entrerEntier(question3.toString());
		if() {
			StringBuilder question4 = new StringBuilder();
			question4.append("Quelle est la force la plus faible que vous produissez:\n");
			int effetPostionMin= Clavier.entrerEntier(question4.toString());
			
			StringBuilder question5 = new StringBuilder();
			question4.append("Quelle est la force la plus forte que vous produissez:\n");
			int effetPostionMax= Clavier.entrerEntier(question4.toString());
		}
	}
	
}
