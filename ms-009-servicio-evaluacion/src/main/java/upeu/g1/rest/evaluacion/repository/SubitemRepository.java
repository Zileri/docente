package upeu.g1.rest.evaluacion.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import upeu.g1.rest.evaluacion.entity.Factor;
import upeu.g1.rest.evaluacion.entity.Item;
import upeu.g1.rest.evaluacion.entity.Seccion;
import upeu.g1.rest.evaluacion.entity.Subitem;

public interface SubitemRepository extends JpaRepository<Subitem, Long>{

	public Subitem findByname(String name);
	public List<Subitem> findByItem(Item item);
	public List<Item> findByFactor(Factor factor);
	public List<Factor> findBySeccion(Seccion seccion);
	
}
