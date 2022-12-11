package tn.esprit.spring;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;

import java.util.List;

import org.junit.Test;
import org.junit.jupiter.api.MethodOrderer.OrderAnnotation;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.TestMethodOrder;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import tn.esprit.spring.entities.Voyageur;
import tn.esprit.spring.services.IVoyageurService;

@SpringBootTest
@RunWith(SpringRunner.class)
@TestMethodOrder(OrderAnnotation.class)
public class VoyageurServiceImplTest {
	
	@Autowired
	IVoyageurService voyageurService;
	
	@Test
	@Order(1)
	public void testAjouterVoyageur()
	{
		List<Voyageur> voyageurs = voyageurService.recupererAll();
		Voyageur v =  new Voyageur("mamadou", null);
		int expected = voyageurs.size() ;
		Voyageur savedVoyageur = voyageurService.ajouterVoyageur(v);
		assertEquals(expected+1, voyageurService.recupererAll().size());
		assertNotNull(savedVoyageur.getNomVoyageur());
		voyageurService.supprimerVoyageur(savedVoyageur);
	}
	
	@Test
	@Order(2)
	public void testModifierVoyageur()
	{
		Voyageur voyageur = voyageurService.recupererVoyageParId((long) 1);
		assertNotNull(voyageur);
		
		voyageur.setNomVoyageur("ba");
		Voyageur savedVoyageur = voyageurService.modifierVoyageur(voyageur);
		assertNotNull(savedVoyageur);
		assertNotNull(savedVoyageur.getNomVoyageur());
		
	}
	
   @Test
   @Order(3)
	public void testSupprimerVoyageur() 
	{
		Voyageur v = new Voyageur("mamadouba", null);
		Voyageur savedVoyageur = voyageurService.ajouterVoyageur(v);
		assertNotNull(savedVoyageur);
		voyageurService.supprimerVoyageur(savedVoyageur);
		assertNull(voyageurService.recupererVoyageParId(savedVoyageur.getIdVoyageur()));
		
	}

}
