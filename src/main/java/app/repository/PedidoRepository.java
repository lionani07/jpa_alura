package app.repository;

import app.model.Pedido;
import app.model.vo.PedidoRelatorioVO;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.math.BigDecimal;
import java.util.List;

public interface PedidoRepository extends JpaRepository<Pedido, Long> {

    List<Pedido> findByClienteId(Long clienteId);

    @Query("SELECT SUM(p.valorTotal) FROM Pedido p")
    BigDecimal valorTotal();

    @Query(value = "SELECT produto.nome as nome, "
            + "SUM(item.quantidade) as quantidade, "
            + "MAX(pedido.data) as data "
            + "FROM Pedido pedido "
            + "JOIN pedido.itens item "
            + "JOIN item.produto produto "
            + "GROUP BY produto.id "
    )
    List<PedidoRelatorioVO> relatorio();
}
