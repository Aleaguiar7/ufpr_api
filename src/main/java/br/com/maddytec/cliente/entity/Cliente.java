package br.com.maddytec.cliente.entity;

import lombok.Data;

import javax.persistence.*;

@Entity
@Data
public class Cliente {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id_customer;

    @Column(name = "firstName", nullable = false)
    private String firstName;

    @Column(name = "secondName")
    private String secondName;

    public Cliente(Long id_customer, String firstName, String secondName) {
		super();
		this.id_customer = id_customer;
		this.firstName = firstName;
		this.secondName = secondName;
	}

	public Long getId_customer() {
		return id_customer;
	}

	public void setId_customer(Long id_customer) {
		this.id_customer = id_customer;
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

	// Construtor vazio para JPA
    public Cliente() {
    }

    // Construtor com os campos obrigatórios
    public Cliente(String firstName) {
        this.firstName = firstName;
    }
}
