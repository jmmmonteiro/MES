
public class Celula {
	private boolean livre;
	//Construtor Célula inicializa-a como livre
	public Celula(){
		livre=true;
	}
	//Verifica Disponibilidade da Célula
	public  synchronized boolean Disponibilidade(){
		return livre;
	}
	//Altera Disponibilidade da Célula
	public synchronized boolean AlteraDisponibilidade(){
		livre=!livre;
		System.out.println(livre);
		return livre;
	}
}
