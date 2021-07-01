package upeu.g1.rest.resultado.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import upeu.g1.rest.resultado.entity.Evaluacion;


@Repository
public interface EvaluacionRepository extends JpaRepository<Evaluacion, Long>{

}
