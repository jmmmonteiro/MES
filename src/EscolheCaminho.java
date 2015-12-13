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
					return 0;//pode mudar para outro numero
				}
				else if(Celula2.Disponibilidade()==true){//Verifica disponibilidade célula 2	
					Celula2.AlteraDisponibilidade();
					return -1;
				}
				else if(Celula3.Disponibilidade()==true){//Verifica disponibilidade célula 3	
					Celula3.AlteraDisponibilidade();
					return -1;
				}
				else if(Celula4.Disponibilidade()==true){//Verifica disponibilidade célula 4	
					Celula4.AlteraDisponibilidade();
					return -1;
				}
				else{
					return -1;//Não há células disponiveis para este pedido
				}
			}	
			else if(PO==1 && PF==2){//Só pode ser transformada na Célula 1
				if(Celula1.Disponibilidade()==true){//Verifica disponibilidade célula 1	
					Celula1.AlteraDisponibilidade();
					return 1;
				}
				else{//Não há células disponiveis para este pedido
					return -1;
				}
			}
			else if(PO==1 && PF==3){//Só pode ser transformada na Célula 1
				if(Celula1.Disponibilidade()==true){//Verifica disponibilidade célula 1
					Celula1.AlteraDisponibilidade();
					return 2;
				}
				else{//Não há células disponiveis para este pedido
					return -1;
				}	
			}
			else if(PO==1 && PF==4){//Só pode ser transformada na Célula 1
				if(Celula1.Disponibilidade()==true){//Verifica disponibilidade célula 1	
					Celula1.AlteraDisponibilidade();
					return 3;
				}
				else{//Não há células disponiveis para este pedido
					return -1;
				}
			}
			else if(PO==1 && PF==8){//Só pode ser transformada por C2,C3,C4
				if(Celula2.Disponibilidade()==true){//Verifica disponibilidade célula 2	
					Celula2.AlteraDisponibilidade();
					return 1;
				}
				else if(Celula3.Disponibilidade()==true){//Verifica disponibilidade célula 3
					Celula3.AlteraDisponibilidade();
					return 1;
				}
				else if(Celula4.Disponibilidade()==true){//Verifica disponibilidade célula 4	
					Celula4.AlteraDisponibilidade();
					return 1;
				}
				else{
					return -1;//Não há células disponiveis para este pedido
				}
			}
			else if(PO==1 && PF==9){//Só pode ser transformada por C2,C3,C4
				if(Celula2.Disponibilidade()==true){//Verifica disponibilidade célula 2	
					Celula2.AlteraDisponibilidade();
					return 1;
				}
				else if(Celula3.Disponibilidade()==true){//Verifica disponibilidade célula 3	
					Celula3.AlteraDisponibilidade();
					return 1;
				}
				else if(Celula4.Disponibilidade()==true){//Verifica disponibilidade célula 4	
					Celula4.AlteraDisponibilidade();
					return 1;
				}
				else{
					return -1;//Não há células disponiveis para este pedido
				}
			}
			else if(PO==2 && PF==4){//Só pode ser transformada na Célula 1
				if(Celula1.Disponibilidade()==true){//Verifica disponibilidade célula 1	
					Celula1.AlteraDisponibilidade();
					return 5;
				}
				else{//Não há células disponiveis para este pedido
					return -1;
				}	
			}
			else if(PO==2 && PF==3){//Pode ser transformada em qualquer célula de transformação
				if(Celula1.Disponibilidade()==true){//Verifica disponibilidade célula 1	
					Celula1.AlteraDisponibilidade();
					return 4;
				}
				else if(Celula2.Disponibilidade()==true){//Verifica disponibilidade célula 2	
					Celula2.AlteraDisponibilidade();
					return 1;
				}
				else if(Celula3.Disponibilidade()==true){//Verifica disponibilidade célula 3	
					Celula3.AlteraDisponibilidade();
					return 1;
				}
				else if(Celula4.Disponibilidade()==true){//Verifica disponibilidade célula 4	
					Celula4.AlteraDisponibilidade();
					return 1;
				}
				else{
					return -1;//Não há células disponiveis para este pedido
				}
			}
			else if(PO==3 && PF==4){//Só pode ser transformada na Célula 1
				if(Celula1.Disponibilidade()==true){//Verifica disponibilidade célula 1	
					Celula1.AlteraDisponibilidade();
					return 6;
				}
				else{//Não há células disponiveis para este pedido
					return -1;
				}
			}
			else if(PO==5 && PF==6){//Só pode ser transformada em C2,C3,C4
				if(Celula2.Disponibilidade()==true){//Verifica disponibilidade célula 2	
					Celula2.AlteraDisponibilidade();
					return 1;
				}
				else if(Celula3.Disponibilidade()==true){//Verifica disponibilidade célula 3	
					Celula3.AlteraDisponibilidade();
					return 1;
				}
				else if(Celula4.Disponibilidade()==true){//Verifica disponibilidade célula 4	
					Celula4.AlteraDisponibilidade();
					return 1;
				}
				else{
					return -1;//Não há células disponiveis para este pedido
				}
			}
			else if(PO==5 && PF==8){//Só pode ser transformada em C2,C3,C4
				if(Celula2.Disponibilidade()==true){//Verifica disponibilidade célula 2	
					Celula2.AlteraDisponibilidade();
					return 1;
				}
				else if(Celula3.Disponibilidade()==true){//Verifica disponibilidade célula 3	
					Celula3.AlteraDisponibilidade();
					return 1;
				}
				else if(Celula4.Disponibilidade()==true){//Verifica disponibilidade célula 4	
					Celula4.AlteraDisponibilidade();
					return 1;
				}
				else{
					return -1;//Não há células disponiveis para este pedido
				}
			}
			else if(PO==5 && PF==7){//Só pode ser transformada em C2,C3,C4
				if(Celula2.Disponibilidade()==true){//Verifica disponibilidade célula 2	
					Celula2.AlteraDisponibilidade();
					return 1;
				}
				else if(Celula3.Disponibilidade()==true){//Verifica disponibilidade célula 3	
					Celula3.AlteraDisponibilidade();
					return 1;
				}
				else if(Celula4.Disponibilidade()==true){//Verifica disponibilidade célula 4	
					Celula4.AlteraDisponibilidade();
					return 1;
				}
				else{
					return -1;//Não há células disponiveis para este pedido
				}
			}
			else if(PO==5 && PF==9){//Só pode ser transformada em C2,C3,C4
				if(Celula2.Disponibilidade()==true){//Verifica disponibilidade célula 2	
					Celula2.AlteraDisponibilidade();
					return 1;
				}
				else if(Celula3.Disponibilidade()==true){//Verifica disponibilidade célula 3	
					Celula3.AlteraDisponibilidade();
					return 1;
				}
				else if(Celula4.Disponibilidade()==true){//Verifica disponibilidade célula 4	
					Celula4.AlteraDisponibilidade();
					return 1;
				}
				else{
					return -1;//Não há células disponiveis para este pedido
				}
			}
			else if(PO==6 && PF==7){//pode ser transformada em C1,C2,C3,C4
				if(Celula1.Disponibilidade()==true){//verifica disponibilidade célula 1
					Celula1.AlteraDisponibilidade();
					return 1;
				}
				else if(Celula2.Disponibilidade()==true){//Verifica disponibilidade célula 2	
					Celula2.AlteraDisponibilidade();
					return 1;
				}
				else if(Celula3.Disponibilidade()==true){//Verifica disponibilidade célula 3	
					Celula3.AlteraDisponibilidade();
					return 1;
				}
				else if(Celula4.Disponibilidade()==true){//Verifica disponibilidade célula 4	
					Celula4.AlteraDisponibilidade();
					return 1;
				}
				else{
					return -1;//Não há células disponiveis para este pedido
				}
			}
			else if(PO==8 && PF==7){
				if(Celula1.Disponibilidade()==true){//verifica disponibilidade célula 1
					Celula1.AlteraDisponibilidade();
					return 1;
				}
				else{
					return -1;//Não há células disponiveis para este pedido
				}
			}
			else{
				if(Celula2.Disponibilidade()==true){//Verifica disponibilidade célula 2	
					Celula2.AlteraDisponibilidade();
					return 1;
				}
				else if(Celula3.Disponibilidade()==true){//Verifica disponibilidade célula 3	
					Celula3.AlteraDisponibilidade();
					return 1;
				}
				else if(Celula4.Disponibilidade()==true){//Verifica disponibilidade célula 4	
					Celula4.AlteraDisponibilidade();
					return 1;
				}
				else{
					return -1;//Não há células disponiveis para este pedido
				}
			}		
		}
		else if(tipo=='M'){
			
		}
		else if(tipo=='U'){
			
		}
	return -1;
	}
}
