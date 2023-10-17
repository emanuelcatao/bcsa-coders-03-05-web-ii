package tech.ada.ecommerce.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import tech.ada.ecommerce.model.Produto;

import java.util.List;
import java.util.Optional;

@Repository
public interface ProdutoRepository extends JpaRepository<Produto, Long> {

    @Query("SELECT p FROM Produto p WHERE p.nome LIKE %:nome%")
    List<Produto> findByNomeContaining(@Param("nome") String nome);

    @Query("SELECT p FROM Produto p WHERE p.preco BETWEEN :minPreco AND :maxPreco")
    List<Produto> findByPrecoBetween(@Param("minPreco") double minPreco, @Param("maxPreco") double maxPreco);

    @Query("SELECT p FROM Produto p WHERE p.nome LIKE %:nome% AND p.preco BETWEEN :minPreco AND :maxPreco")
    List<Produto> findByNomeContainingAndPrecoBetween(@Param("nome") String nome, @Param("minPreco") double minPreco, @Param("maxPreco") double maxPreco);

    Optional<Produto> findProdutoById(Long id);

    Optional<Produto> findProdutoBySku(String sku);
}
