package tech.ada.ecommerce.model;

import jakarta.persistence.Column;
import jakarta.persistence.DiscriminatorValue;
import jakarta.persistence.Entity;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import org.hibernate.validator.constraints.CreditCardNumber;

import java.util.Date;

@Entity
@DiscriminatorValue("CARTAO")
@Data
@EqualsAndHashCode(callSuper = true)
@NoArgsConstructor
@AllArgsConstructor
public class PagamentoCartaoCredito extends FormaPagamento {
    @Column(unique = true, nullable = false, length = 16)
    @CreditCardNumber
    private String numeroCartao;

    @Column(nullable = false)
    private String nomeTitular;

    @Column(nullable = false)
    private Date validade;

    @Column(nullable = false, length = 3)
    private String cvv;

    @Column(nullable = false)
    private int qtdParcelas;

    @Column(nullable = false)
    private String cpfTitular;
}