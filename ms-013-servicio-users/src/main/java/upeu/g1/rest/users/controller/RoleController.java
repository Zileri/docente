package upeu.g1.rest.users.controller;

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
import upeu.g1.rest.users.entity.Role;
import upeu.g1.rest.users.service.RoleService;

@Slf4j
@RestController
@RequestMapping("/api/roles")
public class RoleController {

	@Autowired
	private RoleService roleService;
	
	@PostMapping
	public ResponseEntity<Role> create(@Valid @RequestBody Role role, BindingResult result){
		log.info("creando rol: {}", role);
		if(result.hasErrors()) {
			throw new ResponseStatusException(HttpStatus.BAD_REQUEST, this.formatMessage(result));
		}
		Role roleDB = roleService.createRole(role);
		return ResponseEntity.status(HttpStatus.CREATED).body(roleDB);
	}
	
	@PutMapping("/{id}")
	public ResponseEntity<?> update(@RequestBody Role factorDetails, @PathVariable(value = "id") Long roleId) {
		log.info("actualizando rol con id {}", roleId);

		Role role = roleService.getRole(roleId);
		if (null == role) {
			log.error("No se puede actualizar. Rol con id {} no encontrado", roleId);
			return ResponseEntity.notFound().build();
		}
		factorDetails.setId(roleId);
		role=roleService.updateRole(role);
		return ResponseEntity.ok(role);
	}
	
	@GetMapping
	public List<Role> readAll() {

		List<Role> roles = StreamSupport.stream(roleService.findAll().spliterator(), false)
				.collect(Collectors.toList());

		return roles;
	}
	
	@GetMapping(value="/{id}")
	public ResponseEntity<Role> get(@PathVariable("id") long id){
		log.info("Obteniendo rol con id {}", id);
		Role role = roleService.getRole(id);
		if(null == role) {
			log.error("rol con id {} no encontrado", id);
			return ResponseEntity.notFound().build();
		}
		return ResponseEntity.ok(role);
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
