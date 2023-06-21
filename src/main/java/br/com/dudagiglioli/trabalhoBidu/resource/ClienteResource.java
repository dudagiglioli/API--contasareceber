package br.com.dudagiglioli.trabalhoBidu.resource;

import br.com.dudagiglioli.trabalhoBidu.model.Cliente;
import br.com.dudagiglioli.trabalhoBidu.repository.ClienteRepository;
import br.com.dudagiglioli.trabalhoBidu.repository.Filter.ClienteFilter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;


@RestController
@RequestMapping("/cliente")

public class ClienteResource {

    @Autowired
    private ClienteRepository clienteRepository;

    @GetMapping
    public Page<Cliente> pesquisar(ClienteFilter clienteFilter, Pageable pageable){

        return clienteRepository.Filtrar(clienteFilter, pageable);

    }

    @GetMapping("/todos")
    public List<Cliente> listartodososclientes(){
        return clienteRepository.findAll();
    }
}
