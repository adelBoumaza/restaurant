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

@Entity
@Table(name="TB_PRODUCT")
public class Produit {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "PK_ID")
	private Integer id;
	private String nomProduit;
	private BigDecimal prixInitialProduct;
	@OneToOne(fetch = FetchType.LAZY)
	@JoinColumn(name="FK_USER")
	private User user;
	@ManyToOne
	@JoinColumn(name="FK_CATEGORIE")
	private Categorie categorie;
	@OneToOne
	@JoinColumn(name="FK_PHOTO_PRODUIT")
	private PhotoProduit photoProduit;
	
	public Produit() {
		// TODO Auto-generated constructor stub
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getNomProduit() {
		return nomProduit;
	}

	public void setNomProduit(String nomProduit) {
		this.nomProduit = nomProduit;
	}

	public BigDecimal getPrixInitialProduct() {
		return prixInitialProduct;
	}

	public void setPrixInitialProduct(BigDecimal prixInitialProduct) {
		this.prixInitialProduct = prixInitialProduct;
	}

	

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public Categorie getCategorie() {
		return categorie;
	}

	public void setCategorie(Categorie categorie) {
		this.categorie = categorie;
	}

	public PhotoProduit getPhotoProduit() {
		return photoProduit;
	}

	public void setPhotoProduit(PhotoProduit photoProduit) {
		this.photoProduit = photoProduit;
	}

	@Override
	public String toString() {
		return "Produit [id=" + id + ", nomProduit=" + nomProduit + ", prixInitialProduct=" + prixInitialProduct + "]";
	}
	
	
	
}
