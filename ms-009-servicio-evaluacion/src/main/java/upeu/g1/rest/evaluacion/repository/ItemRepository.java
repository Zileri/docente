package upeu.g1.rest.evaluacion.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import upeu.g1.rest.evaluacion.entity.Factor;
import upeu.g1.rest.evaluacion.entity.Item;

@Repository
public interface ItemRepository extends JpaRepository<Item, Long>{

	public Item findByname(String name);
	public List<Item> findByFactor(Factor factor);
	
}
