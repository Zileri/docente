package upeu.g1.rest.nomina.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import upeu.g1.rest.nomina.entity.Nomina;
import upeu.g1.rest.nomina.repository.NominaRepository;

@Service
public class NominaServiceImpl implements NominaService{

	@Autowired
	private NominaRepository nominaRepository;
	
	@Override
	@Transactional(readOnly = true)
	public Iterable<Nomina> findAll() {
		return nominaRepository.findAll();
	}

	/*@Override
	@Transactional(readOnly = true)
	public Page<Nomina> findAll(Pageable pageable) {
		return nominaRepository.findAll(pageable);
	}*/

	@Override
	@Transactional(readOnly = true)
	public Optional<Nomina> findById(Long id) {
		return nominaRepository.findById(id);
	}

	@Override
	@Transactional
	public Nomina save(Nomina nomina) {
		return nominaRepository.save(nomina);
	}

	@Override
	@Transactional
	public void deleteById(Long id) {
		nominaRepository.deleteById(id);
	}

	@Override
	public Nomina getNomina(Long id) {
		return nominaRepository.findById(id).orElse(null);
	}

	@Override
	public Nomina updateNomina(Nomina nomina) {
		Nomina nominaDB = getNomina(nomina.getId());
		if(null == nominaDB) {
			return null;
		}
		nominaDB.setEstadoActa(true);
		nominaDB.setEstadoPago(true);
		return nominaRepository.save(nomina);
	}

}
