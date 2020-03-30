package com.joenpaco.utils;

import java.io.IOException;
import java.util.Arrays;
import java.util.List;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.joenpaco.models.Usuario;

public class Factory {

	public static Usuario getUsuario() {
		
		Usuario usuario = null;
		
		try {
			
			usuario = new ObjectMapper().readValue("{\"id\":3,\"username\":\"Manuel Parico\",\"password\":\"Manuel77\",\"enabled\":true,\"creatAt\":\"2020-03-20T12:41:30.312+0000\",\"updatedAt\":\"2020-03-20T12:41:30.312+0000\",\"roles\":[{\"id\":3,\"authority\":\"ROLE_USER\"}],\"email\":\"manuel@manuel.com\",\"phones\":[{\"number\":\"1234567\",\"citycode\":\"1\",\"countrycode\":\"57\",\"phoneId\":1}]}", Usuario.class);
		
		} catch (IOException e) {

			throw new RuntimeException();
		}
		return usuario;
	}
	
	public static List<Usuario> getUsuarios(){
		
		Usuario usuario = null;
		Usuario usuario1 = null;
		Usuario usuario2 = null;
		
		try {
			
			usuario = new ObjectMapper().readValue("{\"id\":1,\"username\":\"Manuel Parico\",\"password\":\"Manuel77\",\"enabled\":true,\"creatAt\":\"2020-03-20T12:41:30.312+0000\",\"updatedAt\":\"2020-03-20T12:41:30.312+0000\",\"roles\":[{\"id\":3,\"authority\":\"ROLE_USER\"}],\"email\":\"manuel@manuel.com\",\"phones\":[{\"number\":\"1234567\",\"citycode\":\"1\",\"countrycode\":\"57\",\"phoneId\":1}]}", Usuario.class);
			usuario1 = new ObjectMapper().readValue("{\"id\":2,\"username\":\"Manuel Parico\",\"password\":\"Manuel77\",\"enabled\":true,\"creatAt\":\"2020-03-20T12:41:30.312+0000\",\"updatedAt\":\"2020-03-20T12:41:30.312+0000\",\"roles\":[{\"id\":3,\"authority\":\"ROLE_USER\"}],\"email\":\"manuel@manuel.com\",\"phones\":[{\"number\":\"1234567\",\"citycode\":\"1\",\"countrycode\":\"57\",\"phoneId\":1}]}", Usuario.class);
			usuario2 = new ObjectMapper().readValue("{\"id\":3,\"username\":\"Manuel Parico\",\"password\":\"Manuel77\",\"enabled\":true,\"creatAt\":\"2020-03-20T12:41:30.312+0000\",\"updatedAt\":\"2020-03-20T12:41:30.312+0000\",\"roles\":[{\"id\":3,\"authority\":\"ROLE_USER\"}],\"email\":\"manuel@manuel.com\",\"phones\":[{\"number\":\"1234567\",\"citycode\":\"1\",\"countrycode\":\"57\",\"phoneId\":1}]}", Usuario.class);
		
		} catch (IOException e) {

			throw new RuntimeException();
		}
		
		Usuario[] arrayUsuarios = {usuario, usuario1, usuario2};

		List<Usuario> usuarios = Arrays.asList (arrayUsuarios);
		
		return usuarios;
	}
	
}
