package fr.restauration.skikda.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Lob;
import javax.persistence.Table;

@Entity
@Table(name="TB_PHOTO_PRODUIT")
public class PhotoProduit {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "PK_ID")
	private Integer id;
	@Lob
	private byte[] photoProduit;
	
	public PhotoProduit() {
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public byte[] getPhotoProduit() {
		return photoProduit;
	}

	public void setPhotoProduit(byte[] photoProduit) {
		this.photoProduit = photoProduit;
	}

	@Override
	public String toString() {
		return "PhotoProduit [id=" + id + "]";
	}
	
	
	
}
