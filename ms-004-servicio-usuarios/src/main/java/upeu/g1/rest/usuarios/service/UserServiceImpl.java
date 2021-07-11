package upeu.g1.rest.usuarios.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import upeu.g1.rest.usuarios.entity.Role;
import upeu.g1.rest.usuarios.entity.User;
import upeu.g1.rest.usuarios.repository.UserRepository;


@Service
public class UserServiceImpl implements UserService{

	@Autowired
	private UserRepository userRepository;
	
	@Override
	public Iterable<User> findAll() {
		return userRepository.findAll();
	}

	@Override
	public User getUser(Long id) {
		return userRepository.findById(id).orElse(null);
	}

	@Override
	public User createUser(User user) {
		User userDB = userRepository.findByemail(user.getEmail());
		if(userDB != null) {
			return userDB;
		}
		userDB = userRepository.save(user);
		return userDB;
	}

	@Override
	public User save(User user) {
		return userRepository.save(user);
	}

	@Override
	public List<User> findByRole(Role role) {
		return userRepository.findByRole(role);
	}

	@Override
	public User updateUser(User user) {
		User userDB = getUser(user.getId());
		if(null == userDB) {
			return null;
		}
		userDB.setUsername(user.getUsername());
		userDB.setLastname(user.getLastname());
		userDB.setDni(user.getDni());
		userDB.setEmail(user.getEmail());
		userDB.setPassword(user.getPassword());
		userDB.setEstado(true);
		return userRepository.save(user);
	}

}
