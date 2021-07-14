package upeu.g1.rest.oauth.service;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import lombok.extern.slf4j.Slf4j;
import upeu.g1.rest.oauth.clients.UsuarioFeignClient;
import upeu.g1.rest.usuariocommons.entity.Usuario;

@Slf4j
@Service
public class UsuarioService implements UserDetailsService, IUsuarioService {

	@Autowired
	private UsuarioFeignClient client;

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException{
		var usuario = client.findByName(username);

		if (usuario == null) {
			log.error("Error en el login, no existe el usuario: " + username + " en el sistema");
			throw new UsernameNotFoundException(
					"Error en el login, no existe el usuario: " + username + " en el sistema");
		}
		List<GrantedAuthority> authorities = usuario.getRoles().stream()
				.map(role -> new SimpleGrantedAuthority(role.getName()))
				.peek(authority -> log.info("Role: " + authority.getAuthority())).collect(Collectors.toList());
		log.info("Usuario autenticado: " + username);
		return new User(usuario.getName(), usuario.getPassword(), usuario.isEstado(),
				true, true, true, authorities);
	}

	@Override
	public Usuario findByUsername(String username) {
		return client.findByName(username);
	}

}
