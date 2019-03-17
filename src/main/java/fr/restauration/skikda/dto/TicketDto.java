package fr.restauration.skikda.dto;

import java.math.BigDecimal;


public class TicketDto {

	private Integer id;
	private Integer idCommande;
	private String numeroTicket;
	private BigDecimal totalCommandeHT;
	private BigDecimal totalCommandeTTC;
	
	
	
	public TicketDto(String numeroTicket, BigDecimal totalCommandeHT, BigDecimal totalCommandeTTC) {
		super();
		this.numeroTicket = numeroTicket;
		this.totalCommandeHT = totalCommandeHT;
		this.totalCommandeTTC = totalCommandeTTC;
	}


	public TicketDto() {
		// TODO Auto-generated constructor stub
	}


	public Integer getId() {
		return id;
	}


	public void setId(Integer id) {
		this.id = id;
	}


	public Integer getIdCommande() {
		return idCommande;
	}


	public void setIdCommande(Integer idCommande) {
		this.idCommande = idCommande;
	}


	public String getNumeroTicket() {
		return numeroTicket;
	}


	public void setNumeroTicket(String numeroTicket) {
		this.numeroTicket = numeroTicket;
	}


	public BigDecimal getTotalCommandeHT() {
		return totalCommandeHT;
	}


	public void setTotalCommandeHT(BigDecimal totalCommandeHT) {
		this.totalCommandeHT = totalCommandeHT;
	}


	public BigDecimal getTotalCommandeTTC() {
		return totalCommandeTTC;
	}


	public void setTotalCommandeTTC(BigDecimal totalCommandeTTC) {
		this.totalCommandeTTC = totalCommandeTTC;
	}


	@Override
	public String toString() {
		return "TicketDto [id=" + id + ", idCommande=" + idCommande + ", numeroTicket=" + numeroTicket
				+ ", totalCommandeHT=" + totalCommandeHT + ", totalCommandeTTC=" + totalCommandeTTC + "]";
	}
	
	
	
}
