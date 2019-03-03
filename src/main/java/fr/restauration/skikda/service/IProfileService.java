package fr.restauration.skikda.service;

import java.io.IOException;

import org.springframework.web.multipart.MultipartFile;

import fr.restauration.skikda.dto.ProfileDto;

public interface IProfileService {
	
	ProfileDto personaliserProfile(ProfileDto profileDto);
	
	void prsonalisaerProfileImage(Integer idUser,MultipartFile multipartFile) throws IOException;
	
	ProfileDto profileDtoByUser(Integer idUser);
	
}
