package upeu.g1.rest.evaluacion.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Transient;
import javax.validation.constraints.NotEmpty;

import lombok.Data;
import model.Archivo;

@Entity
@Table(name = "secciones")
@Data
public class Seccion implements Serializable{

	private static final long serialVersionUID = 5004986828970980239L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@NotEmpty(message = "el campo no debe ser vacio")
	@Column(length = 70)
	private String name;
	
	private int totalValorMin;
	
	private int totalValorMax;
	
	private int puntajeTotal;
	
	@Transient
	private Archivo archivo;
}
