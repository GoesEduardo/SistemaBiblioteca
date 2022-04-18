import java.util.HashMap;

public class inicializadorComandos {

	public static HashMap<String,Comando> inicializarComandos() {
	HashMap<String,Comando>	comandos = new HashMap<String, Comando>();
		
		comandos.put("emp", new Emprestar());
		comandos.put("res", new Reservar());
		comandos.put("dev", new Devolver());
		comandos.put("obs", new Observar());
		comandos.put("liv", new consultarLivro());
		comandos.put("usu", new consultarUsuario());
		comandos.put("ntf", new notificarProfessor());
		
		return comandos;
	}

	
	
}
