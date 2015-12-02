//import java.net.UnknownHostException;

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
	public static void main(String args[]){
		System.out.println("MES criado");
		//GestordePedidos Pedido=GestordePedidos.getInstance();
		//Pedido.novoPedido(":T001151");
		
		//Thread T1=new Thread (new Transforma(1,1,5,));//Pedido pré-definido VERSÂO DE TESTE
		
		EscolheCaminho Caminho=EscolheCaminho.getInstance();//vai buscar objecto Caminho
		int caminho=Caminho.EscolheNovoCaminho('T', 1, 5);
		if(caminho!=0){//se já tem caminho começa VERSÂO DE TESTE
			try{
			Thread T1=new Thread (new Transforma(1,1,5,caminho));//Pedido pré-definido VERSÂO DE TESTE		
			T1.start();//VERSÂO DE TESTE
			}
			catch(Exception e){
				System.out.println("Erro");
			}
		}
		
	}
}
