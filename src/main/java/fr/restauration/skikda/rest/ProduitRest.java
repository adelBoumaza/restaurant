package fr.restauration.skikda.rest;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import fr.restauration.skikda.dto.CommandeDto;
import fr.restauration.skikda.dto.ProduitDto;
import fr.restauration.skikda.entities.Produit;
import fr.restauration.skikda.service.IProduitService;

@RestController
@RequestMapping(value="/api/v1")
public class ProduitRest {

	@Autowired
	private IProduitService iProduitService;
	
	@PostMapping(value="/produit/telecharger/{nomCategorie}/{idUser}")
	public ResponseEntity<String> uploadImages(@RequestParam("file") MultipartFile file,
			@PathVariable ("nomCategorie") String nomCategorie,
			@PathVariable ("idUser") Integer idUser) throws IOException {
		
		ProduitDto produit = iProduitService.upladeImage(file, nomCategorie,idUser);
		return new ResponseEntity<>("l/'imaage a bien été chargé dans le serveur"
		+"[pathFile]="+produit.getPath()  + " [fileNAme]="+produit.getNomImage(),HttpStatus.OK);	
	}
	
	@PostMapping(value="/produit/ajouterProduit")
	public ProduitDto ajouterUnProduit(@RequestBody ProduitDto produitDto) {
		return iProduitService.ajouterUnProduit(produitDto);
	}
	@GetMapping(value="/produit/getAllProduitByUser/{idUser}")
	public List<CommandeDto> getAllProduitByUser(@PathVariable("idUser") Integer idUser) {
		return iProduitService.getAllProduitByUser(idUser);
	}

	
}
