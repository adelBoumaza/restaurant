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
import javax.persistence.JoinTable;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonSetter;

@Entity
@Table(name="TB_COMMANDE")
public class Commande {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="PK_ID")
	private Integer id;
	private String numeroTicket;
	@Column(name="MONT_TOT_HT", precision = 20, scale = 2)
	private BigDecimal totalCommandeHT;
	@Column(name="MONT_TOT_TTC", precision = 20, scale = 2)
	private BigDecimal totalCommandeTTC;
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="FK_USER")
	private User user;
	@OneToMany
	@JoinTable(name="TB_PRODUIT_COMMANDE")
	private List<Produit> produits;
	private boolean actived;
	private Date dateDeCreation;
	private String statut = "En cours de Préparation";
	
	public Commande() {
		
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
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

	@JsonIgnore
	public User getUser() {
		return user;
	}

	@JsonSetter
	public void setUser(User user) {
		this.user = user;
	}

	@JsonIgnore
	public List<Produit> getProduits() {
		return produits;
	}
	@JsonSetter
	public void setProduits(List<Produit> produits) {
		this.produits = produits;
	}

	public boolean isActived() {
		return actived;
	}

	public void setActived(boolean actived) {
		this.actived = actived;
	}

	public Date getDateDeCreation() {
		return dateDeCreation;
	}

	public void setDateDeCreation(Date dateDeCreation) {
		this.dateDeCreation = dateDeCreation;
	}

	public String getStatut() {
		return statut;
	}

	public void setStatut(String statut) {
		this.statut = statut;
	}

	@Override
	public String toString() {
		return "Commande [id=" + id + ", numeroTicket=" + numeroTicket + ", totalCommandeHT=" + totalCommandeHT
				+ ", totalCommandeTTC=" + totalCommandeTTC + ", actived=" + actived + ", dateDeCreation="
				+ dateDeCreation + ", statut=" + statut + "]";
	}
	
	
	
	
	
	
}
