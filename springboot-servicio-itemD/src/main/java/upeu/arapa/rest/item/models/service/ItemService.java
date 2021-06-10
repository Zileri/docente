package upeu.arapa.rest.item.models.service;

import java.util.List;
import upeu.arapa.rest.item.models.Item;

public interface ItemService {

	public List<Item> findAll();
	public Item findById(Long id);
}
