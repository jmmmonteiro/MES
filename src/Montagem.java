
public class Montagem implements Runnable{
	public int NO;
	public int Pb;
	public int Pc;
	public char Tipo;
	public boolean fim;
	//private int caminho;
	//Construtor Montagem cria nova montagem com as variaveis necessárias
	public Montagem(int NumO, int Pbaixo, int Pcima){
		NO=NumO;//define numero de ordem
		Pb=Pbaixo;//define peça original
		Pc=Pcima;//define peça final
		Tipo='M';	//define tipo
		fim=false;			
		//caminho=cnovo;
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
			//disponibilidade da celula é aletrada no gestor de pedidos
			ModBus.writePLC(46,Pb);//escreve peça de baixo no PLC
			ModBus.writePLC(47,Pc);//escreve peça de cima no PLC
			ModBus.writePLC(45,1);//escreve 1 no resgito 45 (dá ordem de começo)
			int a,b;
			boolean run=true;
			System.out.println("Thread a correr");
			//IMPEDE QUE ARRANQUE COM OUTRA PEÇA
			do{
				a=ModBus.readPLC(0, 45);
				if(a==1 || a==2)//Se a passa a 1 significa que já arrancou 
				{
					ModBus.writePLC(45, 0);//escreve 0 para impedir que arranque caso haja nova peça
					System.out.println("\nEscreve zero no PLC aaaaaaaaaaaaaa");
					break;
				}
			}
			while(run);
			
			//System.out.println(a);
			Thread.sleep(40000);//sleep 40 segundos
			
			do{
				b=ModBus.readPLC(0, 45);
				if(b==2 || b==3)
				{
					System.out.println("\naltera disponibilidade da célula 5");
					EscolheCaminho Caminho=EscolheCaminho.getInstance();//vai buscar objecto Caminho
					Caminho.Celula5.AlteraDisponibilidade();//liberta célula	
					GestordePedidos Gestor=GestordePedidos.getInstance();  // manda ao gestor pedidos a dizer que acabou 
					Gestor.SinalPedidoAcabado(NO);
					//atualiza interface numero peças descarregadas
					Interface face=Interface.getInstance();
					face.adiciona_peca_montada(Pb, Pc);
					break;
					//ALTERA DISP DA Célula
				}
				Thread.sleep(5000);//sleep 5 segundos				
			}
			while(run);
			//fim=true;
			
		}
		catch(Exception e){
			System.out.println("Erro");
		}
	}
	
}