package upeu.arapa.rest.docente.models.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import upeu.arapa.rest.docente.models.dao.DocenteDao;
import upeu.arapa.rest.docente.models.entity.Docente;

@Service
public class DocenteServiceImpl implements IDocenteService{

	@Autowired
	private DocenteDao docenteDao;
	
	@Override
	@Transactional(readOnly = true)
	public List<Docente> findAll(){
		return (List<Docente>) docenteDao.findAll();
	}
	
	@Override
	@Transactional(readOnly = true)
	public Docente findById(Long id) {
		return docenteDao.findById(id).orElse(null);
	}

}
