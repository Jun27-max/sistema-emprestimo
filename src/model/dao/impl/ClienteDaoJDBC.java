package model.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import model.dao.ClienteDao;
import model.dao.ConnectionFactory;
import model.dao.DataAcessException;
import model.entities.Cliente;
import model.entities.Emprestimo;

public class ClienteDaoJDBC implements ClienteDao {

	private static ConnectionFactory connectionFactory = ConnectionFactory.getInstance();

	@Override
	public void insert(Cliente obj) {
		try (Connection conn = connectionFactory.getConnection()) {
			conn.setAutoCommit(false);

			try (PreparedStatement insert = conn.prepareStatement(
					"INSERT INTO cliente(nome, email, cpf, rg, endereco, renda, senha, valorEmprestimo, qtdParcela) VALUES (?, ?, ?, ?, ?, ?,?,?,?);");) {
				insert.setString(1, obj.getNome());
				insert.setString(2, obj.getEmail());
				insert.setString(3, obj.getCpf());
				insert.setString(4, obj.getRg());
				insert.setString(5, obj.getEndereço());
				insert.setDouble(6, obj.getRenda());
				insert.setString(7, obj.getSenha());

				insert.executeUpdate();

				conn.commit();

			} catch (Exception e) {
				conn.rollback();
				throw new DataAcessException("Problemas ao executar comando para inserir o cliente. ");
			}
		} catch (SQLException e) {
			throw new DataAcessException("Problemas na conexão ao inserir o cliente. ");
		}

	}

	@Override
	public void update(Cliente obj) {
		try (Connection conn = connectionFactory.getConnection()) {
			conn.setAutoCommit(false);

			try (PreparedStatement update = conn.prepareStatement(
					"UPDATE cliente SET nome = ?, email = ? , cpf = ?, rg = ?, endereco = ?, renda = ?, senha = \"1234\" WHERE Id = ?;");) {

				update.setString(1, obj.getNome());
				update.setString(2, obj.getEmail());
				update.setString(3, obj.getCpf());
				update.setString(4, obj.getRg());
				update.setString(5, obj.getEndereço());
				update.setDouble(6, obj.getRenda());
				update.setString(7, obj.getSenha());
				update.executeUpdate();

				conn.commit();

			} catch (Exception e) {
				conn.rollback();
				throw new DataAcessException("Problemas ao executar comando para modificar os dados.");
			}
		} catch (SQLException e) {
			throw new DataAcessException("Problemas na conexão.");
		}

	}

	@Override
	public void deleteById(Integer id) {
		try (Connection conn = connectionFactory.getConnection()) {
			conn.setAutoCommit(false);

			try (PreparedStatement delete = conn.prepareStatement("DELETE FROM cliente WHERE id = ? ;");) {

				delete.setInt(1, id);
				delete.executeUpdate();

				conn.commit();

			} catch (Exception e) {
				conn.rollback();
				throw new DataAcessException("Problemas ao executar comando para deletar o cliente. ");
			}
		} catch (SQLException e) {
			throw new DataAcessException("Problemas na conexão ao deletar o cliente. ");
		}

	}

	@Override
	public void insert(Emprestimo obj) {
		try (Connection conn = connectionFactory.getConnection()) {
			conn.setAutoCommit(false);

			try (PreparedStatement insert = conn.prepareStatement(
					"INSERT INTO emprestimo(dataPrimeiraParc,valorTotalEmprestimo, id_cliente) VALUES (?, ?, ?);");) {

				insert.setString(1, obj.getData());
				insert.setDouble(2, obj.getTotal());
				insert.setInt(3, obj.getIdCliente());

				insert.executeUpdate();

				conn.commit();

			} catch (Exception e) {
				conn.rollback();
				throw new DataAcessException("Problemas ao executar comando para inserir o empréstimo. ");
			}
		} catch (SQLException e) {
			throw new DataAcessException("Problemas na conexão ao inserir o empréstimo. ");
		}

	}

	@Override
	public void update(Emprestimo obj) {
		try (Connection conn = connectionFactory.getConnection()) {
			conn.setAutoCommit(false);

			try (PreparedStatement update = conn
					.prepareStatement("UPDATE emprestimo SET dataPrimeiraParc = ?, id_cliente = ? WHERE cod = ?;");) {

				update.setString(1, obj.getData());
				update.setInt(2, obj.getIdCliente());
				update.setInt(3, obj.getCod());
				update.executeUpdate();

				conn.commit();

			} catch (Exception e) {
				conn.rollback();
				throw new DataAcessException("Problemas ao executar comando para modificar a data do empréstimo.");
			}
		} catch (SQLException e) {
			throw new DataAcessException("Problemas na conexão ao alterar o empréstimo.");
		}
	}

	@Override
	public void deleteEmprestimo(Integer id) {
		try (Connection conn = connectionFactory.getConnection()) {
			conn.setAutoCommit(false);

			try (PreparedStatement delete = conn.prepareStatement("DELETE FROM emprestimo WHERE cod = ? ;");) {

				delete.setInt(1, id);
				delete.executeUpdate();

				conn.commit();

			} catch (Exception e) {
				conn.rollback();
				throw new DataAcessException("Problemas ao executar comando para deletar o cliente. ");
			}
		} catch (SQLException e) {
			throw new DataAcessException("Problemas na conexão ao deletar o cliente. ");
		}

	}

	private Cliente consultaCliente(ResultSet rs, Emprestimo emp) throws SQLException {
		Cliente obj = new Cliente();
		obj.setId(rs.getInt("id"));
		obj.setNome(rs.getString("nome"));
		obj.setEmail(rs.getString("email"));
		obj.setRenda(rs.getDouble("renda"));
		obj.setValor(rs.getDouble("valorEmprestimo"));
		obj.setParcela(rs.getInt("qtdParcela"));
		obj.setEmprestimo(emp);
		return obj;
	}

	private Emprestimo consultaEmprestimo(ResultSet rs) throws SQLException {
		Emprestimo emp = new Emprestimo();
		emp.setCod(rs.getInt("cod"));
		emp.setData(rs.getString("dataPrimeiraParc"));
		emp.setTotal(rs.getDouble("valorTotalEmprestimo"));
		emp.setIdCliente(rs.getInt("id_cliente"));
		return emp;
	}

	@Override
	public Cliente findById(Integer id) {
		try (Connection conn = connectionFactory.getConnection()) {
			conn.setAutoCommit(false);

			Cliente obj = null;
			Emprestimo emp = null;

			try (PreparedStatement ps = conn
					.prepareStatement("c.nome, e.dataPrimeiraParc, e.valorTotalEmprestimo FROM cliente c "
							+ "INNER JOIN emprestimo e ON c.id = e.id_cliente WHERE c.id =?;")) {
				ps.setInt(1, id);

				try (ResultSet rs = ps.executeQuery();) {
					if (rs.next()) {
						emp = consultaEmprestimo(rs);
						obj = consultaCliente(rs, emp);
						return obj;
					}
				}
			} catch (Exception e) {
				conn.rollback();
				throw new DataAcessException("Problemas ao executar comando para deletar o cliente. ");
			}
		} catch (SQLException e) {
			throw new DataAcessException("Problemas na conexão ao deletar o cliente. ");
		}

		return null;

	}

	@Override
	public List<Cliente> findAll() {
		try (Connection conn = connectionFactory.getConnection()) {
			conn.setAutoCommit(false);

			try (PreparedStatement ps = conn.prepareStatement(
					"SELECT c.nome, c.renda , e.dataPrimeiraParc , " + "e.valorTotalEmprestimo FROM cliente c "
							+ "INNER JOIN emprestimo e ON c.id = e.id_cliente order by c.nome;")) {

				ResultSet rs = ps.executeQuery();

				List<Cliente> listaClientes = new ArrayList<>();
				Map<Integer, Emprestimo> map = new HashMap<>();

				while (rs.next()) {

					Emprestimo emp = map.get(rs.getInt("id_cliente"));

					if (emp == null) {
						emp = consultaEmprestimo(rs);
						map.put(rs.getInt("id_cliente"), emp);
					}

					Cliente obj = consultaCliente(rs, emp);
					listaClientes.add(obj);
				}

				return listaClientes;

			} catch (Exception e) {
				conn.rollback();
				throw new DataAcessException("Problemas ao executar comando para deletar o cliente. ");
			}
		} catch (SQLException e) {
			throw new DataAcessException("Problemas na conexão ao deletar o cliente. ");
		}
	}

}
