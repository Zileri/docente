package upeu.g1.rest.docente.entity;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.Valid;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import lombok.Data;

@Data
@Entity
@Table(name = "docentes")
public class Docente implements Serializable{
	
	private static final long serialVersionUID = 6331723992331312560L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	private String name;
	
	private String lastName;
	
	private String dni;
	
	private String gradoAcademico;
	
	private String email;
	
	@Temporal(TemporalType.DATE)
	private Date fecha;
	
	private String direccion;
	
	private String categoria;
	
	private boolean estado;
	
	@Valid
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "id_escuela")
	@JsonIgnoreProperties({"hibernateLazyInitializer","handler"})
	private Escuela escuela;
	
}
