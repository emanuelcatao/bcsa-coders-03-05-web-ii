package tech.ada.ecommerce.service;

import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;
import tech.ada.ecommerce.dto.CEP;
import tech.ada.ecommerce.model.Endereco;
import tech.ada.ecommerce.repository.EnderecoRepository;

@Service
public class EnderecoService {

    EnderecoRepository enderecoRepository;
//    WebClient webClient;

    private EnderecoService(EnderecoRepository enderecoRepository) {
        this.enderecoRepository = enderecoRepository;
//        this.webClient = webClient;
    }

    public CEP buscaPorCEP(String cep) {
        String url = "https://viacep.com.br/ws/";
//        RestTemplate restTemplate = new RestTemplate();
//        ResponseEntity<CEP> response = restTemplate.getForEntity(url, CEP.class);
//        return response.getBody();
//        OAuth2RestTemplate
//        String token = "<token>";
        WebClient webClient = WebClient.builder()
                .baseUrl(url)
//                .defaultHeader(HttpHeaders.AUTHORIZATION, "Bearer " + token)
                .build();

        CEP result = webClient.get().uri(url + cep + "/json").retrieve().bodyToMono(CEP.class).block();
        return result;
    }

    public Endereco saveEndereco(Endereco endereco) {
        CEP cep = buscaPorCEP(endereco.getCep());
        endereco.setUf(cep.getUf());
        endereco.setCidade(cep.getLocalidade());
        endereco.setBairro(cep.getBairro());
        endereco.setLogradouro(cep.getLogradouro());
        return enderecoRepository.save(endereco);
    }

}