package fr.restauration.skikda.entities;

import java.math.BigDecimal;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonSetter;

@Entity
@Table(name="TB_INFORMATION_TCIKET")
public class InformationTicket {

	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Id
	private Integer id;
	@OneToOne(fetch = FetchType.LAZY)
	@JoinColumn(name="FK_PRODUIT_INFO")
	private Produit produit;
	private Integer quantite;
	@Column(name="MONT_HT", precision = 20, scale = 2)
	private BigDecimal montantHT;
	
	@Column(name="MONT_TTC", precision = 20, scale = 2) 
	private BigDecimal montantTTC;
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name="FK_TICKET_INFO")
	private Ticket ticket;
	
	public InformationTicket() {
		
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	@JsonIgnore
	public Produit getProduit() {
		return produit;
	}

	@JsonSetter
	public void setProduit(Produit produit) {
		this.produit = produit;
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
	
	
	@JsonIgnore
	public Ticket getTicket() {
		return ticket;
	}
	
	@JsonSetter
	public void setTicket(Ticket ticket) {
		this.ticket = ticket;
	}

	@Override
	public String toString() {
		return "InformationTicket [id=" + id + ", quantite=" + quantite + ", montantHT=" + montantHT + ", montantTTC="
				+ montantTTC + "]";
	}
	
	
	
	
	
}
