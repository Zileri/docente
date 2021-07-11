package upeu.g1.rest.docente.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import upeu.g1.rest.docente.entity.Facultad;
import upeu.g1.rest.docente.entity.Sede;


@Repository
public interface FacultadRepository extends JpaRepository<Facultad, Long>{

	public Facultad findByname(String name);
	public List<Facultad> findBySede(Sede sede);
	
}
