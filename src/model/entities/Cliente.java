package model.entities;

import java.util.Objects;

public class Cliente {

	private int id;
	private String nome;
	private String email;
	private String cpf;
	private String rg;
	private String endere�o;
	private Double renda;
	private String senha;

	private Emprestimo emprestimo;

	public Cliente() {

	}

	public Cliente(int id, String nome, String email, String cpf, String rg, String endere�o, Double renda,
			String senha, Emprestimo emprestimo) {
		this.id = id;
		this.nome = nome;
		this.email = email;
		this.cpf = cpf;
		this.rg = rg;
		this.endere�o = endere�o;
		this.renda = renda;
		this.senha = senha;
		this.emprestimo = emprestimo;
	}

	public int getId() {
		return id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getCpf() {
		return cpf;
	}

	public void setCpf(String cpf) {
		this.cpf = cpf;
	}

	public String getRg() {
		return rg;
	}

	public void setRg(String rg) {
		this.rg = rg;
	}

	public String getEndere�o() {
		return endere�o;
	}

	public void setEndere�o(String endere�o) {
		this.endere�o = endere�o;
	}

	public Double getRenda() {
		return renda;
	}

	public String getSenha() {
		return senha;
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
		Cliente other = (Cliente) obj;
		return id == other.id;
	}

	@Override
	public String toString() {
		return "Cliente [id=" + id + ", nome=" + nome + ", email=" + email + ", cpf=" + cpf + ", rg=" + rg
				+ ", endere�o=" + endere�o + ", renda=" + renda + ", senha=" + senha + ", emprestimo=" + emprestimo
				+ "]";
	}

}
