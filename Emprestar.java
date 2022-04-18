
public class Emprestar implements Comando {

	@Override
	public void executar(String cmd, String par1, String par2) {
		bibliotecaFachada.obterInstancia().realizarEmprestimo(cmd, par1, par2);
		
	}

}
