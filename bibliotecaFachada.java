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
		//par�metros: emp - codigo usuario - codigo do livro
		//excluir reserva se tiver feito e emprestimo efetivado
		// exibir mensagem de sucesso ou insucesso, mencionando nome de usu�rio, t�tulo do livro, se for 
		//uma mensagem de insucesso, relatar o motivo do insucesso: livro indispn�vel
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
              System.out.printf("FALHA! N�o h� exemplares dispon�veis para este livro.");

          }
		  
		  
          
	}
	
   public void realizarDevolucao(String cmd, String cod1, String cod2) {  //feito
		//par�metros: dev - codigo de identificacao do usuario - codigo de identifacao do livro
	   //mensagem de sucesso ou insucesso da devolu��o, que mencione o nome do usu�rio e o t�tulo
	   //a mensagem de insucesso ocorre quando n�o houver emprestimo em aberto daquele livro para aquele usu�rio
	   //percorre a lista de emprestimos, se n�o achar: retorna falha. se achar, muda o status do emprestimo pra finalizado, muda o status do exemplar
	   //para "dispon�vel" na lista de exemplares do livro.
	   
	   //metodo pra procurar o livro na lista de livros atraves do c�digo
	   //m�todo pra procurar o usu�rio em uma lista de usuarios atrav�s do c�digo
	   
	  Usuario usuario = getUsuario(cod1);
	  Livro livro = getLivro(cod2);
	//  Exemplar exemplar = getExemplar("100");
	  
	  int i = usuario.procuraEmprestimo(livro);        //procura o emprestimo passando o codigo do livro
      

	  
	   if(i<0)                                                      //se n�o achou
	    System.out.printf("%s%s%s%s%n","FALHA! N�o existe empr�stimo em aberto do livro ",livro.getTitulo()," para o usu�rio ", usuario.getNome());
	  else {                                                       //se achou
	  	  usuario.getEmprestimos().get(i).setStatusEmp(false);//define o status do emprestimo na lista de emprestimos do usuario como finalizado
	  	  usuario.getEmprestimos().get(i).setDataDevolucao(LocalDateTime.now());   //passa a data da devolu�ao
	  	 String j = usuario.getEmprestimos().get(i).getExemplar().getCodigoExemplar(); //pega o c�digo do exemplar
	  	 getExemplar(j).setStatusExemplar(true); //passa o c�digo do exemplr e exemplar passa a ficar dispon�vel
	  	 livro.getEmprestimos().remove(usuario.getEmprestimos().get(i));     
	  	System.out.println("O livro foi devolvido com sucesso!");
	      }
	
	  
	}
   
   
   

   public void realizarConsultaLivro(String cmd, String cod1, String cod2) { //feito
	//par�metros: liv - c�digo do livro
	//apresentar: t�tulo, 
	   //apresntar quantidade de reservas para aquele livro, se diferente de 0: apresentar tamb�m o nome dos usu�rios que fizeram cada reserva
	   //colocar um 
	   //apresentar: p/ cada exemplar seu c�digo, seu status,  e em caso de emprestado, o nome do usu�rio, a data de emprestimo e a prevista de devolu��o

	   
	   Livro livro = getLivro(cod1);
      
	  System.out.printf( "%s%s%n","T�tulo do Livro: ", livro.getTitulo());

       
       if(livro.getReservas().size()==0)
		   System.out.println("O livro n�o apresenta reservas");
       else {
		   System.out.printf("%s%s%s%n","H� ",livro.getReservas().size(), " reservas para este livro");
		   
		   System.out.printf("Usu�rios que reservaram: ");

    	   for(int i=0;i<livro.getReservas().size();i++) {
    		   System.out.println(livro.getReservas().get(i).getNomeUsuario());
    	   }
       }
    	   
	   System.out.println("Exemplares:");

    	   for(int i=0;i<livro.getExemplares().size();i++) {
    		 Exemplar exemplar =  livro.getExemplares().get(i);
    		  System.out.printf("%s%s%n","c�digo do exemplar: ",exemplar.getCodigoExemplar());
    		  if(exemplar.isStatusExemplar()) {
        		  System.out.println( "Status: Dispon�vel");
    		  }
    		  else
        		  System.out.println( "Status: Indispon�vel");
    	   }

 		  System.out.printf("%s%s%n", "Empr�stimos ", livro.getEmprestimos().size());

    	   for(int i=0;i<livro.getEmprestimos().size();i++) {
    		 Emprestimo emprestimo =  livro.getEmprestimos().get(i);
    		      System.out.printf("%s%s%n", "c�digo exemplar: ",emprestimo.getExemplar().getCodigoExemplar());
        		  System.out.printf("Status: Indispon�vel ");
        		  System.out.printf("%s%s%n","Usu�rio: ", emprestimo.getUsuario().getNome());
        		  System.out.printf("%s%s%n", "Data de empr�stimo: ", emprestimo.getDataEmprestimo());
        		  if(emprestimo.isStatusEmp())
                  System.out.printf("%s%s%n", "Data prevista de devolu��o: ", emprestimo.getDataDevolucaoPrevista());
    		  }
    		  
    		  
    	   }
    	   
       
   
   
   public void realizarConsultaUsuario(String cmd, String cod1, String cod2) { //feito
	   //par�metros: usu - codigo do usuario
	   //apresentar a lista de todos os seus emprestimos recorrentes e passados, assim como de suas reservas
	   //a listagem de cada emprestimo dever� apresentar: o t�tulo do livro - a data de emprestimo - o status (em curso ou finalizado) - a data de devolu�ao
	   //a listagem de reservas dever� apresentar: o t�tulo do livro reservado - a data de solicita��o da reserva.
	   Usuario usuario = getUsuario(cod1);
	   
	   System.out.printf("%s%s%n","Nome do Usu�rio: ",usuario.getNome());
	   
   	  System.out.printf( "%s%s%n","Empr�stimos do usu�rio: ",usuario.getEmprestimos().size());
	   for(int i=0;i<usuario.getEmprestimos().size();i++) {
  		Emprestimo emprestimo =  usuario.getEmprestimos().get(i);
  		  System.out.printf("%s%s%n", "T�tulo do Livro: ",emprestimo.getTituloLivro());
  		  System.out.printf("%s%s%n","Data de empr�stimo: ", emprestimo.getDataEmprestimo() );
  		if(emprestimo.isStatusEmp()) {
    	  System.out.println( "Status: Em curso");
    	  System.out.printf("%s%s%n", "Data prevista de Devolu��o: ", emprestimo.getDataDevolucaoPrevista());
  		}
  		else {
      	  System.out.println( "Status: Finalizado");
		  System.out.printf("%s%s%n", "Data de Devolu��o: ", emprestimo.getDataDevolucao());
  		}
	   }
	   
	   System.out.printf( "%s%s%n","Reservas do usu�rio: ",usuario.getLivrosReservados().size());
	   for(int i=0;i<usuario.getLivrosReservados().size();i++) {
	  		Reserva reserva =  usuario.getLivrosReservados().get(i);
	  		  System.out.printf("%s%s%n", "T�tulo do Livro: ",reserva.getTituloLivro());
	  		  System.out.printf("%s%s%n", "Data de solicita��o: ", reserva.getDataSolicitacao() );
	   }
	   
	   
   }
	
   public void realizarReserva(String cmd, String cod1, String cod2) { //feito
	   //par�metros: res - codigo de identifica��o do usuario - c�digo de identifica�ao do livro
	   //ser� permitida apenas a reserva de 3 livros por usu�rio
	   // exibir mensagem de sucesso ou insucesso, mencionando nome de usu�rio, t�tulo do livro, a mensagem de insucesso
	   //deve dizer o motivo
	   Livro livro = getLivro(cod2);
	   Usuario usuario = getUsuario(cod1);
	   usuario.getLivrosReservados().size();
	   LocalDateTime data = LocalDateTime.now();
	 
	   if(usuario.getLivrosReservados().size()>=3) {
		   System.out.printf("%s%s%s%s%s","FALHA! O usu�rio: ", usuario.getNome(), " n�o pode reservar o livro: ", livro.getTitulo(),", pois o usu�rio atingiu o n�mero limite de reservas");
	   }
	   
	   else if(usuario.procuraReservas(livro)>=0){
		   System.out.printf("%s%s%s%s%s","FALHA! O usu�rio: ", usuario.getNome(), " n�o pode reservar o livro: ", livro.getTitulo(),", pois o usu�rio j� possui uma reserva desse livro");
	   }
	   
	   else{
		   Reserva novaReserva = new Reserva(livro, usuario, data );
		   livro.addReserva(novaReserva);
		   usuario.addReserva(novaReserva);
		   System.out.println("Realizando reserva!");
		//   System.out.println(usuario.getLivrosReservados().size());
		   System.out.printf("%s%s%n","titulo do livro: ", novaReserva.getLivro().getTitulo());
		   System.out.printf("%s%s%n","nome do usuario: ", novaReserva.getUsuario().getNome());
		//   System.out.printf("%s%s%n","data de solicita��o: ", novaReserva.getDataSolicitacao());


	   }
	   
   }
   
   public void RegistrarObservador(String obs, String codigoUsu, String codLivro) {                //feito
	   //par�metros: obs - c�digo do usu�rio - c�digo do livro
	   //registrar professor para receber notifica��o quando um livro tiver mais de duas reservas simult�neas
      
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
