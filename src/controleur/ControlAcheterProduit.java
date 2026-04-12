
package controleur;

import villagegaulois.Village;
import villagegaulois.Etal;
import personnages.Gaulois;

public class ControlAcheterProduit {
	private Village village;
	private ControlTrouverEtalVendeur controlTrouverEtalVendeur;
	private ControlVerifierIdentite controlVerifierIdentite;
	
    


	public ControlAcheterProduit(ControlVerifierIdentite controlVerifierIdentite,
			ControlTrouverEtalVendeur controlTrouverEtalVendeur,
			Village village) {
		this.village = village;
		this.controlVerifierIdentite = controlVerifierIdentite;
		this.controlTrouverEtalVendeur = controlTrouverEtalVendeur;
	}

	public boolean verifierIdentite(String nomAcheteur) {
		return controlVerifierIdentite.verifierIdentite(nomAcheteur);
	}
	
	
	public Gaulois[] afficherVendeursProduit(String produit) {
		return village.rechercherVendeursProduit(produit);
	}
	
	 public int acheterProduit(String nomVendeur, int quantite) {
	        Etal etal = controlTrouverEtalVendeur.trouverEtalVendeur(nomVendeur);
	        return etal.acheterProduit(quantite);
	 }

	
	
}
