package upeu.g1.rest.usuario.service;

import java.util.List;

import upeu.g1.rest.usuario.entity.Rol;


public interface RolService {

	public Iterable<Rol> findAll();

	// public Page<Factor> findAll(Pageable pageable);

	// public Optional<Factor> findById(Long id);

	public Rol getRol(Long id);

	public Rol createRol(Rol rol);

	public Rol save(Rol rol);

	//public Factor deleteFactor(Long id);

	//public List<Docente> findByEscuela(Escuela escuela);

	public Rol updateRol(Rol rol);

	// public void deleteById(Long id);
	
}
