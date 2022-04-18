
public class Observar implements Comando {

	@Override
	public void executar(String cmd, String par1, String par2) {
		bibliotecaFachada.obterInstancia().RegistrarObservador(cmd, par1, par2);
	}

}
