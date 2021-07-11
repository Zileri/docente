package upeu.g1.rest.usuario.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import upeu.g1.rest.usuario.entity.Rol;
import upeu.g1.rest.usuario.entity.Usuario;
import upeu.g1.rest.usuario.repository.UsuarioRepository;

@Service
public class UsuarioServiceImpl implements UsuarioService{
	
	@Autowired
	private UsuarioRepository usuarioRepository;

	@Override
	public Iterable<Usuario> findAll() {
		return usuarioRepository.findAll();
	}

	@Override
	public Usuario getUsuario(Long id) {
		return usuarioRepository.findById(id).orElse(null);
	}

	@Override
	public Usuario createUsuario(Usuario usuario) {
		Usuario usuarioDB = usuarioRepository.findByname(usuario.getName());
		if(usuarioDB != null) {
			return usuarioDB;
		}
		usuarioDB = usuarioRepository.save(usuario);
		return usuarioDB;
	}

	@Override
	public Usuario save(Usuario usuario) {
		return usuarioRepository.save(usuario);
	}

	@Override
	public List<Usuario> findByRol(Rol rol) {
		return usuarioRepository.findByRol(rol);
	}

	@Override
	public Usuario updateUsuario(Usuario usuario) {
		Usuario usuarioDB = getUsuario(usuario.getId());
		if(null == usuarioDB) {
			return null;
		}
		usuarioDB.setName(usuario.getName());
		usuarioDB.setLastName(usuario.getLastName());
		usuarioDB.setDni(usuario.getDni());
		usuarioDB.setPassword(usuario.getPassword());
		usuarioDB.setEmail(usuario.getEmail());
		usuarioDB.setRol(usuario.getRol());
		usuarioDB.setEstado(true);
		return usuarioRepository.save(usuario);
	}

}
