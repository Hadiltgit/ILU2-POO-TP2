package controleur;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import personnages.Chef;
import personnages.Gaulois;
import villagegaulois.Village;

class ControlAfficherVillageTest {
	private Village village;
	private Chef abraracourcix;
	   
	@BeforeEach
	public void setup() {
		System.out.println("Inintialisation ...");
		village = new Village("le village des irréductible ",10,5);
		abraracourcix = new Chef ("abraracourcix",10,village);
		village.setChef(abraracourcix);
		
	}

	 
	@Test
	void testDonnerNomsVillageois() {
		ControlAfficherVillage controlAfficherVillage = new ControlAfficherVillage(village);
	    Gaulois gaulois = new Gaulois ("obelix",10);
		village.ajouterHabitant(gaulois);
        assertEquals("abraracourcix", controlAfficherVillage.donnerNomsVillageois()[0]);
        assertEquals("obelix", controlAfficherVillage.donnerNomsVillageois()[1]);
	}

	
	
	@Test
	void testDonnerNomVillage() {
		ControlAfficherVillage controlAfficherVillage = new ControlAfficherVillage(village);
		assertEquals("le village des irréductible ", controlAfficherVillage.donnerNomVillage());
	}

	
	
	@Test
	void testDonnerNbEtals() {
		ControlAfficherVillage controlAfficherVillage = new ControlAfficherVillage(village);
		assertEquals(5, controlAfficherVillage.donnerNbEtals());
	}
	

	@Test
	void testAfficherVendeursProduit() {
		ControlAfficherVillage controlAfficherVillage = new ControlAfficherVillage(village);
		Gaulois gaulois = new Gaulois("obelix", 10);
		village.ajouterHabitant(gaulois);
		village.installerVendeur(gaulois, "fleurs" , 10 ); 
		assertArrayEquals(   village.rechercherVendeursProduit("fleurs")    , controlAfficherVillage.afficherVendeursProduit("fleurs"));
	}
	
	
	
}
