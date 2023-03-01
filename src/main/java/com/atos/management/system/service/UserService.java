package com.atos.management.system.service;

import java.util.List;

import com.atos.management.system.dto.UserDto;
import com.atos.management.system.entity.User;

public interface UserService {
	void saveUser(UserDto userDto);
	
	User findUserByEmail(String email);
	
	List<UserDto> findAllUsers();
	

}
