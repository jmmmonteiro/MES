import java.util.ArrayList;
//import java.util.concurrent.TimeUnit;
import java.util.Date;
import java.util.*;
import java.text.*;


public class GestordePedidos{  
	
	String[] vetorPedidosPendentes = new String[15]; // apenas pedidos pendentes vai apagando � medida que v�o 
	// passando a execu��o 
	int numPedido=0;	
	String[] pedidosEmExecucao = new String[7]; // vetor com apenas pedidos em execucao, como so temos 6 celulas
	//s� pode trabalhar em 6 processos em paralelo
	
	ArrayList <Thread> transformacoes_threads = new ArrayList<Thread>(); //arrayList para transformacoes 
	ArrayList <Integer> transformacoes_threads_elementos = new ArrayList<Integer>(); //para saber qual pedido em que thread
	 
	ArrayList <Thread> montagens_threads = new ArrayList<Thread>();//arrayList para montagens
	ArrayList <Integer> montagens_threads_elementos = new ArrayList<Integer>(); //para saber qual pedido em que thread
	
	ArrayList <Thread> descargas_threads = new ArrayList<Thread>();//arrayList para montagens
	ArrayList <Integer> descargas_threads_elementos = new ArrayList<Integer>(); //para saber qual pedido em que thread
	
	private static GestordePedidos instance;
	private GestordePedidos(){}                                                
	
	public synchronized static GestordePedidos getInstance(){
		if(instance==null){
			instance=new GestordePedidos();	
		}
		return instance;
	}	

//***********************************************************************************************************************************************
// devolve string com hora:minuto:segundos
public synchronized String tempo(){
		
		String hora;
		Date date = new Date();
		SimpleDateFormat ft=new SimpleDateFormat ("HH:mm:ss");
	    hora=ft.format(date);
		
		return hora;
	}	

//fun��o para atualizar a interface
public  synchronized void mandaInterface(int posicao, String pedido, int num){
	
	Interface face=Interface.getInstance();
	String temp=tempo();
	String aux;
	
	if(num==0){//pega no novo pedido inserido acescenta-lhe hora(chegou sistema)+pedido e manda pedido para interface
		
		aux=temp+"                    "+pedido;
		face.adiciona_pedido_pendente(aux);
	}
	else if(num==1){//pega pedido e passa a em execu��o pedido+hora(arranque execu��o)
		
		aux=pedido+"                    "+temp;
		face.adiciona_pedido_execucao(aux);
	}
	else if(num==2){//pega pedido em execu��o acabado e soma-lhe hora atual e manda para inteface pedido acabado
		
		aux=pedido+"                    "+temp;
		face.adicionaPedidoAcabado(aux);
		face.removePedido(posicao, face.pedidosEmExecucaoInterface);
		
	}
	else if(num==3){
		face.removePedido(posicao, face.vetorPedidosPendentesInterface);
	}
	else if(num==4){
		face.removePedido(posicao, face.pedidosEmExecucaoInterface);
	}
	else if(num==5){
		face.reordenaVetor(posicao, face.vetorPedidosPendentesInterface);
	}
	else if(num==6){
		face.reordenaVetor(posicao, face.pedidosEmExecucaoInterface);
	}
	
	//atualiza pedido pendente, pois so parte foi posta em execu��o
	else if(num==100){
		//buscar pedido antigo
		String axu=face.vetorPedidosPendentesInterface[posicao];
		//novo horas do anterior + novo pedido
		face.vetorPedidosPendentesInterface[posicao]="";
		face.vetorPedidosPendentesInterface[posicao]=axu.substring(0, 8)+"                    "+pedido;
		face.reordenaVetor(posicao, face.vetorPedidosPendentesInterface);
	}
	
}

//*****************************************************************************************************************************************************



	
	// inserir novo pedido pendente, MES que solicita                                (VERIFICADA)              
public boolean novoPedidoPendente(String pedido){
	
		//System.outprintln("\nentrou novoPedidoPendente");
		
		int aux=checkPrimeiraPosicoesVazia(vetorPedidosPendentes);
		if( aux==-1){
			//System.outprintln("\nErro imposs�vel inserir vetor pedidos pendentes cheio");
			return false;
		}
		/*
		if( aux==0){
			vetorPedidosPendentes[aux]=pedido; // a fun��o checkPrimeira... devolve a primeira posicao vazia  
			//excepto se a primeira posi��o vazia for zero
			//System.outprintln("Pedido inserido com sucesso");
			return true;
		}
		*/
		else{
			vetorPedidosPendentes[aux]=pedido; // a fun��o checkPrimeira... devolve a primeira posicao vazia 
			//System.outprintf("\nPedido inserido com sucesso %s", vetorPedidosPendentes[aux]);
			////System.outprintln(vetorPedidosPendentes[aux]);
			
//*************************************************************************************************************************************************			
			mandaInterface(0, pedido, 0); //ALTERADO PARA USAR FUN��O PARA MANDAR PARA INTERFACE	
//*************************************************************************************************************************************************			
			return true;
			
		}
		
	}
	
	//encontra a primeira posi��o vazia no vetor ....                          (VERIFICADA) 
public synchronized int checkPrimeiraPosicoesVazia(String[] str){                         //synchronized     <---------
		
		int i;
		
		//System.outprintln("\ncheckPrimeiraPosicoesVazia");
		
		for(i=0; i<str.length;i++){ // pois lenght por exemplo 15, mas come�a no zero logo 14 posi��es
			
			//System.outprintln("\nentrou for posi��es vazias");
			
			////System.outprintln("\nvalor do primeiro elemento vetor passado fun��o " +str[i] );
			
			// pois no shift esquerda quando quero dizer que est� livre fa�o str[i]="" e fica so o caracter '\0'
			if( ((str[i] == null) || (str[i].length()<=1)) /*&& (vetorPedidosPendentes[i].length() == 0)*/ ){ 
				
				//System.outprintf("\nentrou if \ni: %d str[i]: %s",i,str[i]);
				
				/*if(i==0)
				{	
					//System.outprintln("\n 1� posi��o vazia");
					
					return 0;
				}	
				else 
				{
				*/	
					////System.outprintln("\nposi��o diferente 1� vazia");
					return i;
				//}	
			}
		}
		
		//System.outprintln("vetor totalmente cheio");
		
		return -1; // se vetor  cheio
		
	}
	
	//faz um shiftLeft do vetor.....
public synchronized void shiftEsquerdaVetor(int posicao, String[] str/*, int tamanho*/){	//recebe a posicao do elemento removido

	int i=0;
	//System.outprintf("\nchegou a shift left");
	int tamanho=checkPrimeiraPosicoesVazia(str);
	
	if(tamanho==-1){
		if(str.length==15){
			tamanho=15;
		}
		else if(str.length==7){
			tamanho=7;
		}
	}	
	
	//System.outprintf("\nregressou shift esquerda");
	
	tamanho=tamanho-1;
	//System.outprintf("\nvalor do tamnaho %d", tamanho);
	
	i=posicao;
	//System.outprintf("\nvalor da posi��o %d", posicao);
	//System.outprintf("\nvalor de i %d", i);
	
		while(i<=tamanho){
			//System.outprintf("\n entrou left");
			if(i==(tamanho)){ // n�o dava para fazer dentro para ultima posi��o
				//System.outprintln("\nentrou if");
				str[i]="";
				//System.outprintln("valor str");
				//System.outprintln(str[i]);
			}
			if(i!=(tamanho)){
				//System.outprintf("\n entrou else left");
				//System.outprintln("\nvalor str");
				str[i]=str[i+1];
				//System.outprintln(str[i]);
			}
			//System.outprintf("\nvalor do i %d", i);
			//System.outprintf("\nvalor do tamanho %d", tamanho);
			i++;	
		}
	}
	
	//passa o elemento que n�o pode executar para o fim do vetor
public void reordenaVetor(int posicao, String[] str/*, int tamanho*/){ // quando um pedido n�o pode ser realizado passa para o fim da fila
		
		//System.outprintf("\nchegou reordena vetor");
		String aux;
		int finalOndeInserir;
		
		aux = str[posicao];
		//System.outprintf("\n valor aux %s", aux);
		
		shiftEsquerdaVetor(posicao, str /*, tamanho*/);
		//System.outprintf("\n voltou de shift esquerda");
		finalOndeInserir=checkPrimeiraPosicoesVazia(str); //para inserir na primeira posi��o vazia que encontrar
		//System.outprintf("\n onde isnerir %d",finalOndeInserir);
		str[finalOndeInserir]=aux;
		//System.outprintf("\n posi��o onde inserido");
		//System.outprintf(str[finalOndeInserir]);
		
	}
	
	//remover pedido, aplica-se apenas aos em pendente para quando passam para em execu��o
	// e para os em execu��o quando passam a acabados
public synchronized void removePedido(int posicao, String[] str){
		
		//System.outprintf("\n Chegou remove pedido: %s", str[posicao]);
		
		/*str[posicao]=null; // apaga o que estava l� escrito
		//System.outprintf("\n valor str[posicao]");
		//System.outprintf(str[posicao]);
		//System.outprintf("\n valor naquela posi��o que a remover");
		*/
		
		//System.outprintf("\n vai para shift left");
		shiftEsquerdaVetor(posicao, str/*, tamanho*/);// retirar do vetor com os pedidos pendentes, o pedido acabado	
		//System.outprintf("\n chegou de shift left");
		//System.outprintf("\n depois de removido %s", str[posicao]);
		
		
	}
	
	// normalmente para procurar a posi��o do elemento que terminou, que est� no vetor dos elementos em execu��o
public synchronized int procuraPosicao(int NO, String[] nomeVetor/*, int tamanho*/){
		
		//System.outprintf("\n chegou procura posi��o");
		int i;
		int a;
		for(i=0; i<=(nomeVetor.length-1); i++){
			
			a=Integer.parseInt(nomeVetor[i].substring(2, 5));
			//System.outprintf("\n entrou for");
			//System.out.printf("\nvalor do i: %d", i);
			if(a==NO){ //quando encontrar o elemento do qual se quer saber a posi��o
				//System.outprintf("\n valor supostamente igual %s",nomeVetor[i]);
				System.out.printf("\nvalor do i: %d", i);
				return i; //retorna a posi��o do elemento no vetor
			}
		}	
		return -1; // quando n�o encontra elemento
	}

// Mandar para inteface o pedido acabado
public synchronized void SinalPedidoAcabado(int NO){ //synchronized para so uma thread por fazer isto de cada vez
	int a;
	int i;
	for(i=0; i<=(pedidosEmExecucao.length-1); i++){
		
		a=Integer.parseInt(pedidosEmExecucao[i].substring(2, 5));
		//System.outprintf("\n entrou for");
		System.out.printf("\nvalor do i: %d", i);
		if(a==NO){ //quando encontrar o elemento do qual se quer saber a posi��o
			//System.outprintf("\n valor supostamente igual %s",nomeVetor[i]);
			System.out.printf("\nvalor do i: %d", i);
			break; //retorna a posi��o do elemento no vetor
		}
	}	
	
	String auxiliar=pedidosEmExecucao[i];
	//mandar para interface
	//System.outprintf("\nManda para interface %s",pedidosEmExecucao[posicao]);
	
	//DEPOIS SE DER MAL DESCOMENTAR ISTO <+++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++
	//Interface grafica=Interface.getInstance();//vai buscar objecto Interface
	//grafica.adicionaPedidoAcabado(auxiliar);
	
	
	removePedido(i, pedidosEmExecucao);
	
	
//****************************************************************************************************************************************************************	
	mandaInterface(i,auxiliar,2);//mandar pedido acabado e remove tamb�m
//****************************************************************************************************************************************************************	
	
}

	
// Para criar novo pedido em execu��o
public boolean inserePedidosEmExecucao(String pedido){
		
	//System.outprintln("\nchegou vetor pedidos em execu��o");
	//String ss=String.format("valor aux %s na itera��o", pedido);
	//System.outprintln(ss);
	
	
		int i=checkPrimeiraPosicoesVazia(pedidosEmExecucao);
		if(i==-1){
			
			//System.outprintln("Vetor pedidos pendentes cheios");
			return false; // vetor espera j� cheio, logo fazer pedido
			
		}
		
		else{
			
			//System.outprintf("\n entrou 1� else pedidos Em Execu��o");
			
			char[] aux = pedido.toCharArray(); // copia a string para um vetor de char's para ser mais f�cil aceder a cada caracter
			//int j=0, posicao;
			//System.outprintln("\nvalor do vetor de char");
			//System.outprintln(aux);
			
			
			if(aux[1]=='T'){  // Trata-se de uma transforma��o, e aux[0] � :
				
				int j=0, posicao;
				//System.outprintln("\ntrata-se transforma��o");
				//System.outprintln(aux[1]);
				
				
				String s = new StringBuilder().append(aux[7]).append(aux[8]).toString(); //junta a quantidade numa string
				int n = Integer.parseInt(s.toString()); //converte para inteiro para criar tantos transforma quantas transforma��es deste tipo
				//System.outprintf("\nvalor da quantidade � %d:", n);
				
				int caminho, contadorTransformasFeitosDaqueleTipo=0;
				
				while(j<n){
					String str = new StringBuilder().append(aux[2]).append(aux[3]).append(aux[4]).toString(); // junta o n� ordem numa string
					int auxiliar= Integer.parseInt(str.toString()); // coverter para inteiro, pois o que recebe transforma
					
					//System.outprintf("\n NO � %d:", auxiliar);
					int auxiliar2 = Character.getNumericValue(aux[5]); //converter char para inteiro
					//System.outprintf("\n Pe�aOrigem � %d:", auxiliar2);
					int auxiliar3 = Character.getNumericValue(aux[6]);
					//System.outprintf("\n Pe�aFinal � %d:", auxiliar3);
					
					EscolheCaminho Caminho=EscolheCaminho.getInstance();//vai buscar objecto Caminho
					caminho=Caminho.EscolheNovoCaminho('T', auxiliar2, auxiliar3, 0); // 0 , pois n�o se especifica destino
					
					//System.outprintf("\nvalor de caminho %d", caminho);
					//if(j!=0) caminho=0; //DEPOIS TIRAR, S� PARA TESTE
					
					if( caminho>=0){ // se transforma conseguir ter caminho atribuido ent�o fazer:
						
						//System.outprintf("\n Entrou if");
						//System.outprintf("\n o caminho � %d:", caminho);
						contadorTransformasFeitosDaqueleTipo++;
						// criar objecto tipo transforma
						Thread T=new Thread (new Transforma(auxiliar,auxiliar2,auxiliar3,caminho));
						//adiciona-lo ao ArrayList de threads
						transformacoes_threads.add(T);
						//adiciona ao ArrayList de numeros para saber qual o pedido em cada posi��o do vetor de threads
						//ou seja na 1� posi�ao transformacoes_threads_elementos tem o NO da primeira thread para transforma��es 
						transformacoes_threads_elementos.add(auxiliar);
						// pois como insere um de cada vez, apesar n diferente de 1, acho que vale a pena por apenas com n=1
						String numTransformacao = "01";
						String unicaTransformacaoTemp = new StringBuilder().append(aux[0]).append(aux[1]).append(aux[2]).append(aux[3]).append(aux[4]).append(aux[5]).append(aux[6]).toString();
						String pedidoNumCorreto = unicaTransformacaoTemp + numTransformacao;
						
						//caso n�o se queira meter quandidade 1 em cada que se fa�a
						//pedidosEmExecucao[i]=pedido;
						i=checkPrimeiraPosicoesVazia(pedidosEmExecucao);
						pedidosEmExecucao[i]= pedidoNumCorreto; //insere a ultima ordem recebida na 1� posi�ao livre do vetor em execu��o
						//System.outprintf("\n valor pedido inserido: %s", pedidosEmExecucao[i]);
						//System.outprintf("\nvalor de j %d", j);
						
						
//*********************************************************************************************************************************************************************************************						
						mandaInterface(0,pedidoNumCorreto,1);//acresentar pedido em execu��o interface
//*********************************************************************************************************************************************************************************************
						
						
						if(j==(n-1)){ // pois quando insere todos em execu��o apaga de pendentes
							
							//System.outprintf("\n entrou j=n-1");
							posicao=procuraPosicao(auxiliar, vetorPedidosPendentes/*, 15*/); //procura elemento pelo valor NO
							//System.outprintf("\n voltou de procura posi��o");
							//System.outprintf("\n valor posi��o %d", posicao);
							////System.outprintf("\n valor na posi��o %s", vetorPedidosPendentes[posicao]);
							//if(posicao==-1) //System.outprintln("N�o existe esse elemento");
							removePedido(posicao, vetorPedidosPendentes); // s� remove pedido do vetorPedidosPendentes se for so uma transforma deste tipo	
							//System.outprintln("\nvalor pedidos pendentes");
							//System.outprintln(vetorPedidosPendentes[posicao]);
							//System.outprintln("\nvalor pedidos em execu��o");
							//System.outprintln(pedidosEmExecucao[i]);
							
//*******************************************************************************************************************************************************************************************							
							mandaInterface(posicao, null, 3); //remove pedido pendente passado a execu��o da interface
//********************************************************************************************************************************************************************************************							
							
						}
						//arrancar  a thread
						T.start();	
					}
					
					else{ // se transforma n�o conseguir ter caminho atribuido ent�o fazer:
						
						if(n==1){ //se s� um transforma deste tipo e n�o tiver caminho
							
							//System.outprintf("\n else if n==1");
							//System.outprintf("\n valor de n � %d:", n);
							posicao=procuraPosicao(auxiliar, vetorPedidosPendentes/*, 15*/); //procura elemento pelo valor NO
							//System.outprintf("regressou pedidosEmExecu��o");
							//System.outprintf("\n valor posi��o %d", posicao);
							//System.outprintf("\n valor na posi��o %s", vetorPedidosPendentes[posicao]);
							//if(posicao==-1) //System.outprintln("N�o existe esse elemento");
							reordenaVetor(posicao, vetorPedidosPendentes/*, 15*/); //passar pedido para final do vetor pedidosPendentes
							//System.outprintf("\nvoltou do reordena");
							//System.outprintf("\n valor do contador ciclo � %d:", j);
							
							
//***************************************************************************************************************************************************************************************							
							mandaInterface(posicao,null,5); //reordena vetor pedidos pendentes da interface
//***********************************************************************************************************************************************************************************
							
							
							return false;
						}
						else{ 
							
							//System.outprintf("\n entrou else if com n diferente 1");
							//System.outprintf("\n valor de n � %d:", n);
							//mais do que um transforma do mesmo tipo, mas n�o consegui criar todos
							//atualiza a quantidade que tem de fazer
							posicao=procuraPosicao(auxiliar, vetorPedidosPendentes/*, 15*/); //procura elemneto pelo valor NO
							//System.outprintf("\n valor posi��o %d", posicao);
							//System.outprintf("\n valor na posi��o %s", vetorPedidosPendentes[posicao]);
							//if(posicao==-1) //System.outprintln("N�o existe esse elemento");
							int novaQuantidade=n-contadorTransformasFeitosDaqueleTipo;
							//System.outprintf("\n valor quantidade %d", novaQuantidade);
							String temp = String.valueOf(novaQuantidade); //novo valor para a quantdade a inserir
							//System.outprintf("\n valor string temp");
							//System.outprintf(temp);
							//System.outprintln("\ntamanho string quantidade");
							//System.outprintln(temp.length());
							if(temp.length()==1){ // pois caso numero transforma n�o atinja dezenas tenho de por zero antes
								String temp2 = '0'+ temp;
								//System.outprintln("\nstring temp");
								//System.outprintln(temp2);
								temp=temp2;
							}
							//vai buscar todos os outros chars que se mant�m
							String pedidoAlteradoTemp = new StringBuilder().append(aux[0]).append(aux[1]).append(aux[2]).append(aux[3]).append(aux[4]).append(aux[5]).append(aux[6]).toString();
							//System.outprintf("\n valor string pedidoAlteradoTemp");
							//System.outprintf(pedidoAlteradoTemp);
							//string como o pedido atualizado para o n de transformas daquele tipo que falta
							String pedidoAlteradoDefinitivo = new StringBuilder().append(pedidoAlteradoTemp).append(temp).toString();
							//System.outprintf("\n valor string pedidoAlteradoDefinitivo");
							//System.outprintf(pedidoAlteradoDefinitivo);
							//atualiza o pedido
							vetorPedidosPendentes[posicao]=pedidoAlteradoDefinitivo;
							//System.outprintf("\n novo valor pedido atualizado/alterado");
							//System.outprintf(vetorPedidosPendentes[posicao]);
							//para assim meter no final da fila o pedido que n�o consegui executar
							reordenaVetor(posicao, vetorPedidosPendentes);
							//System.outprintf("\n valor do contador ciclo � %d:", j);
							
							
//******************************************************************************************************************************************************************************************							
							mandaInterface(posicao,pedidoAlteradoDefinitivo,100);
//***************************************************************************************************************************************************************************************							
							
							return false;
						}
						
					}
					
					j++;//para criar tantos pedidos transforma deste tipo quantos indicados
					
				}
				//System.outprintf("\n valor do contador ciclo � %d:", j);
				//System.outprintf("\nvalores pedidos pendentes");
				return true;
			}	
			
			if(aux[1]=='M'){  // Trata-se de uma Montagem
				
				//System.outprintln("\ntrata-se Montagem");
				//System.outprintln(aux[1]);
				int j=0, posicao;
				
				String s = new StringBuilder().append(aux[7]).append(aux[8]).toString(); //junta a quantidade numa string
				int n = Integer.parseInt(s.toString()); //converte para inteiro para criar tantos Montagem quantas Montagem deste tipo
				//System.outprintf("\nvalor da quantidade � %d:", n);
				
				int caminho, contadorMontagemFeitosDaqueleTipo=0;
				
				while(j<n){
					String str = new StringBuilder().append(aux[2]).append(aux[3]).append(aux[4]).toString(); // junta o n� ordem numa string
					int auxiliar= Integer.parseInt(str.toString()); // coverter para inteiro, pois o que recebe Montagem
					
					//System.outprintf("\n NO � %d:", auxiliar);
					int auxiliar2 = Character.getNumericValue(aux[5]); //converter char para inteiro
					//System.outprintf("\n Pe�aBaixo � %d:", auxiliar2);
					int auxiliar3 = Character.getNumericValue(aux[6]);
					//System.outprintf("\n Pe�aCima � %d:", auxiliar3);
					
					EscolheCaminho Caminho=EscolheCaminho.getInstance();//vai buscar objecto Caminho
					caminho=Caminho.EscolheNovoCaminho('M', auxiliar2, auxiliar3, 0); // 0 , pois n�o se especifica destino
					
					//System.outprintf("\nvalor de caminho %d", caminho);
					if( caminho>=0){ // se montagem conseguir ter caminho atribuido ent�o fazer:
						
						//System.outprintf("\n Entrou if");
						//System.outprintf("\n o caminho � %d:", caminho);
						contadorMontagemFeitosDaqueleTipo++;
						// criar objecto tipo montagem
						Thread T=new Thread (new Montagem(auxiliar,auxiliar2,auxiliar3));
						//adiciona-lo ao ArrayList de threads
						montagens_threads.add(T);
						//adiciona ao ArrayList de numeros para saber qual o pedido em cada posi��o do vetor de threads
						//ou seja na 1� posi�ao montagem_threads_elementos tem o NO da primeira thread para montagens 
						montagens_threads_elementos.add(auxiliar);
						// pois como insere um de cada vez, apesar n diferente de 1, acho que vale a pena por apenas com n=1
						String numMontagem = "01";
						String unicaMontagemTemp = new StringBuilder().append(aux[0]).append(aux[1]).append(aux[2]).append(aux[3]).append(aux[4]).append(aux[5]).append(aux[6]).toString();
						String pedidoNumCorreto = unicaMontagemTemp + numMontagem;
						
						//caso n�o se queira meter quandidade 1 em cada que se fa�a
						//pedidosEmExecucao[i]=pedido;
						i=checkPrimeiraPosicoesVazia(pedidosEmExecucao);
						pedidosEmExecucao[i]= pedidoNumCorreto; //insere a ultima ordem recebida na 1� posi�ao livre do vetor em execu��o
						//System.outprintf("\n valor pedido inserido");
						//System.outprintf(pedidosEmExecucao[i]);
						
						
//*********************************************************************************************************************************************************************************************						
						mandaInterface(0,pedidoNumCorreto,1);//acresentar pedido em execu��o interface
//*********************************************************************************************************************************************************************************************
						
	
						if(j==(n-1)){ // pois quando insere todos em execu��o apaga de pendentes
							
							//System.outprintf("\n entrou j=n-1");
							posicao=procuraPosicao(auxiliar, vetorPedidosPendentes/*, 15*/); //procura elemento pelo valor NO
							//System.outprintf("\n voltou de procura posi��o");
							//System.outprintf("\n valor posi��o %d", posicao);
							////System.outprintf("\n valor na posi��o %s", vetorPedidosPendentes[posicao]);
							//if(posicao==-1) //System.outprintln("N�o existe esse elemento");
							removePedido(posicao, vetorPedidosPendentes); // s� remove pedido do vetorPedidosPendentes se for so uma montagem deste tipo	
							//System.outprintln("\nvalor pedidos pendentes");
							//System.outprintln(vetorPedidosPendentes[posicao]);
							//System.outprintln("\nvalor pedidos em execu��o");
							//System.outprintln(pedidosEmExecucao[i]);
													
							
//*******************************************************************************************************************************************************************************************							
							mandaInterface(posicao, null, 3); //remove pedido pendente passado a execu��o da interface
//********************************************************************************************************************************************************************************************														
							
														
						}
						
						//arrancar  a thread
						T.start();	
					}
					else{ // se montagem n�o conseguir ter caminho atribuido ent�o fazer:
						
						if(n==1){ //se s� um montagem deste tipo e n�o tiver caminho
							
							//System.outprintf("\n else if n==1");
							//System.outprintf("\n valor de n � %d:", n);
							posicao=procuraPosicao(auxiliar, vetorPedidosPendentes/*, 15*/); //procura elemento pelo valor NO
							//System.outprintf("\nregressou pedidosEmExecu��o");
							//System.outprintf("\n valor posi��o %d", posicao);
							//System.outprintf("\n valor na posi��o %s", vetorPedidosPendentes[posicao]);
							//if(posicao==-1) //System.outprintln("N�o existe esse elemento");
							reordenaVetor(posicao, vetorPedidosPendentes/*, 15*/); //passar pedido para final do vetor pedidosPendentes
							//System.outprintf("\nvoltou do reordena");
							//System.outprintf("\n valor do contador ciclo � %d:", j);
							
		
//***************************************************************************************************************************************************************************************							
							mandaInterface(posicao,null,5); //reordena vetor pedidos pendentes da interface
//***********************************************************************************************************************************************************************************
														
							
							return false;
						}
						
						else{ //
							
							//System.outprintf("\n entrou else if com n diferente 1");
							//System.outprintf("\n valor de n � %d:", n);
							//mais do que um montagem do mesmo tipo, mas n�o consegui criar todos
							//atualiza a quantidade que tem de fazer
							posicao=procuraPosicao(auxiliar, vetorPedidosPendentes/*, 15*/); //procura elemneto pelo valor NO
							//System.outprintf("\n valor posi��o %d", posicao);
							//System.outprintf("\n valor na posi��o %s", vetorPedidosPendentes[posicao]);
							//if(posicao==-1) //System.outprintln("N�o existe esse elemento");
							int novaQuantidade=n-contadorMontagemFeitosDaqueleTipo;
							//System.outprintf("\n valor quantidade %d", novaQuantidade);
							String temp = String.valueOf(novaQuantidade); //novo valor para a quantdade a inserir
							//System.outprintf("\n valor string temp");
							//System.outprintf(temp);
							//System.outprintln("\ntamanho string quantidade");
							//System.outprintln(temp.length());
							if(temp.length()==1){ // pois caso numero montagem n�o atinja dezenas tenho de por zero antes
								String temp2 = '0'+ temp;
								//System.outprintln("\nstring temp");
								//System.outprintln(temp2);
								temp=temp2;
							}
							//vai buscar todos os outros chars que se mant�m
							String pedidoAlteradoTemp = new StringBuilder().append(aux[0]).append(aux[1]).append(aux[2]).append(aux[3]).append(aux[4]).append(aux[5]).append(aux[6]).toString();
							//System.outprintf("\n valor string pedidoAlteradoTemp");
							//System.outprintf(pedidoAlteradoTemp);
							//string como o pedido atualizado para o n de montagens daquele tipo que falta
							String pedidoAlteradoDefinitivo = new StringBuilder().append(pedidoAlteradoTemp).append(temp).toString();
							//System.outprintf("\n valor string pedidoAlteradoDefinitivo");
							//System.outprintf(pedidoAlteradoDefinitivo);
							//atualiza o pedido
							vetorPedidosPendentes[posicao]=pedidoAlteradoDefinitivo;
							//System.outprintf("\n novo valor pedido atualizado/alterado");
							//System.outprintf(vetorPedidosPendentes[posicao]);
							//para assim meter no final da fila o pedido que n�o consegui executar
							reordenaVetor(posicao, vetorPedidosPendentes);
							//System.outprintf("\n valor do contador ciclo � %d:", j);
							
							
//******************************************************************************************************************************************************************************************							
							mandaInterface(posicao,pedidoAlteradoDefinitivo,100);
//***************************************************************************************************************************************************************************************							
							
							
							
							return false;
						}
					
				    }
					j++;//para criar tantos pedidos transforma deste tipo quantos indicados
					//System.outprintf("\n valor do contador ciclo � %d:", j);
					//System.outprintf("\nvalores pedidos pendentes");
					
			}
			return true;	
		}
		if(aux[1]=='U'){ // Trata-se de uma Descarga
			
			//System.outprintln("\ntrata-se Descarga");
			//System.outprintln(aux[1]);
			int j=0, posicao;
			
			String s = new StringBuilder().append(aux[7]).append(aux[8]).toString(); //junta a quantidade numa string
			int n = Integer.parseInt(s.toString()); //converte para inteiro para criar tantos Montagem quantas Montagem deste tipo
			//System.outprintf("\nvalor da quantidade � %d:", n);
			
			int caminho, contadorDescargaFeitosDaqueleTipo=0;
			
			while(j<n){
				String str = new StringBuilder().append(aux[2]).append(aux[3]).append(aux[4]).toString(); // junta o n� ordem numa string
				int auxiliar= Integer.parseInt(str.toString()); // coverter para inteiro, pois o que recebe Descarga
				
				//System.outprintf("\n NO � %d:", auxiliar);
				int auxiliar2 = Character.getNumericValue(aux[5]); //converter char para inteiro
				//System.outprintf("\n Pe�aBaixo � %d:", auxiliar2);
				int auxiliar3 = Character.getNumericValue(aux[6]);
				//System.outprintf("\n Destino � %d:", auxiliar3);
				
				EscolheCaminho Caminho=EscolheCaminho.getInstance();//vai buscar objecto Caminho
				caminho=Caminho.EscolheNovoCaminho('U', auxiliar2, 0 ,auxiliar3); // 0 , pois n�o se especifica Pe�a destino
				
				//System.outprintf("\nvalor de caminho %d", caminho);
				if( caminho>=0){ // se montagem conseguir ter caminho atribuido ent�o fazer:
					
					//System.outprintf("\n Entrou if");
					//System.outprintf("\n o caminho � %d:", caminho);
					contadorDescargaFeitosDaqueleTipo++;
					// criar objecto tipo descarga
					Thread T=new Thread (new Descarga(auxiliar,auxiliar2,auxiliar3, caminho));
					//adiciona-lo ao ArrayList de threads
					descargas_threads.add(T);
					//adiciona ao ArrayList de numeros para saber qual o pedido em cada posi��o do vetor de threads
					//ou seja na 1� posi�ao descarga_threads_elementos tem o NO da primeira thread para descargas 
					descargas_threads_elementos.add(auxiliar);
					// pois como insere um de cada vez, apesar n diferente de 1, acho que vale a pena por apenas com n=1
					String numDescarga = "01";
					String unicaDescargaTemp = new StringBuilder().append(aux[0]).append(aux[1]).append(aux[2]).append(aux[3]).append(aux[4]).append(aux[5]).append(aux[6]).toString();
					String pedidoNumCorreto = unicaDescargaTemp + numDescarga;
					
					//caso n�o se queira meter quandidade 1 em cada que se fa�a
					//pedidosEmExecucao[i]=pedido;
					i=checkPrimeiraPosicoesVazia(pedidosEmExecucao);
					pedidosEmExecucao[i]= pedidoNumCorreto; //insere a ultima ordem recebida na 1� posi�ao livre do vetor em execu��o
					//System.outprintf("\n valor pedido inserido");
					//System.outprintf(pedidosEmExecucao[i]);
					
					
//*********************************************************************************************************************************************************************************************						
					mandaInterface(0,pedidoNumCorreto,1);//acresentar pedido em execu��o interface
//*********************************************************************************************************************************************************************************************
					
					
					
					if(j==(n-1)){ // pois quando insere todos em execu��o apaga de pendentes
						
						//System.outprintf("\n entrou j=n-1");
						posicao=procuraPosicao(auxiliar, vetorPedidosPendentes/*, 15*/); //procura elemento pelo valor NO
						//System.outprintf("\n voltou de procura posi��o");
						//System.outprintf("\n valor posi��o %d", posicao);
						////System.outprintf("\n valor na posi��o %s", vetorPedidosPendentes[posicao]);
						//if(posicao==-1) //System.outprintln("N�o existe esse elemento");
						removePedido(posicao, vetorPedidosPendentes); // s� remove pedido do vetorPedidosPendentes se for so uma montagem deste tipo	
						//System.outprintln("\nvalor pedidos pendentes");
						//System.outprintln(vetorPedidosPendentes[posicao]);
						//System.outprintln("\nvalor pedidos em execu��o");
						//System.outprintln(pedidosEmExecucao[i]);
						
						
						
//*******************************************************************************************************************************************************************************************							
						mandaInterface(posicao, null, 3); //remove pedido pendente passado a execu��o da interface
//********************************************************************************************************************************************************************************************	
						
						
					}
					
					//arrancar  a thread
					T.start();	
					
				}
				else{ // se descarga n�o conseguir ter caminho atribuido ent�o fazer:
					
					if(n==1){ //se s� um descarga deste tipo e n�o tiver caminho
						
						//System.outprintf("\n else if n==1");
						//System.outprintf("\n valor de n � %d:", n);
						posicao=procuraPosicao(auxiliar, vetorPedidosPendentes/*, 15*/); //procura elemento pelo valor NO
						//System.outprintf("regressou pedidosEmExecu��o");
						//System.outprintf("\n valor posi��o %d", posicao);
						//System.outprintf("\n valor na posi��o %s", vetorPedidosPendentes[posicao]);
						//if(posicao==-1) //System.outprintln("N�o existe esse elemento");
						reordenaVetor(posicao, vetorPedidosPendentes/*, 15*/); //passar pedido para final do vetor pedidosPendentes
						//System.outprintf("\nvoltou do reordena");
						//System.outprintf("\n valor do contador ciclo � %d:", j);
						
						
//***************************************************************************************************************************************************************************************							
						mandaInterface(posicao,null,5); //reordena vetor pedidos pendentes da interface
//***********************************************************************************************************************************************************************************
						
						
						
						return false;
					}
					
					else{ //
						
						//System.outprintf("\n entrou else if com n diferente 1");
						//System.outprintf("\n valor de n � %d:", n);
						//mais do que um descarga do mesmo tipo, mas n�o consegui criar todos
						//atualiza a quantidade que tem de fazer
						posicao=procuraPosicao(auxiliar, vetorPedidosPendentes/*, 15*/); //procura elemento pelo valor NO
						//System.outprintf("\n valor posi��o %d", posicao);
						//System.outprintf("\n valor na posi��o %s", vetorPedidosPendentes[posicao]);
						//if(posicao==-1) //System.outprintln("N�o existe esse elemento");
						int novaQuantidade=n-contadorDescargaFeitosDaqueleTipo;
						//System.outprintf("\n valor quantidade %d", novaQuantidade);
						String temp = String.valueOf(novaQuantidade); //novo valor para a quantidade a inserir
						//System.outprintf("\n valor string temp");
						//System.outprintf(temp);
						//System.outprintln("\ntamanho string quantidade");
						//System.outprintln(temp.length());
						if(temp.length()==1){ // pois caso numero montagem n�o atinja dezenas tenho de por zero antes
							String temp2 = '0'+ temp;
							//System.outprintln("\nstring temp");
							//System.outprintln(temp2);
							temp=temp2;
						}
						//vai buscar todos os outros chars que se mant�m
						String pedidoAlteradoTemp = new StringBuilder().append(aux[0]).append(aux[1]).append(aux[2]).append(aux[3]).append(aux[4]).append(aux[5]).append(aux[6]).toString();
						//System.outprintf("\n valor string pedidoAlteradoTemp");
						//System.outprintf(pedidoAlteradoTemp);
						//string como o pedido atualizado para o n de montagens daquele tipo que falta
						String pedidoAlteradoDefinitivo = new StringBuilder().append(pedidoAlteradoTemp).append(temp).toString();
						//System.outprintf("\n valor string pedidoAlteradoDefinitivo");
						//System.outprintf(pedidoAlteradoDefinitivo);
						//atualiza o pedido
						vetorPedidosPendentes[posicao]=pedidoAlteradoDefinitivo;
						//System.outprintf("\n novo valor pedido atualizado/alterado");
						//System.outprintf(vetorPedidosPendentes[posicao]);
						//para assim meter no final da fila o pedido que n�o consegui executar
						reordenaVetor(posicao, vetorPedidosPendentes);
						//System.outprintf("\n valor do contador ciclo � %d:", j);
						
						
//******************************************************************************************************************************************************************************************							
						mandaInterface(posicao,pedidoAlteradoDefinitivo,100);
//***************************************************************************************************************************************************************************************							
						
						
						return false;
					}
				
			    }	
				j++;//para criar tantos pedidos transforma deste tipo quantos indicados
				//System.outprintf("\n valor do contador ciclo � %d:", j);
				
			}	
			
		 return true;
		}
	
	//System.outprintln("ERRO, pedido para inserir n�o � Transforma, nem Montagem, nem Descarga");	
	return false; // no caso de n�o ser nem transforma��o, nem montagem, nem descarga	
	}
		

}//pedido carga � o plc que gere
	
	
	//Correr uma vez para tentar passar todos os pedidos possivies de pendentes a execu��o 
	// e para passar todos os pedidos de em execu��o para acabados, caso terminados 

public void runCicle () throws InterruptedException{                                                 
			
		//System.outprintln("\nrunCicle");
		
			//int i;
			boolean j;
			
			//inserir um pedido vetor pendentes para ver se funciona
			//vetorPedidosPendentes[0]=":T0012002";
			
			int aux=checkPrimeiraPosicoesVazia(vetorPedidosPendentes); // ou pedidosEmExecucao
			//aux valor da primeira posi��o vazia
			
			
			//System.outprintln("\nvolta runCicle");
			//System.outprintln("\nvalor aux " +aux);
			
			if(aux==0){ // vetor totalmente vazio
				//System.outprintln("\nN�o h� pedidos pendentes");
				return; //pode n�o dar
			}	
			else{ //sabemos ultima posi��o ocupada 
				
				//System.outprintln("\nentrou else runCicle");
				
				/*if(aux==-1){
					aux=14; // para se estiver cheio ter de ver at� ao tamanho de vetorPedidosPendentes
					//System.outprintln("\nvetor pendentes cheio");
				}
				*/
				//for(i=0; i<=(aux-1); i++){  //pois diz at� � primeira posi��o livre logo -1 para ultima ocupada
					
					String str=vetorPedidosPendentes[0];
					
					//System.outprintf("\nvalor string %s na itera��o 0", str);
					//String s=String.format("\nvalor string %s na itera��o %d", str, 0);
					////System.outprintln(s);
					
					j=inserePedidosEmExecucao(str);
					if(j==true){
						//System.outprintln("\nNovo pedido em execu��o adicionado");	
						//esta a dizer que est� a inserir, mesmo que n>2 e n�o insira nenhum pq retorna true fun��o
						//mas vendo pelos printfs dentro do pedidos em execu��o ve-se o que insere ou n�o
					}
					else {
						//System.outprintln("\nNovo pedido n�o tem recursos disponiveis, passado para fim da fila existente");							
					}
					
					//System.outprintf("\nvetor pendentes");
					//System.outprintf("\n 0: %s", vetorPedidosPendentes[0]);
					//System.outprintf("\n 1: %s", vetorPedidosPendentes[1]);
					//System.outprintf("\n 2: %s", vetorPedidosPendentes[2]);
					//System.outprintf("\n 3: %s", vetorPedidosPendentes[3]);
					//System.outprintf("\n 4: %s", vetorPedidosPendentes[4]);
					//System.outprintf("\n 5: %s", vetorPedidosPendentes[5]);
					//System.outprintf("\n 6: %s", vetorPedidosPendentes[6]);
					//System.outprintf("\n 7: %s", vetorPedidosPendentes[7]);
					//System.outprintf("\n 8: %s", vetorPedidosPendentes[8]);
					//System.outprintf("\n 9: %s", vetorPedidosPendentes[9]);
					//System.outprintf("\n 10: %s", vetorPedidosPendentes[10]);
					//System.outprintf("\n 11: %s", vetorPedidosPendentes[11]);
					//System.outprintf("\n 12: %s", vetorPedidosPendentes[12]);
					//System.outprintf("\n 13: %s", vetorPedidosPendentes[13]);
					////System.outprintf("\n 14: %s", vetorPedidosPendentes[14]);
					//System.outprintf("\nvetor em execu��o");
					//System.outprintf("\n 0: %s", pedidosEmExecucao[0]);
					//System.outprintf("\n 1: %s", pedidosEmExecucao[1]);
					//System.outprintf("\n 2: %s", pedidosEmExecucao[2]);
					//System.outprintf("\n 3: %s", pedidosEmExecucao[3]);
					//System.outprintf("\n 4: %s", pedidosEmExecucao[4]);
					//System.outprintf("\n 5: %s", pedidosEmExecucao[5]);		
			}
			
			
			//verificar todos pedidos em execu��o, e os que tiverem acabados, tenho de retirar do em execu��o 
			//e passar para acabados	
			
	}

}