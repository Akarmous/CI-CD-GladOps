package tn.esprit.rh.achat.services.SecteurActivite;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.List;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;

import tn.esprit.rh.achat.entities.SecteurActivite;
import tn.esprit.rh.achat.services.ISecteurActiviteService;

public class SecteurActiviteServiceTest {
	
	
    @Autowired
    ISecteurActiviteService as;

  /*  @Test
    @Order(1)
    public void testRetrieveAllISecteurActiviteServices() {
        List<SecteurActivite> listSecteurActivite = as.retrieveAllSecteurActivite();
        Assertions.assertEquals(0, listSecteurActivite.size());
    } 
    
    @Test
 @Order(2)
  void testAddSecteurActivite() {
 
    	SecteurActivite sa = new SecteurActivite("aa","aa");
    	SecteurActivite savedSecteur= as.addSecteurActivite(sa);
 assertEquals(sa.getLibelleSecteurActivite(), savedSecteur.getLibelleSecteurActivite());
 }
	    @Test
    @Order(3)
     void testRetrieveSecteurActivite() {
    	SecteurActivite p = ps.retrieveProduit((long) 1);
    assertEquals("1", as.getIdProduit().toString());
    } */
    @Test
    @Order(1)
     void testDeleteSecteurActivite() {
    	ps.deleteSecteurActivite((long) 1);
    assertNull(as.retrieveSecteurActivite((long) 1));
    }

}
