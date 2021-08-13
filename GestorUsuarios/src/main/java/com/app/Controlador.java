package com.app;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AnonymousAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
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
		
		BCryptPasswordEncoder codificador = new BCryptPasswordEncoder();
		usuario.setContrasena(codificador.encode(usuario.getContrasena()));
		
		try {
			rep.save(usuario);
		} catch (Exception e) {
			return "error";
		}
		
		return "altaCompletada";
	}
	
	@GetMapping("/login")
	public String mostrarAutenticacionUsuarios() {
		Authentication autenticacion = SecurityContextHolder.getContext().getAuthentication();
		if (autenticacion == null || autenticacion instanceof AnonymousAuthenticationToken) {
			return "autenticacionUsuarios";
		}
		
		return "redirect:/";
	}
	
	@GetMapping("/listado")
	public String mostrarListado(Model model) {
		
		List<Usuario> listado = rep.findAll();
	    model.addAttribute("listado", listado);
	    
		return "listadoUsuarios";
	}
}
