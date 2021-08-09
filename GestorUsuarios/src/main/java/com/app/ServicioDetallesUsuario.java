package com.app;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

public class ServicioDetallesUsuario implements UserDetailsService {

	@Autowired
	private RepositorioUsuario rep;
	
	@Override
	public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
		Usuario usuario = rep.encontrarUsuarioPorEmail(email);
		if (usuario == null) {
			throw new UsernameNotFoundException("Usuario no encontrado");
		}
		
		return new DetallesUsuario(usuario);
	}

}
