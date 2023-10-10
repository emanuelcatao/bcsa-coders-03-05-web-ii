package tech.ada.ecommerce.model;

import jakarta.persistence.*;
import lombok.*;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@EqualsAndHashCode(of = {"id", "compra", "produto"})
public class ItemProduto {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @ManyToOne
    //@JoinColumn(name = "compra_valor_produtos",referencedColumnName = "valor_produtos")
    private Compra compra;
    @ManyToOne
    private Produto produto;

    private Long qtd;

    private double valorTotalProduto;
}
