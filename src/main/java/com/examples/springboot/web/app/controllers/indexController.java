package com.examples.springboot.web.app.controllers;

//import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Value;

//import java.util.Map;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
//import org.springframework.web.servlet.ModelAndView;

import com.examples.springboot.web.app.models.Usuario;

@Controller
@RequestMapping("/app")
public class indexController {
	
	@Value("${texto.indexcontroller.index.titulo}")
	private String textoIndex;
	
	@Value("${texto.indexcontroller.perfil.titulo}")
	private String textoPerfil;
	
	@Value("${texto.indexcontroller.listar.titulo}")
	private String textoListar;
	
	
	@GetMapping({"/index","/","","/home"})
	public String index(Model model) {
		model.addAttribute("titulo", textoIndex);
		return "index";
	}
	
	@GetMapping("/perfil")
	public String perfil(Model model) {
		
		Usuario usuario = new Usuario();
		usuario.setNombre("oscar");
		usuario.setApellido("cervantes");
		usuario.setEmail("OC@email.com");
		
		model.addAttribute("usuario",usuario);
		model.addAttribute("titulo", textoPerfil.concat(usuario.getNombre()));
		return "perfil";
	}
	
	@GetMapping("/listar")
	public String listar(Model model) {
		
		model.addAttribute("titulo", textoListar);
		
		return "listar";
		/*
		List<Usuario> usuarios = new ArrayList<>();
		usuarios.add(new Usuario("Oscar","Cervantes","oc@email.com"));
		usuarios.add(new Usuario("Carlos","garcia","cg@email.com"));
		usuarios.add(new Usuario("Adriana","Barona","ab@email.com"));
		*/
		//model.addAttribute("usuarios", usuarios);
	}
	
	@ModelAttribute("usuarios")
	public List<Usuario> poblarUsuarios(){
		List<Usuario> usuarios = Arrays.asList(new Usuario("Oscar","Cervantes","oc@email.com"),
				new Usuario("Carlos","Garcia","cg@email.com"),
				new Usuario("Adriana","Barona","ab@email.com"),
				new Usuario("Liz","Garcia","lg@email.com")
				);
		
		return usuarios;
		
	}
	
	
    /*
	@GetMapping({"/index","/","/home"})
	public ModelAndView index(ModelAndView mv) {
		mv.addObject("titulo","hola Spring Framework con ModelAndView!");
		mv.setViewName("index");
		return mv;
	}
	/*
	@GetMapping({"/index","/","/home"})
	public String index(Map<String,Object> map) {
		map.put("titulo", "Hola Spring Framework con map!");
		return "index";
	}
		*/
}
