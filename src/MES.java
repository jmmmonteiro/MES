//import java.net.UnknownHostException;
import java.net.*;
import java.util.concurrent.TimeUnit;
import java.io.*;

public class MES {
	private static MES instance;
	private MES(){}
	
	public static MES getInstance(){
		if(instance==null){
			instance=new MES();	
		}
		return instance;
	}
	//Singleton
	
	//inicializa objectos
	public static void init(){
		
	}
	
	//main
	public static void main(String args[]) throws InterruptedException{
		
		
		
		Thread servidor = new Thread(new UDPservidor());
		servidor.start();
		
		GestordePedidos gestor=GestordePedidos.getInstance();//vai buscar objecto gestor pedidos
		while(true){
			gestor.runCicle(); // 0 , pois não se especifica destino
			TimeUnit.SECONDS.sleep(10);
		}
		
		
		
		
		
		
		
		
		

		/*System.out.println("MES criado");
		
		//Pedido.novoPedido(":T001151");
		
		GestordePedidos gestorPedido=GestordePedidos.getInstance();
		// testar se insere bem pedidosPendentes
				String r = new String(":M0021502"); // para testar quando n diferente de 1
				//String r = new String(":T0021501"); // para testar quando n=1
				//String s = new String(":T1021502");
				if( (gestorPedido.novoPedidoPendente(r)) ==true)
					System.out.println("pedido pendente criado");
				//if( (gestorPedido.novoPedidoPendente(s)) ==true)
					//System.out.println("pedido pendente criado");
		 		
				//testar o runCucle
				gestorPedido.runCicle();				
		*/	
					
				
		//Thread T1=new Thread (new Transforma(1,1,5,));//Pedido pré-definido VERSÂO DE TESTE
		/*
		EscolheCaminho Caminho=EscolheCaminho.getInstance();//vai buscar objecto Caminho
		int caminho=Caminho.EscolheNovoCaminho('T', 1, 5);
		if(caminho!=0){//se já tem caminho começa VERSÂO DE TESTE
			try{
			Thread T1=new Thread (new Transforma(1,1,5,caminho));//Pedido pré-definido VERSÂO DE TESTE	
			Thread T2=new Thread (new Transforma(1,1,5,caminho));//Pedido pré-definido VERSÂO DE TESTE	
			T1.start();//VERSÂO DE TESTE
			T2.start();
			}
			catch(Exception e){
				System.out.println("Erro");
			}
		}
		*/
	}
}
