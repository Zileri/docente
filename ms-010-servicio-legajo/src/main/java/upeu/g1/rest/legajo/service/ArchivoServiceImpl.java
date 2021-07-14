package upeu.g1.rest.legajo.service;

import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Date;
import java.util.List;
import java.util.Optional;
import java.util.stream.Stream;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.Resource;
import org.springframework.core.io.UrlResource;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;

import upeu.g1.rest.legajo.entity.Archivo;
import upeu.g1.rest.legajo.entity.Legajo;
import upeu.g1.rest.legajo.repository.ArchivoRepository;

@Service
public class ArchivoServiceImpl implements ArchivoService{

	private final Path rootFolder = Paths.get("uploads");
	
	@Autowired
	private ArchivoRepository archivoRepository;
	
	@Override
	@Transactional(readOnly = true)
	public Iterable<Archivo> findAll() {
		return archivoRepository.findAll();
	}

	/*@Override
	@Transactional(readOnly = true)
	public Page<Archivo> findAll(Pageable pageable) {
		return archivoRepository.findAll(pageable);
	}*/

	/*@Override
	@Transactional(readOnly = true)
	public Optional<Archivo> findById(Long id) {
		return archivoRepository.findById(id);
	}*/

	@Override
	@Transactional
	public Archivo save(Archivo archivo) {
		return archivoRepository.save(archivo);
	}

	@Override
	public Archivo deleteArchivo(Long id) {
		Archivo archivoDB = getArchivo(id);
		if(null == archivoDB) {
			return null;
		}
		archivoDB.setEstado(false);
		return archivoRepository.save(archivoDB);
	}

	@Override
	public List<Archivo> findByLegajo(Legajo legajo) {
		return archivoRepository.findByLegajo(legajo);
	}

	@Override
	public Archivo updateArchivo(Archivo archivo) {
		Archivo archivoDB = getArchivo(archivo.getId());
		if(null == archivoDB) {
			return null;
		}
		archivoDB.setName(archivo.getName());
		archivoDB.setFecha(archivo.getFecha());
		archivoDB.setLegajo(archivo.getLegajo());
		archivoDB.setEstado(true);
		return archivoRepository.save(archivo);
	}

	@Override
	@Transactional
	public Archivo createArchivo(Archivo archivo) {
		Archivo archivoDB = archivoRepository.findByname(archivo.getName());
		if(archivoDB != null) {
			return archivoDB;
		}
		archivo.setEstado(true);
		archivoDB = archivoRepository.save(archivo);
		return archivoDB;
	}

	@Override
	public Archivo getArchivo(Long id) {
		return archivoRepository.findById(id).orElse(null);
	}

	@Override
	public void save(MultipartFile archivo) throws Exception {
		Files.copy(archivo.getInputStream(), this.rootFolder.resolve(archivo.getOriginalFilename()));	
	}

	@Override
	public Resource load(String name) throws Exception {
		Path archivo = rootFolder.resolve(name);
		Resource resource = new UrlResource(archivo.toUri());
		return resource;
	}

	@Override
	public void save(List<MultipartFile> archivos) throws Exception {
		for (MultipartFile archivo : archivos) {
			this.save(archivo);
		}
		
	}

	@Override
	public Stream<Path> loadAll() throws Exception {
		return Files.walk(rootFolder, 1).filter(path -> !path.equals(rootFolder)).map(rootFolder::relativize);
	}


	/*@Override
	@Transactional
	public List<Archivo> listAllArchivo() {
		return archivoRepository.findAll();
	}*/

}
