package upeu.g1.rest.oauth.service;

import upeu.g1.rest.usuariocommons.entity.Usuario;

public interface IUsuarioService {

	public Usuario findByUsername(String username);
}
