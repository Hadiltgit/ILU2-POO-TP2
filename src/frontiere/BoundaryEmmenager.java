package frontiere;

import controleur.ControlEmmenager;

public class BoundaryEmmenager {
	private ControlEmmenager controlEmmenager;

	public BoundaryEmmenager(ControlEmmenager controlEmmenager) {
		this.controlEmmenager = controlEmmenager;
	}
	
	
	
	public void emmenagerDruide(String nomVisiteur) {
		StringBuilder question1 = new StringBuilder();
		question1.append("Bienvenu druide "+nomVisiteur+"\n");
		question1.append("Quelle est votre force? \n");
		int forceDruide = Clavier.entrerEntier(question1.toString());
		
		int effetPotionMax = 0;
		int effetPotionMin = 0;
		do{
			StringBuilder question2 = new StringBuilder();
			question2.append("Quelle est la force de potion la plus faible que vous produissez?\n");
			effetPotionMin = Clavier.entrerEntier(question1.toString());
			StringBuilder question3 = new StringBuilder();
			question3.append("Quelle est la force de potion la plus forte que vous produissez?\n");
			effetPotionMax = Clavier.entrerEntier(question3.toString());
			if(effetPotionMax<effetPotionMin) {
				System.out.println("Attention Druide, vous vous etes trompe entre le minimum et le maximum\n");	
			}
		}while(effetPotionMax<effetPotionMin);
	
		controlEmmenager.ajouterDruide(nomVisiteur, forceDruide, effetPotionMin, effetPotionMax);
   }

	public void emmenager(String nomVisiteur) {
		
		if (controlEmmenager.isHabitant(nomVisiteur)) {
			System.out.println(	"Mais vous êtes déjà un habitant du village !");
		} else {
			int choixUtilisateur = 0;
			do {
				StringBuilder question = new StringBuilder();
				question.append("Êtes-vous :\n");
				question.append("1 - un druide.\n");
				question.append("2 - un gaulois.\n");
				choixUtilisateur = Clavier.entrerEntier(question.toString());
				if(choixUtilisateur == 1) {
					   emmenagerDruide(nomVisiteur);
				}else {
					if(choixUtilisateur == 2) {
						StringBuilder questionn1 = new StringBuilder();
						questionn1.append("Bienvenu villageois "+nomVisiteur+"\n");
						questionn1.append("Quelle est votre force? \n");
						int force = Clavier.entrerEntier(questionn1.toString());
						controlEmmenager.ajouterGaulois(nomVisiteur , force);
					}else {
						System.out.println("Voud devez choisir le chifre 1 ou 2!");
					}
			   }
			}while(choixUtilisateur != 1 && choixUtilisateur!=2);
		}
	}
}
