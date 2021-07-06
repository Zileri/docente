package upeu.g1.rest.users.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import upeu.g1.rest.users.entity.Role;

@Repository
public interface RoleRepository extends JpaRepository<Role, Long>{

	public Role findByname(String name);
	
}
