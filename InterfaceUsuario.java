import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;

public class InterfaceUsuario {
	
	private HashMap<String, Comando> comandos;
	
		
	private String obterComandoConsole() throws IOException {
        BufferedReader teclado = new BufferedReader(new InputStreamReader(System.in));
        
        System.out.println();
        System.out.println("Digite o comando:");
		return teclado.readLine();
        
	}
	
	public void fazerLoopEntrada() throws IOException {
		 comandos = inicializadorComandos.inicializarComandos();
	    String string1, string2=null, string3=null;
		String stringComando = obterComandoConsole();
		//System.out.println(stringComando); 
		 string1 = stringComando.split(" ")[0];
		// System.out.println(string1);
		 if(stringComando.split(" ").length>1) {string2 = stringComando.split(" ")[1];}
		// System.out.println(string2);
		 if(stringComando.split(" ").length>2) {string3 = stringComando.split(" ")[2];}
		// System.out.println(string3);
		 
	        
		while(!stringComando.equals("sai")){
		
			 executarComando(string1, string2, string3);
			 stringComando = obterComandoConsole();	
			 string1 = stringComando.split(" ")[0];
			// System.out.println(string1);
			 if(stringComando.split(" ").length>1) {string2 = stringComando.split(" ")[1];}
			// System.out.println(string2);
			 if(stringComando.split(" ").length>2) {string3 = stringComando.split(" ")[2];}
			// System.out.println(string3);
			
		}
	}
	
	
	private void executarComando(String strComando, String par1, String par2) {
		
		// System.out.println(strComando);
		// System.out.println(par1);
		/// System.out.println(par2);

		Comando comando = comandos.get(strComando);
		comando.executar(strComando, par1, par2);

	}
	
	
}
