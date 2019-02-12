package fr.restauration.skikda.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import fr.restauration.skikda.entities.Produit;

public interface IProduitRepository extends JpaRepository<Produit, Integer>{

}
