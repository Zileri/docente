package upeu.g1.rest.legajo.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import upeu.g1.rest.legajo.entity.Archivo;
import upeu.g1.rest.legajo.entity.Legajo;


@Repository
public interface ArchivoRepository extends JpaRepository<Archivo, Long>{
	public Archivo findByname(String name);
	public List<Archivo> findByLegajo(Legajo legajo);
}
