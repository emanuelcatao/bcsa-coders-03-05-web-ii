package tech.ada.ecommerce.dto;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Builder;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import java.util.Date;

@Data
@Builder
@Getter
@Setter
public class ClienteDTO {

    private Long id;

    private String nomeCompleto;

    private String dataNascimento;

    private String cpf;

    private String email;

    private String senha;

    private boolean ativo;

    @JsonIgnore
    private Date dataDesativacao;
}