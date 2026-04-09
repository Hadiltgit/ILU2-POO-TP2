package controleur;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import personnages.Chef;
import villagegaulois.Village;

class ControlAfficherVillageTest {
	private Village village;
	private Chef abraracourcix;
	   
	@BeforeEach
	void testControlAfficherVillage() {
		System.out.println("Inintialisation ...");
	}

	 
	@Test
	void testDonnerNomsVillageois() {
		ControlAfficherVillage controlAfficherVillage = new ControlAfficherVillage(village);
		Village village = new Village("le village des irréductible ",10,5);
		abraracourcix = new Chef ("abraracourcix",10,village);
		village.setChef(abraracourcix);
		String a ="le village des irréductible ";
		String[] b = controlAfficherVillage.donnerNomsVillageois();
		assertTrue(a.equals(b) );
		//assertFalse(ControlAfficherVillage.donnerNomsVillageois());
	}

	@Test
	void testDonnerNomVillage() {
		fail("Not yet implemented");
	}

	@Test
	void testDonnerNbEtals() {
		fail("Not yet implemented");
	}

}
