
public class Montagem implements Runnable{
	public int NO;
	public int Pb;
	public int Pc;
	public char Tipo;
	public boolean fim;
	//private int caminho;
	//Construtor Montagem cria nova montagem com as variaveis necess�rias
	public Montagem(int NumO, int Pbaixo, int Pcima){
		NO=NumO;//define numero de ordem
		Pb=Pbaixo;//define pe�a original
		Pc=Pcima;//define pe�a final
		Tipo='M';	//define tipo
		fim=false;			
		//caminho=cnovo;
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
			int ref=100;//escreve no registo 100 (TESTE)
			ModBus.writePLC(ref,1);//escreve 1 no resgito ref
			int a,b;
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
			
			do{
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
			//fim=true;
			
		}
		catch(Exception e){
			System.out.println("Erro");
		}
	}
	
}

