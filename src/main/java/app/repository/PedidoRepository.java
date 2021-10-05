package app.repository;

import app.model.Pedido;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.math.BigDecimal;
import java.util.List;

public interface PedidoRepository extends JpaRepository<Pedido, Long> {

    List<Pedido> findByClienteId(Long clienteId);

    @Query("SELECT SUM(p.valorTotal) FROM Pedido p")
    BigDecimal valorTotal();

}
