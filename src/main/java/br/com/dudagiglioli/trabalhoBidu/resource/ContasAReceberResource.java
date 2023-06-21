package br.com.dudagiglioli.trabalhoBidu.resource;

import br.com.dudagiglioli.trabalhoBidu.model.Cliente;
import br.com.dudagiglioli.trabalhoBidu.model.ContasAReceber;
import br.com.dudagiglioli.trabalhoBidu.repository.ContasAReceberRepository;
import br.com.dudagiglioli.trabalhoBidu.repository.Filter.ClienteFilter;
import br.com.dudagiglioli.trabalhoBidu.repository.Filter.ContasAReceberFilter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/contasareceber")

public class ContasAReceberResource {

    @Autowired
    private ContasAReceberRepository contasAReceberRepository;

    @GetMapping
    public Page<ContasAReceber> pesquisar(ContasAReceberFilter contasAReceberFilter, Pageable pageable){

        return contasAReceberRepository.Filtrar(contasAReceberFilter, pageable);

    }

    @GetMapping("/todos")
    public List<ContasAReceber> listartodascontas(){
        return  contasAReceberRepository.findAll();
    }
}
