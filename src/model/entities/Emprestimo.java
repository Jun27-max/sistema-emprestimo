package model.entities;

import java.util.Date;
import java.util.Objects;

public class Emprestimo {

	private int id;
	private Date data;
	private Double valor;
	private int parcela;

	public Emprestimo() {

	}

	public Emprestimo(int id, Double valor, int parcela) {
		this.id = id;
		this.valor = valor;
		this.parcela = parcela;
	}

	public int getId() {
		return id;
	}

	public Date getData() {
		return data;
	}

	public Double getValor() {
		return valor;
	}

	public int getQuantidade() {
		return parcela;
	}

	@Override
	public int hashCode() {
		return Objects.hash(id);
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
		return id == other.id;
	}

	@Override
	public String toString() {
		return "Emprestimo [id=" + id + ", data=" + data + ", valor=" + valor + ", parcela=" + parcela + "]";
	}

}
