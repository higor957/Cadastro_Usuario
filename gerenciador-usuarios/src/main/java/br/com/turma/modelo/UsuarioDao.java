package br.com.turma.modelo;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import br.com.turma.jdbc.Conexao;

public class UsuarioDao {
	
	public void cadastrar(Usuario usuario) {
		
		Connection con = Conexao.obterConexao();
		
		String sql = "INSERT INTO Usuario(nome,data_nascimento,login,senha) VALUES(?,?,?,?)";
		
		try {
			PreparedStatement preparador = con.prepareStatement(sql);
			preparador.setString(1, usuario.getNome());
			preparador.setDate(2, new Date(usuario.getDataNascimento().getTime()));
			preparador.setString(3, usuario.getLogin());
			preparador.setString(4, usuario.getSenha());
			
			preparador.execute();
			con.close();
			
			System.out.println("Usuário Cadastrado com Sucesso!!!");
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
	}

	
	public ArrayList<Usuario> mostrarTodos(){
		
		Connection con = Conexao.obterConexao();
		ArrayList<Usuario> usuarios = new ArrayList<>();
		String sql = "SELECT * FROM Usuario";
		
		try {
			PreparedStatement preparador = con.prepareStatement(sql);
			ResultSet resultado = preparador.executeQuery();
			
			while(resultado.next()) {
				Usuario usuario = new Usuario();
				usuario.setCodigo(resultado.getInt("codigo"));
				usuario.setNome(resultado.getString("nome"));
				usuario.setDataNascimento(new java.util.Date(resultado.getDate("data_nascimento").getTime()));
				usuario.setLogin(resultado.getString("login"));
				usuario.setSenha(resultado.getString("senha"));
				
				usuarios.add(usuario);
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return usuarios;
	}
	
	
	public void remover(Integer codigo) {
	
		Connection con = Conexao.obterConexao();
		String sql = "DELETE FROM Usuario WHERE codigo = ?";
		
		try {
			PreparedStatement preparador = con.prepareStatement(sql);
			preparador.setInt(1, codigo);
			
			preparador.execute();
			preparador.close();
			
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
	}
	
	
	public Usuario buscarPorCodigo(Integer codigo) {
		
		Connection con = Conexao.obterConexao();
		Usuario usuario = null;
		String sql = "SELECT * FROM Usuario WHERE codigo = ?";
		
		try {
			PreparedStatement preparador = con.prepareStatement(sql);
			preparador.setInt(1, codigo);
			
			ResultSet resultado = preparador.executeQuery();
			
			
			if(resultado.next()) {
				usuario = new Usuario();
				usuario.setCodigo(resultado.getInt("codigo"));
				usuario.setNome(resultado.getString("nome"));
				usuario.setDataNascimento(new java.util.Date(resultado.getDate("data_nascimento").getTime()));
				usuario.setLogin(resultado.getString("login"));
				usuario.setSenha(resultado.getString("senha"));
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return usuario;
		
	}
	
	
	public void alterar(Usuario usuario) {
		
		Connection con = Conexao.obterConexao();
		
		String sql = "UPDATE Usuario SET nome=?,data_nascimento=?,login=?,senha=? WHERE codigo=?";
		
		try {
			PreparedStatement preparador = con.prepareStatement(sql);
			preparador.setString(1, usuario.getNome());
			preparador.setDate(2, new Date(usuario.getDataNascimento().getTime()));
			preparador.setString(3, usuario.getLogin());
			preparador.setString(4, usuario.getSenha());
			preparador.setInt(5, usuario.getCodigo());
			
			preparador.execute();
			preparador.close();
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
	}
	
	
}















