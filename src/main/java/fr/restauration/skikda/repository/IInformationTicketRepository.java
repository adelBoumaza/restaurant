package fr.restauration.skikda.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import fr.restauration.skikda.entities.InformationTicket;

public interface IInformationTicketRepository extends JpaRepository<InformationTicket, Integer> {

}
