package upeu.g1.rest.resultado.entity;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;


@Data
@Entity
@Table(name = "resultados")
public class Evaluacion implements Serializable{

	private static final long serialVersionUID = 6969780998220640099L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	private int puntaje;

	
	
	//@ManyToOne(fetch = FetchType.LAZY)
	//@JoinColumn(name = "id_legajo")
	//Legajo legajo;
	
	
	//@ManyToOne(fetch = FetchType.LAZY)
	//@JoinColumn(name = "item")
	//Item item;
	
	
	
}
