package com.app;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class Controlador {

	@Autowired
	private RepositorioUsuario rep;
	
	@GetMapping("")
	public String mostrarAltaUsuarios(Model model) {
		model.addAttribute("usuario", new Usuario());
		
		return "altaUsuarios";
	}
	
	@PostMapping("/registroUsuario")
	public String registrarUsuario(Usuario usuario) {
		rep.save(usuario);
		
		return "altaCompletada";
	}
}
