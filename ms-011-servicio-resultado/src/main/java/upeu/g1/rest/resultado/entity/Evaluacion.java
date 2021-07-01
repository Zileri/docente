package upeu.g1.rest.resultado.entity;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;



@Entity
@Table(name = "resultados")
public class Evaluacion implements Serializable{

	private static final long serialVersionUID = 6969780998220640099L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	private int puntaje;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public int getPuntaje() {
		return puntaje;
	}

	public void setPuntaje(int puntaje) {
		this.puntaje = puntaje;
	}
	
	//@ManyToOne(fetch = FetchType.LAZY)
	//@JoinColumn(name = "id_legajo")
	//Legajo legajo;
	
	
	//@ManyToOne(fetch = FetchType.LAZY)
	//@JoinColumn(name = "item")
	//Item item;
	
	
	
}
