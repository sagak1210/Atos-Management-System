package com.atos.management.system.service.Implementation;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.atos.management.system.dto.UserDto;
import com.atos.management.system.entity.Role;
import com.atos.management.system.entity.User;
import com.atos.management.system.repository.RoleRepository;
import com.atos.management.system.repository.UserRepository;
import com.atos.management.system.service.UserService;

@Service
public class UserServiceImplementation implements UserService {

	private UserRepository userRepository;
	private RoleRepository roleRepository;
	private PasswordEncoder passwordEncoder;

	public UserServiceImplementation(UserRepository userRepository, RoleRepository roleRepository,
			PasswordEncoder passwordEncoder) {
		this.userRepository = userRepository;
		this.roleRepository = roleRepository;
		this.passwordEncoder = passwordEncoder;

	}

	@Override
	public void saveUser(UserDto userDto) {
		User user = new User();
		user.setName(userDto.getFirstName() + " " + userDto.getLastName());
		user.setEmail(userDto.getEmail());
		user.setPassword(passwordEncoder.encode(userDto.getPassword()));

		Role role = roleRepository.findByName("ROLE_ADMIN");
		if (role == null) {
			role = checkRoleExist();

		}

		user.setRoles(Arrays.asList(role));
		userRepository.save(user);

	}

	private Role checkRoleExist() {
		// TODO Auto-generated method stub
		Role role = new Role();
		role.setName("ROLE_ADMIN");
		return roleRepository.save(role);
	}

	@Override
	public User findUserByEmail(String email) {
		// TODO Auto-generated method stub
		return userRepository.findByEmail(email);
	}

	@Override
	public List<UserDto> findAllUsers() {
		List<User> users = userRepository.findAll();
		return users.stream().map((user) -> mapToUserDto(user)).collect(Collectors.toList());
	}

	private UserDto mapToUserDto(User user) {
		// TODO Auto-generated method stub
		UserDto userDto = new UserDto();
		String[] strings = user.getName().split(" ");
		userDto.setFirstName(strings[0]);
		userDto.setLastName(strings[1]);
		return userDto;

	}

}
