import java.util.ArrayList;

public class DadosBiblioteca {
	
private static ArrayList<Usuario> ListaUsuarios;
private static ArrayList<Livro> ListaLivros;
private static  ArrayList<Exemplar> ListaExemplares;


private static DadosBiblioteca instancia;
	
private DadosBiblioteca() {
	   ListaUsuarios = new ArrayList<Usuario>();
	   Professor prof1 = new Professor("100", "Carlos Lucena");
	   alunoGraduacao aluno1 = new alunoGraduacao("123", "João da Silva");
	   alunoGraduacao aluno2 = new alunoGraduacao("789", "Pedro Paulo");
	   alunoPosGraduacao aluno3 = new alunoPosGraduacao("456", "Luiz Fernando Rodriguez");
     ListaUsuarios.add(prof1);
     ListaUsuarios.add(aluno1);
     ListaUsuarios.add(aluno2);
     ListaUsuarios.add(aluno3);
     
     
       ListaLivros = new ArrayList<Livro>();
       Livro livro1 = new Livro("100", "Engenharia de Software", "AddisonWesley", "Ian Sommervile", "6ª", 2000);
	   Livro livro2 = new Livro("101", "UML – Guia do Usuário", "Campus Grady Booch", "James Rumbaugh, IvarJacobson","7ª", 2000);
	   Livro livro3 = new Livro("200", "Code Complete", "Microsoft Press", "Steve McConnell", "2ª", 2014);
	   Livro livro4 = new Livro("201", "Agile Software Development, Principles, Patterns, and Practices", "Prentice Hall", "Robert Martin", "1ª", 2002);
	   Livro livro5 = new Livro("300", "Refactoring: Improving the Design of Existing Code", "AddisonWesley Professional", "Martin Fowler", "1ª", 1999);
	   Livro livro6 = new Livro("301", "Software Metrics: A Rigorous and Practical Approach", "CRC Press", "Norman Fenton, James Bieman","3ª", 2014);
	   Livro livro7 = new Livro("400", "Design Patterns: Elements of Reusable Object-Oriented Software", "AddisonWesley Professional",
			                   "Erich Gamma, Richard Helm, Ralph Johnson, John Vlissides", "1ª", 1994);
	   Livro livro8 = new Livro("401", "UML Distilled: A Brief Guide to the Standard Object Modeling Language", "AddisonWesley Professional",
			                   "Martin Fowler","3ª", 2003);
	   
	   ListaLivros.add(livro1);
	   ListaLivros.add(livro2);
	   ListaLivros.add(livro3);
	   ListaLivros.add(livro4);
	   ListaLivros.add(livro5);
	   ListaLivros.add(livro6);
	   ListaLivros.add(livro7);
	   ListaLivros.add(livro8);
     
	   
	   
	   ListaExemplares = new ArrayList<Exemplar>();
		 
	   Exemplar exemplar1 = new Exemplar("100", "01", true);
	   Exemplar exemplar2 = new Exemplar("100", "02", true);
	   Exemplar exemplar3 = new Exemplar("101", "03", true);
	   Exemplar exemplar4 = new Exemplar("200", "04", true);
	   Exemplar exemplar5 = new Exemplar("201", "05", true);
	   Exemplar exemplar6 = new Exemplar("300", "06", true);
	   Exemplar exemplar7 = new Exemplar("300", "07", true);
	   Exemplar exemplar8 = new Exemplar("400", "08", true);
	   Exemplar exemplar9 = new Exemplar("400", "09", true);
	
       ListaExemplares.add(exemplar1);
       ListaExemplares.add(exemplar2);
       ListaExemplares.add(exemplar3);
       ListaExemplares.add(exemplar4);
       ListaExemplares.add(exemplar5);
       ListaExemplares.add(exemplar6);
       ListaExemplares.add(exemplar7);
       ListaExemplares.add(exemplar8);
       ListaExemplares.add(exemplar9);
       
      
       
      livro1.addExemplar(exemplar1);
      livro1.addExemplar(exemplar2);
      livro2.addExemplar(exemplar3);
      
      livro3.addExemplar(exemplar4);
      livro4.addExemplar(exemplar5);
     

      livro5.addExemplar(exemplar6);
      livro5.addExemplar(exemplar7);

      livro7.addExemplar(exemplar8);
      livro7.addExemplar(exemplar9);


}

public static DadosBiblioteca obterInstancia() {
	if(instancia == null) {
      instancia = new DadosBiblioteca();
	}
	return instancia;
}


	
public static ArrayList<Usuario>getListaUsuarios(){
	return ListaUsuarios;
}
	
	
public static ArrayList<Livro>getListaLivros(){
	return ListaLivros;
}



public static ArrayList<Exemplar>getListaExemplares(){
	return ListaExemplares;
}



public Usuario getUsuario(String codigo){
	int i = 0;
	 ArrayList<Usuario>ListaUsuarios = getListaUsuarios();
	 
	
	while(ListaUsuarios.get(i).getIDUsuario()!=codigo) {
         i++;
	}
	
    return ListaUsuarios.get(i);
	
}


public Livro getLivro(String codigo){
	int i = 0;
	 ArrayList<Livro>ListaLivros = getListaLivros();
	 
	 //for(i=0;i<ListaUsuarios.size();i++) {
	 //	if(ListaUsuarios.get(i).getIDUsuario()==codigo);
	     
	 //}
	
	while(ListaLivros.get(i).getcodigoLivro()!=codigo&&i<ListaLivros.size()-1) {
         i++;
	}
	
    return ListaLivros.get(i);
	
}


public Exemplar getExemplar(String codigo){
	int i = 0;
	 ArrayList<Exemplar>ListaExemplares = getListaExemplares();
	 
	 //for(i=0;i<ListaUsuarios.size();i++) {
	 //	if(ListaUsuarios.get(i).getIDUsuario()==codigo);
	     
	 //}
	
	while(ListaExemplares.get(i).getcodigoLivro()!=codigo&&i<ListaExemplares.size()-1) {
         i++;
	}
	
    return ListaExemplares.get(i);
	
}







}