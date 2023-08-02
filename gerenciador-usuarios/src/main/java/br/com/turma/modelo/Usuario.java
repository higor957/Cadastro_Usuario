package br.com.turma.modelo;

import java.util.Date;

public class Usuario {
	
	public Usuario() {}
	
	public Usuario(String nome,Date dataNascimento,String login, String senha) {
		this.nome = nome;
		this.dataNascimento = dataNascimento;
		this.login = login;
		this.senha = senha;
	}
	
	private Integer codigo;
	private String nome;
	private Date dataNascimento;
	private String login;
	private String senha;
	
	public Integer getCodigo() {
		return codigo;
	}
	public void setCodigo(Integer codigo) {
		this.codigo = codigo;
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public Date getDataNascimento() {
		return dataNascimento;
	}
	public void setDataNascimento(Date dataNascimento) {
		this.dataNascimento = dataNascimento;
	}
	public String getLogin() {
		return login;
	}
	public void setLogin(String login) {
		this.login = login;
	}
	public String getSenha() {
		return senha;
	}
	public void setSenha(String senha) {
		this.senha = senha;
	}

}
