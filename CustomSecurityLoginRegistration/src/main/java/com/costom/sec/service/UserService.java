package com.costom.sec.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.costom.sec.entity.Role;
import com.costom.sec.entity.User;

@Service
public interface UserService {

	User registerUser(User user,String roleName);
	
	User findByUserName(String username);
	
	List<Role> getAllRole();
}
