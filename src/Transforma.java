//import java.net.UnknownHostException;

public class Transforma implements Runnable{
	public int NO;
	public int PO;
	public int PF;
	public char Tipo;
	public boolean fim;
	private int caminho;
	//Construtor Transforma cria novo transforma com as variaveis necessárias
	public Transforma(int NumO, int PecaO, int PecaF,int cnovo){
		NO=NumO;//define numero de ordem
		PO=PecaO;//define peça original
		PF=PecaF;//define peça final
		Tipo='T';	//define tipo
		fim=false;			
		caminho=cnovo;
	}
	
	/*public int caminho(){//Vê se existe caminho livre
		
		EscolheCaminho Caminho=EscolheCaminho.getInstance();//vai buscar objecto Caminho
		caminho=Caminho.EscolheNovoCaminho(Tipo, PO, PF);
		if(caminho!=0){//se existe célula livre
			return 1;
		}
		else{//se não tiver célula disponivel
			return 0;
		}
		
	}*/
	
	public void run(){
		try{
			ModBus.writePLC(0, caminho);//VERSÂO DE TESTE
			int a,b;
			System.out.println("Thread a correr");
			//IMPEDE QUE ARRANQUE COM OUTRA PEÇA
			do{
				a=ModBus.readPLC(0, 1);
			}
			while(a==0);
			if(a==1)//Se a passa a 1 significa que já arrancou 
			{
				ModBus.writePLC(0, 0);//escreve 0 para impedir que arranque caso haja nova peça
			}
			//System.out.println(a);
			//Thread.sleep(25000);//sleep 25 segundos
			Thread.sleep(10000);//sleep 10 segundos	
			do{
				b=ModBus.readPLC(0, 1);
				//System.out.println("ciclo");
				if(b==2 || b==3)
				{
					System.out.println("altera disponibilidade da célula");
					EscolheCaminho Caminho=EscolheCaminho.getInstance();//vai buscar objecto Caminho
					if(caminho==1)
					{
						Caminho.Celula1.AlteraDisponibilidade();	
					}
					break;
					//ALTERA DISP DA Célula
				}
							
			}
			while(b!=2 || b!=3);
			//fim=true;
			
		}
		catch(Exception e){
			System.out.println("Erro");
		}
	}
	
}
