package br.com.dudagiglioli.trabalhoBidu.repository.ContasAReceber;


import br.com.dudagiglioli.trabalhoBidu.repository.Filter.ContasAReceberFilter;
import br.com.dudagiglioli.trabalhoBidu.repository.projections.ContasAReceberDTO;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface ContasAReceberRepositoryQuery {

    public Page<ContasAReceberDTO> Filtrar(ContasAReceberFilter contasAReceberFilter, Pageable pageable);

}
