package br.com.maddytec.cliente.service;

import br.com.maddytec.cliente.entity.Compras;
import br.com.maddytec.cliente.repository.ComprasRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ComprasService {

    @Autowired
    private ComprasRepository comprasRepository;

    public Compras salvar(Compras compras) {
        return comprasRepository.save(compras);
    }

    public List<Compras> listaCompras() {
        return comprasRepository.findAll();
    }

    public Optional<Compras> buscarPorId(Long id) {
        return comprasRepository.findById(id);
    }

    public void removerPorId(Long id) {
        comprasRepository.deleteById(id);
    }
}
