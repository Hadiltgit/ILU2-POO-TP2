package controleur;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import personnages.Chef;
import personnages.Gaulois;
import villagegaulois.Etal;
import villagegaulois.Village;

class ControlLibererEtalTest {
	
	private ControlTrouverEtalVendeur controlTrouverEtalVendeur;
	private Village village;
	private Chef chef;
	
	 @BeforeEach
	  public void initialiserSituation() {
		 village = new Village("A", 40 , 20);
		 chef = new Chef ("Pano",9 ,village);
	     village.setChef(chef);
		 controlTrouverEtalVendeur = new ControlTrouverEtalVendeur (village);	   
	   } 
	   
	
	@Test
	void testControlLibererEtal() {
		ControlLibererEtal controlLibererEtal = new ControlLibererEtal(controlTrouverEtalVendeur );
		assertNotNull(controlLibererEtal, "Le constructeur ne peut pas retourner null");
	}

	@Test
	void testIsVendeur() {
		ControlLibererEtal controlLibererEtal = new ControlLibererEtal(controlTrouverEtalVendeur );
		
		Gaulois gaulois = new Gaulois("obelix", 10);
		village.ajouterHabitant(gaulois);
		village.installerVendeur(gaulois, "fleurs" , 10 ); 
		Etal etal = controlTrouverEtalVendeur. trouverEtalVendeur(gaulois.getNom());
		assertNotNull(etal);
		assertTrue(controlLibererEtal.isVendeur(gaulois.getNom()));
		
		Gaulois gauloi = new Gaulois("obeli", 10);
		assertFalse(controlLibererEtal.isVendeur(gauloi.getNom()));
		
	}	
	

	@Test
	void testLibererEtal() {
		ControlLibererEtal controlLibererEtal = new ControlLibererEtal(controlTrouverEtalVendeur );

		Gaulois gaulois = new Gaulois("obelix", 10);
		village.ajouterHabitant(gaulois);
		village.installerVendeur(gaulois, "fleurs" , 10 ); 
		Etal etal = controlTrouverEtalVendeur. trouverEtalVendeur(gaulois.getNom());
		assertNotNull(etal);
		String[] attendu = etal.etatEtal();
		assertArrayEquals(attendu, controlLibererEtal.libererEtal(gaulois.getNom()) );
		
		Gaulois gauloi = new Gaulois("obeli", 10);
		assertNull(controlLibererEtal.libererEtal(gauloi.getNom()) );
	}
	
}
