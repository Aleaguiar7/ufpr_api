package br.com.maddytec.cliente.service;

import br.com.maddytec.cliente.entity.Venda;
import br.com.maddytec.cliente.repository.VendaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class VendaService {

    @Autowired
    private VendaRepository vendaRepository;

    public Venda salvar(Venda venda) {
        return vendaRepository.save(venda);
    }

    public List<Venda> listaVendas() {
        return vendaRepository.findAll();
    }

    public Optional<Venda> buscarPorId(Long id) {
        return vendaRepository.findById(id);
    }

    public void removerPorId(Long id) {
        vendaRepository.deleteById(id);
    }
}
