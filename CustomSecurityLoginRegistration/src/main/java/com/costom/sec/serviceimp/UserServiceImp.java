package com.costom.sec.serviceimp;

import java.util.HashSet;
import java.util.List;
import java.util.Set;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

import com.costom.sec.entity.Role;
import com.costom.sec.entity.User;
import com.costom.sec.repo.RoleRepo;
import com.costom.sec.repo.UserRepo;
import com.costom.sec.service.UserService;

@Component
public class UserServiceImp implements UserService {

	
	private final UserRepo userRepo;
	private final RoleRepo roleRepo;
	private final PasswordEncoder passwordEncoder;
	
	public UserServiceImp(UserRepo userRepo,RoleRepo roleRepo,PasswordEncoder passwordEncoder) {
		this.userRepo =userRepo;
		this.roleRepo =roleRepo;
		this.passwordEncoder =passwordEncoder;
	}
	
	@Override
	public User registerUser(User user, String roleName) {
		user.setPassword(passwordEncoder.encode(user.getPassword()));
		Role selectedRole = roleRepo.findByName(roleName);
		Set<Role> roles =new HashSet<>();
		roles.add(selectedRole);
		user.setRoles(roles);
		return userRepo.save(user);
	}

	@Override
	public User findByUserName(String username) {
		return userRepo.finfindByUserName(username).orElse(null);
	}

	@Override
	public List<Role> getAllRole() {
		return roleRepo.findAll();
	}

}
