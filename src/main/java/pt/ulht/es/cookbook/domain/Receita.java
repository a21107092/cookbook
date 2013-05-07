package pt.ulht.es.cookbook.domain;

import java.text.SimpleDateFormat;
import java.util.Comparator;
import org.joda.time.DateTime;

public class Receita {

	private String id, titulo, problema, solucao, autor, tags;
	private DateTime dataCriacao;

	public Receita(String titulo, String problema, String solucao, String autor, String tags) {
		this.titulo = titulo;
		this.problema = problema;
		this.solucao = solucao;
		this.autor = autor;
		this.tags = tags;
		this.dataCriacao = new DateTime();
	}

	public String getTitulo() {
		return titulo;
	}

	public String getProblema() {
		return problema;
	}

	 public String getSolucao() {
		return solucao;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getAutor() {
		return autor;
	}

	public String getTags() {
		return tags;
	}

	public DateTime getDataCriacao() {
		return dataCriacao;
	}

	public String getDataCriacaoFormatada() {
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
		return sdf.format( dataCriacao.toDate() );
	}

	public static class CreationDateComparator implements Comparator<Receita> {

		public int compare(Receita r1, Receita r2) {
			return r1.titulo.compareToIgnoreCase(r2.titulo);
		}

	}
}