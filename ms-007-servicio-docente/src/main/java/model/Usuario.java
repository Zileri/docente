package model;

import java.util.List;

import lombok.Data;
@Data
public class Usuario {

	private Long id;
	
	private String name;
	
	private String lastName;
	
	private String dni;
	
	private String email;
	
	private String password;
	
	private boolean estado;
	
	private List<Rol> roles;
	
}
