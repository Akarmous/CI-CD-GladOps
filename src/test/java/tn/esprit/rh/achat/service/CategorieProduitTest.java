package tn.esprit.rh.achat.service;

import java.util.List;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.MethodOrderer.OrderAnnotation;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import tn.esprit.rh.achat.entities.CategorieProduit;
import tn.esprit.rh.achat.services.ICategorieProduitService;

@SpringBootTest
@TestMethodOrder(OrderAnnotation.class)
public class CategorieProduitTest {
	
	@Autowired
	ICategorieProduitService cs;
	
	@Test
	@Order(1)
	
	public void testRetrieveAllCategorieProduit() {
		List<CategorieProduit> listCategories = cs.retrieveAllCategorieProduits();
		Assertions.assertEquals(0, listCategories.size());
		
	}

}
