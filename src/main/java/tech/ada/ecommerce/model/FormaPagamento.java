package tech.ada.ecommerce.model;

import jakarta.persistence.*;

@Entity
@Table
public class FormaPagamento {//CRIAAAAARRRRRR
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String descricao;

}
