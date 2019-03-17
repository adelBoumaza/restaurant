package fr.restauration.skikda.rest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import fr.restauration.skikda.dto.TicketDto;
import fr.restauration.skikda.service.ITicketService;

@RestController
@RequestMapping(value="/api/v1")
public class TicketRest {

	@Autowired
	private ITicketService iTicketService;
	
	@GetMapping(value = "/ticket/nextTicketForToDayAndUser/{idUser}")
	public  TicketDto getNextTicketForToDayAndUser(@PathVariable Integer idUser) {
		return iTicketService.getNextTicketForToDayAndUser(idUser);
	}
}
