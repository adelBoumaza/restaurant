package fr.restauration.skikda.service;

import java.util.List;

import fr.restauration.skikda.dto.CommandeDto;
import fr.restauration.skikda.dto.SocketDataDto;

public interface ICommandeService {

	List<SocketDataDto> saveOrUpdateCommande(CommandeDto commandeDto,boolean save);
	
	List<SocketDataDto> getLastTicketCreatedByUser(Integer idUser);
	
}
