package tech.ada.ecommerce.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import tech.ada.ecommerce.model.Cliente;
import tech.ada.ecommerce.model.Compra;

import java.util.Date;
import java.util.List;

@Repository
public interface CompraRepository extends JpaRepository<Compra, Long> {

    List<Compra> findByCliente(Cliente cliente);

    List<Compra> findByDataCompraBetween(Date dataInicio, Date dataFim);

    // Adicione mais métodos conforme a necessidade.
}