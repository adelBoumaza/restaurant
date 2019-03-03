package fr.restauration.skikda.dto;

import java.util.Arrays;

public class ProfileDto {
	private Integer id;
	private String nom;
	private String prenom;
	private String nomRestaurant;
	private String adresse;
	private String siret;
	private byte[] logo;
	private String numeroTel;
	private Integer idUser;
	private String encodedImage;
	private String nomFichier;
	private String extentionFile;
	
	public ProfileDto() {
	}
	
	

	public ProfileDto(Integer id, String nom, String prenom, String nomRestaurant, String adresse, String siret,
			String numeroTel, Integer idUser, String encodedImage,String nomFichier,String extentionFile) {
		super();
		this.id = id;
		this.nom = nom;
		this.prenom = prenom;
		this.nomRestaurant = nomRestaurant;
		this.adresse = adresse;
		this.siret = siret;
		this.numeroTel = numeroTel;
		this.idUser = idUser;
		this.encodedImage = encodedImage;
		this.nomFichier = nomFichier;
		this.extentionFile = extentionFile;
	}



	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getNom() {
		return nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

	public String getPrenom() {
		return prenom;
	}

	public void setPrenom(String prenom) {
		this.prenom = prenom;
	}

	public String getNomRestaurant() {
		return nomRestaurant;
	}

	public void setNomRestaurant(String nomRestaurant) {
		this.nomRestaurant = nomRestaurant;
	}

	public String getAdresse() {
		return adresse;
	}

	public void setAdresse(String adresse) {
		this.adresse = adresse;
	}

	public String getSiret() {
		return siret;
	}

	public void setSiret(String siret) {
		this.siret = siret;
	}

	public byte[] getLogo() {
		return logo;
	}

	public void setLogo(byte[] logo) {
		this.logo = logo;
	}

	public String getNumeroTel() {
		return numeroTel;
	}

	public void setNumeroTel(String numeroTel) {
		this.numeroTel = numeroTel;
	}

	public Integer getIdUser() {
		return idUser;
	}

	public void setIdUser(Integer idUser) {
		this.idUser = idUser;
	}

	public String getEncodedImage() {
		return encodedImage;
	}

	public void setEncodedImage(String encodedImage) {
		this.encodedImage = encodedImage;
	}
	
	



	public String getNomFichier() {
		return nomFichier;
	}



	public void setNomFichier(String nomFichier) {
		this.nomFichier = nomFichier;
	}



	public String getExtentionFile() {
		return extentionFile;
	}



	public void setExtentionFile(String extentionFile) {
		this.extentionFile = extentionFile;
	}



	@Override
	public String toString() {
		return "ProfileDto [id=" + id + ", nom=" + nom + ", prenom=" + prenom + ", nomRestaurant=" + nomRestaurant
				+ ", adresse=" + adresse + ", siret=" + siret + ", logo=" + Arrays.toString(logo) + ", numeroTel="
				+ numeroTel + ", idUser=" + idUser + ", encodedImage=" + encodedImage + "]";
	}
	
	
	
}
