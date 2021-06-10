package upeu.arapa.rest.docente.models.service;

import java.util.List;

import upeu.arapa.rest.docente.models.entity.Docente;

public interface IDocenteService {

	public List<Docente> findAll();
	public Docente findById(Long id);
}
