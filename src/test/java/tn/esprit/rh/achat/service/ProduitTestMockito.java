package tn.esprit.rh.achat.service;


import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

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



@SpringBootTest
//@TestMethodOrder(OrderAnnotation.class)
@ExtendWith(MockitoExtension.class)
public class ProduitTestMockito {

	@Mock
	ProduitRepository produitRepository=Mockito.mock(ProduitRepository.class);
	
	@InjectMocks
	ProduitServiceImpl produitService;
	
	Produit produit1 = new Produit(null, "1111111111", "PRODUIT1", 5, null, null, null, null, null);
	
	List<Produit> prodlist = new ArrayList<Produit>() {

		{
			add(new Produit(null, "123456789", "Biscuit", 5, null, null, null, null, null));
			add(new Produit(null, "55522233", "Javel", 5, null, null, null, null, null));
			add(new Produit(null, "456897321", "Tv", 5, null, null, null, null, null));
		}};


	@Test
	public void createProduitTest()
	{
		when(produitService.addProduit(produit1)).thenReturn(produit1);
		produit1.setIdProduit(1L);
		produitRepository.save(produit1);
		Boolean resultat = produitRepository.existsById(produit1.getIdProduit());
		assertThat(resultat).isTrue();
		//assertEquals("1111111111", produit1.getCodeProduit());
		//verify(produitService, times(1)).retrieveAllProduits();
	}

	@Test
	public void retrieveAllProduitstest() {
		
	}
	@Test
	public void TestDeleteProduit(){

		produit1.setIdProduit(2L);

		Mockito.lenient().when(produitRepository.findById(produit1.getIdProduit())).thenReturn(Optional.of(produit1));

		produitService.deleteProduit(2L);
		verify(produitRepository).deleteById(produit1.getIdProduit());
  
	}
	


}
