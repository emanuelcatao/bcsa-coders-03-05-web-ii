package tech.ada.ecommerce.model;

import jakarta.persistence.*;
import lombok.*;
import tech.ada.ecommerce.model.enums.StatusType;

import java.util.Date;
import java.util.List;

@Entity
@Table
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode(of="id")
public class Compra {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @ManyToOne
    private Cliente cliente;
    private Date dataCompra;
    private double valorProduto;
    private double desconto;
    private double valorFrete;
    private double valorTotal;
    //@OneToMany(fetch = FetchType.LAZY) --> ver depois
    @OneToMany
    private List<ItemProduto> produtos;

    @Enumerated(value = EnumType.STRING)
    private StatusType statusType;
}
