
package frontiere;

import controleur.ControlAcheterProduit;
import personnages.Gaulois;

public class BoundaryAcheterProduit {
	private ControlAcheterProduit controlAcheterProduit;

	public BoundaryAcheterProduit(ControlAcheterProduit controlAcheterProduit) {
		this.controlAcheterProduit = controlAcheterProduit;
	}

	//TODO retirer l'entité et simplifier la méthode
	public void acheterProduit(String nomAcheteur) {
		if (controlAcheterProduit.verifierIdentite(nomAcheteur)) {

			String produit = Clavier.entrerChaine("Quel produit voulez-vous acheter ?");

			Gaulois[] vendeurs = controlAcheterProduit.afficherVendeursProduit(produit);

			if (vendeurs == null || vendeurs.length == 0) {
				System.out.println("Désolé, personne ne vend ce produit au marché.");
			} else {

				System.out.println("Chez quel commerçant voulez-vous acheter des " + produit + " ?\n");
				for (int i = 0; i < vendeurs.length; i++) {
					System.out.println((i + 1) + " - " + vendeurs[i].getNom() + "\n");
				}
				int num = Clavier.entrerEntier("");

				String nomVendeur = vendeurs[num - 1].getNom();
				System.out.println(nomAcheteur + " se déplace jusqu'à l'étal du vendeur " + nomVendeur + "\n");

				int quantiteVolue = Clavier
						.entrerEntier("Bonjour " + nomAcheteur + " \n Combien de fleurs voulez-vous acheter ?\n");
				int quantiteAchete = controlAcheterProduit.acheterProduit(nomVendeur, quantiteVolue);

				if (quantiteAchete == 0) {
					System.out.println(nomAcheteur + " veut acheter " + quantiteVolue + " " + produit
							+ " malheureusement il n’y en a plus !");
				} else {
					if (quantiteVolue > quantiteAchete) {
						System.out.println(nomAcheteur + " veut acheter " + quantiteVolue + " " + produit
								+ " malheureusement " + nomVendeur + " n’en plus que " + quantiteAchete + ".\n");
						System.out.println(nomAcheteur + " achète tout le stock de " + nomVendeur + ".");
					} else {
						System.out.println(
								nomAcheteur + " achète " + quantiteAchete + " " + produit + " à " + nomVendeur + ".");
					}
				}

			}

		} else {
			System.out.println("Je  suis désolée " + nomAcheteur
					+ " mais il faut être un habitant de notre village pour commercer ici.");
		}
	}
}
