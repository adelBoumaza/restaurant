package fr.restauration.skikda.service;

import fr.restauration.skikda.entities.User;

public interface IUserService {

	
	User saveUser(User user);
	
	User getByUsername(String username);
	
}