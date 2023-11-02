package br.com.maddytec.cliente.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Compras {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id_compra;

    @Column(name = "qtdade", nullable = false)
    private Long qtdade;

    @ManyToOne
    @JoinColumn(name = "id_pedido")
    private Pedido pedido;

    @ManyToOne
    @JoinColumn(name = "id_item")
    private Item item;
    
    private Compras () {
    	super();
    }

	public Long getId_compra() {
		return id_compra;
	}

	public void setId_compra(Long id_compra) {
		this.id_compra = id_compra;
	}

	public Long getQtdade() {
		return qtdade;
	}

	public void setQtdade(Long qtdade) {
		this.qtdade = qtdade;
	}

	public Pedido getPedido() {
		return pedido;
	}

	public void setPedido(Pedido pedido) {
		this.pedido = pedido;
	}

	public Item getItem() {
		return item;
	}

	public void setItem(Item item) {
		this.item = item;
	}

	public Compras(Long id_compra, Long qtdade, Pedido pedido, Item item) {
		super();
		this.id_compra = id_compra;
		this.qtdade = qtdade;
		this.pedido = pedido;
		this.item = item;
	}

    
}
