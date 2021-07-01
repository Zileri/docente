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
import upeu.g1.rest.evaluacion.repository.ItemRepository;

@Service
public class ItemServiceImpl implements ItemService{
	
	@Autowired
	private ItemRepository itemRepository;

	@Override
	@Transactional(readOnly = true)
	public Iterable<Item> findAll() {
		return itemRepository.findAll();
	}

	/*@Override
	@Transactional(readOnly = true)
	public Page<Item> findAll(Pageable pageable) {
		return itemRepository.findAll(pageable);
	}*/

	/*@Override
	@Transactional(readOnly = true)
	public Optional<Item> findById(Long id) {
		return itemRepository.findById(id);
	}*/

	@Override
	@Transactional
	public Item save(Item item) {
		return itemRepository.save(item);
	}

	/*@Override
	@Transactional
	public void deleteById(Long id) {
		itemRepository.deleteById(id);
	}*/

	@Override
	public Item getItem(Long id) {
		return itemRepository.findById(id).orElse(null);
	}

	@Override
	public Item createItem(Item item) {
		Item itemDB = itemRepository.findByname(item.getName());
		if(itemDB != null) {
			return itemDB;
		}
		itemDB=itemRepository.save(item);
		return itemDB;
	}

	@Override
	public Item updateItem(Item item) {
		Item itemDB = getItem(item.getId());
		if(null == itemDB) {
			return null;
		}
		itemDB.setName(item.getName());
		itemDB.setRequisito(item.getRequisito());
		itemDB.setValorMin(item.getValorMin());
		itemDB.setValorMax(item.getValorMax());
		itemDB.setPuntajeAsignado(item.getPuntajeAsignado());
		itemDB.setPuntajeSubtotal(item.getPuntajeSubtotal());
		itemDB.setFactor(item.getFactor());
		return itemRepository.save(item);
	}

	@Override
	public List<Item> findByFactor(Factor factor) {
		return itemRepository.findByFactor(factor);
	}

}
