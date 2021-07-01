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
import javax.validation.Valid;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "factors")
@Data @AllArgsConstructor @NoArgsConstructor @Builder
public class Factor implements Serializable{

	private static final long serialVersionUID = 6748066514328352159L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@Column(length = 70)
	private String name;
	
	private int puntajeSubtotal;

	@Valid
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "id_seccion")
	@JsonIgnoreProperties({"hibernateLazyInitializer","handler"})
	private Seccion seccion;

	

}
