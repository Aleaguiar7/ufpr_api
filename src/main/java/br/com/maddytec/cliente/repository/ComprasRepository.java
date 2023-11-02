package br.com.maddytec.cliente.repository;

import br.com.maddytec.cliente.entity.Compras;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ComprasRepository extends JpaRepository<Compras, Long> {
}
