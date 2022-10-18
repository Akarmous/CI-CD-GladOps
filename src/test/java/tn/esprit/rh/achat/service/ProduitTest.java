package tn.esprit.rh.achat.service;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.MethodOrderer.OrderAnnotation;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.core.annotation.Order;

import tn.esprit.rh.achat.AchatApplication;
import tn.esprit.rh.achat.entities.Produit;
import tn.esprit.rh.achat.services.IProduitService;

@SpringBootTest(classes = AchatApplication.class)
@TestMethodOrder(OrderAnnotation.class)
public class ProduitTest {
	
	@Autowired
	IProduitService ps;
	
	List<Produit> prodlist = new ArrayList<Produit>() {

		{
			add(new Produit(1L, "123456789", "Biscuit", 5, null, null, null, null, null));
			add(new Produit(2L, "55522233", "Javel", 5, null, null, null, null, null));
			add(new Produit(3L, "456897321", "Tv", 5, null, null, null, null, null));
		}};
	
	@Test
	@Order(1)
	public void testRetrieveAllProduits() {
		List<Produit> listProduits = ps.retrieveAllProduits();
		Assertions.assertEquals(0, listProduits.size());
		System.out.println("retrieveAllProduits test");
	}
	
}
