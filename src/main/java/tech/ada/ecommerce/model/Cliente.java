package tech.ada.ecommerce.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import lombok.*;
import org.hibernate.validator.constraints.br.CPF;

import java.util.Date;
import java.util.Set;

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
    @Temporal(TemporalType.DATE)
    private Date dataNascimento;

    @Column(unique = true)
    @CPF
    private String cpf;

    @Column(unique = true, nullable = false)
    @Email(message = "Email inválido")
    private String email;

    @Column(nullable = false)
    private String senha;

    @Column(nullable = false)
    private boolean ativo = true;

    @Temporal(TemporalType.TIMESTAMP)
    private Date dataDesativacao;

    @ManyToMany(fetch = FetchType.EAGER)
    @JoinTable(name = "clientes_roles",
            joinColumns = @JoinColumn(name = "cliente_id", referencedColumnName = "id"),
            inverseJoinColumns = @JoinColumn(name = "role_id", referencedColumnName = "id")
    )
    private Set<Role> roles;

    public Cliente(String nomeCompleto, Date dataNascimento, String cpf, String email, String senha, boolean ativo) {
        this.nomeCompleto = nomeCompleto;
        this.dataNascimento = dataNascimento;
        this.cpf = cpf;
        this.email = email;
        this.senha = senha;
        this.ativo = ativo;
    }

}
