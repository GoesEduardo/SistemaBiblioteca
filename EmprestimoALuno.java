
public class EmprestimoALuno implements StrategyEmprestimo {

	@Override
	public String Emprestar(Emprestimo emprestimo) {
		Usuario usuario = emprestimo.getUsuario();
		Livro livro = emprestimo.getLivro();
		
	        if(emprestimo.getUsuario().isEmprestimoAtraso()) {
	        	return ("Falha! Há empréstimos em atraso.");
	        }
	        
	        else if(emprestimo.getUsuario().qtdeEmprestimoAberto() >= emprestimo.getUsuario().getLivrosEmAberto()) {
	        	//System.out.printf("%s%s%n","qtde de reservas",emprestimo.getUsuario().qtdeEmprestimoAberto());
				//	System.out.printf("%s%s%n","qtde de exemplares disponíveis",emprestimo.getUsuario().getLivrosEmAberto());
	        	
	        	return ("Falha! Usuário atingiu limite de empréstimos em curso");
	        } 
	        
	        else if(emprestimo.getLivro().getReservas().size()>=emprestimo.getLivro().qtdeExemplaresDisponiveis()&&emprestimo.getUsuario().procuraReservas(emprestimo.getLivro())==-1) {

	        	return ("Falha! o número de reservas é superior ao de exemplares.");
	        }
	        
	        
	        else if(emprestimo.getUsuario().procuraEmprestimo(emprestimo.getLivro())!=-1){
	       // 	System.out.printf("%s%s%n","qtde de reservas",emprestimo.getUsuario().qtdeEmprestimoAberto());
			//	System.out.printf("%s%s%n","qtde de exemplares disponíveis",emprestimo.getUsuario().getLivrosEmAberto());
	        		return ("Falha! o usuário possui um empréstimo do livro em curso");
	        }
	        
	        else {
	        	
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


