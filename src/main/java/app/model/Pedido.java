package app.model;

import lombok.Data;
import org.springframework.jmx.export.annotation.ManagedResource;

import javax.persistence.*;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Data
@Entity
@Table(name = "pedidos")
public class Pedido {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    private Cliente cliente;

    private LocalDate data;

    private BigDecimal valorTotal;

    @OneToMany(mappedBy = "pedido", cascade = CascadeType.ALL)
    private List<ItensPedido> itens = new ArrayList<>();

    public void addItemPedido(final ItensPedido itensPedido) {
        itensPedido.setPedido(this);
        this.itens.add(itensPedido);
    }

}
