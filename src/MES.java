
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
		MES.init();//inicializa MES
		Transforma Transforma1=new Transforma(1,1,1,'t');//Cria transformação
		//Imprime parametros da Transformação criada
		int NO=Transforma1.NO;
		System.out.println(" NO é "+NO);
		int PO=Transforma1.PO;
		System.out.println(" PO é "+PO);
		int PF=Transforma1.PF;
		System.out.println(" PF é "+PF);
		char tipo=Transforma1.Tipo;
		System.out.println(" Tipo é "+tipo);
			
	}
}
