package com.joenpaco.daos;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.joenpaco.models.Usuario;

public interface UsuarioRepository extends JpaRepository<Usuario, Long> {

	@Query("select u from Usuario u where u.username = ?1")
	Usuario findByUsername(String username);
	
	@Query("select u from Usuario u where u.email = ?1")
	Usuario findByEmail(String email);
	
}
