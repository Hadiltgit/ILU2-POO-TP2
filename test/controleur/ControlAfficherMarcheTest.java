package controleur;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import personnages.Chef;
import villagegaulois.Village;

class ControlAfficherMarcheTest {
	
	Village village;
	Chef chef ;

	@BeforeEach
	void setUp() throws Exception {
		village = new Village("A", 40 , 20);
	    chef = new Chef ("Pano",9 ,village);
		village.setChef(chef);
	}

	@Test
	void testControlAfficherMarche() {
		 ControlAfficherMarche controlAfficherMarche = new ControlAfficherMarche (village);
		 assertNotNull(controlAfficherMarche,"Le constructeur ne peut pas retourner null");
	}

	@Test
	void testDonnerInfosMarche() {
		ControlAfficherMarche controlAfficherMarche = new ControlAfficherMarche (village);
		assertArrayEquals(village.donnerEtatMarche() , controlAfficherMarche.donnerInfosMarche());
	}
}
