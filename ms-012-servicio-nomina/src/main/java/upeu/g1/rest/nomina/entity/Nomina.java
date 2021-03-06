package upeu.g1.rest.nomina.entity;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;

@Data
@Entity
@Table(name = "nominas")
public class Nomina implements Serializable{

	private static final long serialVersionUID = 4829271457947521437L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	private boolean estadoActa;
	
	private boolean estadoPago;
	
	
}
