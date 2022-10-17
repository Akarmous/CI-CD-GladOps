package tn.esprit.rh.achat.service;

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
public class TestProduit {

    @Autowired
    IProduitService ps;

    @Test
    @Order(1)
    public void testRetrieveAllProduits() {
        List<Produit> listProduits = ps.retrieveAllProduits();
        Assertions.assertEquals(listProduits.size() , listProduits.size());
        System.out.println("retrieveAllProduits test");
    }




}

