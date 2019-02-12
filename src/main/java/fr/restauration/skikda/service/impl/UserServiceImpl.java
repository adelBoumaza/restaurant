package fr.restauration.skikda.service.impl;

import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import fr.restauration.skikda.entities.Role;
import fr.restauration.skikda.entities.User;
import fr.restauration.skikda.repository.RoleRepository;
import fr.restauration.skikda.repository.UserRepository;
import fr.restauration.skikda.service.IUserService;



@Transactional(readOnly = true)
@Service
public class UserServiceImpl implements IUserService{

	@Autowired
	private UserRepository iUserRepository;
	
	@Autowired
	private RoleRepository iRoleRepository;
	
	@Autowired
	private PasswordEncoder passwordEncoder;
	
	@Override
	@Transactional(readOnly = false)
	public User saveUser(User user) {
		user.setPassword(passwordEncoder.encode(user.getPassword()));
		Role role = new Role("ROLE_ADMIN");
		iRoleRepository.save(role);
		user.setRoles(Arrays.asList(role));
		return iUserRepository.save(user);
	}
	
	@Override
	public User getByUsername(String username) {
		return iUserRepository.getByUserName(username);
	}

}