package br.com.dudagiglioli.trabalhoBidu.resource;

import br.com.dudagiglioli.trabalhoBidu.model.Cliente;
import br.com.dudagiglioli.trabalhoBidu.repository.ClienteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;


@RestController
@RequestMapping("/cliente")

public class ClienteResource {

    @Autowired
    private ClienteRepository clienteRepository;

    @GetMapping("/todos")
    public List<Cliente> listartodososclientes(){
        return clienteRepository.findAll();
    }
}
