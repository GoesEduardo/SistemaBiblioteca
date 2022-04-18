
public class notificarProfessor implements Comando {

	@Override
	public void executar(String cmd, String codUsu, String codLiv) {
		bibliotecaFachada.obterInstancia().NotificacaoObservador(codUsu);
       
	}

}
