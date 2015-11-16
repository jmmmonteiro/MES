public class GestordePedidos {
	
	String[] vetorPedidosPendentes = new String[15]; // apenas pedidos pendentes vai apagando á medida que vai lançando as threads
	int numPedido=0;
	
	
	
	private static GestordePedidos instance;
	private GestordePedidos(){}
	
	public static GestordePedidos getInstance(){
		if(instance==null){
			instance=new GestordePedidos();	
		}
		return instance;
	}	


	public boolean novoPedido(String pedido){
		
		if(numPedido==15){
			
			System.out.println("Vetor pedidos pendentes cheios");
			return false;
			
		}
		
		else{
			int i=0;
			vetorPedidosPendentes[numPedido]= pedido; //insere a ultima ordem recebida no vetor
			char[] aux = pedido.toCharArray(); // copia a string para um vetor de char's para ser mais fácil aceder a cada caracter
			
			if(aux[1]=='T'){  // Trata-se de uma transformação
				String s = new StringBuilder().append(aux[6]).append(aux[7]).toString(); //junta a quantidade numa string
				int n = Integer.parseInt(s.toString()); //converte para inteiro para criar tantos transforma quantas transformações deste tipo
				boolean fim = false;
				
				while(i<n){
					String str = new StringBuilder().append(aux[1]).append(aux[2]).append(aux[3]).toString(); // junta o nº ordem numa string
					int auxiliar = Integer.parseInt(str.toString()); // coverter para inteiro, pois o que recebe transforma
					int auxiliar2 = Character.getNumericValue(aux[4]); //converter char para inteiro
					int auxiliar3 = Character.getNumericValue(aux[5]);
					Transforma novoTransforma=new Transforma(auxiliar, auxiliar2 , auxiliar3, 't',  fim); // criar objecto tipo transforma
					i++;//para criar tantos pedidos transforma deste tipo quantos indicados
				}
				System.out.println("Pedido adicionado");
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
		
		numPedido++; // atuaiza  num pedidos para a seguir inserir na proxima posição
	}

  }
	
	
	public boolean removePedidoCompletado(int numOrdem){
	
			// retirar do vetor com os pedidos pendentes este 
			return true // se realizado com sucesso 
			// inserir no vetor que terá historico de todos pedidos executados		
	}
}
	
	
	
