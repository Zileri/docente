package upeu.g1.rest.evaluacion.service;

import java.util.Optional;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import upeu.g1.rest.evaluacion.entity.Seccion;
import upeu.g1.rest.evaluacion.repository.SeccionRepository;

@Service
public class SeccionServiceImpl implements SeccionService{

	@Autowired
	private SeccionRepository seccionRepository;
	
	@Override
	@Transactional(readOnly = true)
	public Iterable<Seccion> findAll() {
		return seccionRepository.findAll();
	}

	/*@Override
	@Transactional(readOnly = true)
	public Page<Seccion> findAll(Pageable pageable) {
		return seccionRepository.findAll(pageable);
	}*/

	/*@Override
	@Transactional(readOnly = true)
	public Optional<Seccion> findById(Long id) {
		return seccionRepository.findById(id);
	}*/

	@Override
	@Transactional
	public Seccion save(Seccion seccion) {
		return seccionRepository.save(seccion);
	}

	/*@Override
	@Transactional
	public void deleteById(Long id) {
		seccionRepository.deleteById(id);
	}*/

	@Override
	public Seccion getSeccion(Long id) {
		return seccionRepository.findById(id).orElse(null);
	}

	@Override
	public Seccion createSeccion(Seccion seccion) {
		Seccion seccionDB = seccionRepository.findByname(seccion.getName());
		if(seccionDB != null) {
			return seccionDB;
		}
		seccionDB = seccionRepository.save(seccion);
		return seccionDB;
	}

	@Override
	public Seccion updateSeccion(Seccion seccion) {
		Seccion seccionDB = getSeccion(seccion.getId());
		if(null == seccionDB) {
			return null;
		}
		seccionDB.setName(seccion.getName());
		seccionDB.setTotalValorMin(seccion.getTotalValorMin());
		seccionDB.setTotalValorMax(seccion.getTotalValorMax());
		seccionDB.setPuntajeTotal(seccion.getPuntajeTotal());
		return seccionRepository.save(seccion);
	}

}
