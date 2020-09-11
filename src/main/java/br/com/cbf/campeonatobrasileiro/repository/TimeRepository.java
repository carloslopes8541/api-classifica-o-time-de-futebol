package br.com.cbf.campeonatobrasileiro.repository;

import br.com.cbf.campeonatobrasileiro.entity.Time;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import javax.persistence.criteria.CriteriaBuilder;
import java.util.function.Supplier;

@Repository
public interface TimeRepository extends JpaRepository<Time, Integer> {


}
