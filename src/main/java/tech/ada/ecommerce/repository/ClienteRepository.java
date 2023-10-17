package tech.ada.ecommerce.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import tech.ada.ecommerce.model.Cliente;

import java.util.Date;
import java.util.List;
import java.util.Optional;

@Repository
public interface ClienteRepository extends JpaRepository<Cliente, Long> {
    List<Cliente> findClientesByNomeCompleto(String nomeCompleto);

    List<Cliente> findClientesByNomeCompletoLike(String nomeCompleto);

    @Query("SELECT c FROM Cliente c WHERE c.nomeCompleto LIKE CONCAT('%', :nome, '%')")
    List<Cliente> findClientesByNomeCompletoCustom(@Param("nome") String nome);

    /*@Query(value = "SELECT c FROM Cliente c WHERE c.nomeCompleto LIKE CONCAT('%', :nome, '%')", nativeQuery = true)
    List<Cliente> findClientesByNomeCompletoCustom2(@Param("nome") String nome);*/

    @Modifying
    @Query("UPDATE Cliente c SET c.ativo = :ativo WHERE c.id = :id")
    void ativarUsuario(@Param("ativo") boolean ativo, @Param("id") long id);

    //Isso aqui faz ser uma sql msm
    /*@Query(value = "UPDATE Cliente c SET c.ativo = :ativo WHERE c.id = :id", nativeQuery = true)
    void ativarUsuario2(@Param("ativo") boolean ativo, @Param("id") long id);*/

    Cliente dataNascimentoBetween(Date data1, Date data2);
}
