package fr.restauration.skikda.service.impl;




import java.util.Collections;
import java.util.Date;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import fr.restauration.skikda.dto.CommandeDto;
import fr.restauration.skikda.dto.InformationTicketDto;
import fr.restauration.skikda.dto.SocketDataDto;
import fr.restauration.skikda.dto.TicketDto;
import fr.restauration.skikda.entities.Commande;
import fr.restauration.skikda.entities.InformationTicket;
import fr.restauration.skikda.entities.Produit;
import fr.restauration.skikda.entities.Ticket;
import fr.restauration.skikda.entities.User;
import fr.restauration.skikda.repository.ICommandeRepository;
import fr.restauration.skikda.repository.IInformationTicketRepository;
import fr.restauration.skikda.repository.ITicketRepository;
import fr.restauration.skikda.service.ICommandeService;

@Transactional(readOnly = true)
@Service
public class CommandeServiceImpl implements ICommandeService{

	@Autowired
	private ICommandeRepository iCommandeRepository;
	
	@Autowired
	private ITicketRepository iTicketRepository;
	
	@Autowired
	private IInformationTicketRepository iInformationTicketRepository;
	
	@Transactional(readOnly = false)
	@Override
	public List<SocketDataDto> saveOrUpdateCommande(CommandeDto commandeDto,boolean save) {
		Commande commande = new Commande();
		User user = new User();
		user.setId(commandeDto.getIdUser());
		commande.setActived(true);
		commande.setDateDeCreation(new Date());
		commande.setStatut(commandeDto.getStatut());
		commande.setUser(user);
		//commande.setProduits(produits);
		iCommandeRepository.save(commande);
		Ticket ticket = new Ticket();
		ticket.setCommande(commande);
		ticket.setTotalCommandeTTC(commandeDto.getTicketDto().getTotalCommandeTTC());
		ticket.setTotalCommandeHT(commandeDto.getTicketDto().getTotalCommandeHT());
		ticket.setNumeroTicket(commandeDto.getTicketDto().getNumeroTicket());
		ticket.setDateCreation(new Date());
		iTicketRepository.save(ticket);
		commandeDto.getInformationTicketDtos().forEach(dto -> {
			InformationTicket informationTicket = new InformationTicket();
			informationTicket.setMontantHT(dto.getMontantHT());
			informationTicket.setMontantTTC(dto.getMontantTTC());
			Produit produit = new Produit();
			produit.setId(dto.getIdProduit());
			informationTicket.setProduit(produit);
			informationTicket.setQuantite(dto.getQuantite());
			informationTicket.setTicket(ticket);
			iInformationTicketRepository.save(informationTicket);
		});
		
		return getLastTicketCreatedByUser(commandeDto.getIdUser());
	}

	@Override
	public List<SocketDataDto> getLastTicketCreatedByUser(Integer idUser) {
		List<Object[]> dataSendigSocket = iTicketRepository.getLastTicketCreatedByUser(idUser);
		return Optional.ofNullable(dataSendigSocket)
				.orElse(Collections.emptyList())
				.stream()
				.map(data -> new SocketDataDto((String)data[0], (String)data[1], (String)data[2]))
				.collect(Collectors.toList());
	}

}
