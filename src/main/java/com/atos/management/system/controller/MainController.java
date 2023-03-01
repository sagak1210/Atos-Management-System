package com.atos.management.system.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.atos.management.system.dto.UserDto;

@Controller
public class MainController {

	// handler for home page
	@GetMapping("/index.html")
	public String homePage() {
		return "index";
		
	}
	//handler for registration page
	@GetMapping("/register.html")
	public String registartionPage(Model model){
		UserDto userDto = new UserDto();
		model.addAttribute("user", userDto);
		return "register";

	}

}
