package upeu.g1.rest.evaluacion.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Transient;
import javax.validation.Valid;
import javax.validation.constraints.NotEmpty;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import lombok.Data;
import model.Evaluacion;

@Entity
@Table(name = "items")
@Data
public class Item implements Serializable{

	private static final long serialVersionUID = -9101626603125366597L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@NotEmpty(message = "el campo no debe ser vacio")
	@Column(length = 100)
	private String name;
	
	@Column(length = 2)
	private String requisito;
	
	@NotEmpty(message = "el campo no debe ser vacio")
	private int valorMin;
	
	@NotEmpty(message = "el campo no debe ser vacio")
	private int valorMax;
	
	private int puntajeAsignado;
	
	private int puntajeSubtotal;

	@Valid
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "id_factor")
	@JsonIgnoreProperties({"hibernateLazyInitializer","handler"})
	private Factor factor;
	
	@Transient
	private Evaluacion evaluacion;

	
}
