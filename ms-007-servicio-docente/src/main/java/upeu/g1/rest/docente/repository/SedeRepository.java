package upeu.g1.rest.docente.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import upeu.g1.rest.docente.entity.Sede;



@Repository
public interface SedeRepository extends JpaRepository<Sede, Long>{

	public Sede findByname(String name);
	
}
