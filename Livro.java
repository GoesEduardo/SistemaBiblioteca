import java.time.LocalDateTime;
import java.util.ArrayList;

public class Livro implements Subject{
    public String codigoLivro;
    public String titulo;
    public String autores;
    public String editora;
    public String edicao;
    public int anoPublicacao;
    public ArrayList<Observer>observers;
	public LocalDateTime dataEmprestimo;
    private ArrayList<Exemplar>Exemplares;
    private ArrayList<Reserva>Reservas;
    private ArrayList<Emprestimo>Emprestimos;
    

    
    
    public Livro(String codigoLivro, String titulo, String editora, String autores, String edicao, int anoPub) {
    	this.codigoLivro = codigoLivro;
    	this.titulo = titulo;
    	this.editora = editora;
    	this.autores = autores;
    	this.edicao = edicao;
    	this.anoPublicacao = anoPub;	
    	 observers = new ArrayList<Observer>();
    	 Exemplares = new ArrayList<Exemplar>();
    	 Reservas = new ArrayList<Reserva>();
         Emprestimos = new ArrayList<Emprestimo>();
   
    }

	public ArrayList<Reserva> getReservas() {
		return Reservas;
	}

	public void setReservas(ArrayList<Reserva> reservas) {
		Reservas = reservas;
	}

	public void addReserva(Reserva reserva) {
		Reservas.add(reserva);
		if(Reservas.size()>=2)
			notifyObservers();
	}
	
    public void addExemplar(Exemplar exemplar) {
    	Exemplares.add(exemplar);
    }
    
	public String getcodigoLivro() {
		return codigoLivro;
	}

	public void setcodigoLivro(String codigoLivro) {
		this.codigoLivro = codigoLivro;
	}

	public String getTitulo() {
		return titulo;
	}

	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}

	public String getAutor() {
		return autores;
	}

	public void setAutor(String autores) {
		this.autores = autores;
	}

	public LocalDateTime getDataEmprestimo() {
		return dataEmprestimo;
	}

	public void setDataEmprestimo(LocalDateTime dataEmprestimo) {
		this.dataEmprestimo = dataEmprestimo;
	}
	
	public ArrayList<Exemplar> getExemplares() {
		return Exemplares;
	}

	public void setExemplares(ArrayList<Exemplar> exemplares) {
		Exemplares = exemplares;
	}

	
	public Exemplar ItemDisponivel() {
			int i = 0;
			Exemplar exemplar = null;
			
        //    System.out.println("vendo se tem item disponível!");
         //   System.out.printf("%s%s%n","tamanho da lista de exemplares!", Exemplares.size());

            if( Exemplares.size()>0) {
			while(Exemplares.get(i).isStatusExemplar()==false&&i<Exemplares.size()-1) {
		            
		        //    System.out.println("entrou no while!");
		        //    System.out.println(i);
            
		            i++;

			}
        //    System.out.println("saiu do while!");

			
			if(Exemplares.get(i).isStatusExemplar()==true) 
		        exemplar = Exemplares.get(i);
	            
            }
            
            
            	return exemplar;
            
	
	}
	
	public int qtdeExemplaresDisponiveis() {
		int i = 0, soma = 0;
	
		
		for(i=0; i<Exemplares.size(); i++) {
			if(Exemplares.get(i).isStatusExemplar()==true)
				soma++;
		}
        
		return soma;
		
	}
	
	
	public Emprestimo procuraEmprestimoExemplar(Exemplar exemplar) {
		
		int i = 0;
		
     //   System.out.println("vendo se tem item disponível!");
     //   System.out.printf("%s%s%n","tamanho da lista de exemplares!", Exemplares.size());

        if( Exemplares.size()>0) {
		while(Emprestimos.get(i).getExemplar()!=exemplar&&i-1>Emprestimos.size()) {
	            i++;
		}
		
      //  System.out.println("saiu do while!");

		
		if(Exemplares.get(i).isStatusExemplar()==true) 
	        exemplar = Exemplares.get(i);
            
        }
        
        
        	return Emprestimos.get(i);
			
	}
	

	@Override
	public void registerObserver(Observer o) {
		// TODO Auto-generated method stub
		observers.add(o);
	}

	@Override
	public void removeObserver(Observer o) {
		int i = observers.indexOf(o);
		if(i>=0) {
		observers.remove(o);
		}
	}
	
	
	
		
       
	
	
	@Override
	public void notifyObservers() {
		for(int i=0; i<observers.size(); i++) {
			Observer observer = observers.get(i);
			observer.update();
		}
	}

	public ArrayList<Emprestimo> getEmprestimos() {
		return Emprestimos;
	}

	public void setEmprestimos(ArrayList<Emprestimo> emprestimos) {
		Emprestimos = emprestimos;
	}
	
	public ArrayList<Observer> getObservers() {
		return observers;
	}

	public void setObservers(ArrayList<Observer> observers) {
		this.observers = observers;
	}
	
	
}
