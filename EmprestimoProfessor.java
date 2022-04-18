
public class EmprestimoProfessor implements StrategyEmprestimo {

	
	@Override
	public String Emprestar(Emprestimo emprestimo) {
		// TODO Auto-generated method stub //podemos passar atributos ou o proprio objeto professor 
		//houver a disponibilidade do livro
		//usuario nao estiver devedor de um livro em atraso
		//if(livro.ItemDisponivel());
		Livro livro = emprestimo.getLivro();
		Usuario usuario = emprestimo.getUsuario();
		
        if(usuario.isEmprestimoAtraso()) {
        	return ("Falha! Há empréstimos em atraso.");
        }
        
        else {
        	//System.out.println("vai realizar empréstimo");

        	livro.ItemDisponivel().setStatusExemplar(false);
        	int i = usuario.procuraReservas(livro);
            if(i>=0)
        	usuario.getLivrosReservados().remove(usuario.getLivrosReservados().remove(i));
            usuario.getEmprestimos().add(emprestimo); //add emprestimo na lista
            livro.getEmprestimos().add(emprestimo);
        	return ("O emprestimo foi realizado com sucesso!");
        }
	}

}
