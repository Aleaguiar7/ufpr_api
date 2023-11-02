package br.com.maddytec.cliente.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

import com.fasterxml.jackson.annotation.JsonFormat;

import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Pedido {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id_pedido;

    @Column(name = "data_criacao", nullable = false)
    @JsonFormat(pattern = "yyyy-MM-dd")
    private Date data;

    @ManyToOne
    @JoinColumn(name = "id_cliente")
    private Cliente cliente;

    public Pedido(Date data, Cliente cliente) {
        this.data = data;
        this.cliente = cliente;
    }
    
    private Pedido () {
    	super();
    }

	public Pedido(Long id_pedido, Date data, Cliente cliente) {
		super();
		this.id_pedido = id_pedido;
		this.data = data;
		this.cliente = cliente;
	}

	public Long getId_pedido() {
		return id_pedido;
	}

	public void setId_pedido(Long id_pedido) {
		this.id_pedido = id_pedido;
	}

	public Date getData() {
		return data;
	}

	public void setData(Date data) {
		this.data = data;
	}

	public Cliente getCliente() {
		return cliente;
	}

	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}

	
	}

