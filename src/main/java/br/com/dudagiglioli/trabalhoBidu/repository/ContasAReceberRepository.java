package br.com.dudagiglioli.trabalhoBidu.repository;

import br.com.dudagiglioli.trabalhoBidu.model.ContasAReceber;
import br.com.dudagiglioli.trabalhoBidu.repository.ContasAReceber.ContasAReceberRepositoryQuery;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ContasAReceberRepository extends JpaRepository<ContasAReceber, Integer>, ContasAReceberRepositoryQuery {
}
