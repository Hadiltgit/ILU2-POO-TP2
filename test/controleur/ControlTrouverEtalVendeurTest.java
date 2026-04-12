package controleur;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import personnages.Chef;
import personnages.Gaulois;
import villagegaulois.Etal;
import villagegaulois.Village;

class ControlTrouverEtalVendeurTest {
    
	private Village village;
	private Chef chef ;
	
	@BeforeEach
	void setUp() throws Exception {
		village = new Village("A", 40 , 20);
	    chef = new Chef ("Pano",9 ,village);
		village.setChef(chef);
	}


	@Test
	void testControlTrouverEtalVendeur() {
		ControlTrouverEtalVendeur controlTrouverEtalVendeur = new ControlTrouverEtalVendeur(village);
		assertNotNull(controlTrouverEtalVendeur,"un constructeur ne peut pas returner null");
	}

	@Test
	void testTrouverEtalVendeur() {
		ControlTrouverEtalVendeur controlTrouverEtalVendeur = new ControlTrouverEtalVendeur(village);

		Gaulois gaulois = new Gaulois("obelix",10);
		village.ajouterHabitant(gaulois);
		assertEquals( village.rechercherEtal(gaulois) , controlTrouverEtalVendeur.trouverEtalVendeur( gaulois.getNom() ));
		
		Gaulois gauloi = new Gaulois("obeli",6);
		assertEquals( null ,controlTrouverEtalVendeur.trouverEtalVendeur( gauloi.getNom() ));
	}
}
