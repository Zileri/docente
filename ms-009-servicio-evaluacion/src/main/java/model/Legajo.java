package model;

import java.util.Date;

import lombok.Data;

@Data
public class Legajo {

	private Long id;
	
	private String name;
	
	private boolean estado;
	
	private Date fecha;
	
	private int numFolios;
	
}
