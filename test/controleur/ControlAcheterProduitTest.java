package controleur;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import personnages.Chef;
import personnages.Gaulois;
import villagegaulois.Etal;
import villagegaulois.Village;

class ControlAcheterProduitTest {
	
	Chef chef;
	Village village;
	ControlVerifierIdentite controlVerifierIdentite;
	ControlTrouverEtalVendeur controlTrouverEtalVendeur;
	Etal etal;
	

	@BeforeEach
	void setUp() throws Exception {
		village = new Village("A", 40 , 20);
	    chef = new Chef ("Pano",9 ,village);
		village.setChef(chef);
		controlVerifierIdentite = new ControlVerifierIdentite(village);
		controlTrouverEtalVendeur = new ControlTrouverEtalVendeur(village);	
	}


	@Test
	void testControlAcheterProduit() {
		ControlAcheterProduit controlAcheterProduit = new ControlAcheterProduit(controlVerifierIdentite,controlTrouverEtalVendeur,village);
		assertNotNull(controlAcheterProduit,"un constructeur ne peut pas retourner null");
	}

	@Test
	void testVerifierIdentite() {
		ControlAcheterProduit controlAcheterProduit = new ControlAcheterProduit(controlVerifierIdentite,controlTrouverEtalVendeur,village);
		Gaulois gaulois = new Gaulois("obelix",10);
		village.ajouterHabitant(gaulois);
		assertEquals(controlVerifierIdentite.verifierIdentite(gaulois.getNom()) ,controlAcheterProduit.verifierIdentite(gaulois.getNom()));
		
		Gaulois gauloi = new Gaulois("obeli",10);
		assertEquals(controlVerifierIdentite.verifierIdentite(gauloi.getNom()) ,controlAcheterProduit.verifierIdentite(gauloi.getNom()));
	}
	
	

	@Test
	void testAfficherVendeursProduit() {
		ControlAcheterProduit controlAcheterProduit = new ControlAcheterProduit(controlVerifierIdentite,controlTrouverEtalVendeur,village);
		Gaulois gaulois = new Gaulois("obelix", 10);
		village.ajouterHabitant(gaulois);
		village.installerVendeur(gaulois, "fleurs" , 10 ); 
		assertArrayEquals(   village.rechercherVendeursProduit("fleurs")    ,controlAcheterProduit.afficherVendeursProduit("fleurs"));
	}


	@Test
	void testAcheterProduit() {
		ControlAcheterProduit controlAcheterProduit = new ControlAcheterProduit(controlVerifierIdentite,controlTrouverEtalVendeur,village);
		Gaulois gaulois = new Gaulois("obelix", 10);
		village.ajouterHabitant(gaulois);
		village.installerVendeur(gaulois, "fleurs", 10);
		etal = controlTrouverEtalVendeur.trouverEtalVendeur(gaulois.getNom());
		assertNotNull(etal);
		assertEquals( etal.acheterProduit(4)    ,controlAcheterProduit.acheterProduit(gaulois.getNom() , 4));
	}

}
