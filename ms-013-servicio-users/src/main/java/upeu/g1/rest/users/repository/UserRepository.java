package upeu.g1.rest.users.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import upeu.g1.rest.users.entity.Role;
import upeu.g1.rest.users.entity.User;

@Repository
public interface UserRepository extends JpaRepository<User, Long>{

	public User findByemail(String email);
	public List<User> findByRole(Role role);
	
}