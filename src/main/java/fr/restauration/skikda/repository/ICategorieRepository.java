package fr.restauration.skikda.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import fr.restauration.skikda.entities.Categorie;

public interface ICategorieRepository extends JpaRepository<Categorie, Integer>{

	Categorie findByNomCategorie(String nomCategorie);
}
