package fr.restauration.skikda.util;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;


public class Constant {

	//public static String uploadDirectory = "/var/www/html/assets/images/imageProduit";
	public static String uploadDirectory = System.getProperty("user.dir")+"/images";
	public static final String urlImageFront   = "../../../assets/images/imageProduit";
	
	
	public  static void createRepertoire(String nomRepertoire,Integer idUser) {
		new File(Constant.uploadDirectory.concat("/User")+"/"+idUser+"/"
				.concat(nomRepertoire))
		.mkdirs();
	}
	
	public static Map<String, String> chargerLimageDansLeServeur(MultipartFile file, String nomCategorie,Integer idUser) throws IOException {
		Path fileNamePath = Paths.get(Constant.uploadDirectory.concat("/User")+"/"+idUser+"/"
				.concat(nomCategorie), file.getOriginalFilename());
		Files.write(fileNamePath, file.getBytes());
		String fileName = file.getOriginalFilename();
		Map<String, String> pathAndFileNAme = new HashMap<>();
		pathAndFileNAme.put(fileNamePath.toString(), fileName);
		return pathAndFileNAme;
	}

}
