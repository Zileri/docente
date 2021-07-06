package upeu.g1.rest.resultado.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import upeu.g1.rest.resultado.entity.Evaluacion;
import upeu.g1.rest.resultado.repository.EvaluacionRepository;

@Service
public class EvaluacionServiceImpl implements EvaluacionService{
	
	@Autowired
	private EvaluacionRepository evaluacionRepository;

	@Override
	@Transactional(readOnly = true)
	public Iterable<Evaluacion> findAll() {
		return evaluacionRepository.findAll();
	}

	/*@Override
	@Transactional(readOnly = true)
	public Page<Evaluacion> findAll(Pageable pageable) {
		return evaluacionRepository.findAll(pageable);
	}*/

	@Override
	@Transactional(readOnly = true)
	public Optional<Evaluacion> findById(Long id) {
		return evaluacionRepository.findById(id);
	}

	@Override
	@Transactional
	public Evaluacion save(Evaluacion evaluacion) {
		return evaluacionRepository.save(evaluacion);
	}

	@Override
	@Transactional
	public void deleteById(Long id) {
		evaluacionRepository.deleteById(id);
	}

	@Override
	public Evaluacion getEvaluacion(Long id) {
		return evaluacionRepository.findById(id).orElse(null);
	}


	@Override
	public Evaluacion updateEvaluacion(Evaluacion evaluacion) {
		Evaluacion evaluacionDB = getEvaluacion(evaluacion.getId());
		if(null == evaluacionDB) {
			return null;
		}
		evaluacionDB.setPuntaje(evaluacion.getPuntaje());
		return evaluacionRepository.save(evaluacion);
	}

	
	
}
