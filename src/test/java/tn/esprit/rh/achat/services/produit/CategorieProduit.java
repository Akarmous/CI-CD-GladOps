package tn.esprit.rh.achat.services.produit;

import java.util.List;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import tn.esprit.rh.achat.entities.Produit;
import tn.esprit.rh.achat.services.IProduitService;

@SpringBootTest
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)


	public class CategorieProduit {

	}

    @Autowired
    idCategorieProduit cp;

    @Test
    @Order(1)
    public void testRetrieveAllUsers() {
        List<Produit> listProduits = cp.retrieveAllProduits();
        Assertions.assertEquals(0, listProduits.size());
    }
}