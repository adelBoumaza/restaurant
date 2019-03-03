package fr.restauration.skikda.util;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.HashMap;
import java.util.Map;

import org.springframework.web.multipart.MultipartFile;

public class Constant {

	public static String uploadDirectory = "/var/www/html/assets/images/imageProduit";
	public static String urlImageFront   = "../../../assets/images/imageProduit";
	
	public  static void createRepertoire(String nomRepertoire) {
		new File(Constant.uploadDirectory.concat("/").concat(nomRepertoire)).mkdir();
	}
	
	public static Map<String, String> chargerLimageDansLeServeur(MultipartFile file, String nomCategorie) throws IOException {
		Path fileNamePath = Paths.get(Constant.uploadDirectory.concat("/").concat(nomCategorie), file.getOriginalFilename());
		Files.write(fileNamePath, file.getBytes());
		String fileName = file.getOriginalFilename();
		Map<String, String> pathAndFileNAme = new HashMap<>();
		pathAndFileNAme.put(fileNamePath.toString(), fileName);
		return pathAndFileNAme;
	}

}
