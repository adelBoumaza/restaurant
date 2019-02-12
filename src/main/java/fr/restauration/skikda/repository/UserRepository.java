package fr.restauration.skikda.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import fr.restauration.skikda.entities.User;


public interface UserRepository extends JpaRepository<User, Integer> {

	User getByUserName(String username) ;
}
