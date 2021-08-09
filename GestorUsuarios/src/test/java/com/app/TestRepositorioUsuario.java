package com.app;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase.Replace;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.test.annotation.Rollback;

@DataJpaTest
@AutoConfigureTestDatabase(replace = Replace.NONE)
@Rollback(false)
public class TestRepositorioUsuario {
	
	@Autowired
	private RepositorioUsuario rep;
	
	@Autowired
    private TestEntityManager entityManager;
	
	@Test
	public void testCreateUser() {
	    Usuario usuario = new Usuario();
	    usuario.setNombre("Jon");
	    usuario.setEdad(25);
	    usuario.setEmail("jon@gmail.com");
	    usuario.setContraseña("jonpass");
	     
	    Usuario usuarioGuardado = rep.save(usuario);
	     
	    Usuario usuarioExistente = entityManager.find(Usuario.class, usuarioGuardado.getId());
	     
	    assertThat(usuario.getEmail()).isEqualTo(usuarioExistente.getEmail());
	     
	}
}
