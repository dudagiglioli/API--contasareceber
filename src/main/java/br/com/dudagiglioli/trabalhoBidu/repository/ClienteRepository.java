package br.com.dudagiglioli.trabalhoBidu.repository;

import br.com.dudagiglioli.trabalhoBidu.model.Cliente;
import br.com.dudagiglioli.trabalhoBidu.repository.Cliente.ClienteRepositoryQuery;
import br.com.dudagiglioli.trabalhoBidu.repository.Filter.ClienteFilter;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ClienteRepository extends JpaRepository<Cliente, Integer>, ClienteRepositoryQuery {
}
