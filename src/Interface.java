public class Interface {

	private static Interface instance;
	private Interface(){}
	
	public static Interface getInstance(){
		if(instance==null){
			instance = new Interface();	
		}
		return instance;
	}
	//Singleton
	
	String[] vetorPedidosAcabados = new String [40]; // vetor com todos pedidos acabados
	
// Dizer a primeira posição livre do vetorPedidosAcabados onde inserir
public int checkPrimeiraPosicoesVazia(String[] str){
		
		int i;
		
		System.out.println("\ncheckPrimeiraPosicoesVazia");
		
		for(i=0; i<str.length;i++){ // pois lenght por exemplo 15, mas começa no zero logo 14 posições
			
			System.out.println("\nentrou for posições vazias");
			
			//System.out.println("\nvalor do primeiro elemento vetor passado função " +str[i] );
			
			// pois no shift esquerda quando quero dizer que está livre faço str[i]="" e fica so o caracter '\0'
			if( ((str[i] == null) || (str[i].length()<=1))){ 
				System.out.printf("\nentrou if \ni: %d str[i]: %s",i,str[i]);
				return i;		
			}
		}
		System.out.println("vetor totalmente cheio");
		return -1; // se vetor pendentes cheio
	}
	
public void adicionaPedidoAcabado(String str){
	
		System.out.printf("\n chegou a adicionar pedido acabado %s", str);
		int posicao=checkPrimeiraPosicoesVazia(vetorPedidosAcabados);
		if( (posicao)!=-1){
			vetorPedidosAcabados[posicao]=str;
			System.out.printf("\nPedido acabado adicionado %s", vetorPedidosAcabados[posicao]);
		}
		else 
			System.out.println("Pedido acabado não adicionado, pois vetor cheio");
	}
	
}
