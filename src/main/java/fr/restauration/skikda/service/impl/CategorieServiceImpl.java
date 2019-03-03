package fr.restauration.skikda.service.impl;

import java.util.Collections;
import java.util.List;
import java.util.Observable;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import fr.restauration.skikda.dto.CategorieDto;
import fr.restauration.skikda.entities.Categorie;
import fr.restauration.skikda.repository.ICategorieRepository;
import fr.restauration.skikda.service.ICategorieService;

@Transactional
@Service
public class CategorieServiceImpl  implements ICategorieService{
	
	@Autowired
	private ICategorieRepository iCategorieRepository;

	@Override
	public Categorie ajouterCategorie(Categorie categorie) {
		
		return iCategorieRepository.save(categorie);
	}

	@Override
	public List<CategorieDto> findAll() {
		List<Categorie> categories = iCategorieRepository.findAll();
		List<CategorieDto> dtos = categories.
				stream().map(c -> new CategorieDto(c.getId(), c.getNomCategorie(), false))
				.collect(Collectors.toList());
				
		if(!dtos.isEmpty())	{
			dtos.stream().findFirst().get().setActive(true);
		}
				
	    return dtos;
	    		
	}

	
}
