package app.model.vo;

import java.math.BigDecimal;
import java.time.LocalDate;

public interface PedidoRelatorioVO {

    String getNome();
    Long getQuantidade();
    BigDecimal getValorUnitario();
    BigDecimal getValorTotal();
    LocalDate getData();
}
