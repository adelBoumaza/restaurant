package fr.restauration.skikda.rest;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import fr.restauration.skikda.dto.CommandeDto;
import fr.restauration.skikda.dto.SocketDataDto;
import fr.restauration.skikda.service.ICommandeService;

@RestController
@RequestMapping(value="/api/v1")
public class CommandeRest {

	@Autowired
	private ICommandeService iCommandeService;
	
	@PostMapping(value="/commande/saveOrUpdateCommande/{save}")
	public List<SocketDataDto> saveOrUpdateCommande(@RequestBody CommandeDto commandeDto,@PathVariable boolean save) {
		return iCommandeService.saveOrUpdateCommande(commandeDto, save);
	}
}
