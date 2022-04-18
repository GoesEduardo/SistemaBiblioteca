import java.io.IOException;

public class SistemaBiblioteca {

	public static void main(String[] args) throws IOException {
		inicializadorComandos.inicializarComandos();
		
		InterfaceUsuario interfaceUsu = new InterfaceUsuario();
		interfaceUsu.fazerLoopEntrada();
        
		//bibliotecaFachada.obterInstancia().realizarDevolucao();
		//bibliotecaFachada.obterInstancia().getLivro("123");
		//System.out.println(bibliotecaFachada.obterInstancia().getLivro("123").titulo);
		
		
		
		
		
	}

}
