package fr.restauration.skikda.entities;

import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonSetter;

@Entity
@Table(name="TB_TICKET")
public class Ticket {

	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Id
	private Integer id;
	
	@OneToOne(fetch = FetchType.LAZY)
	@JoinColumn(name="FK_COMMANDE_TICKET")
	private Commande commande;
	private String numeroTicket;
	@Column(name="MONT_TOT_HT", precision = 20, scale = 2)
	private BigDecimal totalCommandeHT;
	@Column(name="MONT_TOT_TTC", precision = 20, scale = 2)
	private BigDecimal totalCommandeTTC;
	
	private Date dateCreation;
	
	public Ticket() {
		
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
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

	public String getNumeroTicket() {
		return numeroTicket;
	}

	public void setNumeroTicket(String numeroTicket) {
		this.numeroTicket = numeroTicket;
	}

	@JsonIgnore
	public Commande getCommande() {
		return commande;
	}

	@JsonSetter
	public void setCommande(Commande commande) {
		this.commande = commande;
	}

	public Date getDateCreation() {
		return dateCreation;
	}

	public void setDateCreation(Date dateCreation) {
		this.dateCreation = dateCreation;
	}
	
	
	
	
}
