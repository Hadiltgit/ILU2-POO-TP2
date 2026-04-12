package controleur;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import personnages.Chef;
import personnages.Gaulois;
import villagegaulois.Village;

class ControlVerifierIdentiteTest {
	
	private Village village;
	private Chef chef;

	@BeforeEach
	void setUp() throws Exception {
		village = new Village("A", 40 , 20);
	    chef = new Chef ("Pano",9 ,village);
		village.setChef(chef);
	}


	ControlVerifierIdentiteTest() {
		ControlVerifierIdentite controlVerifierIdentite = new ControlVerifierIdentite(village);
		assertNotNull(controlVerifierIdentite,"Le constructeur ne peut pas retourner null");
	}
	
	@Test
	void verifierIdentiteTest() {
		ControlVerifierIdentite controlVerifierIdentite = new ControlVerifierIdentite(village);
		Gaulois gaulois = new Gaulois("obelix",10);
		village.ajouterHabitant(gaulois);
		assertTrue(  controlVerifierIdentite.verifierIdentite(gaulois.getNom())  , "Habitant" );
		
		Gaulois gauloi = new Gaulois("obeli",6);
		assertFalse(  controlVerifierIdentite.verifierIdentite(gauloi.getNom())  , "nest pas habitant" );
	}
	
	

	
}
