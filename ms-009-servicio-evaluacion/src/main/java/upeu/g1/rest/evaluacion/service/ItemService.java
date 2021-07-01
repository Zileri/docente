package upeu.g1.rest.evaluacion.service;

import java.util.List;
import java.util.Optional;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import upeu.g1.rest.evaluacion.entity.Factor;
import upeu.g1.rest.evaluacion.entity.Item;

public interface ItemService {

	public Iterable<Item> findAll();
	
	//public Page<Item> findAll(Pageable pageable);
	
	//public Optional<Item> findById(Long id);
	
	public Item save(Item item);
	
	public Item getItem(Long id);
	
	public Item createItem(Item item);
	
	public Item updateItem(Item item);
	
	public List<Item> findByFactor(Factor factor);
	
	//public void deleteById(Long id);
}
