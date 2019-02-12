package fr.restauration.skikda.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import fr.restauration.skikda.entities.PhotoProduit;

public interface IPhotoProduitRepository extends JpaRepository<PhotoProduit, Integer>{

}
