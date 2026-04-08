package controleur;

import villagegaulois.Village;
import personnages.Gaulois;

public class ControlPrendreEtal {
	private Village village;
	private ControlVerifierIdentite controlVerifierIdentite;

	public ControlPrendreEtal(ControlVerifierIdentite controlVerifierIdentite,
			Village village) {
		this.controlVerifierIdentite = controlVerifierIdentite;
		this.village = village;
	}

	public boolean resteEtals() {
		boolean etalDisponible = village.rechercherEtalVide();
		return etalDisponible;
	}

	public int prendreEtal(String nomVendeur, String produit, int nbProduit) {
		Gaulois gauloi = village.trouverHabitant(nomVendeur);
		int numerEtal = village.installerVendeur(gauloi, produit, nbProduit);
		int numeroEtal = -1;
		return numeroEtal;
	}

	public boolean verifierIdentite(String nomVendeur) {
		boolean nomVendeurConnu = controlVerifierIdentite.verifierIdentite(nomVendeur);
		return nomVendeurConnu;
	}
}
