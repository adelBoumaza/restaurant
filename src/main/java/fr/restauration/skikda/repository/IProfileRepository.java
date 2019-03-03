package fr.restauration.skikda.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import fr.restauration.skikda.entities.Profile;

public interface IProfileRepository extends JpaRepository<Profile, Integer> {

	@Query(value="FROM Profile p join fetch p.user u where u.id =? ")
	Profile findOneProfileByUser(Integer idUser);
}
