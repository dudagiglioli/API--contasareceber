package br.com.dudagiglioli.trabalhoBidu.resource;

import br.com.dudagiglioli.trabalhoBidu.model.ContasAReceber;
import br.com.dudagiglioli.trabalhoBidu.repository.ContasAReceberRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/contasareceber")

public class ContasAReceberResource {

    @Autowired
    private ContasAReceberRepository contasAReceberRepository;

    @GetMapping("/todos")
    public List<ContasAReceber> listartodascontas(){
        return  contasAReceberRepository.findAll();
    }
}
