package model.entities;

import java.util.Objects;

public class Cliente {

	private int id;
	private String nome;
	private String email;
	private String cpf;
	private String rg;
	private String endereço;
	private Double renda;
	private String senha;
	private Double valor;
	private int parcela;
	
	private Emprestimo emprestimo;

	public Cliente() {

	}

	public Cliente( String nome, String email, String cpf, String rg, String endereço, Double renda,
			String senha, Double valor, int parcela) {
		this.nome = nome;
		this.email = email;
		this.cpf = cpf;
		this.rg = rg;
		this.endereço = endereço;
		this.renda = renda;
		this.senha = senha;
		this.valor = valor;
		this.parcela = parcela;
	}
	
	
	public Cliente(int id, String nome, String email, String cpf, Double renda, Double valor, int parcela,
			Emprestimo emprestimo) {
		this.id = id;
		this.nome = nome;
		this.email = email;
		this.cpf = cpf;
		this.renda = renda;
		this.valor = valor;
		this.parcela = parcela;
		this.emprestimo = emprestimo;
	}

	public int getId() {
		return id;
	}
	
	public void setId(int id) {
		this.id = id;
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

	public String getEndereço() {
		return endereço;
	}

	public void setEndereço(String endereço) {
		this.endereço = endereço;
	}

	public Double getRenda() {
		return renda;
	}

	public void setRenda(Double renda) {
		this.renda = renda;
	}

	public String getSenha() {
		return senha;
	}

	public void setSenha(String senha) {
		this.senha = senha;
	}

	public Double getValor() {
		return valor;
	}

	public void setValor(Double valor) {
		this.valor = valor;
	}

	public int getParcela() {
		return parcela;
	}

	public void setParcela(int parcela) {
		this.parcela = parcela;
	}
	
	public Emprestimo getEmprestimo() {
		return emprestimo;
	}

	public void setEmprestimo(Emprestimo emprestimo) {
		this.emprestimo = emprestimo;
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

	public Double subTotal() {
		return valor * parcela;
	}

}
