
public class Celula {
	private boolean livre;
	//Construtor Célula inicializa-a como livre
	public Celula(){
		livre=true;
	}
	//Verifica Disponibilidade da Célula
	public  boolean Disponibilidade(){
		return livre;
	}
	//Altera Disponibilidade da Célula
	public boolean AlteraDisponibilidade(){
		livre=!livre;
		System.out.println(livre);
		return livre;
	}
}
