package model;

import java.util.List;

import lombok.Data;


@Data
public class Rol {
	
	private Long id;
	
	private String name;
	
	private List<Usuario> usuarios;
}
