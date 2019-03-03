package fr.restauration.skikda.dto;

import java.math.BigDecimal;

public class ProduitDto {
	private Integer id;
	private String nomProduit;
	private BigDecimal prixInitialProduct;
	private Integer idUser;
	private String nomCategorie;
	private String path;
	private String nomImage;
	
	public ProduitDto() {
	}
	
	

	


	public Integer getIdUser() {
		return idUser;
	}



	public void setIdUser(Integer idUser) {
		this.idUser = idUser;
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




	public String getNomCategorie() {
		return nomCategorie;
	}

	public void setNomCategorie(String nomCategorie) {
		this.nomCategorie = nomCategorie;
	}

	public String getPath() {
		return path;
	}

	public void setPath(String path) {
		this.path = path;
	}

	public String getNomImage() {
		return nomImage;
	}

	public void setNomImage(String nomImage) {
		this.nomImage = nomImage;
	}

	@Override
	public String toString() {
		return "ProduitDto [id=" + id + ", nomProduit=" + nomProduit + ", prixInitialProduct=" + prixInitialProduct
				+ ", user=" + idUser + ", categorie="+ ", nomCategorie=" + nomCategorie + ", path=" + path
				+ ", nomImage=" + nomImage + "]";
	}
	
	
}
