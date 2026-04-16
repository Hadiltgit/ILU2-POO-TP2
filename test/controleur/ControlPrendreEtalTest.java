package controleur;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import personnages.Chef;
import villagegaulois.Village;

class ControlPrendreEtalTest {
	
	private Village village;
    private Chef abraracourcix;
	private ControlVerifierIdentite controlVerifierIdentite;   
	
	@BeforeEach
	  public void initialiserSituation() {
		   System.out.println("Inintialisation ...");
		   village = new Village("le village des irréductible ",10,5);
		   abraracourcix = new Chef ("abraracourcix",10,village);
		   village.setChef(abraracourcix);
	   } 

	@Test
	void testControlPrendreEtal() {
		ControlPrendreEtal controlPrendreEtal = new ControlPrendreEtal(controlVerifierIdentite, village);
		assertNotNull(controlPrendreEtal,"constructeur ne renvoi pas null");
	}

	@Test
	void testResteEtals() {
		fail("Not yet implemented");
	}

	/*@Test
	void testPrendreEtal() {
		assertT
		fail("Not yet implemented");
	}*/

	@Test
	void testVerifierIdentite() {
		fail("Not yet implemented");
	}

}
