
package frontiere;

import controleur.ControlLibererEtal;

public class BoundaryLibererEtal {
	private ControlLibererEtal controlLibererEtal;

	public BoundaryLibererEtal(ControlLibererEtal controlLibererEtal) {
		this.controlLibererEtal = controlLibererEtal;
	}

	public void libererEtal(String nomVendeur) {
		 boolean vendeurReconnu = controlLibererEtal.isVendeur(nomVendeur);
		 if(!vendeurReconnu) {
			 System.out.println("Mais vous n'etes pas inscrit sur notre marché aujourd'hui");	 
		 }else {
			 String donneesEtal[] = controlLibererEtal.libererEtal(nomVendeur);
			 boolean  etalOcupe = Boolean.valueOf( donneesEtal[0]);
			 if(etalOcupe) {
				 String produit = donneesEtal[2];
				 String quantiteIninitial = donneesEtal[3];
				 String quantiteVendu = donneesEtal[4];
				 System.out.println("Vous avez vendu "+quantiteVendu+" sur "+quantiteIninitial+" "+produit+".");
				 System.out.println("En revoir "+nomVendeur+" passez une bonne journnée");
			 }
		 }
	}

}
