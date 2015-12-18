//Classe Singleton - só existe um objecto 
public class EscolheCaminho {
	//criar Células
	Celula Celula1=new Celula();
	Celula Celula2=new Celula();
	Celula Celula3=new Celula();
	Celula Celula4=new Celula();
	Celula Celula5=new Celula();
	Celula Celula6=new Celula();
	Celula Celula7=new Celula();
	public boolean Robot;//Indica se usa Robot
	//Singleton
	private static EscolheCaminho instance;
	private EscolheCaminho(){}
	
	public synchronized static EscolheCaminho getInstance(){
		if(instance==null){
			instance=new EscolheCaminho();	
		}
		return instance;
	}
	//Singleton

	//Escolhe Novo Caminho
	public int EscolheNovoCaminho(char tipo, int PO, int PF, int destino){
		if(tipo=='T'){//Testa todos os caminhos possiveis para transformação
			if(PO==1 && PF==5){//Pode ser transformada em qualquer célula de transformação
				if(Celula1.Disponibilidade()==true){//Verifica disponibilidade célula 1	
					Celula1.AlteraDisponibilidade();
					return 0; //0
				}
				else if(Celula2.Disponibilidade()==true){//Verifica disponibilidade célula 2	
					Celula2.AlteraDisponibilidade();
					return 8;//8
				}
				else if(Celula3.Disponibilidade()==true){//Verifica disponibilidade célula 3	
					Celula3.AlteraDisponibilidade();
					return 20;//20
				}
				else if(Celula4.Disponibilidade()==true){//Verifica disponibilidade célula 4	
					Celula4.AlteraDisponibilidade();
					return 32;
				}
				else{
					return -1;//Não há células disponiveis para este pedido
				}
			}	
			else if(PO==1 && PF==2){//Só pode ser transformada na Célula 1
				if(Celula1.Disponibilidade()==true){//Verifica disponibilidade célula 1	
					Celula1.AlteraDisponibilidade();
					return 1;//1
				}
				else{//Não há células disponiveis para este pedido
					return -1;
				}
			}
			else if(PO==1 && PF==3){//Só pode ser transformada na Célula 1
				if(Celula1.Disponibilidade()==true){//Verifica disponibilidade célula 1
					Celula1.AlteraDisponibilidade();
					return 2;//2 
				}
				else{//Não há células disponiveis para este pedido
					return -1;
				}	
			}
			else if(PO==1 && PF==4){//Só pode ser transformada na Célula 1
				if(Celula1.Disponibilidade()==true){//Verifica disponibilidade célula 1	
					Celula1.AlteraDisponibilidade();
					return 3; //3
				}
				else{//Não há células disponiveis para este pedido
					return -1;
				}
			}
			else if(PO==1 && PF==6){//Só pode ser transformada por C2,C3,C4
				if(Celula2.Disponibilidade()==true){//Verifica disponibilidade célula 2	
					Celula2.AlteraDisponibilidade();
					return 9;//9
				}
				else if(Celula3.Disponibilidade()==true){//Verifica disponibilidade célula 3
					Celula3.AlteraDisponibilidade();
					return -1; //21
				}
				else if(Celula4.Disponibilidade()==true){//Verifica disponibilidade célula 4	
					Celula4.AlteraDisponibilidade();
					return 33;
				}
				else{
					return -1;//Não há células disponiveis para este pedido
				}
			}
			else if(PO==1 && PF==7){//Só pode ser transformada por C2,C3,C4
				if(Celula2.Disponibilidade()==true){//Verifica disponibilidade célula 2	
					Celula2.AlteraDisponibilidade();
					return 10; //10
				}
				else if(Celula3.Disponibilidade()==true){//Verifica disponibilidade célula 3
					Celula3.AlteraDisponibilidade();
					return 22; //22
				}
				else if(Celula4.Disponibilidade()==true){//Verifica disponibilidade célula 4	
					Celula4.AlteraDisponibilidade();
					return 34;
				}
				else{
					return -1;//Não há células disponiveis para este pedido
				}
			}
			else if(PO==1 && PF==8){//Só pode ser transformada por C2,C3,C4
				if(Celula2.Disponibilidade()==true){//Verifica disponibilidade célula 2	
					Celula2.AlteraDisponibilidade();
					return 11;//11
				}
				else if(Celula3.Disponibilidade()==true){//Verifica disponibilidade célula 3
					Celula3.AlteraDisponibilidade();
					return 23;//23
				}
				else if(Celula4.Disponibilidade()==true){//Verifica disponibilidade célula 4	
					Celula4.AlteraDisponibilidade();
					return 35;
				}
				else{
					return -1;//Não há células disponiveis para este pedido
				}
			}
			else if(PO==1 && PF==9){//Só pode ser transformada por C2,C3,C4
				if(Celula2.Disponibilidade()==true){//Verifica disponibilidade célula 2	
					Celula2.AlteraDisponibilidade();
					return 12; //12
				}
				else if(Celula3.Disponibilidade()==true){//Verifica disponibilidade célula 3	
					Celula3.AlteraDisponibilidade();
					return 24; //24
				}
				else if(Celula4.Disponibilidade()==true){//Verifica disponibilidade célula 4	
					Celula4.AlteraDisponibilidade();
					return 36;
				}
				else{
					return -1;//Não há células disponiveis para este pedido
				}
			}
			else if(PO==2 && PF==4){//Só pode ser transformada na Célula 1
				if(Celula1.Disponibilidade()==true){//Verifica disponibilidade célula 1	
					Celula1.AlteraDisponibilidade();
					return 5; //5
				}
				else{//Não há células disponiveis para este pedido
					return -1;
				}	
			}
			else if(PO==2 && PF==3){//Pode ser transformada em qualquer célula de transformação
				if(Celula1.Disponibilidade()==true){//Verifica disponibilidade célula 1	
					Celula1.AlteraDisponibilidade();
					return 4; //4
				}
				else if(Celula2.Disponibilidade()==true){//Verifica disponibilidade célula 2	
					Celula2.AlteraDisponibilidade();
					return 7;//7
				}
				else if(Celula3.Disponibilidade()==true){//Verifica disponibilidade célula 3	
					Celula3.AlteraDisponibilidade();
					return 19;//19
				}
				else if(Celula4.Disponibilidade()==true){//Verifica disponibilidade célula 4	
					Celula4.AlteraDisponibilidade();
					return 31;
				}
				else{
					return -1;//Não há células disponiveis para este pedido
				}
			}
			else if(PO==3 && PF==4){//Só pode ser transformada na Célula 1
				if(Celula1.Disponibilidade()==true){//Verifica disponibilidade célula 1	
					Celula1.AlteraDisponibilidade();
					return 6;//6 
				}
				else{//Não há células disponiveis para este pedido
					return -1;
				}
			}
			else if(PO==5 && PF==6){//Só pode ser transformada em C2,C3,C4
				if(Celula2.Disponibilidade()==true){//Verifica disponibilidade célula 2	
					Celula2.AlteraDisponibilidade();
					return 13;//13
				}
				else if(Celula3.Disponibilidade()==true){//Verifica disponibilidade célula 3	
					Celula3.AlteraDisponibilidade();
					return 25;//25
				}
				else if(Celula4.Disponibilidade()==true){//Verifica disponibilidade célula 4	
					Celula4.AlteraDisponibilidade();
					return 37;
				}
				else{
					return -1;//Não há células disponiveis para este pedido
				}
			}
			else if(PO==5 && PF==8){//Só pode ser transformada em C2,C3,C4
				if(Celula2.Disponibilidade()==true){//Verifica disponibilidade célula 2	
					Celula2.AlteraDisponibilidade();
					return 15;//15
				}
				else if(Celula3.Disponibilidade()==true){//Verifica disponibilidade célula 3	
					Celula3.AlteraDisponibilidade();
					return 27; //27
				}
				else if(Celula4.Disponibilidade()==true){//Verifica disponibilidade célula 4	
					Celula4.AlteraDisponibilidade();
					return 39;
				}
				else{
					return -1;//Não há células disponiveis para este pedido
				}
			}
			else if(PO==5 && PF==7){//Só pode ser transformada em C2,C3,C4
				if(Celula2.Disponibilidade()==true){//Verifica disponibilidade célula 2	
					Celula2.AlteraDisponibilidade();
					return 14;//14
				}
				else if(Celula3.Disponibilidade()==true){//Verifica disponibilidade célula 3	
					Celula3.AlteraDisponibilidade();
					return 26; //26
				}
				else if(Celula4.Disponibilidade()==true){//Verifica disponibilidade célula 4	
					Celula4.AlteraDisponibilidade();
					return 38;
				}
				else{
					return -1;//Não há células disponiveis para este pedido
				}
			}
			else if(PO==5 && PF==9){//Só pode ser transformada em C2,C3,C4
				if(Celula2.Disponibilidade()==true){//Verifica disponibilidade célula 2	
					Celula2.AlteraDisponibilidade();
					return 16;//16
				}
				else if(Celula3.Disponibilidade()==true){//Verifica disponibilidade célula 3	
					Celula3.AlteraDisponibilidade();
					return 28;//28
				}
				else if(Celula4.Disponibilidade()==true){//Verifica disponibilidade célula 4	
					Celula4.AlteraDisponibilidade();
					return 40;
				}
				else{
					return -1;//Não há células disponiveis para este pedido
				}
			}
			else if(PO==6 && PF==7){//pode ser transformada em C1,C2,C3,C4
				if(Celula1.Disponibilidade()==true){//verifica disponibilidade célula 1
					Celula1.AlteraDisponibilidade();
					return 43; //43
				}
				else if(Celula2.Disponibilidade()==true){//Verifica disponibilidade célula 2	
					Celula2.AlteraDisponibilidade();
					return 17;//17
				}
				else if(Celula3.Disponibilidade()==true){//Verifica disponibilidade célula 3	
					Celula3.AlteraDisponibilidade();
					return 29; //29
				}
				else if(Celula4.Disponibilidade()==true){//Verifica disponibilidade célula 4	
					Celula4.AlteraDisponibilidade();
					return 41;
				}
				else{
					return -1;//Não há células disponiveis para este pedido
				}
			}
			else if(PO==8 && PF==7){
				if(Celula1.Disponibilidade()==true){//verifica disponibilidade célula 1
					Celula1.AlteraDisponibilidade();
					return 44;//44 
				}
				else{
					return -1;//Não há células disponiveis para este pedido
				}
			}
			else if(PO==8 && PF==9){
				if(Celula2.Disponibilidade()==true){//Verifica disponibilidade célula 2	
					Celula2.AlteraDisponibilidade();
					return 18;//18
				}
				else if(Celula3.Disponibilidade()==true){//Verifica disponibilidade célula 3	
					Celula3.AlteraDisponibilidade();
					return 30; //30
				}
				else if(Celula4.Disponibilidade()==true){//Verifica disponibilidade célula 4	
					Celula4.AlteraDisponibilidade();
					return 42;
				}
				else{
					return -1;//Não há células disponiveis para este pedido
				}
			}		
		}
		else if(tipo=='M'){
			if(Celula5.Disponibilidade()==true){//Verifica disponibilidade célula 2	
				Celula5.AlteraDisponibilidade();
				return 45;//45
			}
			else
				return -1;
		}
		else if(tipo=='U'){
			
		}
	return -1;
	}
}

