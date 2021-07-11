package upeu.g1.rest.usuarios.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import upeu.g1.rest.usuarios.entity.Role;
import upeu.g1.rest.usuarios.repository.RoleRepository;


@Service
public class RoleServiceImpl implements RoleService{

	@Autowired
	private RoleRepository roleRepository;
	
	@Override
	public Iterable<Role> findAll() {
		return roleRepository.findAll();
	}

	@Override
	public Role getRole(Long id) {
		return roleRepository.findById(id).orElse(null);
	}

	@Override
	public Role createRole(Role role) {
		Role roleDB = roleRepository.findByname(role.getName());
		if(roleDB != null) {
			return roleDB;
		}
		roleDB = roleRepository.save(role);
		return roleDB;
	}

	@Override
	public Role save(Role role) {
		return roleRepository.save(role);
	}

	@Override
	public Role updateRole(Role role) {
		Role roleDB = getRole(role.getId());
		if(null == roleDB) {
			return null;
		}
		roleDB.setName(role.getName());
		return roleRepository.save(role);
	}

}
