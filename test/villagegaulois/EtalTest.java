package villagegaulois;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import controleur.ControlAcheterProduit;
import personnages.Chef;
import personnages.Gaulois;

class EtalTest {

	private Etal etal;
	private Village village;
	private Chef chef;
	private boolean etalOccupe;
  

	@BeforeEach
	void setUp() throws Exception {
		etalOccupe = false;
		village = new Village("A", 40 , 20);
	    chef = new Chef ("Pano",9 ,village);
		village.setChef(chef);
		
	}

	@Test
	void testIsEtalOccupe() {
		
		Gaulois gaulois = new Gaulois("obelix",10);
		village.ajouterHabitant(gaulois);
		village.installerVendeur(gaulois, "fleurs ",10);
		Etal etal = village.rechercherEtal(gaulois);
		assertTrue(etal.isEtalOccupe());
		
	
	}
	

	/*@Test
	void testGetVendeur() {
		
	}*/

	@Test
	void testGetQuantite() {
		Gaulois gaulois = new Gaulois("obelix",10);
		village.ajouterHabitant(gaulois);
		village.installerVendeur(gaulois, "fleurs ",10);
		Etal etal = village.rechercherEtal(gaulois);
		assertEquals(10, etal.getQuantite());
	}

	@Test
	void testGetProduit() {
		Gaulois gaulois = new Gaulois("obelix",10);
		village.ajouterHabitant(gaulois);
		village.installerVendeur(gaulois, "fleurs",10);
		Etal etal = village.rechercherEtal(gaulois);
		assertEquals("fleurs", etal.getProduit());
	}

	/*@Test
	void testOccuperEtal() {
		fail("Not yet implemented");
	}*/

	@Test
	void testContientProduit() {
		Gaulois gaulois = new Gaulois("obelix",10);
		village.ajouterHabitant(gaulois);
		village.installerVendeur(gaulois, "fleurs",10);
		Etal etal = village.rechercherEtal(gaulois);
		assertTrue(etal.contientProduit("fleurs"));
		assertFalse(etal.contientProduit("Poisson"));
	}

	
	
	/*@Test
	void testAcheterProduit() {
		Gaulois gaulois = new Gaulois("obelix",10);
		village.ajouterHabitant(gaulois);
		 acheterProduit(gaulois.getNom());
		Etal etal = rechercherEtal(Gaulois vendeur);
	}*/
	
	
	
	
	
	

	@Test
	void testLibererEtal() {
		Gaulois gaulois = new Gaulois("obelix",10);
		village.ajouterHabitant(gaulois);
		village.installerVendeur(gaulois, "fleurs",10);
		Etal etal = village.rechercherEtal(gaulois);
		
		
		assertTrue(etal.isEtalOccupe());   
	    etal.libererEtal();
	    assertFalse(etal.isEtalOccupe()); 
	}

	

	
	
	@Test
	void testEtatEtal() {
		Gaulois gaulois = new Gaulois("obelix",10);
		village.ajouterHabitant(gaulois);
		village.installerVendeur(gaulois, "fleurs",10);
		Etal etal = village.rechercherEtal(gaulois);
		
		
		String[] expected = {"true","obelix","fleurs","10","0"};
		assertArrayEquals(expected, etal.etatEtal());
	}
	
	

}
