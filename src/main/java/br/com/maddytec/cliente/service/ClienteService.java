package br.com.maddytec.cliente.service;

import br.com.maddytec.cliente.entity.Cliente;
import br.com.maddytec.cliente.repository.ClienteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ClienteService {

    @Autowired
    private ClienteRepository clienteRepository;

    public Cliente salvar(Cliente cliente) {
        return clienteRepository.save(cliente);
    }

    public List<Cliente> listaClientes() {
        return clienteRepository.findAll();
    }

    public Optional<Cliente> buscarPorId(Long id_cliente) {
        return clienteRepository.findById(id_cliente);
    }

    public void removerPorId(Long id) {
        clienteRepository.deleteById(id);
    }

    public void atualizarCliente(Long id, Cliente novoCliente) {
        Cliente clienteExistente = buscarPorId(id)
                .orElseThrow(() -> new RuntimeException("Cliente não encontrado."));

        clienteExistente.setFirstName(novoCliente.getFirstName());
        clienteExistente.setSecondName(novoCliente.getSecondName());

        clienteRepository.save(clienteExistente);
    }
}
