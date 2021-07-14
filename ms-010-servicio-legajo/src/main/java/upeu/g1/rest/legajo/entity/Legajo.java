package upeu.g1.rest.legajo.entity;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.PrePersist;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

import lombok.Data;

@Entity
@Table(name = "legajos")
@Data
public class Legajo implements Serializable{

	private static final long serialVersionUID = -1488119889836518341L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	//@NotEmpty(message = "el campo no debe ser vacio")
	//private String name;
	
	//private boolean estado;
	
	@NotNull(message = "el legajo no puede estar vacio")
	@Temporal(TemporalType.DATE)
	private Date fecha;
	
	private int numFolios;

	@PrePersist
	public void prePersist() {this.fecha=new Date();}
	
}
