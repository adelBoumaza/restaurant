package fr.restauration.skikda.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import fr.restauration.skikda.entities.Commande;

public interface ICommandeRepository extends JpaRepository<Commande, Integer>{
	
	
}
