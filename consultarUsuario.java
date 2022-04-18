
public class consultarUsuario implements Comando {

	@Override
	public void executar(String cmd, String cod1, String cod2) {

		bibliotecaFachada.obterInstancia().realizarConsultaUsuario(cmd, cod1, null);
	}

}
