package br.curso.jsp.model;

import java.io.Serializable;
import java.util.Objects;

@SuppressWarnings("unused")
public class Livro implements Serializable {

	private static final long serialVersionUID = -5025346886502074460L;
	private long idLivro;
	private long codigoLivro;
	private String tituloLivro;
	private String subTituloLivro;
	private String descricaoLivro;
	private boolean livrosFavoritos;
	private Integer quantidadePaginasLivro;

	private FileDocumeto anexoLivro;
	private FileDocumeto capaLivro;
	private Usuario idResponssavelDoCadastroDoLivro;
	private AutorLivro autorLivro;
	
	
	
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
	public String getTituloLivro() {
		return tituloLivro;
	}
	public void setTituloLivro(String tituloLivro) {
		this.tituloLivro = tituloLivro;
	}
	public String getSubTituloLivro() {
		return subTituloLivro;
	}
	public void setSubTituloLivro(String subTituloLivro) {
		this.subTituloLivro = subTituloLivro;
	}
	public String getDescricaoLivro() {
		return descricaoLivro;
	}
	public void setDescricaoLivro(String descricaoLivro) {
		this.descricaoLivro = descricaoLivro;
	}
	public Integer getQuantidadePaginasLivro() {
		return quantidadePaginasLivro;
	}
	public void setQuantidadePaginasLivro(Integer quantidadePaginasLivro) {
		this.quantidadePaginasLivro = quantidadePaginasLivro;
	}
	public FileDocumeto getAnexoLivro() {
		return anexoLivro;
	}
	public void setAnexoLivro(FileDocumeto anexoLivro) {
		this.anexoLivro = anexoLivro;
	}
	public FileDocumeto getCapaLivro() {
		return capaLivro;
	}
	public void setCapaLivro(FileDocumeto capaLivro) {
		this.capaLivro = capaLivro;
	}
	public Usuario getIdResponssavelDoCadastroDoLivro() {
		return idResponssavelDoCadastroDoLivro;
	}
	public void setIdResponssavelDoCadastroDoLivro(Usuario idResponssavelDoCadastroDoLivro) {
		this.idResponssavelDoCadastroDoLivro = idResponssavelDoCadastroDoLivro;
	}
	public AutorLivro getAutorLivro() {
		return autorLivro;
	}
	public void setAutorLivro(AutorLivro autorLivro) {
		this.autorLivro = autorLivro;
	}
	@Override
	public int hashCode() {
		return Objects.hash(anexoLivro, autorLivro, capaLivro, codigoLivro, descricaoLivro, idLivro,
				idResponssavelDoCadastroDoLivro, livrosFavoritos, quantidadePaginasLivro, subTituloLivro, tituloLivro);
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
		return Objects.equals(anexoLivro, other.anexoLivro) && Objects.equals(autorLivro, other.autorLivro)
				&& Objects.equals(capaLivro, other.capaLivro) && codigoLivro == other.codigoLivro
				&& Objects.equals(descricaoLivro, other.descricaoLivro) && idLivro == other.idLivro
				&& Objects.equals(idResponssavelDoCadastroDoLivro, other.idResponssavelDoCadastroDoLivro)
				&& livrosFavoritos == other.livrosFavoritos
				&& Objects.equals(quantidadePaginasLivro, other.quantidadePaginasLivro)
				&& Objects.equals(subTituloLivro, other.subTituloLivro)
				&& Objects.equals(tituloLivro, other.tituloLivro);
	}

	
}
