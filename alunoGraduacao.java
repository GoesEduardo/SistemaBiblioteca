import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;
import java.util.ArrayList;

public class alunoGraduacao extends Usuario {
  //  private String nome;
  //  private String codigoID;
	private ArrayList<Reserva> LivrosReservados;
	private ArrayList<Emprestimo> Emprestimos;
	private StrategyEmprestimo EmprestimoAlunoGrad;

    
    
	public alunoGraduacao(String codigoID, String nome) {
		super(codigoID,nome);
		LivrosReservados = super.getLivrosReservados(); 
		Emprestimos = super.getEmprestimos();
		super.setLivrosEmAberto(3);
		EmprestimoAlunoGrad = new EmprestimoALuno();
        super.setDiasAtraso(3);
	}
	



	@Override
	public String emprestimo(Emprestimo emprestimo) {
		// TODO Auto-generated method stub
		        //houver a disponibilidade de algum exemplar do livro
				//o usuario não estiver devedor
				//forem obedecidas as regras especificas no que se refere a quantidade de emprestimos: 3 emprestimos
				//a quantidade de reservas existentes for menor ou igual de exemplares caso o usuario nao tenha feito reserva
				//a quantidade de reservas for maior maior ou igual a de exemplares, mas uma reversa é do usuario
				//o usuario nao tiver nenhum emprestimo em curso de um exemplar daquele livro
	    
		return EmprestimoAlunoGrad.Emprestar(emprestimo);
	}
}
	
	