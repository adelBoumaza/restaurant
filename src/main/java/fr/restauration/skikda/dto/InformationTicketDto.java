package fr.restauration.skikda.dto;

import java.math.BigDecimal;


public class InformationTicketDto {

	private Integer id;
	private Integer idProduit;
	private Integer idTicket;
	private Integer quantite;
	private BigDecimal montantHT;
	private BigDecimal montantTTC;
	
	
	
	public InformationTicketDto(Integer idProduit, Integer quantite, BigDecimal montantHT, BigDecimal montantTTC) {
		super();
		this.idProduit = idProduit;
		this.quantite = quantite;
		this.montantHT = montantHT;
		this.montantTTC = montantTTC;
	}

	public InformationTicketDto() {
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Integer getIdProduit() {
		return idProduit;
	}

	public void setIdProduit(Integer idProduit) {
		this.idProduit = idProduit;
	}

	public Integer getIdTicket() {
		return idTicket;
	}

	public void setIdTicket(Integer idTicket) {
		this.idTicket = idTicket;
	}

	public Integer getQuantite() {
		return quantite;
	}

	public void setQuantite(Integer quantite) {
		this.quantite = quantite;
	}

	public BigDecimal getMontantHT() {
		return montantHT;
	}

	public void setMontantHT(BigDecimal montantHT) {
		this.montantHT = montantHT;
	}

	public BigDecimal getMontantTTC() {
		return montantTTC;
	}

	public void setMontantTTC(BigDecimal montantTTC) {
		this.montantTTC = montantTTC;
	}

	@Override
	public String toString() {
		return "InformationTicketDto [id=" + id + ", idProduit=" + idProduit + ", idTicket=" + idTicket + ", quantite="
				+ quantite + ", montantHT=" + montantHT + ", montantTTC=" + montantTTC + "]";
	}
	
	
	
}
