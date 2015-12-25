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
			System.out.println("\nThread a correr");
			//IMPEDE QUE ARRANQUE COM OUTRA PEÇA
			do{
				a=ModBus.readPLC(0, caminho);
				if(a==1)//Se a passa a 1 significa que já arrancou 
				{
					ModBus.writePLC(caminho, 0);//escreve 0 para impedir que arranque caso haja nova peça
					System.out.println("ESCREVE 0 NO PLC AAAAAAAAAAAA");
					break;
				}
			}
			while(run);
			Interface i=Interface.getInstance();
			//System.out.println(a);
			//Thread.sleep(25000);//sleep 25 segundos
			Thread.sleep(10000);//sleep 10 segundos	
			do{
				b=ModBus.readPLC(0, caminho);
				//System.out.println("ciclo");
				if(b==2 || b==3)
				{
					
					if((caminho>=0 && caminho<=6) || caminho==43 || caminho==44)
					{
						
						if(caminho==0)
						{
							i.np1_mA_c1++;//soma uma peça produzida (P1 em P5) em MA
							i.t_mA_c1=i.t_mA_c1+25;//soma 25 segundos ao tempo da máquina
							System.out.println("numero de peças p1 em MA " +i.np1_mA_c1);
							System.out.println("tempo máquina c1 MA "+i.t_mA_c1);
						}
						else if(caminho==1)
						{
							i.np1_mC_c1++;//soma uma peça produzida (P1 em P2) em MC
							i.t_mC_c1=i.t_mC_c1+25;
						}
						else if(caminho==2)
						{
							i.np1_mC_c1++;//soma uma peça produzida em MC p1 em p2
							i.np2_mA_c1++;//soma uma peça produzida em MC p2 em p3
							i.t_mC_c1=i.t_mC_c1+25;
							i.t_mA_c1=i.t_mA_c1+20;
						}
						else if(caminho==3)
						{
							i.np1_mC_c1++;//soma uma peça produzida em MC p1 em p2
							i.np2_mA_c1++;//soma uma peça produzida em MC p2 em p3
							i.np3_mC_c1++;//soma uma peça produzida em MC p3 em p4
							i.t_mC_c1=i.t_mC_c1+25;
							i.t_mA_c1=i.t_mA_c1+20;
							i.t_mC_c1=i.t_mC_c1+10;
						}
						else if(caminho==4)
						{
							i.np2_mA_c1++;//soma uma peça produzida em MC p2 em p3
							i.t_mA_c1=i.t_mA_c1+20;
						}
						else if(caminho==5) //p2 em p4
						{
							i.np2_mA_c1++;//soma uma peça produzida em MC p2 em p3
							i.np3_mC_c1++;//soma uma peça produzida em MC p3 em p4
							i.t_mA_c1=i.t_mA_c1+20;
							i.t_mC_c1=i.t_mC_c1+10;
						}
						else if(caminho==6)
						{
							i.np3_mC_c1++;//soma uma peça produzida em MC p3 em p4
							i.t_mC_c1=i.t_mC_c1+10;
						}
						else if(caminho==43)
						{
							i.np6_mA_c1++;//p6 em p7
							i.t_mA_c1=i.t_mA_c1+25;
						}
						else if(caminho==44)
						{
							i.np8_mA_c1++;// p8 em p7
							i.t_mC_c1=i.t_mC_c1+30;
						}

						
						EscolheCaminho Caminho=EscolheCaminho.getInstance();//vai buscar objecto Caminho
						Caminho.Celula1.AlteraDisponibilidade();
						System.out.println("Disponibilidade "+Caminho.Celula1.Disponibilidade());
						GestordePedidos Gestor=GestordePedidos.getInstance();  // manda ao gestor pedidos a dizer que acabou 
						Gestor.SinalPedidoAcabado(NO);
					}
					
					else if(caminho>=7 && caminho<=18)
					{
						
						
						if(caminho==7)
						{
							i.np2_mA_c2++;//p2 em p3
							i.t_mA_c2=i.t_mA_c2+20;
						}
						else if(caminho==8)
						{
							i.np1_mA_c2++;
							i.t_mA_c2=i.t_mA_c2+25;
						}
						else if(caminho==9)
						{
							i.np1_mA_c2++;//p1 em p5
							i.np5_mB_c2++;//p5 em p6
							i.t_mA_c2=i.t_mA_c2+25;
							i.t_mB_c2=i.t_mB_c2+25;
						}
						else if(caminho==10)//p1 em p7
						{
							i.np1_mA_c2++;//p1 em p5
							i.np5_mB_c2++;//p5 em p6
							i.np6_mA_c2++;//p6 em p7
							i.t_mA_c2=i.t_mA_c2+25;
							i.t_mB_c2=i.t_mB_c2+25;
							i.t_mA_c2=i.t_mA_c2+25;
							
						}
						else if(caminho==11)//p1 em p8
						{
							i.np1_mA_c2++;//p1 em p5
							i.np5_mB_c2++;//p5 em p8
							i.t_mA_c2=i.t_mA_c2+25;
							i.t_mB_c2=i.t_mB_c2+25;
						}
						else if(caminho==12)//p1 em p9
						{
							i.np1_mA_c2++;//p1 em p5
							i.np5_mB_c2++;//p5 em p8
							i.np8_mB_c2++;//p8 em p9
							i.t_mA_c2=i.t_mA_c2+25;
							i.t_mB_c2=i.t_mB_c2+25;
							i.t_mB_c2=i.t_mB_c2+20;
						}
						else if(caminho==13)//p5 em p6
						{
							i.np5_mB_c2++;//p5 em p6
							i.t_mB_c2=i.t_mB_c2+25;
						}
						else if(caminho==14)//p5 em p7
						{
							i.np5_mB_c2++;//p5 em p6
							i.np6_mA_c2++;//p6 em p7
							i.t_mB_c2=i.t_mB_c2+25;
							i.t_mA_c2=i.t_mA_c2+25;
						}
						else if(caminho==15)//p5 em p8
						{
							i.np5_mB_c2++;//p5 em p8
							i.t_mB_c2=i.t_mB_c2+25;
						}
						else if(caminho==16)//p5 em p9
						{
							i.np5_mB_c2++;//p5 em p8
							i.np8_mB_c2++;//p8 em p9
							i.t_mB_c2=i.t_mB_c2+25;
							i.t_mB_c2=i.t_mB_c2+20;
						}
						else if(caminho==17)//p6 em p7
						{
							i.np6_mA_c2++;//p6 em p7
							i.t_mA_c2=i.t_mA_c2+25;
						}
						else if(caminho==18)//p8 em p8
						{
							i.np8_mB_c2++;//p8 em p9
							i.t_mB_c2=i.t_mB_c2+20;
						}
						
						EscolheCaminho Caminho=EscolheCaminho.getInstance();//vai buscar objecto Caminho
						Caminho.Celula2.AlteraDisponibilidade();
						System.out.println("Disponibilidade "+Caminho.Celula2.Disponibilidade());
						GestordePedidos Gestor=GestordePedidos.getInstance();  // manda ao gestor pedidos a dizer que acabou 
						Gestor.SinalPedidoAcabado(NO);
					}
					
					else if(caminho>=19 && caminho<=30)
					{
						
						if(caminho==19)
						{
							i.np2_mA_c3++;//p2 em p3
							i.t_mA_c3=i.t_mA_c3+20;
						}
						else if(caminho==20)
						{
							i.np1_mA_c3++;//p1 em p5
							i.t_mA_c3=i.t_mA_c3+25;
						}
						else if(caminho==21)
						{
							i.np1_mA_c3++;//p1 em p5
							i.np5_mB_c3++;//p5 em p6
							i.t_mA_c3=i.t_mA_c3+25;
							i.t_mB_c3=i.t_mB_c3+25;
						}
						else if(caminho==22)//p1 em p7
						{
							i.np1_mA_c3++;//p1 em p5
							i.np5_mB_c3++;//p5 em p6
							i.np6_mA_c3++;//p6 em p7
							i.t_mA_c3=i.t_mA_c3+25;
							i.t_mB_c3=i.t_mB_c3+25;
							i.t_mA_c3=i.t_mA_c3+25;
							
						}
						else if(caminho==23)//p1 em p8
						{
							i.np1_mA_c3++;//p1 em p5
							i.np5_mB_c3++;//p5 em p8
							i.t_mA_c3=i.t_mA_c3+25;
							i.t_mB_c3=i.t_mB_c3+25;
						}
						else if(caminho==24)//p1 em p9
						{
							i.np1_mA_c3++;//p1 em p5
							i.np5_mB_c3++;//p5 em p8
							i.np8_mB_c3++;//p8 em p9
							i.t_mA_c3=i.t_mA_c3+25;
							i.t_mB_c3=i.t_mB_c3+25;
							i.t_mB_c3=i.t_mB_c3+20;
						}
						else if(caminho==25)//p5 em p6
						{
							i.np5_mB_c3++;//p5 em p6
							i.t_mB_c3=i.t_mB_c3+25;
						}
						else if(caminho==26)//p5 em p7
						{
							i.np5_mB_c3++;//p5 em p6
							i.np6_mA_c3++;//p6 em p7
							i.t_mB_c3=i.t_mB_c3+25;
							i.t_mA_c3=i.t_mA_c3+25;
						}
						else if(caminho==27)//p5 em p8
						{
							i.np5_mB_c3++;//p5 em p8
							i.t_mB_c3=i.t_mB_c3+25;
						}
						else if(caminho==28)//p5 em p9
						{
							i.np5_mB_c3++;//p5 em p8
							i.np8_mB_c3++;//p8 em p9
							i.t_mB_c3=i.t_mB_c3+25;
							i.t_mB_c3=i.t_mB_c3+20;
						}
						else if(caminho==29)//p6 em p7
						{
							i.np6_mA_c3++;//p6 em p7
							i.t_mA_c3=i.t_mA_c3+25;
						}
						else if(caminho==30)//p8 em p9
						{
							i.np8_mB_c3++;//p8 em p9
							i.t_mB_c3=i.t_mB_c3+20;
						}

						
						EscolheCaminho Caminho=EscolheCaminho.getInstance();//vai buscar objecto Caminho
						Caminho.Celula3.AlteraDisponibilidade();
						System.out.println("Disponibilidade "+Caminho.Celula3.Disponibilidade());
						GestordePedidos Gestor=GestordePedidos.getInstance();  // manda ao gestor pedidos a dizer que acabou 
						Gestor.SinalPedidoAcabado(NO);
					}
					
					else if(caminho>=31 && caminho<=42)
					{
						
						
						if(caminho==31)
						{
							i.np2_mA_c4++;//p2 em p3
							i.t_mA_c4=i.t_mA_c4+20;
						}
						else if(caminho==32)
						{
							i.np1_mA_c4++;//p1 em p5
							i.t_mA_c4=i.t_mA_c4+25;
						}
						else if(caminho==33)
						{
							i.np1_mA_c4++;//p1 em p5
							i.np5_mB_c4++;//p5 em p6
							i.t_mA_c4=i.t_mA_c4+25;
							i.t_mB_c4=i.t_mB_c4+25;
						}
						else if(caminho==34)//p1 em p7
						{
							i.np1_mA_c4++;//p1 em p5
							i.np5_mB_c4++;//p5 em p6
							i.np6_mA_c4++;//p6 em p7
							i.t_mA_c4=i.t_mA_c4+25;
							i.t_mB_c4=i.t_mB_c4+25;
							i.t_mA_c4=i.t_mA_c4+25;
							
						}
						else if(caminho==35)//p1 em p8
						{
							i.np1_mA_c4++;//p1 em p5
							i.np5_mB_c4++;//p5 em p8
							i.t_mA_c4=i.t_mA_c4+25;
							i.t_mB_c4=i.t_mB_c4+25;
						}
						else if(caminho==36)//p1 em p9
						{
							i.np1_mA_c4++;//p1 em p5
							i.np5_mB_c4++;//p5 em p8
							i.np8_mB_c4++;//p8 em p9
							i.t_mA_c4=i.t_mA_c4+25;
							i.t_mB_c4=i.t_mB_c4+25;
							i.t_mB_c4=i.t_mB_c4+20;
						}
						else if(caminho==37)//p5 em p6
						{
							i.np5_mB_c4++;//p5 em p6
							i.t_mB_c4=i.t_mB_c4+25;
						}
						else if(caminho==38)//p5 em p7
						{
							i.np5_mB_c4++;//p5 em p6
							i.np6_mA_c4++;//p6 em p7
							i.t_mB_c4=i.t_mB_c4+25;
							i.t_mA_c4=i.t_mA_c4+25;
						}
						else if(caminho==39)//p5 em p8
						{
							i.np5_mB_c4++;//p5 em p8
							i.t_mB_c4=i.t_mB_c4+25;
						}
						else if(caminho==40)//p5 em p9
						{
							i.np5_mB_c4++;//p5 em p8
							i.np8_mB_c4++;//p8 em p9
							i.t_mB_c4=i.t_mB_c4+25;
							i.t_mB_c4=i.t_mB_c4+20;
						}
						else if(caminho==41)//p6 em p7
						{
							i.np6_mA_c4++;//p6 em p7
							i.t_mA_c4=i.t_mA_c4+25;
						}
						else if(caminho==42)//p8 em p9
						{
							i.np8_mB_c4++;//p8 em p9
							i.t_mB_c4=i.t_mB_c4+20;
						}
						
						EscolheCaminho Caminho=EscolheCaminho.getInstance();//vai buscar objecto Caminho
						Caminho.Celula4.AlteraDisponibilidade();
						System.out.println("Disponibilidade "+Caminho.Celula4.Disponibilidade());
						GestordePedidos Gestor=GestordePedidos.getInstance();  // manda ao gestor pedidos a dizer que acabou 
						Gestor.SinalPedidoAcabado(NO);
					}
					break;
					//ALTERA DISP DA Célula
					
				}
				Thread.sleep(1000);//sleep 5 segundos			
			}
			while(run);
			//fim=true;
			
		}
		catch(Exception e){
			System.out.println("Erro");
			 e.printStackTrace(System.out);
		}
	}
	
}