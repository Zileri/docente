package upeu.g1.rest.usuariocommons.entity;

import java.io.Serializable;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

import lombok.Data;

@Entity
@Table(name = "roles")
@Data
public class Rol implements Serializable{
	
	private static final long serialVersionUID = -8787958776205690355L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@Column(unique = true, length = 30)
	private String name;
	
	@ManyToMany(fetch = FetchType.LAZY, mappedBy = "roles")
	private List<Usuario> usuarios;
	
	public List<Usuario> getUsuarios(){
		return usuarios;
	}
	
}
