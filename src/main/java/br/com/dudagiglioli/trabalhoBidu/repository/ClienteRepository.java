package br.com.dudagiglioli.trabalhoBidu.repository;

import br.com.dudagiglioli.trabalhoBidu.model.Cliente;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ClienteRepository extends JpaRepository<Cliente, Integer> {
}
