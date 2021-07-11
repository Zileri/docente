package upeu.g1.rest.usuario.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import upeu.g1.rest.usuario.entity.Rol;
import upeu.g1.rest.usuario.entity.Usuario;

@Repository
public interface UsuarioRepository extends JpaRepository<Usuario, Long>{

	public Usuario findByname(String name);
	public List<Usuario> findByRol(Rol rol);
}
