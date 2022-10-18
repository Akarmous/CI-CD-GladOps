package tn.esprit.rh.achat.service;


import static org.assertj.core.api.Assertions.assertThat;
import static org.hamcrest.CoreMatchers.any;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.boot.test.context.SpringBootTest;

import tn.esprit.rh.achat.entities.Produit;
import tn.esprit.rh.achat.repositories.ProduitRepository;
import tn.esprit.rh.achat.services.ProduitServiceImpl;



@SpringBootTest(classes = AchatApplication.class)
//@TestMethodOrder(OrderAnnotation.class)
@ExtendWith(MockitoExtension.class)
public class ProduitTestMockito {

	private Produit produit ;
	@Mock
	ProduitRepository produitRepository=Mockito.mock(ProduitRepository.class);

	@InjectMocks
	ProduitServiceImpl produitService;

	Produit produit1 = new Produit(null, "1111111111", "PRODUIT1", 5, null, null, null, null, null);

	List<Produit> prodlist = new ArrayList<Produit>() {

		{
			add(new Produit(1L, "123456789", "Biscuit", 5, null, null, null, null, null));
			add(new Produit(2L, "55522233", "Javel", 5, null, null, null, null, null));
			add(new Produit(3L, "456897321", "Tv", 5, null, null, null, null, null));
		}};


		@Test
		public void addProduitTest()
		{
			System.out.println("***** addProduitTest Mockito *****");
			for (Produit p:prodlist) {
				produitService.addProduit(p);
				verify(produitRepository, times(1)).save(p);
			}
			System.out.println("***** addProduitTest Mockito: success *****");
		}

		@Test
		public void retrieveAllProduitstest() {
			System.out.println("***** retrieveAllProduitstest Mockito *****");
			when(produitService.retrieveAllProduits()).thenReturn(prodlist);
			List<Produit> produitList1 = produitService.retrieveAllProduits();
			Assertions.assertEquals(3, produitList1.size());
			System.out.println(" retrieveAllProduitstest Mockito : success");
		}


		@Test
		public void TestDeleteProduit(){

			System.out.println("*********TestDeleteProduit Mockito*********");

			produit1.setIdProduit(2L);
			Mockito.lenient().when(produitRepository.findById(produit1.getIdProduit())).thenReturn(Optional.of(produit1));
			produitService.deleteProduit(2L);
			verify(produitRepository).deleteById(produit1.getIdProduit());

			System.out.println("*******TestDeleteProduit Mockito : success*********");

		}



}
