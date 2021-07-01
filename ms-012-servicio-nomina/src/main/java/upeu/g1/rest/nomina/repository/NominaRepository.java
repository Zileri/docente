package upeu.g1.rest.nomina.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import upeu.g1.rest.nomina.entity.Nomina;

@Repository
public interface NominaRepository extends JpaRepository<Nomina, Long>{

}
