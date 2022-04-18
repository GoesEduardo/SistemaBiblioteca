
public class Devolver implements Comando {

	@Override
	public void executar(String cmd, String par1, String par2) {
		// TODO Auto-generated method stub
		bibliotecaFachada.obterInstancia().realizarDevolucao(cmd, par1, par2);
	}

}
