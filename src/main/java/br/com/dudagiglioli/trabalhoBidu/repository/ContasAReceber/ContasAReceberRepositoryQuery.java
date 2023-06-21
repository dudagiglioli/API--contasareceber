package br.com.dudagiglioli.trabalhoBidu.repository.ContasAReceber;

import br.com.dudagiglioli.trabalhoBidu.model.ContasAReceber;
import br.com.dudagiglioli.trabalhoBidu.repository.Filter.ContasAReceberFilter;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface ContasAReceberRepositoryQuery {

    public Page<ContasAReceber> Filtrar(ContasAReceberFilter contasAReceberFilter, Pageable pageable);

}
