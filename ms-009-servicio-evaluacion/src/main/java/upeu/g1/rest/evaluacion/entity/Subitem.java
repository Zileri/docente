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

import lombok.Data;

@Entity
@Table(name = "subitems")
@Data
public class Subitem implements Serializable{

	private static final long serialVersionUID = 2698136878623733050L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@Column(length = 70)
	private String name;

	@Valid
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "id_item")
	@JsonIgnoreProperties({"hibernateLazyInitializer","handler"})
	private Item item;
	
}
