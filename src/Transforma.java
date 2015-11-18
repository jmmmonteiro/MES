import java.net.UnknownHostException;

public class Transforma {
	public int NO;
	public int PO;
	public int PF;
	public char Tipo;
	public boolean fim;
	private int caminho;
	//Construtor Transforma cria novo transforma com as variaveis necessárias
	public Transforma(int NumO, int PecaO, int PecaF){
		NO=NumO;//define numero de ordem
		PO=PecaO;//define peça original
		PF=PecaF;//define peça final
		Tipo='T';	//define tipo
		fim=false;			
	}
	
	public int caminho(){//Vê se existe caminho livre
		
		EscolheCaminho Caminho=EscolheCaminho.getInstance();//vai buscar objecto Caminho
		caminho=Caminho.EscolheNovoCaminho(Tipo, PO, PF);
		if(caminho!=0){//se existe célula livre
			return 1;
		}
		else{//se não tiver célula disponivel
			return 0;
		}
		
	}
	
	public void start() throws UnknownHostException, Exception{
		ModBus.writePLC(0, caminho);//VERSÂO DE TESTE
	}
	
}
