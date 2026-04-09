
package frontiere;

import controleur.ControlPrendreEtal;

public class BoundaryPrendreEtal {
	private ControlPrendreEtal controlPrendreEtal;

	public BoundaryPrendreEtal(ControlPrendreEtal controlChercherEtal) {
		this.controlPrendreEtal = controlChercherEtal;
	}
   
	private void installerVendeur(String nomVendeur) {
		StringBuilder question = new StringBuilder();
		question.append("c'est parfait il me rest un étal pour vous!\n");
		question.append("il me faudrait quelques renseignements :\n");
		question.append("Quel produit souhaitez vous vrendre \n");
		String produit = Clavier.entrerChaine(question.toString());
		
		StringBuilder question2 = new StringBuilder();
		question2.append("Combien souhaitez vous en vrendre \n");
		int nbProduit = Clavier.entrerEntier(question2.toString());
		int numeroEtal = controlPrendreEtal.prendreEtal(nomVendeur,produit,nbProduit);
		
		if(numeroEtal != -1) {
			System.out.println("Le vendeur"+nomVendeur+"s'est instalé à l'état n°"+numeroEtal);
		}
	}
	
	public void prendreEtal(String nomVendeur) {
		boolean nomVendeurConnu = controlPrendreEtal.verifierIdentite(nomVendeur);
		if(!nomVendeurConnu) {
			System.out.println("Je suis désolée "+nomVendeur+" mais il faut etre un habitant de notre village pour commencer ici.");
		}else {
			System.out.println("Bonjour "+nomVendeur+" je vais regarder si je peux vous trouver un étal.");
			boolean etalDisponible = controlPrendreEtal.resteEtals();
			if(!etalDisponible) {
				System.out.println("Désolée "+nomVendeur+" je n'ai plus d'étal qui ne soit pas déja occupé.");
			}else {
				installerVendeur(nomVendeur);
			}
		}	
	}

	
}
