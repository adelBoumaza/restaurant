package fr.restauration.skikda;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.IntStream;

import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import fr.restauration.skikda.dto.CommandeDto;
import fr.restauration.skikda.dto.InformationTicketDto;
import fr.restauration.skikda.dto.ProduitDto;
import fr.restauration.skikda.dto.ProfileDto;
import fr.restauration.skikda.dto.SocketDataDto;
import fr.restauration.skikda.dto.TicketDto;
import fr.restauration.skikda.entities.Categorie;
import fr.restauration.skikda.entities.Role;
import fr.restauration.skikda.entities.User;
import fr.restauration.skikda.repository.ICategorieRepository;
import fr.restauration.skikda.service.ICategorieService;
import fr.restauration.skikda.service.ICommandeService;
import fr.restauration.skikda.service.IProduitService;
import fr.restauration.skikda.service.IProfileService;
import fr.restauration.skikda.service.ITicketService;
import fr.restauration.skikda.service.IUserService;
import fr.restauration.skikda.util.Constant;
import junit.framework.Assert;


@RunWith(SpringRunner.class)
@SpringBootTest
public class ProjetRestaurationApplicationTests {

	@Autowired
	private IUserService userService;
	
	@Autowired
	private ITicketService iTicketService;
	
	@Autowired
	private ICategorieService iCategorieService;
	
	@Autowired
	private ICategorieRepository iCategorieRepository;
	
	
	@Autowired
	private IProfileService iProfileService;
	
	@Autowired
	private IProduitService iProduitService;
	
	@Autowired
	private ICommandeService iCommandeService;
	
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
	@Ignore
	public void selectAllProduit() {
		System.out.println(iProduitService.getAllProduitByUser(7,1));
	}
	
	@Test
	@Ignore
	public void variableStatic() {
		System.out.println(Constant.uploadDirectory);
	}
	
	@Test
	@Ignore
	public void addCommande() {
		CommandeDto dto = new CommandeDto();
		dto.setIdUser(7);
		dto.setStatut("En cours de préparation");
		dto.setTicketDto(new TicketDto("0001", new BigDecimal(100), new BigDecimal(120)));
		List<InformationTicketDto> dtos = new ArrayList<>();
		dtos = Arrays.asList(new InformationTicketDto(7, 2, new BigDecimal(10), new BigDecimal(20)),new InformationTicketDto(7, 2, new BigDecimal(10), new BigDecimal(20)));
		dto.setInformationTicketDtos(dtos);
		iCommandeService.saveOrUpdateCommande(dto, true);
		
	}
	
	@Test
	@Ignore
	public void getNextTicketByUser() {
		TicketDto next = iTicketService.getNextTicketForToDayAndUser(7);
		System.out.println(next.getNumeroTicket());
	}
	
	@Test
	public void getLastTicketCreatedByUser() {
		List<SocketDataDto> data = iCommandeService.getLastTicketCreatedByUser(7);
		System.out.println(data);
	}

}

