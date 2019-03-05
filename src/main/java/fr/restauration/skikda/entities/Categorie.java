package fr.restauration.skikda.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name="TB_CATEGORIE")
public class Categorie {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "PK_ID")
	private Integer id;
	private String nomCategorie;
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name="FK_USER")
	private User user;
	
	public Categorie() {
		// TODO Auto-generated constructor stub
	}
	
	

	public User getUser() {
		return user;
	}






	public Categorie(String nomCategorie, User user) {
		super();
		this.nomCategorie = nomCategorie;
		this.user = user;
	}



	public void setUser(User user) {
		this.user = user;
	}






	public Categorie(String nomCategorie) {
		super();
		this.nomCategorie = nomCategorie;
	}



	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getNomCategorie() {
		return nomCategorie;
	}

	public void setNomCategorie(String nomCategorie) {
		this.nomCategorie = nomCategorie;
	}

	@Override
	public String toString() {
		return "Categorie [id=" + id + ", nomCategorie=" + nomCategorie + "]";
	}
	
	
	
}
