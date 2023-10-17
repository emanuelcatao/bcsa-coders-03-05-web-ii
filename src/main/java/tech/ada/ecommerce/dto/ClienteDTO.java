package tech.ada.ecommerce.dto;

import java.util.Date;

public record ClienteDTO(String nomeCompleto, String dataNascimento, String cpf, String email, String senha, boolean ativo, Date dataDesativacao) {
}