package app.model.vo;

import java.time.LocalDate;

public interface PedidoRelatorioVO {

    String getNome();
    Long getQuantidade();
    LocalDate getData();
}
