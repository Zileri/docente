package upeu.g1.rest.evaluacion.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

import javax.validation.Valid;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import lombok.extern.slf4j.Slf4j;
import upeu.g1.rest.evaluacion.entity.Item;
import upeu.g1.rest.evaluacion.service.ItemService;

@Slf4j
@RestController
@RequestMapping("/api/items")
public class ItemController {

	@Autowired
	private ItemService itemService;

	// create a new item
	@PostMapping
	public ResponseEntity<Item> create(@Valid @RequestBody Item item, BindingResult result) {
		log.info("creando item: {}", item);
		if (result.hasErrors()) {
			throw new ResponseStatusException(HttpStatus.BAD_REQUEST, this.formatMessage(result));
		}
		Item itemDB = itemService.createItem(item);
		return ResponseEntity.status(HttpStatus.CREATED).body(itemDB);
	}

	// read an item
	/*@GetMapping("/{id}")
	public ResponseEntity<?> read(@PathVariable(value = "id") Long itemId) {
		Optional<Item> oitem = itemService.findById(itemId);

		if (!oitem.isPresent()) {
			return ResponseEntity.notFound().build();
		}

		return ResponseEntity.ok(oitem);
	}*/

	// update an item
	@PutMapping("/{id}")
	public ResponseEntity<?> update(@RequestBody Item itemDetails, @PathVariable(value = "id") Long itemId) {
		log.info("actualizando el item con id {}", itemId);
		Item item = itemService.getItem(itemId);
		if(null == item) {
			log.error("No se puede actualizar. Item con id {} no encontrando", itemId);
			return ResponseEntity.notFound().build();
		}
		itemDetails.setId(itemId);
		item=itemService.updateItem(item);
		return ResponseEntity.ok(item);
	}

	// delete an item
	
	

	// read all items
	@GetMapping
	public List<Item> readAll() {

		List<Item> items = StreamSupport.stream(itemService.findAll().spliterator(), false)
				.collect(Collectors.toList());

		return items;
	}

	
	private String formatMessage(BindingResult result) {
		List<Map<String, String>> erros = result.getFieldErrors().stream()
				.map(err ->{
					Map<String, String> error = new HashMap<>();
					error.put(err.getField(), err.getDefaultMessage());
					return error;
				}).collect(Collectors.toList());
		ErrorMensaje errorMensaje = ErrorMensaje.builder()
				.code("01")
				.messages(erros).build();
		ObjectMapper mapper = new ObjectMapper();
		String jsonString="";
		try {
			jsonString = mapper.writeValueAsString(errorMensaje);
		} catch (JsonProcessingException e) {
			e.printStackTrace();
		}
		return jsonString;
	}
	
}
