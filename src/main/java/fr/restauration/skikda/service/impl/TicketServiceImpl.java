package fr.restauration.skikda.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import fr.restauration.skikda.dto.SocketDataDto;
import fr.restauration.skikda.dto.TicketDto;
import fr.restauration.skikda.repository.ITicketRepository;
import fr.restauration.skikda.service.ITicketService;

@Service
@Transactional(readOnly = true)
public class TicketServiceImpl implements ITicketService{

	@Autowired
	private ITicketRepository iTicketRepository;
	
	@Override
	public TicketDto getNextTicketForToDayAndUser(Integer idUser) {
		TicketDto dto = new TicketDto();
		dto.setNumeroTicket(iTicketRepository.getNextTicketForToDayAndUser(idUser));
		return dto;
	}


}
