
public class Exemplar {
	
	private String codigoLivro, codigoExemplar;
	private boolean statusExemplar;
	
	public Exemplar(String codigoLivro, String codigoExemplar, boolean statusExemplar) {
		
		this.codigoLivro = codigoLivro;
		this.codigoExemplar = codigoExemplar;
		this.statusExemplar = statusExemplar;
	
	}
    
	public String getCodigoExemplar() {
		return codigoExemplar;
	}
	
	public void setCodigoExemplar(String codigoExemplar) {
		this.codigoExemplar = codigoExemplar;
	}
	public boolean isStatusExemplar() {
		return statusExemplar;
	}
	public void setStatusExemplar(boolean statusExemplar) {
		this.statusExemplar = statusExemplar;
	}
	public String getcodigoLivro() {
		return codigoLivro;
	}
	public void setcodigoLivro(String codigoLivro) {
		this.codigoLivro = codigoLivro;
	}
	
	
	

}
