package br.com.maddytec.cliente.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

import javax.persistence.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Venda {

	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id_venda;

    @ManyToOne
    @JoinColumn(name = "id_customer")
    private Cliente cliente;

    private String firstName;

    private String secondName;

    @ManyToOne
    @JoinColumn(name = "id_pedido")
    private Pedido pedido;

    private Date data;

    @ManyToOne
    @JoinColumn(name = "id_item")
    private Item item;

    private String nome_item;

    private Double valor;

    @ManyToOne
    @JoinColumn(name = "id_compras")
    private Compras compras;

    private Long qtdade;

    public Long getId_venda() {
		return id_venda;
	}

	public void setId_venda(Long id_venda) {
		this.id_venda = id_venda;
	}

	public Cliente getCliente() {
		return cliente;
	}

	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getSecondName() {
		return secondName;
	}

	public void setSecondName(String secondName) {
		this.secondName = secondName;
	}

	public Pedido getPedido() {
		return pedido;
	}

	public void setPedido(Pedido pedido) {
		this.pedido = pedido;
	}

	public Date getData() {
		return data;
	}

	public void setData(Date date) {
		this.data = date;
	}

	public Item getItem() {
		return item;
	}

	public void setItem(Item item) {
		this.item = item;
	}

	public String getNome_item() {
		return nome_item;
	}

	public void setNome_item(String nome_item) {
		this.nome_item = nome_item;
	}

	public Double getValor() {
		return valor;
	}

	public void setValor(Double valor) {
		this.valor = valor;
	}

	public Compras getCompras() {
		return compras;
	}

	public void setCompras(Compras compras) {
		this.compras = compras;
	}

	public Long getQtdade() {
		return qtdade;
	}

	public void setQtdade(Long qtdade) {
		this.qtdade = qtdade;
	}

	public Venda(Cliente cliente, Pedido pedido, Item item, Compras compras) {
        this.cliente = cliente;
        this.firstName = cliente.getFirstName();
        this.secondName = cliente.getSecondName();
        this.pedido = pedido;
        this.data = pedido.getData();
        this.item = item;
        this.nome_item = item.getNome_item();
        this.valor = item.getValor();
        this.compras = compras;
        this.qtdade = compras.getQtdade();
    }

	

	

	
}
