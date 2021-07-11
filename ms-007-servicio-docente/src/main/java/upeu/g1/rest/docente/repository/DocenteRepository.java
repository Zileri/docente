package upeu.g1.rest.docente.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import upeu.g1.rest.docente.entity.Docente;
import upeu.g1.rest.docente.entity.Escuela;



@Repository
public interface DocenteRepository extends JpaRepository<Docente, Long>{

	public Docente findByname(String name);
	public List<Docente> findByEscuela(Escuela escuela);
	
}
