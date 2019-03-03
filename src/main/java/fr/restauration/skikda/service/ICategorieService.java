package fr.restauration.skikda.service;

import java.util.List;

import fr.restauration.skikda.dto.CategorieDto;
import fr.restauration.skikda.entities.Categorie;

public interface ICategorieService {

	Categorie ajouterCategorie(Categorie categorie);
	
	List<CategorieDto> findAll();
}
