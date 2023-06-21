package br.com.dudagiglioli.trabalhoBidu.repository.Cliente;

import br.com.dudagiglioli.trabalhoBidu.model.Cliente;
import br.com.dudagiglioli.trabalhoBidu.repository.Filter.ClienteFilter;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface ClienteRepositoryQuery {

    public Page<Cliente> Filtrar(ClienteFilter clienteFilter, Pageable pageable);

}
