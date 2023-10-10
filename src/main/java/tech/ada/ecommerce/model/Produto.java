package tech.ada.ecommerce.model;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "Produto")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode(of="id")
public class Produto {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(nullable = false)
    private String nome;
    @Column(columnDefinition = "TEXT")
    private String descricao;
    @Column(unique = true, name = "SKU")
    private String sku;
    private double preco;
    private int quantidadeEmEstoque;
}