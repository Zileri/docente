package upeu.g1.rest.usuarios.service;

import java.util.List;

import upeu.g1.rest.usuarios.entity.Role;
import upeu.g1.rest.usuarios.entity.User;


public interface UserService {

	public Iterable<User> findAll();

	// public Page<Factor> findAll(Pageable pageable);

	// public Optional<Factor> findById(Long id);

	public User getUser(Long id);

	public User createUser(User user);

	public User save(User user);

	//public Factor deleteFactor(Long id);

	public List<User> findByRole(Role role);

	public User updateUser(User user);

	// public void deleteById(Long id);
	
}
