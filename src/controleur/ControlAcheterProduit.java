
package controleur;

import villagegaulois.Village;
import villagegaulois.Etal;
import frontiere.Clavier;
import personnages.Gaulois;

public class ControlAcheterProduit {
	private Village village;
	private ControlTrouverEtalVendeur controlTrouverEtalVendeur;
	private ControlVerifierIdentite controlVerifierIdentite;

	public ControlAcheterProduit(ControlVerifierIdentite controlVerifierIdentite,
			ControlTrouverEtalVendeur controlTrouverEtalVendeur, Village village) {
		this.village = village;
		this.controlVerifierIdentite = controlVerifierIdentite;
		this.controlTrouverEtalVendeur = controlTrouverEtalVendeur;
	}

	public boolean verifierIdentite(String nomAcheteur) {
		return controlVerifierIdentite.verifierIdentite(nomAcheteur);
	}

	public String[] afficherVendeursProduit(String produit) {
		Gaulois[] vendeurs = village.rechercherVendeursProduit(produit);

		if (vendeurs == null)
			return null;

		String[] noms = new String[vendeurs.length];
		for (int i = 0; i < vendeurs.length; i++) {
			noms[i] = vendeurs[i].getNom();
		}
		return noms;
	}

	public int acheterProduit(String nomVendeur, int quantite) {
		Etal etal = controlTrouverEtalVendeur.trouverEtalVendeur(nomVendeur);
		return etal.acheterProduit(quantite);
	}

	public String choisirComercant(String produit, String[] vendeurs) {

		System.out.println("Chez quel commerçant voulez-vous acheter des " + produit + " ?\n");
		for (int i = 0; i < vendeurs.length; i++) {
			System.out.println((i + 1) + " - " + vendeurs[i] + "\n");
		}
		int num = Clavier.entrerEntier("");

		String nomVendeur = vendeurs[num - 1];
		return nomVendeur;
	}

}
