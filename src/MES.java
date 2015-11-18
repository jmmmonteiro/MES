import java.net.UnknownHostException;

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
	public static void main(String args[])throws UnknownHostException, Exception{
		System.out.println("MES criado");
		//GestordePedidos Pedido=GestordePedidos.getInstance();
		//Pedido.novoPedido(":T001151");
		Transforma T1=new Transforma(1,1,5);//Pedido pr�-definido VERS�O DE TESTE
		if(T1.caminho()!=0){//se j� tem caminho come�a VERS�O DE TESTE
			T1.start();//VERS�O DE TESTE
		}
		
	}
}
