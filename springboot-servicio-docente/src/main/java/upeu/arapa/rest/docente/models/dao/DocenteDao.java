package upeu.arapa.rest.docente.models.dao;

import org.springframework.data.repository.CrudRepository;

import upeu.arapa.rest.docente.models.entity.Docente;

public interface DocenteDao extends CrudRepository<Docente, Long>{

}
