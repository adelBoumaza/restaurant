package fr.restauration.skikda.rest;

import java.io.File;
import java.io.IOException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import fr.restauration.skikda.dto.ProfileDto;
import fr.restauration.skikda.service.IProfileService;

@RestController
@RequestMapping(value="/api/v1")
public class ProfileRest {

	@Autowired
	private IProfileService profileService;
	
	@PostMapping(value = {"/profile/saveOrUpdate"})
	public ProfileDto personaliserProfile(@RequestBody ProfileDto profileDto) throws IOException 
	{

		ProfileDto responseDto =  profileService.personaliserProfile(profileDto);
		
		return responseDto;
	}
	
	@PostMapping(value = {"/profile/saveOrUpdatePicture/{idUSer}"})
	public ResponseEntity<Object> saveorUpdate(@RequestParam(value = "file", required=false,defaultValue = "") MultipartFile multipartFile,
            @PathVariable Integer idUSer) throws IOException {
		
		profileService.prsonalisaerProfileImage(idUSer, multipartFile);
		
		return new ResponseEntity<>("le logo bien été enregistrer",HttpStatus.OK);
	}
	
	@GetMapping("/profile/getProfileByUser/{idUser}")
	public ProfileDto getProfileByUser(@PathVariable Integer idUser) {
		
		return profileService.profileDtoByUser(idUser);
	}
}
