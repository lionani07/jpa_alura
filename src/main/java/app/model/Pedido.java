package app.model;

import lombok.Data;

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

    private BigDecimal valorTotal = BigDecimal.ZERO;

    @OneToMany(mappedBy = "pedido", cascade = CascadeType.ALL)
    private List<ItensPedido> itens = new ArrayList<>();

    @PrePersist
    public void prePersist() {
        this.valorTotal = this.itens.stream()
                .map(ItensPedido::getValorTotal)
                .reduce( BigDecimal::add)
                .orElse(BigDecimal.ZERO);
    }

    public void addItemPedido(final ItensPedido itensPedido) {
        itensPedido.setPedido(this);
        this.itens.add(itensPedido);
    }

}
