package br.com.maddytec.cliente.http.controller;

import br.com.maddytec.cliente.entity.Compras;
import br.com.maddytec.cliente.entity.Item;
import br.com.maddytec.cliente.entity.Pedido;
import br.com.maddytec.cliente.service.ComprasService;
import br.com.maddytec.cliente.service.ItemService;
import br.com.maddytec.cliente.service.PedidoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@RestController
@RequestMapping("/compras")
public class ComprasController {

    @Autowired
    private ComprasService comprasService;

    @Autowired
    private PedidoService pedidoService;

    @Autowired
    private ItemService itemService;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Compras salvar(@RequestBody Compras compras) {
        Pedido pedido = pedidoService.buscarPorId(compras.getPedido().getId_pedido())
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Pedido não encontrado."));
        Item item = itemService.buscarPorId(compras.getItem().getId_item())
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Item não encontrado."));
        compras.setPedido(pedido);
        compras.setItem(item);
        return comprasService.salvar(compras);
    }

    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    public List<Compras> listaCompras() {
        return comprasService.listaCompras();
    }

    @GetMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public Compras buscarCompraPorId(@PathVariable("id") Long id) {
        return comprasService.buscarPorId(id)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Compra não encontrada."));
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void removerCompra(@PathVariable("id") Long id) {
        comprasService.removerPorId(id);
    }

    @PutMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void atualizarCompra(@PathVariable("id") Long id, @RequestBody Compras compras) {
        Pedido pedido = pedidoService.buscarPorId(compras.getPedido().getId_pedido())
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Pedido não encontrado."));
        Item item = itemService.buscarPorId(compras.getItem().getId_item())
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Item não encontrado."));
        compras.setPedido(pedido);
        compras.setItem(item);
        comprasService.buscarPorId(id)
                .map(comprasBase -> {
                    comprasBase.setQtdade(compras.getQtdade());
                    comprasBase.setPedido(compras.getPedido());
                    comprasBase.setItem(compras.getItem());
                    comprasService.salvar(comprasBase);
                    return Void.TYPE;
                }).orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Compra não encontrada."));
    }
}
