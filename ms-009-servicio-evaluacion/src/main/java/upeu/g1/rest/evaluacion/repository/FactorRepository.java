package upeu.g1.rest.evaluacion.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import upeu.g1.rest.evaluacion.entity.Factor;
import upeu.g1.rest.evaluacion.entity.Seccion;

@Repository
public interface FactorRepository extends JpaRepository<Factor, Long>{

	public Factor findByname(String name);
	public List<Factor> findBySeccion(Seccion seccion);
}
