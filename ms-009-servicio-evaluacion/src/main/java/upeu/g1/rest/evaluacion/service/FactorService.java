package upeu.g1.rest.evaluacion.service;

import java.util.List;
import java.util.Optional;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import upeu.g1.rest.evaluacion.entity.Factor;
import upeu.g1.rest.evaluacion.entity.Seccion;

public interface FactorService {

	public Iterable<Factor> findAll();

	// public Page<Factor> findAll(Pageable pageable);

	// public Optional<Factor> findById(Long id);

	public Factor getFactor(Long id);

	public Factor createFactor(Factor factor);

	public Factor save(Factor factor);

	//public Factor deleteFactor(Long id);

	public List<Factor> findBySeccion(Seccion seccion);

	public Factor updateFactor(Factor factor);

	// public void deleteById(Long id);

}
