package upeu.g1.rest.usuario.repository;

import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.data.rest.core.annotation.RestResource;

import upeu.g1.rest.usuariocommons.entity.Usuario;

@RepositoryRestResource(path = "usuarios")
public interface UsuarioRepository extends PagingAndSortingRepository<Usuario, Long>{
	
	@RestResource(path="buscar-username")
	public Usuario findByUsername(@Param("username") String username);
	
	

}
