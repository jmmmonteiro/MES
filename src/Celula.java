
public class Celula {
	private boolean livre;
	//Construtor C�lula inicializa-a como livre
	public Celula(){
		livre=true;
	}
	//Verifica Disponibilidade da C�lula
	public  synchronized boolean Disponibilidade(){
		return livre;
	}
	//Altera Disponibilidade da C�lula
	public synchronized boolean AlteraDisponibilidade(){
		livre=!livre;
		System.out.println(livre);
		return livre;
	}
}
