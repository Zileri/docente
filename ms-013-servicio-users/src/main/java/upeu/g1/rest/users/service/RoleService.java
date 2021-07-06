package upeu.g1.rest.users.service;

import java.util.List;

import upeu.g1.rest.users.entity.Role;


public interface RoleService {
	public Iterable<Role> findAll();

	// public Page<Factor> findAll(Pageable pageable);

	// public Optional<Factor> findById(Long id);

	public Role getRole(Long id);

	public Role createRole(Role role);

	public Role save(Role role);

	//public Factor deleteFactor(Long id);

	public Role updateRole(Role role);

	// public void deleteById(Long id);
}
