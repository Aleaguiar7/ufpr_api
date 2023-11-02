package br.com.maddytec.cliente.repository;

import br.com.maddytec.cliente.entity.Venda;
import org.springframework.data.jpa.repository.JpaRepository;

public interface VendaRepository extends JpaRepository<Venda, Long> {
}
