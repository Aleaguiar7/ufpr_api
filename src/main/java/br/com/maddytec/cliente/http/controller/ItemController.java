package br.com.maddytec.cliente.http.controller;

import br.com.maddytec.cliente.entity.Item;
import br.com.maddytec.cliente.service.ItemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@RestController
@RequestMapping("/item")
public class ItemController {

    @Autowired
    private ItemService itemService;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Item salvar(@RequestBody Item item) {
        return itemService.salvar(item);
    }

    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    public List<Item> listaItens() {
        return itemService.listaItens();
    }

    @GetMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public Item buscarItemPorId(@PathVariable("id") Long id) {
        return itemService.buscarPorId(id)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Item não encontrado."));
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void removerItem(@PathVariable("id") Long id) {
        itemService.buscarPorId(id)
                .map(item -> {
                    itemService.removerPorId(item.getId_item());
                    return Void.TYPE;
                }).orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Item não encontrado."));
    }

    @PutMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void atualizarItem(@PathVariable("id") Long id, @RequestBody Item item) {
        itemService.buscarPorId(id)
                .map(itemBase -> {
                    itemBase.setNome_item(item.getNome_item());
                    itemBase.setValor(item.getValor());
                    itemService.salvar(itemBase);
                    return Void.TYPE;
                }).orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Item não encontrado."));
    }
}
