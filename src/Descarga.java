public class Descarga implements Runnable{
	public int NO;
	public int P;
	public int D;
	public char Tipo;
	//public boolean fim;
	//private int caminho;
	
	//Construtor Descarga cria novo descarga com as variaveis necess�rias
	public Descarga(int NumO, int Peca, int dest){
		NO=NumO;//define numero de ordem
		P=Peca;//define pe�a original
		D=dest;//define pe�a final
		Tipo='U';	//define tipo		
		//fim=false;
	}
	
	/*public int caminho(){//V� se existe caminho livre
		
		EscolheCaminho Caminho=EscolheCaminho.getInstance();//vai buscar objecto Caminho
		caminho=Caminho.EscolheNovoCaminho(Tipo, PO, PF);
		if(caminho!=0){//se existe c�lula livre
			return 1;
		}
		else{//se n�o tiver c�lula disponivel
			return 0;
		}
		
	}*/
	
	public void run(){
		try{
			int ref=200	, a;;//escreve no registo 200 (TESTE)
			if(D==1)
			{
				ModBus.writePLC(ref,1);//escreve 1 no resgito ref 1 (significa que vai para PM1)
			}
			else if(D==2)
			{
				ModBus.writePLC(ref,2);//escreve 2 no resgito ref (significa que vai para PM2)
			}
			System.out.println("Thread a correr");
			//IMPEDE QUE ARRANQUE COM OUTRA PE�A
			do{
				a=ModBus.readPLC(0, 1);
			}
			while(a==0);
			if(a==1)//Se a passa a 1 significa que j� arrancou 
			{
				ModBus.writePLC(ref, 0);//escreve 0 para impedir que arranque caso haja nova pe�a
			}
			//System.out.println(a);
			Thread.sleep(40000);//sleep 40 segundos
			
			
			//SEN�O PRECISAR DE VERIFICAR FIM APAGAR
			/*do{
				b=ModBus.readPLC(0, 1);
				if(b==2 || b==3)
				{
					System.out.println("altera disponibilidade da c�lula");
					EscolheCaminho Caminho=EscolheCaminho.getInstance();//vai buscar objecto Caminho
					Caminho.Celula5.AlteraDisponibilidade();	
					break;
					//ALTERA DISP DA C�lula
				}
				Thread.sleep(5000);//sleep 5 segundos				
			}
			while(b!=2 || b!=3);
			//fim=true;*/
			
		}
		catch(Exception e){
			System.out.println("Erro");
		}
	}
	
}


