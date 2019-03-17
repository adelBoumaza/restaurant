package fr.restauration.skikda.dto;



import java.util.ArrayList;
import java.util.List;

public class CommandeDto {
	private Integer id;
	private Integer idUser;
	private boolean actived;
	private String dateDeCreation;
	private String statut;
	private TicketDto ticketDto = new TicketDto ();
	private List<InformationTicketDto> informationTicketDtos = new ArrayList<>();
	
	public CommandeDto() {
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	

	public Integer getIdUser() {
		return idUser;
	}

	public void setIdUser(Integer idUser) {
		this.idUser = idUser;
	}

	public boolean isActived() {
		return actived;
	}

	public void setActived(boolean actived) {
		this.actived = actived;
	}

	public String getDateDeCreation() {
		return dateDeCreation;
	}

	public void setDateDeCreation(String dateDeCreation) {
		this.dateDeCreation = dateDeCreation;
	}

	public String getStatut() {
		return statut;
	}

	public void setStatut(String statut) {
		this.statut = statut;
	}

	public TicketDto getTicketDto() {
		return ticketDto;
	}

	public void setTicketDto(TicketDto ticketDto) {
		this.ticketDto = ticketDto;
	}

	public List<InformationTicketDto> getInformationTicketDtos() {
		return informationTicketDtos;
	}

	public void setInformationTicketDtos(List<InformationTicketDto> informationTicketDtos) {
		this.informationTicketDtos = informationTicketDtos;
	}
	
	
}
