package upeu.g1.rest.evaluacion.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import upeu.g1.rest.evaluacion.entity.Factor;
import upeu.g1.rest.evaluacion.entity.Item;
import upeu.g1.rest.evaluacion.entity.Seccion;
import upeu.g1.rest.evaluacion.entity.Subitem;
import upeu.g1.rest.evaluacion.repository.SubitemRepository;

@Service
public class SubitemServiceImpl implements SubitemService{

	@Autowired
	private SubitemRepository subitemRepository;
	
	@Override
	@Transactional(readOnly = true)
	public Iterable<Subitem> findAll() {
		return subitemRepository.findAll();
	}

	/*@Override
	@Transactional(readOnly = true)
	public Page<Subitem> findAll(Pageable pageable) {
		return subitemRepository.findAll(pageable);
	}*/

	/*@Override
	@Transactional(readOnly = true)
	public Optional<Subitem> findById(Long id) {
		return subitemRepository.findById(id);
	}*/

	@Override
	@Transactional
	public Subitem save(Subitem subitem) {
		return subitemRepository.save(subitem);
	}

	/*@Override
	@Transactional
	public void deleteById(Long id) {
		subitemRepository.deleteById(id);
	}*/

	@Override
	public Subitem getSubitem(Long id) {
		return subitemRepository.findById(id).orElse(null);
	}

	@Override
	public Subitem createSubitem(Subitem subitem) {
		Subitem subitemDB = subitemRepository.findByname(subitem.getName());
		if(subitemDB != null) {
			return subitemDB;
		}
		subitemDB = subitemRepository.save(subitem);
		return subitemDB;
	}

	@Override
	public Subitem updateSubitem(Subitem subitem) {
		Subitem subitemDB = getSubitem(subitem.getId());
		if(null == subitemDB) {
			return null;
		}
		subitemDB.setName(subitem.getName());
		subitemDB.setItem(subitem.getItem());
		return subitemRepository.save(subitem);
	}

	@Override
	public List<Subitem> findByItem(Item item) {
		return subitemRepository.findByItem(item);
	}

	@Override
	public List<Item> findByFactor(Factor factor) {
		return subitemRepository.findByFactor(factor);
	}

	@Override
	public List<Factor> findBySeccion(Seccion seccion) {
		return subitemRepository.findBySeccion(seccion);
	}

}
