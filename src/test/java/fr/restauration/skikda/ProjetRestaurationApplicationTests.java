package fr.restauration.skikda;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import java.util.Arrays;
import java.util.List;
import java.util.stream.IntStream;

import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import fr.restauration.skikda.dto.ProduitDto;
import fr.restauration.skikda.dto.ProfileDto;
import fr.restauration.skikda.entities.Categorie;
import fr.restauration.skikda.entities.Role;
import fr.restauration.skikda.entities.User;
import fr.restauration.skikda.repository.ICategorieRepository;
import fr.restauration.skikda.service.ICategorieService;
import fr.restauration.skikda.service.IProduitService;
import fr.restauration.skikda.service.IProfileService;
import fr.restauration.skikda.service.IUserService;
import junit.framework.Assert;


@RunWith(SpringRunner.class)
@SpringBootTest
public class ProjetRestaurationApplicationTests {

	@Autowired
	private IUserService userService;
	
	@Autowired
	private ICategorieService iCategorieService;
	
	@Autowired
	private ICategorieRepository iCategorieRepository;
	
	
	@Autowired
	private IProfileService iProfileService;
	
	@Autowired
	private IProduitService iProduitService;
	
	@Test
	@Ignore
	public void contextLoads() {
		Categorie categorie = new Categorie();
		categorie.setNomCategorie("Salade");
		assertNotNull(iCategorieService.ajouterCategorie(categorie));
	}
	
	
	
	@Test
	@Ignore
	public void getAllCategories() {
		System.out.println(iCategorieService.findAll());
	}
	
	@Test
	@Ignore
	public void addUser() {
		User user = new User();
		user.setUserName("rafik");
		user.setPassword("rafik");
		userService.saveUser(user);
	}
	
	@Test
	@Ignore
	public void findOneProfileDtoByUser() {
		ProfileDto profileDto = iProfileService.profileDtoByUser(7);
		if(profileDto == null) {
			Assert.assertEquals(profileDto, null);
		}else {
			assertNotNull(profileDto);
		}

	}
	
	
	@Test
	@Ignore
	public void addProduit() {
		ProduitDto dto = new ProduitDto();
		dto.setNomCategorie("Menus EST");
		dto.setNomImage("mon image");
        dto.setIdUser(7);
        assertNotNull(iProduitService.ajouterUnProduit(dto));
	}
	@Test
	@Ignore
	public void findCategorieByName() {
		System.out.println(iCategorieRepository.findByNomCategorie("Menus EST"));
	}
	
	@Test
	public void selectAllProduit() {
		System.out.println(iProduitService.getAllProduitByUser(7));
	}

}

