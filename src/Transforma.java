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
	
	
	public void run(){
		try{
			ModBus.writePLC(caminho, 1);//VERSÂO DE TESTE
			int a,b;
			boolean run=true;
			System.out.println("Thread a correr");
			//IMPEDE QUE ARRANQUE COM OUTRA PEÇA
			do{
				a=ModBus.readPLC(caminho, 1);
				if(a==1)//Se a passa a 1 significa que já arrancou 
				{
					ModBus.writePLC(caminho, 0);//escreve 0 para impedir que arranque caso haja nova peça
					System.out.println("ESCREVE 0 NO PLC AAAAAAAAAAAA");
					break;
				}
			}
			while(run);
		
			//System.out.println(a);
			//Thread.sleep(25000);//sleep 25 segundos
			Thread.sleep(10000);//sleep 10 segundos	
			do{
				b=ModBus.readPLC(caminho, 1);
				//System.out.println("ciclo");
				if(b==2 || b==3)
				{
					System.out.println("\naltera disponibilidade da célula");
					EscolheCaminho Caminho=EscolheCaminho.getInstance();//vai buscar objecto Caminho
					if(caminho==0)
					{
						Caminho.Celula1.AlteraDisponibilidade();
						GestordePedidos Gestor=GestordePedidos.getInstance();  // manda ao gestor pedidos a dizer que acabou 
						Gestor.SinalPedidoAcabado(NO);
						
					}
					break;
					//ALTERA DISP DA Célula
					
				}
							
			}
			while(run);
			//fim=true;
			
		}
		catch(Exception e){
			System.out.println("Erro");
		}
	}
	
}
