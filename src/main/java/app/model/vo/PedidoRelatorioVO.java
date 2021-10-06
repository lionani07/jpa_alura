package app.model.vo;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;

@Getter
@Setter
@AllArgsConstructor
public class PedidoRelatorioVO {

    private String nome;
    private Long quantidade;
    private LocalDate data;
}
