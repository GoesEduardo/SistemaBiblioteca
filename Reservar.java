
public class Reservar implements Comando {

	@Override
	public void executar(String cmd, String par1, String par2) {
		bibliotecaFachada.obterInstancia().realizarReserva(cmd, par1, par2);
		
	}

}
