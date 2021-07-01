package upeu.g1.rest.evaluacion.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import upeu.g1.rest.evaluacion.entity.Factor;
import upeu.g1.rest.evaluacion.entity.Seccion;
import upeu.g1.rest.evaluacion.repository.FactorRepository;

@Service
public class FactorServiceImpl implements FactorService{

	@Autowired
	private FactorRepository factorRepository;

	@Override
	@Transactional(readOnly = true)
	public Iterable<Factor> findAll() {
		return factorRepository.findAll();
	}

	/*@Override
	@Transactional(readOnly = true)
	public Page<Factor> findAll(Pageable pageable) {
		return factorRepository.findAll(pageable);
	}*/

	/*@Override
	@Transactional(readOnly = true)
	public Optional<Factor> findById(Long id) {
		return factorRepository.findById(id);
	}*/

	@Override
	@Transactional
	public Factor save(Factor factor) {
		return factorRepository.save(factor);
	}

	/*@Override
	@Transactional
	public void deleteById(Long id) {
		factorRepository.deleteById(id);
	}*/

	@Override
	public Factor getFactor(Long id) {
		return factorRepository.findById(id).orElse(null);
	}

	@Override
	public Factor createFactor(Factor factor) {
		Factor factorDB = factorRepository.findByname(factor.getName());
		if(factorDB != null) {
			return factorDB;
		}
		factorDB = factorRepository.save(factor);
		return factorDB;
	}


	@Override
	public List<Factor> findBySeccion(Seccion seccion) {
		return factorRepository.findBySeccion(seccion);
	}

	@Override
	public Factor updateFactor(Factor factor) {
		Factor factorDB = getFactor(factor.getId());
		if(null == factorDB) {
			return null;
		}
		factorDB.setName(factor.getName());
		factorDB.setPuntajeSubtotal(factor.getPuntajeSubtotal());
		factorDB.setSeccion(factor.getSeccion());
		return factorRepository.save(factor);
	}
	
	
}
