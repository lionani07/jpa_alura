package app.service;

import app.model.ItensPedido;
import app.model.Pedido;
import app.repository.PedidoRepository;
import app.repository.ProdutoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class Pedidoservice {

    @Autowired
    private PedidoRepository pedidoRepository;

    @Autowired
    private ProdutoRepository produtoRepository;

    public Pedido save(final Pedido pedido) {
        pedido.setItens(buildItens(pedido));
        return this.pedidoRepository.save(pedido);
    }

    private List<ItensPedido> buildItens(final Pedido pedido) {
        return pedido.getItens().stream().map(itensPedido -> {
            final var produto = this.produtoRepository.findById(itensPedido.getProduto().getId()).orElseThrow();
            return new ItensPedido(pedido, produto, itensPedido.getQuantidade());
        }).collect(Collectors.toList());
    }
}
