package upeu.g1.rest.usuario.service;

import java.util.List;

import upeu.g1.rest.usuario.entity.Rol;
import upeu.g1.rest.usuario.entity.Usuario;


public interface UsuarioService {

	public Iterable<Usuario> findAll();

	// public Page<Factor> findAll(Pageable pageable);

	// public Optional<Factor> findById(Long id);

	public Usuario getUsuario(Long id);

	public Usuario createUsuario(Usuario usuario);

	public Usuario save(Usuario usuario);

	//public Factor deleteFactor(Long id);

	public List<Usuario> findByRol(Rol rol);

	public Usuario updateUsuario(Usuario usuario);

	// public void deleteById(Long id);
	
}
