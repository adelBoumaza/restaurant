package fr.restauration.skikda.service.impl;

import java.util.Collections;
import java.util.List;
import java.util.Observable;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.Stream;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import fr.restauration.skikda.dto.CategorieDto;
import fr.restauration.skikda.entities.Categorie;
import fr.restauration.skikda.repository.ICategorieRepository;
import fr.restauration.skikda.service.ICategorieService;

@Transactional(readOnly = true)
@Service
public class CategorieServiceImpl  implements ICategorieService{
	
	@Autowired
	private ICategorieRepository iCategorieRepository;

	@Override
	@Transactional(readOnly = false)
	public Categorie ajouterCategorie(Categorie categorie) {
		
		return iCategorieRepository.save(categorie);
	}

	@Override
	public List<CategorieDto> findAll() {
	    return categorieTOcategorieDto(iCategorieRepository.findAll());
	    		
	}

	@Override
	public List<CategorieDto> findAllCategorieByUser(Integer idUser) {
		return categorieTOcategorieDto(iCategorieRepository.findAllCategorieByUser(idUser));	
	}
	
	private List<CategorieDto> categorieTOcategorieDto(List<Categorie> categories) {
		List<CategorieDto> dtos = categories.
				stream().map(c -> new CategorieDto(c.getId(), c.getNomCategorie(), false))
				.collect(Collectors.toList());
				
		if(!dtos.isEmpty())	{
			dtos.stream().findFirst().get().setActive(true);
		}
		return dtos;
	}

	
}
