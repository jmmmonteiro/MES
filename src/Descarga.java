public class Descarga implements Runnable{
	public int NO;
	public int P;
	public int D;
	public char Tipo;
	public int caminho;
	//public boolean fim;
	//private int caminho;
	
	//Construtor Descarga cria novo descarga com as variaveis necessárias
	public Descarga(int NumO, int Peca, int dest, int cnovo){
		NO=NumO;//define numero de ordem
		P=Peca;//define peça original
		D=dest;//define peça final
		Tipo='U';	//define tipo		
		//fim=false;
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
			Interface face=Interface.getInstance();
			
			int  a,b;//escreve no registo 200 (TESTE)
				if(D==1) //se destino for o pusher 1
				{
					ModBus.writePLC(caminho, 1);//VERSÂO DE TESTE
					ModBus.writePLC(50,P);//escreve peça a descarregar no PLC
				}
				else if(D==2)
				{
					ModBus.writePLC(caminho, 1);//VERSÂO DE TESTE
					ModBus.writePLC(51,P);//escreve peça a descarregar no PLC
				}	
			face.cDescarga();
			System.out.println("\nThread a correr");
			//IMPEDE QUE ARRANQUE COM OUTRA PEÇA
			do{
				a=ModBus.readPLC(0, caminho);
				if(a==1){
					ModBus.writePLC(caminho, 0);//escreve 0 para impedir que arranque caso haja nova peça
					System.out.println("ESCREVE 0 NO PLC AAAAAAAAAAAA");
					break;
				}
			}	
			while(true);
			//System.out.println(a);
			Thread.sleep(40000);//sleep 40 segundos
			
			
			//SENÃO PRECISAR DE VERIFICAR FIM APAGAR
			do{
				b=ModBus.readPLC(0, caminho);
				if(b==2 || b==3)
				{
					
					
					if(caminho==48){
						System.out.println("\naltera disponibilidade da célula 6");
							
						
						//atualiza interface numero peças descarregadas
						
						face.adiciona_peca_descarregada(P, D);
						EscolheCaminho Caminho=EscolheCaminho.getInstance();//vai buscar objecto Caminho
						Caminho.Celula6.AlteraDisponibilidade();
						GestordePedidos Gestor=GestordePedidos.getInstance();  // manda ao gestor pedidos a dizer que acabou 
						Gestor.SinalPedidoAcabado(NO);
					}
					else if(caminho==49){
						System.out.println("\naltera disponibilidade da célula 7");
						
						
						//atualiza interface numero peças descarregadas
						face.adiciona_peca_descarregada(P, D);
						EscolheCaminho Caminho=EscolheCaminho.getInstance();//vai buscar objecto Caminho
						Caminho.Celula7.AlteraDisponibilidade();
						GestordePedidos Gestor=GestordePedidos.getInstance();  // manda ao gestor pedidos a dizer que acabou 
						Gestor.SinalPedidoAcabado(NO);
					}
					break;
					//ALTERA DISP DA Célula
				}
				Thread.sleep(1000);//sleep 5 segundos				
			}
			while(b!=2 || b!=3);
			//fim=true;
			face.aDescarga();
		}
		catch(Exception e){
			System.out.println("Erro");
			 e.printStackTrace(System.out); 
		}
	}
	
}
