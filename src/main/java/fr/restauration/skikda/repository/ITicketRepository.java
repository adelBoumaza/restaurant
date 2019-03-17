package fr.restauration.skikda.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import fr.restauration.skikda.entities.Ticket;

public interface ITicketRepository extends JpaRepository<Ticket, Integer>{

	@Query(value="select case " +
					"WHEN tmp.result is null  THEN CONCAT('0001') " + 
					"WHEN tmp.result < 10  THEN CONCAT('000', tmp.result) " + 
					"WHEN tmp.result >= 10 AND  tmp.result <100  THEN CONCAT('00', tmp.result) " + 
					"WHEN tmp.result >= 100 AND  tmp.result < 1000 THEN CONCAT('0', tmp.result) " + 
					"ELSE tmp.result END " + 
					"FROM (SELECT (max(CAST(tbt.numero_ticket AS UNSIGNED)) +1) as result from tb_ticket tbt JOIN tb_commande tbc  on tbt.fk_commande_ticket = tbc.pk_id " + 
					"JOIN tb_user tbu on tbu.pk_id=tbc.fk_user where tbu.pk_id =? " + 
					"AND DATE(tbt.date_creation) = CURDATE()) as tmp;",nativeQuery = true)
	String getNextTicketForToDayAndUser(Integer idUser);
	
	@Query(value="SELECT tbt.numero_ticket,tbc.statut, " + 
			"CASE WHEN tbc.statut = 'En cours de préparation' THEN 'en-cours-de-preparation' "+
			"ELSE 'preparation-terminee'  END as cssCLass " + 
			"FROM tb_ticket tbt " + 
			"JOIN tb_commande tbc on tbc.pk_id = tbt.fk_commande_ticket " + 
			"JOIN tb_user tbu on tbu.pk_id = tbc.fk_user " + 
			"where (DATE_ADD(tbt.date_creation, INTERVAL 40 MINUTE) > NOW()) and tbu.pk_id=? order by tbt.date_creation desc",nativeQuery=true)
	List<Object[]> getLastTicketCreatedByUser(Integer idUser);
}
