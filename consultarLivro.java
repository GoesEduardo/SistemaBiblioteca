
public class consultarLivro implements Comando{

	@Override
	public void executar(String cmd, String par1, String par2) {
        
		bibliotecaFachada.obterInstancia().realizarConsultaLivro(cmd, par1, null);
	}

}
