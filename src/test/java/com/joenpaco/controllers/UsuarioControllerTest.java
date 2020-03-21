package com.joenpaco.controllers;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;

import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import com.joenpaco.models.Usuario;
import com.joenpaco.services.UsuarioService;
import com.joenpaco.utils.Factory;

class UsuarioControllerTest {
	
	@InjectMocks
	private UsuarioController usuarioController;
	
	@Mock
	private UsuarioService usuarioService;

	@BeforeEach
	void setUp() throws Exception {
		MockitoAnnotations.initMocks(this);
	}

	@Test
	void testAddNewUsuario() {
		
		// 1.- Arrange
		Usuario usuarioFalso;
		
		usuarioFalso = Factory.getUsuario();
		
		ResponseEntity<Usuario> usuarioResponse = new ResponseEntity<Usuario>(usuarioFalso, HttpStatus.CREATED);
		
		when(usuarioService.addNewUsuario(usuarioFalso)).thenReturn(usuarioResponse);
		
		// 2.- Act
		ResponseEntity<Usuario> usuario = usuarioService.addNewUsuario(usuarioFalso);
		
		// 3.- Assert
		assertEquals("Manuel Parico", usuario.getBody().getUsername());

		
	}

	@Test
	void testFindAllUsuarios() {
		
		// 1.- Arrange
		List<Usuario> usuariosFalsos = Factory.getUsuarios();
		
		when(usuarioService.findAll()).thenReturn(usuariosFalsos);
		
		// 2.- Act
		List<Usuario> usuarios = usuarioService.findAll();
		
		// 3.- Assert
		assertEquals(3, usuarios.size());

		
	}

	@Test
	void testUpdate() {
		
		// 1.- Arrange
		Usuario usuarioFalso;
		
		usuarioFalso = Factory.getUsuario();
		
		ResponseEntity<Usuario> usuarioResponse = new ResponseEntity<Usuario>(usuarioFalso, HttpStatus.OK);
		
		when(usuarioService.updateUsuario(usuarioFalso)).thenReturn(usuarioResponse);
		
		// 2.- Act
		ResponseEntity<Usuario> usuario = usuarioService.updateUsuario(usuarioFalso);
		
		// 3.- Assert
		assertEquals(3, usuario.getBody().getId());

	}

	@Test
	void testDeleteById() {
		
		// 1.- Arrange
		Usuario usuarioFalso;
		
		usuarioFalso = Factory.getUsuario();
		
		ResponseEntity<Usuario> usuarioResponse = new ResponseEntity<Usuario>(usuarioFalso, HttpStatus.GONE);
		
		when(usuarioService.deleteById(usuarioFalso)).thenReturn(usuarioResponse);
		
		// 2.- Act
		ResponseEntity<Usuario> usuario = usuarioService.deleteById(usuarioFalso);
		
		// 3.- Assert
		assertEquals(410, usuario.getStatusCodeValue());

		
	}

}
