package fr.restauration.skikda.dto;

import java.math.BigDecimal;

public class DisplayProduitDto {

	private String pathImage;
	private BigDecimal prixToTal;
	private BigDecimal prixInitial;
	private Integer idProduit;
	private Integer idCategorie;
	private Integer quantite;
	private String libelle;
	
	public DisplayProduitDto() {
		// TODO Auto-generated constructor stub
	}
	
	

	public DisplayProduitDto(String pathImage, BigDecimal prixToTal, BigDecimal prixInitial, Integer idProduit,
			Integer idCategorie, Integer quantite, String libelle) {
		super();
		this.pathImage = pathImage;
		this.prixToTal = prixToTal;
		this.prixInitial = prixInitial;
		this.idProduit = idProduit;
		this.idCategorie = idCategorie;
		this.quantite = quantite;
		this.libelle = libelle;
	}



	public String getPathImage() {
		return pathImage;
	}

	public void setPathImage(String pathImage) {
		this.pathImage = pathImage;
	}

	public BigDecimal getPrixToTal() {
		return prixToTal;
	}

	public void setPrixToTal(BigDecimal prixToTal) {
		this.prixToTal = prixToTal;
	}

	public BigDecimal getPrixInitial() {
		return prixInitial;
	}

	public void setPrixInitial(BigDecimal prixInitial) {
		this.prixInitial = prixInitial;
	}

	public Integer getIdProduit() {
		return idProduit;
	}

	public void setIdProduit(Integer idProduit) {
		this.idProduit = idProduit;
	}

	public Integer getIdCategorie() {
		return idCategorie;
	}

	public void setIdCategorie(Integer idCategorie) {
		this.idCategorie = idCategorie;
	}

	public Integer getQuantite() {
		return quantite;
	}

	public void setQuantite(Integer quantite) {
		this.quantite = quantite;
	}

	public String getLibelle() {
		return libelle;
	}

	public void setLibelle(String libelle) {
		this.libelle = libelle;
	}
	
	
	
	
}
