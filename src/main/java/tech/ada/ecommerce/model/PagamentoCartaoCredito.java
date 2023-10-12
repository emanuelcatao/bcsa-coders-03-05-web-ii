package tech.ada.ecommerce.model;

import jakarta.persistence.DiscriminatorValue;
import jakarta.persistence.Entity;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@Entity
@DiscriminatorValue("CARTAO")
@Data
@EqualsAndHashCode(callSuper = true)
@NoArgsConstructor
public class PagamentoCartaoCredito extends FormaPagamento {

    private String numeroCartao;
    private String titular;
    private String dataExpiracao;
    private String codigoSeguranca;

}