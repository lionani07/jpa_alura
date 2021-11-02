package app.service;

import app.model.ItensPedido;
import app.model.Pedido;
import app.model.vo.PedidoRelatorioVO;
import app.repository.PedidoRepository;
import app.repository.ProdutoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

@Service
public class Pedidoservice {

    @Autowired
    private PedidoRepository pedidoRepository;

    @Autowired
    private ProdutoRepository produtoRepository;

    public Pedido save(final Pedido pedido) {
        updateItens(pedido);
        return this.pedidoRepository.save(pedido);
    }

    private void updateItens(final Pedido pedido) {
        final var itensInRequest = new ArrayList<>(pedido.getItens());
        pedido.getItens().clear();
        itensInRequest.forEach(itensPedidoRequest -> {
            final var produto = this.produtoRepository.findById(itensPedidoRequest.getProduto().getId()).orElseThrow();
            pedido.addItemPedido(new ItensPedido(pedido, produto, itensPedidoRequest.getQuantidade()));
        });
    }

    public List<Pedido> findAll() {
        return this.pedidoRepository.findAll();
    }

    public List<Pedido> findAllByClienteId(Long clienteId) {
        return this.pedidoRepository.findByClienteId(clienteId);
    }

    public BigDecimal calculateValorTotalOfPedidos() {
        return this.pedidoRepository.valorTotal();
    }

    public List<PedidoRelatorioVO> relatorioDeVendas() {
        return this.pedidoRepository.relatorio();
    }
}
