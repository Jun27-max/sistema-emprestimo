package model.entities;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class Emprestimo {

	private int cod;
	private String data;
	private double total;
	private int idCliente;

	private List<Cliente> clientes = new ArrayList<>();

	public Emprestimo() {

	}

	public Emprestimo(String data, double total) {
		this.data = data;
		this.total = total;
	}

	public int getCod() {
		return cod;
	}

	public void setCod(int cod) {
		this.cod = cod;
	}

	public String getData() {
		return data;
	}

	public void setData(String data) {
		this.data = data;
	}
	
	public int getIdCliente() {
		return idCliente;
	}

	public void setIdCliente(int idCliente) {
		this.idCliente = idCliente;
	}

	public double getTotal() {
		return this.total = total();
	}

	public void setTotal(double total) {
		this.total = total;
	}

	private Double total() {
		double sum = 0.0;

		for (Cliente c : clientes) {
			sum = sum + c.subTotal();
		}
		return sum;

	}

	@Override
	public int hashCode() {
		return Objects.hash(cod);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Emprestimo other = (Emprestimo) obj;
		return cod == other.cod;
	}

}
