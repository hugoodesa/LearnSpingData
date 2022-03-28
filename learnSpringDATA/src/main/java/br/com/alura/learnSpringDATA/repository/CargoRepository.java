package br.com.alura.learnSpringDATA.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import br.com.alura.learnSpringDATA.orm.Cargo;

@Repository
public interface CargoRepository extends CrudRepository<Cargo, Long>{

}
