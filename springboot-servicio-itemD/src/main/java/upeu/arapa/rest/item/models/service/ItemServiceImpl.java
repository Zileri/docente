package upeu.arapa.rest.item.models.service;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import upeu.arapa.rest.item.models.Docente;
import upeu.arapa.rest.item.models.Item;

@Service("serviceRestTemplate")
public class ItemServiceImpl implements ItemService {
	
	@Autowired
	private RestTemplate clienteRest;

	@Override
	public List<Item> findAll() {
		List<Docente> docentes = Arrays.asList(clienteRest.getForObject("http://servicio-docentes/listar", Docente[].class));
		return docentes.stream().map(p -> new Item(p)).collect(Collectors.toList());
	}

	@Override
	public Item findById(Long id) {
		Map<String, String> pathVariables = new HashMap<String, String>();
		pathVariables.put("id", id.toString());
		Docente docente = clienteRest.getForObject("http://servicio-docentes/ver/{id}", Docente.class, pathVariables);
		return new Item(docente);
	}

}
