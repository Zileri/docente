package upeu.g1.rest.docente.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import upeu.g1.rest.docente.entity.Escuela;
import upeu.g1.rest.docente.entity.Facultad;


@Repository
public interface EscuelaRepository extends JpaRepository<Escuela, Long>{

	public Escuela findByname(String name);
	public List<Escuela> findByFacultad(Facultad facultad);
	
}
