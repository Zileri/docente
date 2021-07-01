package upeu.g1.rest.legajo.entity;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.PrePersist;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.Valid;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import lombok.Data;

@Entity
@Table(name = "archivos")
@Data
public class Archivo implements Serializable{

	private static final long serialVersionUID = 5164613664494990600L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@NotEmpty(message = "el campo no debe ser vacio")
	@Column(name = "archivo", length = 70)
	private String name;
	
	@Valid
	@NotNull(message = "el legajo no puede estar vacio")
//	@JsonIgnore
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "id_legajo")
	@JsonIgnoreProperties({"hibernateLazyInitializer","handler"})
	Legajo legajo;
	
	private boolean estado;
	
	@NotNull(message = "el legajo no puede estar vacio")
	@Temporal(TemporalType.TIMESTAMP)
	private Date fecha;
	
	@PrePersist
	public void prePersist() {this.fecha=new Date();}
	
//	@JsonIgnore
//	@ManyToOne(fetch = FetchType.LAZY)
//	@JoinColumn(name = "id_seccion")
//	Seccion seccion;
	
	
	
}
