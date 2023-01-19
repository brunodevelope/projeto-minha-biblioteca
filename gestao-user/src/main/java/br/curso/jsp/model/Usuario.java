
package br.curso.jsp.model;

import java.io.Serializable;
import java.sql.Date;
import java.util.Objects;

public class Usuario implements Serializable {

	private static final long serialVersionUID = 441415674530679206L;

	private Long id;
	private String nome;
	private String login;
	private String senha;
	private String email;
	private String foto;
	private long admin;
	private boolean administrador;
	private Date dataNascimento;

	

	
	
	
	
	

	@Override
	public String toString() {
		return "Usuario [id=" + id + ", nome=" + nome + ", login=" + login + ", senha=" + senha + ", email=" + email
				+ ", foto=" + foto + ", admin=" + admin + ", dataNascimento=" + dataNascimento + "]";
	}




	@Override
	public int hashCode() {
		return Objects.hash(admin, dataNascimento, email, foto, id, login, nome, senha);
	}




	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Usuario other = (Usuario) obj;
		return admin == other.admin && Objects.equals(dataNascimento, other.dataNascimento)
				&& Objects.equals(email, other.email) && Objects.equals(foto, other.foto)
				&& Objects.equals(id, other.id) && Objects.equals(login, other.login)
				&& Objects.equals(nome, other.nome) && Objects.equals(senha, other.senha);
	}




	public Long getId() {
		return id;
	}




	public void setId(Long id) {
		this.id = id;
	}




	public String getNome() {
		return nome;
	}




	public void setNome(String nome) {
		this.nome = nome;
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




	public String getEmail() {
		return email;
	}




	public void setEmail(String email) {
		this.email = email;
	}




	public String getFoto() {
		return foto;
	}




	public void setFoto(String foto) {
		this.foto = foto;
	}




	public long getAdmin() {
		return admin;
	}




	public void setAdmin(long admin) {
		this.admin = admin;
	}




	public boolean isAdministrador() {
		return administrador;
	}




	public void setAdministrador(boolean administrador) {
		this.administrador = administrador;
	}




	public Date getDataNascimento() {
		return dataNascimento;
	}




	public void setDataNascimento(Date dataNascimento) {
		this.dataNascimento = dataNascimento;
	}




	public boolean novoUsuario() {
		if (this.id == null) {
			return true;
		} else if (this.id > 0) {
			return false;
		}
		return false;

	}

}