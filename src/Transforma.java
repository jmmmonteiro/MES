
public class Transforma {
	public int NO;
	public int PO;
	public int PF;
	public char Tipo;
	public boolean fim;
	//Construtor Transforma cria novo transforma com as variaveis necessárias
	public Transforma(int NumO, int PecaO, int PecaF, char t){
		NO=NumO;//define numero de ordem
		PO=PecaO;//define peça original
		PF=PecaF;//define peça final
		Tipo=t;	//define tipo
		fim=false;			
	}
	
	public int Start(){
		
		EscolheCaminho Caminho=EscolheCaminho.getInstance();//vai buscar objecto Caminho
		if(Caminho.EscolheNovoCaminho(Tipo, PO, PF)!=0){//se existe célula livre
			//codigo a fazer
			return 0;
		}
		else{//se não tiver célula disponivel
			return 0;
		}
		
	}
	
}
