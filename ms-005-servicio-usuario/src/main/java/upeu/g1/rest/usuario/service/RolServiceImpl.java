package upeu.g1.rest.usuario.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import upeu.g1.rest.usuario.entity.Rol;
import upeu.g1.rest.usuario.repository.RolRepository;

@Service
public class RolServiceImpl implements RolService{

	@Autowired
	private RolRepository rolRepository;
	
	@Override
	public Iterable<Rol> findAll() {
		return rolRepository.findAll();
	}

	@Override
	public Rol getRol(Long id) {
		return rolRepository.findById(id).orElse(null);
	}

	@Override
	public Rol createRol(Rol rol) {
		Rol rolDB = rolRepository.findByname(rol.getName());
		if(rolDB != null) {
			return rolDB;
		}
		rolDB = rolRepository.save(rol);
		return rolDB;
	}

	@Override
	public Rol save(Rol rol) {
		return rolRepository.save(rol);
	}

	@Override
	public Rol updateRol(Rol rol) {
		Rol rolDB = getRol(rol.getId());
		if(null == rolDB) {
			return null;
		}
		rolDB.setName(rol.getName());
		return rolRepository.save(rol);
	}

}
