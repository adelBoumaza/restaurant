package fr.restauration.skikda.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import fr.restauration.skikda.entities.Profile;

public interface IProfileRepository extends JpaRepository<Profile, Integer> {

}
