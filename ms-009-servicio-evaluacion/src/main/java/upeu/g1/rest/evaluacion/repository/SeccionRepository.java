package upeu.g1.rest.evaluacion.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import upeu.g1.rest.evaluacion.entity.Seccion;

@Repository
public interface SeccionRepository extends JpaRepository<Seccion, Long>{

	public Seccion findByname(String name);
	
}
