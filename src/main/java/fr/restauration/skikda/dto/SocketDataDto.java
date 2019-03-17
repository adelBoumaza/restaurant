package fr.restauration.skikda.dto;

public class SocketDataDto {

	private String numeroTicket;
	private String statut;
	private String cssClass;
	
	public SocketDataDto() {
		
	}
	
	

	public SocketDataDto(String numeroTicket, String statut, String cssClass) {
		super();
		this.numeroTicket = numeroTicket;
		this.statut = statut;
		this.cssClass = cssClass;
	}



	public String getNumeroTicket() {
		return numeroTicket;
	}

	public void setNumeroTicket(String numeroTicket) {
		this.numeroTicket = numeroTicket;
	}

	public String getStatut() {
		return statut;
	}

	public void setStatut(String statut) {
		this.statut = statut;
	}

	public String getCssClass() {
		return cssClass;
	}

	public void setCssClass(String cssClass) {
		this.cssClass = cssClass;
	}



	@Override
	public String toString() {
		return "SocketDataDto [numeroTicket=" + numeroTicket + ", statut=" + statut + ", cssClass=" + cssClass + "]";
	}
	
	
	
}
