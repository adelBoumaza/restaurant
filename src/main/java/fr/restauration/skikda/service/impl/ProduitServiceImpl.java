package fr.restauration.skikda.service.impl;

import java.io.Console;
import java.io.IOException;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;

import fr.restauration.skikda.dto.CommandeDto;
import fr.restauration.skikda.dto.ProduitDto;
import fr.restauration.skikda.entities.Categorie;
import fr.restauration.skikda.entities.Produit;
import fr.restauration.skikda.entities.User;
import fr.restauration.skikda.repository.ICategorieRepository;
import fr.restauration.skikda.repository.IProduitRepository;
import fr.restauration.skikda.service.IProduitService;
import fr.restauration.skikda.util.Constant;
@Service
@Transactional(readOnly = false)
public class ProduitServiceImpl implements IProduitService{

	@Autowired
	private ICategorieRepository iCategorieRepository;
		
	@Autowired
	private IProduitRepository iProduitRepository;
	
	@Override
	@Transactional(readOnly = false)
	public ProduitDto ajouterUnProduit(ProduitDto produitDto) {
		User user = new User();
		user.setId(produitDto.getIdUser());
		Categorie categorie = 
					Optional.ofNullable(iCategorieRepository.findByNomCategorie(produitDto.getNomCategorie())).orElse(null); 			
		if(categorie == null) {
			categorie = iCategorieRepository.save(new Categorie(produitDto.getNomCategorie()));
			Constant.createRepertoire(produitDto.getNomCategorie());
		}
		StringBuilder stringBuilder = new StringBuilder();
		String path = stringBuilder.append(Constant.uploadDirectory)
					 .append("/").append(categorie.getNomCategorie())
					 .append("/").append(produitDto.getNomImage()).toString();
		Produit produit = new Produit();
		produit.setNomImage(produitDto.getNomImage());
		produit.setNomProduit(produitDto.getNomProduit());
		produit.setPrixInitialProduct(produitDto.getPrixInitialProduct());
		produit.setPath(path);
		produit.setUser(user);
		produit.setCategorie(categorie);
		iProduitRepository.save(produit);
		return produitDto;
	}

	@Override
	public ProduitDto upladeImage(MultipartFile file, String nomCategorie) throws IOException {
		ProduitDto produitDto = new ProduitDto();
		Map<String, String> map =  Constant.chargerLimageDansLeServeur(file, nomCategorie);
		String pathFile = map.keySet().stream().map(path -> path).collect(Collectors.joining());
		String nameFile = map.values().stream().map(path -> path).collect(Collectors.joining());
		produitDto.setNomImage(nameFile);
		produitDto.setPath(pathFile);
		return produitDto;
	}

	@Override
	@Transactional(readOnly = true)
	public List<CommandeDto> getAllProduitByUser(Integer id) {
		List<Produit> data = iProduitRepository.getAllProduit(id);
		List<CommandeDto> commandeDtos = Optional.
				ofNullable(data)
				.get()
				.stream()
				.map(produit -> new CommandeDto(produit.getPath(), produit.getPrixInitialProduct(),
								produit.getPrixInitialProduct(), produit.getId(),
								produit.getCategorie().getId(), 1, produit.getNomProduit()))
				.collect(Collectors.toList());
				
		return commandeDtos;
	}
	

}
