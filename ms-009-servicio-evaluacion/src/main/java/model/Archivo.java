package model;

import java.util.Date;

import lombok.Data;

@Data
public class Archivo {

	private Long id;
	
	private String name;
	
	private Legajo legajo;
	
	private boolean estado;
	
	private Date fecha;
	
}
