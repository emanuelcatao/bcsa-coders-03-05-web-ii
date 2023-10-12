package tech.ada.ecommerce.model;

import jakarta.persistence.DiscriminatorValue;
import jakarta.persistence.Entity;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@Entity
@DiscriminatorValue("PIX")
@Data
@EqualsAndHashCode(callSuper = true)
@NoArgsConstructor
public class PagamentoPix extends FormaPagamento {

    private String chavePix;

}