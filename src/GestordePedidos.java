
public class GestordePedidos {
	
	String[] vetorPedidosPendentes = new String[15]; // apenas pedidos pendentes vai apagando á medida que vai lançando as threads
	int numPedido=0;
	String[] vetorPedidosAcabados = new String [40]; // vetor com todos pedidos acabados	
	
	private static GestordePedidos instance;
	private GestordePedidos(){}
	
	public static GestordePedidos getInstance(){
		if(instance==null){
			instance=new GestordePedidos();	
		}
		return instance;
	}	

	/*
	public void runCicle( String pedido){
	
	}
	 */
	
	public boolean novoPedido(String pedido){
		
		if(numPedido==15){
			
			System.out.println("Vetor pedidos pendentes cheios");
			return false; // vetor espera já cheio, logo fazer pedido
			
		}
		
		else{
			int i=0;
			vetorPedidosPendentes[numPedido]= pedido; //insere a ultima ordem recebida no vetor
			char[] aux = pedido.toCharArray(); // copia a string para um vetor de char's para ser mais fácil aceder a cada caracter
			
			if(aux[1]=='T'){  // Trata-se de uma transformação, e aux[0] é :
				String s = new StringBuilder().append(aux[6]).append(aux[7]).toString(); //junta a quantidade numa string
				int n = Integer.parseInt(s.toString()); //converte para inteiro para criar tantos transforma quantas transformações deste tipo
				
				//boolean fim = false; //era para ficar a true quando pedido fica-se terminado
				
				while(i<n){
					String str = new StringBuilder().append(aux[1]).append(aux[2]).append(aux[3]).toString(); // junta o nº ordem numa string
					int auxiliar = Integer.parseInt(str.toString()); // coverter para inteiro, pois o que recebe transforma
					int auxiliar2 = Character.getNumericValue(aux[4]); //converter char para inteiro
					int auxiliar3 = Character.getNumericValue(aux[5]);
					Transforma novoTransforma=new Transforma(auxiliar, auxiliar2 , auxiliar3); // criar objecto tipo transforma
					i++;//para criar tantos pedidos transforma deste tipo quantos indicados
				}
				System.out.println("Pedido adicionado");
				numPedido++; // atualiza  numPedidos para a seguir inserir na proxima posição
				return true;
			}	
			
			
			
			/*
			if(aux[1]=='M'){  // Trata-se de uma Montagem
				Montagem nomeMontagem=new Montagem(aux[1],aux[2],aux[3]); // criar objecto tipo monta
				System.out.println("Pedido adicionado");
				return true;
			}
			
			if(aux[1]=='D'){  // Trata-se de uma Montagem
				Descarga nomeDescarga=new Descarga(aux[1],aux[2],aux[3]); // criar objecto tipo descarga
				System.out.println("Pedido adicionado");
				return true;
			}	
			
			if(aux[1]=='C'){  // Trata-se de uma Montagem
				Carga nomeCarga=new Carga(aux[1],aux[2],aux[3],aux[0]); // criar objecto tipo carga
				System.out.println("Pedido adicionado");
				return true;
			}		
		}
		*/
		
		
	}
		return false; // no caso de não conseguir criar o objeto que é o novo pedido

  }
	
	
	
	public void removePedidoCompletado(int posicao){
		
		int i;
		
		for(i=0; i<40;i++){ // procura a primeira posiçao livre do vetor com historico de pedidos acabados
			if( (vetorPedidosAcabados[i] == null) && (vetorPedidosAcabados[0].length() == 0) )
			break;
		}
		
		vetorPedidosAcabados[i]=vetorPedidosPendentes[posicao]; //copia para a primeira posição livre 
		shiftEsquerdaVetor(posicao);// retirar do vetor com os pedidos pendentes, o pedido acabado
					
	}
	
	public int procuraPosicao(int NO){
		
		String str = Integer.toString(NO); // converte string para inteiro
		int i;
		
		for(i=0; i<=15; i++){
			if(vetorPedidosPendentes[i].toLowerCase().contains(str.toLowerCase())){ //quando encontrar o elemento do qual se quer saber a posição
				return i; //retorna a possição do elemento no vetor
			}
		}	
		return -1; // quando não encontra elemento
	}
	
	
	
	public void shiftEsquerdaVetor(int posicao){	//recebe a posicao do elemento removido

		for(int i=posicao; i<15; i++){
			vetorPedidosPendentes[i]=vetorPedidosPendentes[i++];
		}
	}
	
	
	public void reordenaVetorPedidos(int posicao){ // quando um pedido não pode ser realizado passa para o fim da fila
		
		String aux;
		aux = vetorPedidosPendentes[posicao];
		shiftEsquerdaVetor(posicao);
		vetorPedidosPendentes[15]=aux;
		
	}
	
}
	
/*tem ainda de ter ciclo para tentar continuadamente introduzir novos pedidos 
 * transforma tem de retornar qq para saber se não conseguiu criar para passar este pedido para o fim da fila
 */
	
	