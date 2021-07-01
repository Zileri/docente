package upeu.g1.rest.evaluacion.service;

import java.util.List;
import java.util.Optional;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import upeu.g1.rest.evaluacion.entity.Item;
import upeu.g1.rest.evaluacion.entity.Subitem;

public interface SubitemService {

	public Iterable<Subitem> findAll();
	
	//public Page<Subitem> findAll(Pageable pageable);
	
	//public Optional<Subitem> findById(Long id);
	
	public Subitem save(Subitem subitem);
	
	public Subitem getSubitem(Long id);
	
	public Subitem createSubitem(Subitem subitem);
	
	public Subitem updateSubitem(Subitem subitem);
	
	public List<Subitem> findByItem(Item item);
	
	//public void deleteById(Long id);
	
}
