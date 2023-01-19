package br.curso.jsp.model;

import java.io.Serializable;
import java.util.Objects;

@SuppressWarnings("unused")
public class Livro implements Serializable {
	
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -5025346886502074460L;
	private long idLivro;
	private long codigoLivro;
	private String nomeLivro;
	private String descricaoLivro;
	private String pdfLivro;
	private String fotoLivro;
	private Usuario idResponssavelDoCadastroDoLivro;
	private String  categoriaLivro;
	
	
	
	@Override
	public String toString() {
		return "Livro [idLivro=" + idLivro + ", codigoLivro=" + codigoLivro + ", nomeLivro=" + nomeLivro
				+ ", descricaoLivro=" + descricaoLivro + ", pdfLivro=" + pdfLivro + ", fotoLivro=" + fotoLivro
				+ ", idResponssavelDoCadastroDoLivro=" + idResponssavelDoCadastroDoLivro + ", categoriaLivro="
				+ categoriaLivro + "]";
	}
	@Override
	public int hashCode() {
		return Objects.hash(categoriaLivro, codigoLivro, descricaoLivro, fotoLivro, idLivro,
				idResponssavelDoCadastroDoLivro, nomeLivro, pdfLivro);
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Livro other = (Livro) obj;
		return Objects.equals(categoriaLivro, other.categoriaLivro) && codigoLivro == other.codigoLivro
				&& Objects.equals(descricaoLivro, other.descricaoLivro) && Objects.equals(fotoLivro, other.fotoLivro)
				&& idLivro == other.idLivro
				&& Objects.equals(idResponssavelDoCadastroDoLivro, other.idResponssavelDoCadastroDoLivro)
				&& Objects.equals(nomeLivro, other.nomeLivro) && Objects.equals(pdfLivro, other.pdfLivro);
	}
	public long getIdLivro() {
		return idLivro;
	}
	public void setIdLivro(long idLivro) {
		this.idLivro = idLivro;
	}
	public long getCodigoLivro() {
		return codigoLivro;
	}
	public void setCodigoLivro(long codigoLivro) {
		this.codigoLivro = codigoLivro;
	}
	public String getNomeLivro() {
		return nomeLivro;
	}
	public void setNomeLivro(String nomeLivro) {
		this.nomeLivro = nomeLivro;
	}
	public String getDescricaoLivro() {
		return descricaoLivro;
	}
	public void setDescricaoLivro(String descricaoLivro) {
		this.descricaoLivro = descricaoLivro;
	}
	public String getPdfLivro() {
		return pdfLivro;
	}
	public void setPdfLivro(String pdfLivro) {
		this.pdfLivro = pdfLivro;
	}
	public String getFotoLivro() {
		return fotoLivro;
	}
	public void setFotoLivro(String fotoLivro) {
		this.fotoLivro = fotoLivro;
	}
	public Usuario getIdResponssavelDoCadastroDoLivro() {
		return idResponssavelDoCadastroDoLivro;
	}
	public void setIdResponssavelDoCadastroDoLivro(Usuario idResponssavelDoCadastroDoLivro) {
		this.idResponssavelDoCadastroDoLivro = idResponssavelDoCadastroDoLivro;
	}
	public String getCategoriaLivro() {
		return categoriaLivro;
	}
	public void setCategoriaLivro(String categoriaLivro) {
		this.categoriaLivro = categoriaLivro;
	}
	
	
	
	

}
