package app.controller;

import app.model.Pedido;
import app.service.Pedidoservice;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

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
}
