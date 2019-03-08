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

@Entity
@Table(name="TB_COMMANDE")
public class Commande {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="PK_ID")
	private Integer id;
	private String numeroCommande;
	private BigDecimal totalCommandeHT;
	private BigDecimal totalCommandeTTC;
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="FK_USER")
	private User user;
	@OneToMany
	@JoinTable(name="FK_PRODUIT")
	private List<Produit> produits;
	private boolean actived;
	private Date dateDeCreation;
	
	
}
