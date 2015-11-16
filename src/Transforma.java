
public class Transforma {
	public int NO;
	public int PO;
	public int PF;
	public char Tipo;
	public int [] VetorTapetes=new int[10];
	public int [] VetorMaquina=new int[2];
	public int [] VetorTMaquina=new int[2];
	//Construtor Transforma cria novo transforma com as variaveis necess�rias
	public Transforma(int NumO, int PecaO, int PecaF, char t){
		NO=NumO;//define numero de ordem
		PO=PecaO;//define pe�a original
		PF=PecaF;//define pe�a final
		Tipo=t;	//define tipo
		EscolheCaminho Caminho=EscolheCaminho.getInstance();//vai buscar objecto Caminho
		Caminho.EscolheNovoCaminho(Tipo, PO, PF);//escolhe caminho para transforma��o
		VetorTapetes=Caminho.VetorTapetes;
		VetorMaquina=Caminho.VetorMaquina;
		VetorTMaquina=Caminho.VetorTMaquina;
		Armazem A=Armazem.getInstance();
		if(A.PedePeca(PecaO)==1){
			//armazem forneceu pe�a
		}
		else{
			//erro
		}
			
	}
	
	public int Start(){
		
		EscolheCaminho Caminho=EscolheCaminho.getInstance();//vai buscar objecto Caminho
		if(Caminho.EscolheNovoCaminho(Tipo, PO, PF)==1){//se existe c�lula livre
			return 1; //
		}
		else{//se n�o tiver c�lula disponivel
			return 0;
		}
	}
	
}
