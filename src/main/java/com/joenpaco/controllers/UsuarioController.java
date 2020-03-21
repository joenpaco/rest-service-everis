package com.joenpaco.controllers;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.annotation.Secured;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.joenpaco.models.Usuario;
import com.joenpaco.services.UsuarioService;


@RestController
public class UsuarioController {
	
	protected final Log logger = LogFactory.getLog(this.getClass());
	
	@Autowired
	private UsuarioService usuarioService;
	
	@Secured("ROLE_ADMIN")
	@PostMapping(value = "/add")
	public ResponseEntity<Usuario> addNewUsuario(@RequestBody Usuario usuario, Authentication authentication) {
		
		return usuarioService.addNewUsuario(usuario);
		
	}
	
	@GetMapping(value = {"/listar", "/"})
	public List<Usuario> findAllUsuarios(Authentication authentication, HttpServletRequest request) {
		
		if (authentication != null) {
			logger.info("Hola usuario autenticado, tu username es: ".concat(authentication.getName()));
		}
				
		return usuarioService.findAll();
	}

	
	@Secured("ROLE_ADMIN")
	@PutMapping(value = "/update")
	public ResponseEntity<Usuario> update(@RequestBody Usuario usuario) {
		
		return usuarioService.updateUsuario(usuario);
		
	}

	@Secured("ROLE_ADMIN")
	@DeleteMapping(value = "/delete")
	public ResponseEntity<Usuario> deleteById(@RequestBody Usuario usuario) {
		
		return usuarioService.deleteById(usuario);

	}



}
