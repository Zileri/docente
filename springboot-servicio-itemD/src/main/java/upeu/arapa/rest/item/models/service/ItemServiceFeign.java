package upeu.arapa.rest.item.models.service;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;

import upeu.arapa.rest.item.clientes.DocenteClienteRest;
import upeu.arapa.rest.item.models.Item;

@Service("serviceFeign")
@Primary
public class ItemServiceFeign implements ItemService {

	@Autowired
	private DocenteClienteRest clienteFeign;
	
	@Override
	public List<Item> findAll() {
		return clienteFeign.listar().stream().map(p -> new Item(p)).collect(Collectors.toList());
	}

	@Override
	public Item findById(Long id) {
		// TODO Auto-generated method stub
		return new Item(clienteFeign.detalle(id));
	}

}
