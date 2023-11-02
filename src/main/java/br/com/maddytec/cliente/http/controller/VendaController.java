package br.com.maddytec.cliente.http.controller;

import br.com.maddytec.cliente.entity.Cliente;
import br.com.maddytec.cliente.entity.Compras;
import br.com.maddytec.cliente.entity.Item;
import br.com.maddytec.cliente.entity.Pedido;
import br.com.maddytec.cliente.entity.Venda;
import br.com.maddytec.cliente.service.ClienteService;
import br.com.maddytec.cliente.service.ComprasService;
import br.com.maddytec.cliente.service.ItemService;
import br.com.maddytec.cliente.service.PedidoService;
import br.com.maddytec.cliente.service.VendaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@RestController
@RequestMapping("/venda")
public class VendaController {

    @Autowired
    private VendaService vendaService;

    @Autowired
    private ClienteService clienteService;

    @Autowired
    private PedidoService pedidoService;

    @Autowired
    private ItemService itemService;

    @Autowired
    private ComprasService comprasService;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Venda salvar(@RequestBody Venda venda) {
        Cliente cliente = clienteService.buscarPorId(venda.getCliente().getId_customer())
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Cliente não encontrado."));
        Pedido pedido = pedidoService.buscarPorId(venda.getPedido().getId_pedido())
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Pedido não encontrado."));
        Item item = itemService.buscarPorId(venda.getItem().getId_item())
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Item não encontrado."));
        Compras compras = comprasService.buscarPorId(venda.getCompras().getId_compra())
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Compra não encontrada."));

        venda.setCliente(cliente);
        venda.setFirstName(cliente.getFirstName());
        venda.setSecondName(cliente.getSecondName());
        venda.setPedido(pedido);
        venda.setData(pedido.getData());
        venda.setItem(item);
        venda.setNome_item(item.getNome_item());
        venda.setValor(item.getValor());
        venda.setCompras(compras);
        venda.setQtdade(compras.getQtdade());

        return vendaService.salvar(venda);
    }

    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    public List<Venda> listaVendas() {
        return vendaService.listaVendas();
    }

    @GetMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public Venda buscarVendaPorId(@PathVariable("id") Long id) {
        return vendaService.buscarPorId(id)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Venda não encontrada."));
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void removerVenda(@PathVariable("id") Long id) {
        vendaService.removerPorId(id);
    }

    @PutMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void atualizarVenda(@PathVariable("id") Long id, @RequestBody Venda venda) {
        Cliente cliente = clienteService.buscarPorId(venda.getCliente().getId_customer())
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Cliente não encontrado."));
        Pedido pedido = pedidoService.buscarPorId(venda.getPedido().getId_pedido())
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Pedido não encontrado."));
        Item item = itemService.buscarPorId(venda.getItem().getId_item())
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Item não encontrado."));
        Compras compras = comprasService.buscarPorId(venda.getCompras().getId_compra())
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Compra não encontrada."));

        venda.setCliente(cliente);
        venda.setFirstName(cliente.getFirstName());
        venda.setSecondName(cliente.getSecondName());
        venda.setPedido(pedido);
        venda.setData(pedido.getData());
        venda.setItem(item);
        venda.setNome_item(item.getNome_item());
        venda.setValor(item.getValor());
        venda.setCompras(compras);
        venda.setQtdade(compras.getQtdade());

        vendaService.buscarPorId(id)
                .map(vendaBase -> {
                    vendaBase.setCliente(venda.getCliente());
                    vendaBase.setFirstName(venda.getFirstName());
                    vendaBase.setSecondName(venda.getSecondName());
                    vendaBase.setPedido(venda.getPedido());
                    vendaBase.setData(venda.getData());
                    vendaBase.setItem(venda.getItem());
                    vendaBase.setNome_item(venda.getNome_item());
                    vendaBase.setValor(venda.getValor());
                    vendaBase.setCompras(venda.getCompras());
                    vendaBase.setQtdade(venda.getQtdade());
                    vendaService.salvar(vendaBase);
                    return Void.TYPE;
                }).orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Venda não encontrada."));
        
    }
}
