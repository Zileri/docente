package upeu.g1.rest.usuarios.entity;

import java.io.Serializable;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;
import javax.validation.Valid;

import lombok.Builder;
import lombok.Data;

@Entity
@Table(name = "users")
@Data @Builder
public class User implements Serializable{

	private static final long serialVersionUID = -2255493871992459826L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@Column(length = 20)
	private String username;
	
	private String lastname;
	
	private String dni;

	@Column(unique = true, length = 100)
	private String email;
	
	@Column(length = 60)
	private String password;
	
	private boolean estado;
	
	@Valid
	@ManyToMany(fetch = FetchType.LAZY)
	@JoinTable(name = "usuarios_roles", joinColumns = @JoinColumn(name="usuario_id"), 
	inverseJoinColumns = @JoinColumn(name="role_id"),
	uniqueConstraints = {@UniqueConstraint(columnNames = {"usuario_id", "role_id"})})
	private Role roles;
	
}
