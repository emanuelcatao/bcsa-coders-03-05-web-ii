package tech.ada.ecommerce.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import tech.ada.ecommerce.model.Cliente;
import tech.ada.ecommerce.service.ClienteService;

import java.util.List;

@RestController
@RequestMapping("/api/v1")
public class HelloWorldController {

    private static final Logger logger = LoggerFactory.getLogger(HelloWorldController.class);

    private final ClienteService clienteService;

    public HelloWorldController(ClienteService clienteService) {
        this.clienteService = clienteService;
    }

    @GetMapping("/hello")
    public String hello() {
        logger.info("Hello World!");
        return "Olá mundo!!";
    }

    @GetMapping("/clientes/{nome}")
    public List<Cliente> buscarClientes(@PathVariable("nome") String nome) {
        return clienteService.buscarPorNomeCompleto(nome);
    }
}
