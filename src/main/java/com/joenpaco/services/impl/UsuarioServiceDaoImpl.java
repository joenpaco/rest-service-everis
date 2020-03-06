package com.joenpaco.services.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.joenpaco.daos.UsuarioRepository;
import com.joenpaco.error.UsuarioNameException;
import com.joenpaco.error.UsuarioEmailException;
import com.joenpaco.error.UsuarioNotFoundException;
import com.joenpaco.models.Usuario;
import com.joenpaco.services.UsuarioService;


@Service
public class UsuarioServiceDaoImpl implements UsuarioService{
	
	@Autowired
	private UsuarioRepository usuarioRepository;
	
	@Override
	public Usuario findById(String id) {
		
		Usuario usuario = usuarioRepository.findById(Long.parseLong(id)).orElse(null);
		
		if (usuario == null) {
			throw new UsuarioNotFoundException("id: " + id + " No Existe");
		}
		
		return usuario;
	}
	
	public void findByUsername(String nombre) {

		Usuario usuario = this.usuarioRepository.findByUsername(nombre);

		if (usuario != null) {

			throw new UsuarioNameException("El nombre: " + nombre + " ya registrado");

		}

	}
	
	public void findByEmail(String email) {
		
		Usuario usuario = this.usuarioRepository.findByEmail(email);
		
		if (usuario != null) {
			
			throw new UsuarioEmailException("El correo: " + email + " ya registrado");
			
		}
		
	}
	
	@Override
	public ResponseEntity<Usuario> addNewUsuario(Usuario usuario) {
		
		findByUsername(usuario.getUsername());
		
		findByEmail(usuario.getEmail());
		
		usuarioRepository.save(usuario);
		
		return new ResponseEntity<Usuario>(usuario, HttpStatus.CREATED);
	}
	
	@Override
	public List<Usuario> findAll() {

		return usuarioRepository.findAll();
	}
	
	@Override
	public ResponseEntity<Usuario> updateUsuario(Usuario usuario) {
		
		findById(Long.toString(usuario.getId()));
		
		usuarioRepository.save(usuario);
		
		return new ResponseEntity<Usuario>(usuario, HttpStatus.OK);
	}

	@Override
	public ResponseEntity<Usuario> deleteById(Usuario usuario) {
		
		findById(Long.toString(usuario.getId()));
		
		usuarioRepository.delete(usuario);
		
		return new ResponseEntity<Usuario>(usuario, HttpStatus.GONE);
	}
	

}
