package upeu.g1.rest.usuario.controller;

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
import upeu.g1.rest.usuario.entity.Usuario;
import upeu.g1.rest.usuario.service.UsuarioService;

@Slf4j
@RestController
@RequestMapping("/api/usuarios")
public class UsuarioController {

	@Autowired
	private UsuarioService usuarioService;
	
	
	@PostMapping
	public ResponseEntity<Usuario> create(@Valid @RequestBody Usuario usuario, BindingResult result){
		log.info("creando usuario: {}", usuario);
		if(result.hasErrors()) {
			throw new ResponseStatusException(HttpStatus.BAD_REQUEST, this.formatMessage(result));
		}
		Usuario usuarioDB = usuarioService.createUsuario(usuario);
		return ResponseEntity.status(HttpStatus.CREATED).body(usuarioDB);
	}
	
	@PutMapping("/{id}")
	public ResponseEntity<?> update(@RequestBody Usuario usuarioDetails, @PathVariable(value = "id") Long usuarioId) {
		log.info("actualizando usuario con id {}", usuarioId);

		Usuario usuario = usuarioService.getUsuario(usuarioId);
		if (null == usuario) {
			log.error("No se puede actualizar. usuario con id {} no encontrado", usuarioId);
			return ResponseEntity.notFound().build();
		}
		usuarioDetails.setId(usuarioId);
		usuario=usuarioService.updateUsuario(usuario);
		return ResponseEntity.ok(usuario);
	}
	
	@GetMapping
	public List<Usuario> readAll() {

		List<Usuario> usuarios = StreamSupport.stream(usuarioService.findAll().spliterator(), false)
				.collect(Collectors.toList());

		return usuarios;
	}
	
	@GetMapping(value="/{id}")
	public ResponseEntity<Usuario> get(@PathVariable("id") long id){
		log.info("Obteniendo usuario con id {}", id);
		Usuario usuario = usuarioService.getUsuario(id);
		if(null == usuario) {
			log.error("usuario con id {} no encontrado", id);
			return ResponseEntity.notFound().build();
		}
		return ResponseEntity.ok(usuario);
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
