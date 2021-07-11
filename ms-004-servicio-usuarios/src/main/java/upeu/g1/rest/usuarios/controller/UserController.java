package upeu.g1.rest.usuarios.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
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
import upeu.g1.rest.usuarios.entity.User;
import upeu.g1.rest.usuarios.service.UserService;

@Slf4j
@RestController
@RequestMapping("/api/users")
public class UserController {

	@Autowired
	private UserService userService;
	
	@PostMapping
	public ResponseEntity<User> create(@Valid @RequestBody User user, BindingResult result){
		log.info("creando usuario: {}", user);
		if(result.hasErrors()) {
			throw new ResponseStatusException(HttpStatus.BAD_REQUEST, this.formatMessage(result));
		}
		User userDB = userService.createUser(user);
		return ResponseEntity.status(HttpStatus.CREATED).body(userDB);
	}
	
	@PutMapping("/{id}")
	public ResponseEntity<?> update(@PathVariable(value = "id") Long userId, @RequestBody User userDetails) {
		log.info("actualizando el usuario con id {}", userId);
		User user =userService.getUser(userId);
		if(null == user) {
			log.error("No se puedee actualizar. Archivo con id {} no encontrado", userId);
			return ResponseEntity.notFound().build();
		}
		userDetails.setId(userId);
		user=userService.updateUser(user);
		return ResponseEntity.ok(user);
	}
	
	// read
	@GetMapping
	public List<User> readAll() {

		List<User> users = StreamSupport.stream(userService.findAll().spliterator(), false)
				.collect(Collectors.toList());

		return users;
	}
	
	//read por id
	@GetMapping(value="/{id}")
	public ResponseEntity<User> get(@PathVariable("id") long id){
		log.info("Obteniendo usuario con id {}", id);
		User user = userService.getUser(id);
		if(null == user) {
			log.error("usuario con id {} no encontrado", id);
			return ResponseEntity.notFound().build();
		}
		return ResponseEntity.ok(user);
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
