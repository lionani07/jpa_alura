package app.model;

import lombok.Data;

import javax.persistence.*;
import java.math.BigDecimal;
import java.time.LocalDate;

@Data
@Entity
@Table(name = "pedidos")
public class Pedido {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)

    @Column(name = "CLIENTE_ID")
    private Cliente cliente;

    private Long id;

    private LocalDate data;

    private BigDecimal valorTotal;

}
