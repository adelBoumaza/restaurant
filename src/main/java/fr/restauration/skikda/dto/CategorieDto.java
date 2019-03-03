package fr.restauration.skikda.dto;


public class CategorieDto {

	private Integer id;
	private String nomCategorie;
	private boolean active;
	
	public CategorieDto() {
		
	}
	
	

	public CategorieDto(Integer id, String nomCategorie, boolean active) {
		super();
		this.id = id;
		this.nomCategorie = nomCategorie;
		this.active = active;
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

	public boolean isActive() {
		return active;
	}

	public void setActive(boolean active) {
		this.active = active;
	}



	@Override
	public String toString() {
		return "CategorieDto [id=" + id + ", nomCategorie=" + nomCategorie + ", active=" + active + "]";
	}
	
	
	
	
}
