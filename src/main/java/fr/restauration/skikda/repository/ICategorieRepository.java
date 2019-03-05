package fr.restauration.skikda.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import fr.restauration.skikda.entities.Categorie;

public interface ICategorieRepository extends JpaRepository<Categorie, Integer>{

	Categorie findByNomCategorie(String nomCategorie);
	
	@Query(value="From Categorie c Join fetch c.user u where u.id=?")
	List<Categorie> findAllCategorieByUser(Integer idUser);
	
	@Query(value="From Categorie c Join fetch c.user u where u.id=? and c.nomCategorie=?")
	Categorie findByNomCategorieAndUser(Integer idUser,String nomCategorie);
}
