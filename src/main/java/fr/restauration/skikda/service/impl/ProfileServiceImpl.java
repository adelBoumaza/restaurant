package fr.restauration.skikda.service.impl;

import java.io.File;
import java.io.IOException;
import java.util.Base64;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;

import fr.restauration.skikda.dto.ProfileDto;
import fr.restauration.skikda.entities.Profile;
import fr.restauration.skikda.entities.User;
import fr.restauration.skikda.repository.IProfileRepository;
import fr.restauration.skikda.service.IProfileService;
@Service
@Transactional(readOnly=false)
public class ProfileServiceImpl implements IProfileService{

	@Autowired
	private IProfileRepository iProfileRepository;

	@Override
	public ProfileDto personaliserProfile(ProfileDto profileDto) {
		
		Profile profile = iProfileRepository.findOneProfileByUser(profileDto.getIdUser());
		Profile profileEntity = new Profile();
		User user = new User();
		user.setId(profileDto.getIdUser());
		profileEntity.setAdresse(profileDto.getAdresse());
		profileEntity.setNom(profileDto.getNom());
		profileEntity.setPrenom(profileDto.getPrenom());
		profileEntity.setNomRestaurant(profileDto.getNomRestaurant());
		profileEntity.setNumeroSiret(profileDto.getSiret());
		profileEntity.setNumeroTel(profileDto.getNumeroTel());
		profileEntity.setUser(user);
		if(profile != null) {
			profileEntity.setId(profile.getId());
		}
		
		iProfileRepository.save(profileEntity);
		profileDto.setId(profileEntity.getId());
		
		return profileDto;
	}

	@Override
	public void prsonalisaerProfileImage(Integer idUser,MultipartFile multipartFile) throws IOException {
		Profile profile = iProfileRepository.findOneProfileByUser(idUser);
		if(profile != null) {
			File convFile = new File(Optional.ofNullable(multipartFile).map(multi -> multi.getOriginalFilename()).orElse(""));
			User user = new User();
			user.setId(idUser);
			profile.setUser(user);
			profile.setNomFichier(convFile.getName());
			profile.setLogo(multipartFile != null ? multipartFile.getBytes():null);
			iProfileRepository.save(profile);
		}
	}

	@Override
	public ProfileDto profileDtoByUser(Integer idUser) {
		Profile profile = iProfileRepository.findOneProfileByUser(idUser);
		ProfileDto profileDto = Optional.ofNullable(profile)
				.map(dto -> new ProfileDto(profile.getId(), profile.getNom(),
						profile.getPrenom(),
						profile.getNomRestaurant(), profile.getAdresse(),
						profile.getNumeroSiret(), profile.getNumeroTel(),
						profile.getUser().getId(),
						Base64.getEncoder().withoutPadding().encodeToString(profile.getLogo() != null ? profile.getLogo():null),
						profile.getNomFichier(),getExtensionByStringHandling(profile.getNomFichier()).get()))
				.orElse(null);
		
		return profileDto;
	}
	
	
	private Optional<String> getExtensionByStringHandling(String filename) {
	    return Optional.ofNullable(filename)
	      .filter(f -> f.contains("."))
	      .map(f -> f.substring(filename.lastIndexOf(".") + 1));
	}
	
	
	
}
