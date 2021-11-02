package app.controller;

import app.model.Pedido;
import app.model.vo.PedidoRelatorioVO;
import app.service.Pedidoservice;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.math.BigDecimal;
import java.util.List;

@RestController
@RequestMapping("/pedidos")
public class PedidoController {

    @Autowired
    private Pedidoservice pedidoservice;

    @PostMapping
    public ResponseEntity<Pedido> save(@RequestBody Pedido pedido) {
        final var pedidoSaved = this.pedidoservice.save(pedido);

        final var location = ServletUriComponentsBuilder
                .fromCurrentRequest()
                .path("/{id}")
                .buildAndExpand(pedidoSaved.getId())
                .toUri();
        return ResponseEntity.created(location).body(pedidoSaved);
    }

    @GetMapping
    public List<Pedido> findAll() {
        return this.pedidoservice.findAll();
    }

    @GetMapping(params = "cliente")
    public List<Pedido> findAllByClienteId(@RequestParam(value = "cliente") Long clienteId) {
        return this.pedidoservice.findAllByClienteId(clienteId);
    }

    @GetMapping("/valor_total")
    @ResponseStatus(HttpStatus.OK)
    public BigDecimal valorTotal() {
        return this.pedidoservice.calculateValorTotalOfPedidos();
    }

    @GetMapping("/relatorio")
    public List<PedidoRelatorioVO> relatorio() {
        return this.pedidoservice.relatorioDeVendas();
    }

}
