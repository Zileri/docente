package upeu.g1.rest.legajo.service;

import java.nio.file.Path;
import java.util.List;
import java.util.stream.Stream;

import org.springframework.core.io.Resource;
import org.springframework.web.multipart.MultipartFile;

import upeu.g1.rest.legajo.entity.Archivo;
import upeu.g1.rest.legajo.entity.Legajo;

public interface ArchivoService {

	public Iterable<Archivo> findAll();
	
	//public Page<Archivo> findAll(Pageable pageable);
	
	//public Optional<Archivo> findById(Long id);
	
	//public List<Archivo> listAllArchivo();
	
	public Archivo getArchivo(Long id);
	
	public Archivo createArchivo(Archivo archivo);
	
	public Archivo save(Archivo archivo);
	
	public Archivo deleteArchivo(Long id);
	
	public List<Archivo> findByLegajo(Legajo legajo);
	
	public Archivo updateArchivo(Archivo archivo);
	
	public void save(MultipartFile archivo) throws Exception;
	
	public Resource load(String name) throws Exception;
	
	public void save(List<MultipartFile> archivos) throws Exception;
	
	public Stream<Path> loadAll() throws Exception;
	
}
