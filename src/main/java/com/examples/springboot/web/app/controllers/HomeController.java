package com.examples.springboot.web.app.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;


@Controller
public class HomeController {
	
	@GetMapping("/")
	public String home() {
		
		return "forward:/app/index"; //forward te dirige a la raiz del proyecto interno 
		// return "redirect:/app/index"; NOTA: Te redirige a la pagia deseada cambiando el url
		
	}
	
}
