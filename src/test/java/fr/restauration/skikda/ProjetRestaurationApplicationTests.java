package fr.restauration.skikda;

import static org.junit.Assert.assertNotNull;

import java.util.Arrays;

import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import fr.restauration.skikda.entities.Categorie;
import fr.restauration.skikda.entities.Role;
import fr.restauration.skikda.entities.User;
import fr.restauration.skikda.service.ICategorieService;
import fr.restauration.skikda.service.IUserService;

@RunWith(SpringRunner.class)
@SpringBootTest
public class ProjetRestaurationApplicationTests {

	@Autowired
	private IUserService userService;
	
	@Autowired
	private ICategorieService iCategorieService;
	
	@Test
	public void contextLoads() {
		Categorie categorie = new Categorie();
		categorie.setNomCategorie("Salade");
		assertNotNull(iCategorieService.ajouterCategorie(categorie));
	}

}

