package br.com.maddytec.cliente.service;

import br.com.maddytec.cliente.entity.Item;
import br.com.maddytec.cliente.repository.ItemRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ItemService {

    @Autowired
    private ItemRepository itemRepository;

    public Item salvar(Item item) {
        return itemRepository.save(item);
    }

    public List<Item> listaItens() {
        return itemRepository.findAll();
    }

    public Optional<Item> buscarPorId(Long id) {
        return itemRepository.findById(id);
    }

    public void removerPorId(Long id) {
        itemRepository.deleteById(id);
    }
}
