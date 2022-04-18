import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;
import java.util.ArrayList;

public abstract class Usuario {
	
	private String nome;
	private String IDUsuario;
	private int diasAtraso, livrosEmAberto;
	private ArrayList<Reserva> LivrosReservados;
	private ArrayList<Emprestimo> Emprestimos;
    
	
	Usuario (String iDUsuario, String nome){
		this.nome = nome;
		this.IDUsuario = iDUsuario;
		Emprestimos = new ArrayList<Emprestimo>();
		LivrosReservados = new ArrayList<Reserva>();
	}
	
	public  abstract String emprestimo(Emprestimo emprestimo);

	
	public int getDiasAtraso() {
		return diasAtraso;
	}

	public void setDiasAtraso(int diasAtraso) {
		this.diasAtraso = diasAtraso;
	}

	public String getNome() {
		// TODO Auto-generated method stub
		return nome;
	}

	
	public void setNome(String nome) {
		// TODO Auto-generated method stub
        this.nome = nome;
	}
	
	public String getIDUsuario() {
		// TODO Auto-generated method stub
		return IDUsuario;
	}

	
	public void setIDUsuario(String IDUsuario) {
		this.IDUsuario = IDUsuario;

	}

	public ArrayList<Reserva> getLivrosReservados() {
		return LivrosReservados;
	}

	public void setLivrosReservados(ArrayList<Reserva> livrosReservados) {
		LivrosReservados = livrosReservados;
	}

	
	public ArrayList<Emprestimo> getEmprestimos() {
		return Emprestimos;
	}

	public void setEmprestimos(ArrayList<Emprestimo> emprestimos) {
		Emprestimos = emprestimos;
	}
	
	
	public ArrayList<Emprestimo> addEmprestimos(Emprestimo emprestimo){
		Emprestimos.add(emprestimo);
		return Emprestimos;
	}
	
	public void addReserva(Reserva reserva) {
		LivrosReservados.add(reserva);
	}
		
	
	public boolean isEmprestimoAtraso() {
		int i = Emprestimos.size() - 1;
		boolean resultado = false;
		if(Emprestimos.size()!=0) {
			//System.out.printf("%s%s%n","tamanho lista de emprestunos", Emprestimos.size());
			//System.out.printf("%s%s%n","dias atraso", diasAtraso);
			
			  while(i>0&&ChronoUnit.DAYS.between(Emprestimos.get(i).getDataEmprestimo(),LocalDateTime.now())<=diasAtraso) {
			//	System.out.println("entrou aqui");
			//	System.out.println(i);

				i--;
				// Emprestimos.get(i);
				}
				//System.out.println(i);

			long  j = ChronoUnit.DAYS.between(Emprestimos.get(i).getDataEmprestimo(),LocalDateTime.now());
			 // System.out.println(j);
		
        if(j<=diasAtraso||!(Emprestimos.get(i).isStatusEmp())) {
        resultado = false;
		  //System.out.println("não há emprestimo atrasado");

        } 
        
        else {
        	//System.out.println("emprestimo atrasado");

        	resultado = true;
		}
	 }
		//  System.out.println("retornou um resultado");

		return resultado;
}
	
	
	
	
	
	public int procuraEmprestimo(Livro livro){
		int j = -1;
		for(int i=0;i<Emprestimos.size();i++) {
			if((Emprestimos.get(i).getLivro().getcodigoLivro().equals(livro.getcodigoLivro()))&&(Emprestimos.get(i).isStatusEmp()==true))
		     j = i;
			
			//System.out.printf("%s%s%n","codigo livro emprestimo",Emprestimos.get(i).getLivro().getcodigoLivro());
		  // 	System.out.printf("%s%s%n","codigo do livro",livro.getcodigoLivro());
		}
		    
		return j;
	}
	
	public int procuraReservas(Livro livro){
		int j = -1;
		for(int i=0;i<LivrosReservados.size();i++) {
			if((LivrosReservados.get(i).getLivro().codigoLivro==livro.getcodigoLivro()));
		     j = i;
		}   
		return j;
	}
	
	public int qtdeEmprestimoAberto(){
		int j = 0;
		for(int i=0;i<Emprestimos.size();i++) {
			if((Emprestimos.get(i).isStatusEmp()!=true));
		     j++;
		}    
		return j;
	}
	
	

	public int getLivrosEmAberto() {
		return livrosEmAberto;
	}

	public void setLivrosEmAberto(int livrosEmAberto) {
		this.livrosEmAberto = livrosEmAberto;
	}
	

	

}