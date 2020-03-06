package com.joenpaco.services;

import java.util.List;

import org.springframework.http.ResponseEntity;

import com.joenpaco.models.Usuario;


public interface UsuarioService {
	
	public abstract List<Usuario> findAll();
	
	public abstract Usuario findById(String id);
	
	public abstract ResponseEntity<Usuario> addNewUsuario(Usuario usuario);
	
	public abstract ResponseEntity<Usuario> updateUsuario(Usuario usuario);
	
	public abstract ResponseEntity<Usuario> deleteById(Usuario usuario);

}
