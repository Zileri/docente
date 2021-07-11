package upeu.g1.rest.usuario.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import upeu.g1.rest.usuario.entity.Rol;


@Repository
public interface RolRepository extends JpaRepository<Rol, Long>{

	public Rol findByname(String name);
}
