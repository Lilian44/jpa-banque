package fr.diginamic.banque;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;

@Entity
@Inheritance(strategy = InheritanceType.JOINED)
public class Compte {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id;
	private String numero;
	private double solde;

	@ManyToMany
	@JoinTable(name = "compo",

			joinColumns = @JoinColumn(name = "id_com", referencedColumnName = "id"),

			inverseJoinColumns = @JoinColumn(name = "id_cli", referencedColumnName = "id")

	)
	private List<Client> clients= new ArrayList<>();

	@OneToMany
	@JoinColumn(name = "compte")
	private List<Operation> operations= new ArrayList<>();

	public Compte() {
	}
	

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getNumero() {
		return numero;
	}

	public void setNumero(String numero) {
		this.numero = numero;
	}

	public double getSolde() {
		return solde;
	}

	public void setSolde(double solde) {
		this.solde = solde;
	}

	public List<Client> getClients() {
		return clients;
	}

	public void setClients(List<Client> clients) {
		this.clients = clients;
	}

	public List<Operation> getOperations() {
		return operations;
	}

	public void setOperations(List<Operation> operations) {
		this.operations = operations;
	}

}
