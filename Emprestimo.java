import java.time.LocalDateTime;

public class Emprestimo {
	
	//o título do livro - a data de emprestimo - o status (em curso ou finalizado) - a data de devoluçao
	
	//private String tituloLivro;
	private boolean statusEmp;
	public LocalDateTime dataEmprestimo, dataDevolucao, dataDevolucaoPrevista;
	private String codigoLivro;
	private Exemplar exemplar;
	private Usuario usuario;
	private Livro livro;
	

	public Emprestimo(boolean statusEmp, LocalDateTime dataEmprestimo, LocalDateTime dataDevolucaoPrevista, Usuario usuario, Livro livro, Exemplar exemplar) {
		this.statusEmp = statusEmp;
		this.dataEmprestimo = dataEmprestimo;
		this.dataDevolucaoPrevista = dataDevolucaoPrevista;
		this.exemplar = exemplar;
		this.usuario = usuario;
		this.livro = livro;
	}
	
	public LocalDateTime getDataDevolucaoPrevista() {
		return dataDevolucaoPrevista;
	}

	public void setDataDevolucaoPrevista(LocalDateTime dataDevolucaoPrevista) {
		this.dataDevolucaoPrevista = dataDevolucaoPrevista;
	}

	public boolean isStatusEmp() {
		return statusEmp;
	}
	public void setStatusEmp(boolean statusEmp) {
		this.statusEmp = statusEmp;
	}
	public String getTituloLivro() {
		return livro.getTitulo();
	}
	
	public LocalDateTime getDataEmprestimo() {
		return dataEmprestimo;
	}
	public void setDataEmprestimo(LocalDateTime dataEmprestimo) {
		this.dataEmprestimo = dataEmprestimo;
	}
	public LocalDateTime getDataDevolucao() {
		return dataDevolucao;
	}
	public void setDataDevolucao(LocalDateTime dataDevolucao) {
		this.dataDevolucao = dataDevolucao;
	}
	public String getCodigoLivro() {
		return codigoLivro;
	}
	public void setCodigoLivro(String codigoLivro) {
		this.codigoLivro = codigoLivro;
	}
	public Exemplar getExemplar() {
		return exemplar;
	}
	public void setExemplar(Exemplar exemplar) {
		this.exemplar = exemplar;
	}
	public Usuario getUsuario() {
		return usuario;
	}
	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}
	
	public Livro getLivro() {
		return livro;
	}

	public void setLivro(Livro livro) {
		this.livro = livro;
	}

	
	
}
