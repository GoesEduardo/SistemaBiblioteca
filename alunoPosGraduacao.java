import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;
import java.util.ArrayList;

public class alunoPosGraduacao extends Usuario {
	private String nome;
	private String IDUsuario;
	private ArrayList<Emprestimo> Emprestimos;
	private ArrayList<Reserva> LivrosReservados;
	private StrategyEmprestimo EmprestimoAlunoPos;
	

	public alunoPosGraduacao(String iDUsuario, String nome) {
		super(iDUsuario, nome);
		LivrosReservados = super.getLivrosReservados(); 
		Emprestimos = super.getEmprestimos();
		super.setLivrosEmAberto(4);
		EmprestimoAlunoPos = new EmprestimoALuno();
        super.setDiasAtraso(4);
	}



	@Override
	public String emprestimo(Emprestimo emprestimo) {
		return EmprestimoAlunoPos.Emprestar(emprestimo);
	}



}
