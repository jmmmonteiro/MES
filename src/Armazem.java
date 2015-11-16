
public class Armazem {
	private static Armazem instance;
	private Armazem(){}
	
	public static Armazem getInstance(){
		if(instance==null){
			instance=new Armazem();	
		}
		return instance;
	}
	
	public int PedePeca(int peca){
		return 1; //se armazem fornece pe�a retorna 1
	}
	public int RecebePeca(){
		return 1;//se armazem recebe pe�a retorna 1
	}
}


