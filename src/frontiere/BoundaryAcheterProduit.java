
package frontiere;

import controleur.ControlAcheterProduit;
import personnages.Gaulois;

public class BoundaryAcheterProduit {
	private ControlAcheterProduit controlAcheterProduit;

	public BoundaryAcheterProduit(ControlAcheterProduit controlAcheterProduit) {
		this.controlAcheterProduit = controlAcheterProduit;
	}

	public void acheterProduit(String nomAcheteur) {

		if (controlAcheterProduit.verifierIdentite(nomAcheteur)) {

			String produit = Clavier.entrerChaine("Quel produit voulez-vous acheter ?");

			String[] vendeurs = controlAcheterProduit.afficherVendeursProduit(produit);

			if (vendeurs == null) {

				System.out.println("Désolé, personne ne vend ce produit au marché.");

			} else {

				String nomVendeur = controlAcheterProduit.choisirComercant(produit, vendeurs);

				System.out.println(nomAcheteur + " se déplace jusqu'à l'étal du vendeur " + nomVendeur + "\n");

				int quantiteVolue = Clavier
						.entrerEntier("Bonjour " + nomAcheteur + " \n Combien de fleurs voulez-vous acheter ?\n");
				int quantiteAchete = controlAcheterProduit.acheterProduit(nomVendeur, quantiteVolue);

				messageQuantite(quantiteAchete, quantiteVolue, nomAcheteur, nomVendeur, produit);

			}

		} else {
			System.out.println("Je  suis désolée " + nomAcheteur
					+ " mais il faut être un habitant de notre village pour commercer ici.");
		}
	}

	public void messageQuantite(int quantiteAchete, int quantiteVolue, String nomAcheteur, String nomVendeur,
			String produit) {
		if (quantiteAchete == 0) {
			System.out.println(nomAcheteur + " veut acheter " + quantiteVolue + " " + produit
					+ " malheureusement il n’y en a plus !");
		} else {
			if (quantiteVolue > quantiteAchete) {
				System.out.println(nomAcheteur + " veut acheter " + quantiteVolue + " " + produit + " malheureusement "
						+ nomVendeur + " n’en plus que " + quantiteAchete + ".\n");
				System.out.println(nomAcheteur + " achète tout le stock de " + nomVendeur + ".");
			} else {
				System.out
						.println(nomAcheteur + " achète " + quantiteAchete + " " + produit + " à " + nomVendeur + ".");
			}
		}
	}

}
