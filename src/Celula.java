
public class Celula {
	private boolean livre;
	//Construtor C�lula inicializa-a como livre
	public Celula(){
		livre=true;
	}
	//Verifica Disponibilidade da C�lula
	public  boolean Disponibilidade(){
		return livre;
	}
	//Altera Disponibilidade da C�lula
	public boolean AlteraDisponibilidade(){
		livre=!livre;
		return livre;
	}
}