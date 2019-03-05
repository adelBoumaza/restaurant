package fr.restauration.skikda.service;

import java.io.IOException;
import java.util.List;

import org.springframework.web.multipart.MultipartFile;

import fr.restauration.skikda.dto.CommandeDto;
import fr.restauration.skikda.dto.ProduitDto;

public interface IProduitService {

	ProduitDto ajouterUnProduit(ProduitDto produitDto);
	
	ProduitDto upladeImage(MultipartFile file,String nomCategorie,Integer idUser) throws IOException;
	
	List<CommandeDto> getAllProduitByUser(Integer id);

}
