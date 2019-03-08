package fr.restauration.skikda.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.web.multipart.MultipartFile;

import fr.restauration.skikda.dto.CommandeDto;
import fr.restauration.skikda.entities.Produit;

public interface IProduitRepository extends JpaRepository<Produit, Integer>{

	@Query(value="FROM Produit p join fetch p.categorie ca join fetch p.user u where u.id=? and ca.id=?")
	List<Produit> getAllProduit(Integer id,Integer idCategorie);
}
