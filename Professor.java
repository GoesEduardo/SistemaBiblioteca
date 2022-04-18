import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;
import java.util.ArrayList;

public class Professor extends Usuario implements Observer {
    //usuario tem lista de emprestimos e lista de livros reservados
	private String nome;
	private String IDUsuario;
	private ArrayList<Emprestimo>Emprestimos;
	private ArrayList<Reserva>LivrosReservados;
	private StrategyEmprestimo EmprestimoProfessor;
    private int diasAtraso;
    private int numNotificacoes;
	
	

	Professor(String iDUsuario, String nome){
		
		super(iDUsuario, nome);
		LivrosReservados = super.getLivrosReservados(); 
		Emprestimos = super.getEmprestimos();
		this.EmprestimoProfessor = new EmprestimoProfessor();
		super.setDiasAtraso(7);
		this.numNotificacoes = 0;
	}
	
	
	@Override
	public String emprestimo(Emprestimo emprestimo) {
		// TODO Auto-generated method stub
	    return EmprestimoProfessor.Emprestar(emprestimo);
		//return null;
	}


	
	

	@Override
	public void update() {
        this.numNotificacoes = this.numNotificacoes + 1;
	}

	@Override
	public void display() {
		System.out.printf("%s%s%s%n","O usuário foi notificado ", numNotificacoes, " vezes");
	}

	@Override
	public void addReserva(Reserva reserva) {
	LivrosReservados.add(reserva);
	}


	public int getNumNotificacoes() {
		return numNotificacoes;
	}


	public void setNumNotificacoes(int numNotificacoes) {
		this.numNotificacoes = numNotificacoes;
	}

	
	
}
