package fr.restauration.skikda.service.impl;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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

	
}
