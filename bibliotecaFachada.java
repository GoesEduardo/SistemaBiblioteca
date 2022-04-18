import java.time.LocalDateTime;
import java.util.ArrayList;

public class bibliotecaFachada {

	private static bibliotecaFachada instancia;
	
	private bibliotecaFachada() {}
	
	public static bibliotecaFachada obterInstancia() {
		if(instancia == null) {
	      instancia = new bibliotecaFachada();
		}
		return instancia;
	}
	
	
	public Usuario getUsuario(String codigo){
		int i = 0;
		 ArrayList<Usuario>ListaUsuarios = DadosBiblioteca.obterInstancia().getListaUsuarios();
		 
		 //for(i=0;i<ListaUsuarios.size();i++) {
		 //	if(ListaUsuarios.get(i).getIDUsuario()==codigo);
		     
		 //}
		//	System.out.printf("%s%s%n", "tamanho da lista ", ListaUsuarios.size());

		
		while(!(ListaUsuarios.get(i).getIDUsuario().equals(codigo))&&(i<ListaUsuarios.size()-1)) {
			//System.out.printf("%s%s%n", "nome retornado ", ListaUsuarios.get(i).getNome());
			//System.out.printf("%s%s%n", "codigo retornado ", ListaUsuarios.get(i).getIDUsuario());
	         i++;
		}
		
		//System.out.printf("%s%s%n", "i retornado", i);
        return ListaUsuarios.get(i);
        
		
	}
	

	public Livro getLivro(String codigo){
		
		//latualizaDados();
		
		int i = 0;
		 ArrayList<Livro>ListaLivros = DadosBiblioteca.obterInstancia().getListaLivros();
		 
		 //for(i=0;i<ListaUsuarios.size();i++) {
		 //	if(ListaUsuarios.get(i).getIDUsuario()==codigo);
		     
		 //}
		
		while(!(ListaLivros.get(i).getcodigoLivro().equals(codigo))&&(i<ListaLivros.size()-1)) {
	         i++;
		}
		
        return ListaLivros.get(i);
		
	}
	
	
	public Exemplar getExemplar(String codigo){
		int i = 0;
		 ArrayList<Exemplar>ListaExemplares = DadosBiblioteca.obterInstancia().getListaExemplares();
		 
		 //for(i=0;i<ListaUsuarios.size();i++) {
		 //	if(ListaUsuarios.get(i).getIDUsuario()==codigo);
		     
		 //}
		
		while(!(ListaExemplares.get(i).getCodigoExemplar().equals(codigo))&&(i<ListaExemplares.size()-1)) {
	         i++;
		}
		
        return ListaExemplares.get(i);
		
	}
	
	
	
	
	public void realizarEmprestimo(String cmd, String cod1, String cod2) {
		//parâmetros: emp - codigo usuario - codigo do livro
		//excluir reserva se tiver feito e emprestimo efetivado
		// exibir mensagem de sucesso ou insucesso, mencionando nome de usuário, título do livro, se for 
		//uma mensagem de insucesso, relatar o motivo do insucesso: livro indispnível
		  Usuario usuario = getUsuario(cod1);
		  Livro livro = getLivro(cod2);
		  
		//  System.out.println(livro.getTitulo());
          if(livro.ItemDisponivel()!=null) {
    	//	  System.out.println("retornou elemento nao nulo");
    		 Exemplar exemplar = livro.ItemDisponivel();
    	
              
		  Emprestimo emprestimo = new Emprestimo(true, LocalDateTime.now(), LocalDateTime.now().plusDays(usuario.getDiasAtraso()), usuario, livro, exemplar);
		 
		//   System.out.println(emprestimo.getLivro().getTitulo());
		  String mensagem = usuario.emprestimo(emprestimo);
		  System.out.printf(mensagem);
          }
          else{
              System.out.printf("FALHA! Não há exemplares disponíveis para este livro.");

          }
		  
		  
          
	}
	
   public void realizarDevolucao(String cmd, String cod1, String cod2) {  //feito
		//parâmetros: dev - codigo de identificacao do usuario - codigo de identifacao do livro
	   //mensagem de sucesso ou insucesso da devolução, que mencione o nome do usuário e o título
	   //a mensagem de insucesso ocorre quando não houver emprestimo em aberto daquele livro para aquele usuário
	   //percorre a lista de emprestimos, se não achar: retorna falha. se achar, muda o status do emprestimo pra finalizado, muda o status do exemplar
	   //para "disponível" na lista de exemplares do livro.
	   
	   //metodo pra procurar o livro na lista de livros atraves do código
	   //método pra procurar o usuário em uma lista de usuarios através do código
	   
	  Usuario usuario = getUsuario(cod1);
	  Livro livro = getLivro(cod2);
	//  Exemplar exemplar = getExemplar("100");
	  
	  int i = usuario.procuraEmprestimo(livro);        //procura o emprestimo passando o codigo do livro
      

	  
	   if(i<0)                                                      //se não achou
	    System.out.printf("%s%s%s%s%n","FALHA! Não existe empréstimo em aberto do livro ",livro.getTitulo()," para o usuário ", usuario.getNome());
	  else {                                                       //se achou
	  	  usuario.getEmprestimos().get(i).setStatusEmp(false);//define o status do emprestimo na lista de emprestimos do usuario como finalizado
	  	  usuario.getEmprestimos().get(i).setDataDevolucao(LocalDateTime.now());   //passa a data da devoluçao
	  	 String j = usuario.getEmprestimos().get(i).getExemplar().getCodigoExemplar(); //pega o código do exemplar
	  	 getExemplar(j).setStatusExemplar(true); //passa o código do exemplr e exemplar passa a ficar disponível
	  	 livro.getEmprestimos().remove(usuario.getEmprestimos().get(i));     
	  	System.out.println("O livro foi devolvido com sucesso!");
	      }
	
	  
	}
   
   
   

   public void realizarConsultaLivro(String cmd, String cod1, String cod2) { //feito
	//parâmetros: liv - código do livro
	//apresentar: título, 
	   //apresntar quantidade de reservas para aquele livro, se diferente de 0: apresentar também o nome dos usuários que fizeram cada reserva
	   //colocar um 
	   //apresentar: p/ cada exemplar seu código, seu status,  e em caso de emprestado, o nome do usuário, a data de emprestimo e a prevista de devolução

	   
	   Livro livro = getLivro(cod1);
      
	  System.out.printf( "%s%s%n","Título do Livro: ", livro.getTitulo());

       
       if(livro.getReservas().size()==0)
		   System.out.println("O livro não apresenta reservas");
       else {
		   System.out.printf("%s%s%s%n","Há ",livro.getReservas().size(), " reservas para este livro");
		   
		   System.out.printf("Usuários que reservaram: ");

    	   for(int i=0;i<livro.getReservas().size();i++) {
    		   System.out.println(livro.getReservas().get(i).getNomeUsuario());
    	   }
       }
    	   
	   System.out.println("Exemplares:");

    	   for(int i=0;i<livro.getExemplares().size();i++) {
    		 Exemplar exemplar =  livro.getExemplares().get(i);
    		  System.out.printf("%s%s%n","código do exemplar: ",exemplar.getCodigoExemplar());
    		  if(exemplar.isStatusExemplar()) {
        		  System.out.println( "Status: Disponível");
    		  }
    		  else
        		  System.out.println( "Status: Indisponível");
    	   }

 		  System.out.printf("%s%s%n", "Empréstimos ", livro.getEmprestimos().size());

    	   for(int i=0;i<livro.getEmprestimos().size();i++) {
    		 Emprestimo emprestimo =  livro.getEmprestimos().get(i);
    		      System.out.printf("%s%s%n", "código exemplar: ",emprestimo.getExemplar().getCodigoExemplar());
        		  System.out.printf("Status: Indisponível ");
        		  System.out.printf("%s%s%n","Usuário: ", emprestimo.getUsuario().getNome());
        		  System.out.printf("%s%s%n", "Data de empréstimo: ", emprestimo.getDataEmprestimo());
        		  if(emprestimo.isStatusEmp())
                  System.out.printf("%s%s%n", "Data prevista de devolução: ", emprestimo.getDataDevolucaoPrevista());
    		  }
    		  
    		  
    	   }
    	   
       
   
   
   public void realizarConsultaUsuario(String cmd, String cod1, String cod2) { //feito
	   //parâmetros: usu - codigo do usuario
	   //apresentar a lista de todos os seus emprestimos recorrentes e passados, assim como de suas reservas
	   //a listagem de cada emprestimo deverá apresentar: o título do livro - a data de emprestimo - o status (em curso ou finalizado) - a data de devoluçao
	   //a listagem de reservas deverá apresentar: o título do livro reservado - a data de solicitação da reserva.
	   Usuario usuario = getUsuario(cod1);
	   
	   System.out.printf("%s%s%n","Nome do Usuário: ",usuario.getNome());
	   
   	  System.out.printf( "%s%s%n","Empréstimos do usuário: ",usuario.getEmprestimos().size());
	   for(int i=0;i<usuario.getEmprestimos().size();i++) {
  		Emprestimo emprestimo =  usuario.getEmprestimos().get(i);
  		  System.out.printf("%s%s%n", "Título do Livro: ",emprestimo.getTituloLivro());
  		  System.out.printf("%s%s%n","Data de empréstimo: ", emprestimo.getDataEmprestimo() );
  		if(emprestimo.isStatusEmp()) {
    	  System.out.println( "Status: Em curso");
    	  System.out.printf("%s%s%n", "Data prevista de Devolução: ", emprestimo.getDataDevolucaoPrevista());
  		}
  		else {
      	  System.out.println( "Status: Finalizado");
		  System.out.printf("%s%s%n", "Data de Devolução: ", emprestimo.getDataDevolucao());
  		}
	   }
	   
	   System.out.printf( "%s%s%n","Reservas do usuário: ",usuario.getLivrosReservados().size());
	   for(int i=0;i<usuario.getLivrosReservados().size();i++) {
	  		Reserva reserva =  usuario.getLivrosReservados().get(i);
	  		  System.out.printf("%s%s%n", "Título do Livro: ",reserva.getTituloLivro());
	  		  System.out.printf("%s%s%n", "Data de solicitação: ", reserva.getDataSolicitacao() );
	   }
	   
	   
   }
	
   public void realizarReserva(String cmd, String cod1, String cod2) { //feito
	   //parâmetros: res - codigo de identificação do usuario - código de identificaçao do livro
	   //será permitida apenas a reserva de 3 livros por usuário
	   // exibir mensagem de sucesso ou insucesso, mencionando nome de usuário, título do livro, a mensagem de insucesso
	   //deve dizer o motivo
	   Livro livro = getLivro(cod2);
	   Usuario usuario = getUsuario(cod1);
	   usuario.getLivrosReservados().size();
	   LocalDateTime data = LocalDateTime.now();
	 
	   if(usuario.getLivrosReservados().size()>=3) {
		   System.out.printf("%s%s%s%s%s","FALHA! O usuário: ", usuario.getNome(), " não pode reservar o livro: ", livro.getTitulo(),", pois o usuário atingiu o número limite de reservas");
	   }
	   
	   else if(usuario.procuraReservas(livro)>=0){
		   System.out.printf("%s%s%s%s%s","FALHA! O usuário: ", usuario.getNome(), " não pode reservar o livro: ", livro.getTitulo(),", pois o usuário já possui uma reserva desse livro");
	   }
	   
	   else{
		   Reserva novaReserva = new Reserva(livro, usuario, data );
		   livro.addReserva(novaReserva);
		   usuario.addReserva(novaReserva);
		   System.out.println("Realizando reserva!");
		//   System.out.println(usuario.getLivrosReservados().size());
		   System.out.printf("%s%s%n","titulo do livro: ", novaReserva.getLivro().getTitulo());
		   System.out.printf("%s%s%n","nome do usuario: ", novaReserva.getUsuario().getNome());
		//   System.out.printf("%s%s%n","data de solicitação: ", novaReserva.getDataSolicitacao());


	   }
	   
   }
   
   public void RegistrarObservador(String obs, String codigoUsu, String codLivro) {                //feito
	   //parâmetros: obs - código do usuário - código do livro
	   //registrar professor para receber notificação quando um livro tiver mais de duas reservas simultâneas
      
       Livro livro = getLivro(codLivro);
	//   System.out.printf(livro.getTitulo());
//	   System.out.printf("%s%s%n","codigo do livro :", codLivro);
       
	   
	   Observer observer;
	   observer = (Observer) getUsuario(codigoUsu);

       livro.registerObserver(observer);
      // String x = ((Usuario) livro.getObservers().get(0)).getNome();
      // System.out.printf("%s%s","nome do obs: ", x);
   }

public void NotificacaoObservador(String codUsu) {

	Observer observer;
    observer = (Observer) getUsuario(codUsu);
	
    observer.display();
}
   
   
}
