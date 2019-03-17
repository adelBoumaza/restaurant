package fr.restauration.skikda.service;

import java.util.List;

import fr.restauration.skikda.dto.SocketDataDto;
import fr.restauration.skikda.dto.TicketDto;

public interface ITicketService {

	TicketDto getNextTicketForToDayAndUser(Integer idUser);
	
}
