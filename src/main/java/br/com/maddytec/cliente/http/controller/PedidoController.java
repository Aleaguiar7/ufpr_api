package br.com.maddytec.cliente.http.controller;

import br.com.maddytec.cliente.entity.Cliente;
import br.com.maddytec.cliente.entity.Pedido;
import br.com.maddytec.cliente.service.ClienteService;
import br.com.maddytec.cliente.service.PedidoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@RestController
@RequestMapping("/pedido")
public class PedidoController {

    @Autowired
    private PedidoService pedidoService;

    @Autowired
    private ClienteService clienteService;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Pedido salvar(@RequestBody Pedido pedido) {
        Cliente cliente = clienteService.buscarPorId(pedido.getCliente().getId_customer())
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Cliente não encontrado."));
        pedido.setCliente(cliente);
        return pedidoService.salvar(pedido);
    }

    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    public List<Pedido> listaPedidos() {
        return pedidoService.listaPedidos();
    }

    @GetMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public Pedido buscarPedidoPorId(@PathVariable("id") Long id) {
        return pedidoService.buscarPorId(id)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Pedido não encontrado."));
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void removerPedido(@PathVariable("id") Long id) {
        pedidoService.removerPorId(id);
    }

    @PutMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void atualizarPedido(@PathVariable("id") Long id, @RequestBody Pedido pedido) {
        Cliente cliente = clienteService.buscarPorId(pedido.getCliente().getId_customer())
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Cliente não encontrado."));
        pedido.setCliente(cliente);
        pedidoService.buscarPorId(id)
                .map(pedidoBase -> {
                    pedidoBase.setData(pedido.getData());
                    pedidoBase.setCliente(pedido.getCliente());
                    pedidoService.salvar(pedidoBase);
                    return Void.TYPE;
                }).orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Pedido não encontrado."));
    }
}
