/*package tn.esprit.rh.achat.service;

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

} */

//////////////////////////////////////////////////////////////////

package tn.esprit.rh.achat.services.categorieproduit;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.MethodOrderer.OrderAnnotation;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.boot.test.context.SpringBootTest;

import tn.esprit.rh.achat.entities.CategorieProduit;
import tn.esprit.rh.achat.repositories.CategorieProduitRepository;
import tn.esprit.rh.achat.services.CategorieProduitServiceImpl;

@SpringBootTest
@TestMethodOrder(OrderAnnotation.class)
@ExtendWith(MockitoExtension.class)
public class CategorieProduitTest {
	
	@Mock
	CategorieProduitRepository categorieRepository;
	
	@InjectMocks
	CategorieProduitServiceImpl categorieService;
	
	
	@Test
	public void testRetrieveCategorieProduit() {
		
		CategorieProduit categorie = new CategorieProduit(null,"Bouteilles","Eau", null);
		categorie.setIdCategorieProduit(1L);
		
	Mockito.when(categorieRepository.findById(1L)).thenReturn(Optional.of(categorie));
	categorieService.retrieveCategorieProduit(1L);
	Assertions.assertNotNull(categorie);
	
	System.out.println(categorie); 
	System.out.println(" TEST AFFICHAGE ");  
	
	}
	
	@Test
	public void createCategorieProduitTest()
	{

		CategorieProduit categorie2 = new CategorieProduit(null,"Paquet", "Fromage", null);
		categorie2.setIdCategorieProduit(1L);
		
		categorieService.addCategorieProduit(categorie2);
		verify(categorieRepository, times(1)).save(categorie2);
		System.out.println(categorie2); 
		System.out.println(" TEST CREATION ");  
	}
	
	@Test
	public void getAllCategorieProduitTest()
	{
		List<CategorieProduit> Catprodlist = new ArrayList<CategorieProduit>() {

			{
		add(new CategorieProduit(null,"bouteille","eau", null));
		add(new CategorieProduit(null,"paquet","chocolat", null));
		add(new CategorieProduit(null,"lait","ecraime", null));
			}};
			
			
		when(categorieService.retrieveAllCategorieProduits()).thenReturn(Catprodlist);
		//test
		List<CategorieProduit> catList = categorieService.retrieveAllCategorieProduits();
		assertEquals(3,catList.size());
		System.out.println(" TEST RETRIEVE 2 ");  
	
	}
	
	@Test
	public void TestDeleteCategorieProduit(){

	CategorieProduit categorie1 = new CategorieProduit(null,"supprimé","supprimé", null);
	categorie1.setIdCategorieProduit(2L);
	
	Mockito.lenient().when(categorieRepository.findById(categorie1.getIdCategorieProduit())).thenReturn(Optional.of(categorie1));

	categorieService.deleteCategorieProduit(2L);
	verify(categorieRepository).deleteById(categorie1.getIdCategorieProduit());
	
	System.out.println(categorie1);
	System.out.println(" TEST SUPRESSION ");  
	}

}