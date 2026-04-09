
package frontiere;

import controleur.ControlAcheterProduit;
import controleur.ControlVerifierIdentite;

import java.util.Scanner;

public class BoundaryAcheterProduit {
	private ControlAcheterProduit controlAcheterProduit;
	private ControlVerifierIdentite controlVerifierIdentite;

	public BoundaryAcheterProduit(ControlAcheterProduit controlAcheterProduit) {
		this.controlAcheterProduit = controlAcheterProduit;
	}

	public void acheterProduit(String nomAcheteur) {
		if(controlVerifierIdentite.verifierIdentite(nomAcheteur)) {
			StringBuilder questionn1 = new StringBuilder();
			int choix = 0;
			while(choix != 1 && choix != 2 && choix != 3) {
				questionn1.append("1 - je veux acheter un produit.\n");
				questionn1.append("2 - je veux avoir une vue d'ensemble du marché. \n");
				questionn1.append("3 - quitter l'application. \n");
				choix = Clavier.entrerEntier(questionn1.toString());
			    switch (choix) {
			       case 1 :Scanner produit = new Scanner(System.in);
			    	       System.out.println("Quel produit voulez-vous acheter ?");
			               String produit = produit.nextLine(); 
			       case 2 :
			       case 3 :
			       default : System.out.println("Vous devez choisir le chifre 1 ou 2 ou 3");
			    }
			}
		}else {
			System.out.println("“Je  suis désolée "+nomAcheteur+" mais il faut être un habitant de notre village pour commercer ici.");
		}
	}
}
