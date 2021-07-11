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
import javax.validation.Valid;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import lombok.Data;

@Data
@Entity
@Table(name = "escuelas")
public class Escuela implements Serializable {
	
	private static final long serialVersionUID = 5458880014477485763L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	private String name;
	
	@Valid
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "id_facultad")
	@JsonIgnoreProperties({"hibernateLazyInitializer","handler"})
	private Facultad facultad;
	
}
