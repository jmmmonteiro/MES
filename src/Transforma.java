import java.net.UnknownHostException;

public class Transforma {
	public int NO;
	public int PO;
	public int PF;
	public char Tipo;
	public boolean fim;
	private int caminho;
	//Construtor Transforma cria novo transforma com as variaveis necess�rias
	public Transforma(int NumO, int PecaO, int PecaF){
		NO=NumO;//define numero de ordem
		PO=PecaO;//define pe�a original
		PF=PecaF;//define pe�a final
		Tipo='T';	//define tipo
		fim=false;			
	}
	
	public int caminho(){//V� se existe caminho livre
		
		EscolheCaminho Caminho=EscolheCaminho.getInstance();//vai buscar objecto Caminho
		caminho=Caminho.EscolheNovoCaminho(Tipo, PO, PF);
		if(caminho!=0){//se existe c�lula livre
			return 1;
		}
		else{//se n�o tiver c�lula disponivel
			return 0;
		}
		
	}
	
	public void start() throws UnknownHostException, Exception{
		
		ModBus.writePLC(0, caminho);//VERS�O DE TESTE
		int a=ModBus.readPLC(0, 1);
		//IMPEDE QUE ARRANQUE COM OUTRA PE�A
		while(a==0){
			a=ModBus.readPLC(0, 1);//Enquanto a � 0 leio registo
		}
		if(a==1)//Se a passa a 1 significa que j� arrancou 
		{
			ModBus.writePLC(0, 0);//escreve 0 para impedir que arranque caso haja nova pe�a
		}
		//System.out.println(a);
	}
	
}
