import java.time.LocalDateTime;

public class Reserva {
	//o título do livro reservado - a data de solicitação da reserva.
	
	private Livro Livro;
	private Usuario Usuario;
	private LocalDateTime dataSolicitacao;

	
	Reserva(Livro livro, Usuario Usuario, LocalDateTime dataSolicitacao){
		this.Livro = livro;
		this.Usuario = Usuario;
		this.dataSolicitacao = dataSolicitacao;
	}
	
	public Livro getLivro() {
		return Livro;
	}

	public void setLivro(Livro livro) {
		Livro = livro;
	}

	public Usuario getUsuario() {
		return Usuario;
	}

	public void setUsuario(Usuario usuario) {
		this.Usuario = usuario;
	}
	
	
	public String getTituloLivro() {
		return Livro.getTitulo();
	}
	
	public String getNomeUsuario() {
		return Usuario.getNome();
	}
	
	public LocalDateTime getDataSolicitacao() {
		return dataSolicitacao;
	}
	public void setDataSolicitacao(LocalDateTime dataSolicitacao) {
		this.dataSolicitacao = dataSolicitacao;
	}
	
	
}
