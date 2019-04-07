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
        
	public static String uploadDirectory = "/var/www/html/assets/images/imageProduit";
	//public static String uploadDirectory = System.getProperty("user.dir")+"/images";
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
	
	public static String incrementeTicket(String numerTicket) {
		Integer numeroTicketInteger = Integer.parseInt(numerTicket) + 1;
		String value = "";
		if(numeroTicketInteger < 10) {
	       return  value = "000"+numeroTicketInteger;
	    }
	    if(numeroTicketInteger >= 10 && numeroTicketInteger <100 ) {
	       return  value = "00"+numeroTicketInteger;
	    } 
	    if(numeroTicketInteger >= 100 && numeroTicketInteger < 1000) {
	       return value = "0"+numeroTicketInteger;
	    }
	    if(numeroTicketInteger >= 1000) {
	       return value = ""+numeroTicketInteger;
	    }
	    return value;
}

}
