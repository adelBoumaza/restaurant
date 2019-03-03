package fr.restauration.skikda.rest;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import fr.restauration.skikda.dto.CategorieDto;
import fr.restauration.skikda.service.ICategorieService;

@RestController
@RequestMapping(value="/api/v1")
public class CategorieRest {

	@Autowired
	private ICategorieService iCategorieService;
	
	@GetMapping(value="/categorie/findAll")
	public List<CategorieDto> findAll() {
		return iCategorieService.findAll();
	}
}
