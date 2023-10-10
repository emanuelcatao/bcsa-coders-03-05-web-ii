package tech.ada.ecommerce.model;

import jakarta.persistence.*;
import lombok.*;

import java.util.Date;

@Entity(name="Cliente")
@Table(name="Cliente")
@Getter
@Setter
@EqualsAndHashCode
@NoArgsConstructor
@AllArgsConstructor
public class Cliente {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(length = 100, nullable = false)
    private String nomeCompleto;
    @Column(nullable = false)
    private Date dataNascimento;
    @Column(unique = true)
    private String cpf;
    @Column(unique = true, nullable = false)
    private String email;
    @Column(nullable = false)
    private String senha;
}
