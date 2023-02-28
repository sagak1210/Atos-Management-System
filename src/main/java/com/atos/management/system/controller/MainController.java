package com.atos.management.system.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class MainController {

	// handler for homepage
	@GetMapping("/index.html")
	public String homePage() {
		return "index";

	}

}
