package upeu.g1.rest.legajo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import upeu.g1.rest.legajo.entity.Legajo;


@Repository
public interface LegajoRepository extends JpaRepository<Legajo, Long>{

	public Legajo findByname(String name);
	
}
