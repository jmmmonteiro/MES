//Classe Singleton - s� existe um objecto 
public class EscolheCaminho {
	//criar C�lulas
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
	
	public static EscolheCaminho getInstance(){
		if(instance==null){
			instance=new EscolheCaminho();	
		}
		return instance;
	}
	//Singleton
	//Altera Disponibilidade de uma C�lula
	public void Disp(int celula){
		if(celula==1)
		{
			Celula1.AlteraDisponibilidade();
		}
		else if(celula==2)
		{
			Celula2.AlteraDisponibilidade();
		}
		else if(celula==3)
		{
			Celula3.AlteraDisponibilidade();
		}
		else if(celula==4)
		{
			Celula4.AlteraDisponibilidade();
		}
		else
		{
			return;
		}
		return;
	}
	
	//Escolhe Novo Caminho
	public int EscolheNovoCaminho(char tipo, int PO, int PF){
		if(tipo=='T'){//Testa todos os caminhos possiveis para transforma��o
			if(PO==1 && PF==5){//Pode ser transformada em qualquer c�lula de transforma��o
				if(Celula1.Disponibilidade()==true){//Verifica disponibilidade c�lula 1	
					Celula1.AlteraDisponibilidade();
					return 1;//pode mudar para outro numero
				}
				else if(Celula2.Disponibilidade()==true){//Verifica disponibilidade c�lula 2	
					Celula2.AlteraDisponibilidade();
					return 1;
				}
				else if(Celula3.Disponibilidade()==true){//Verifica disponibilidade c�lula 3	
					Celula3.AlteraDisponibilidade();
					return 1;
				}
				else if(Celula4.Disponibilidade()==true){//Verifica disponibilidade c�lula 4	
					Celula4.AlteraDisponibilidade();
					return 1;
				}
				else{
					return 0;//N�o h� c�lulas disponiveis para este pedido
				}
			}	
			else if(PO==1 && PF==2){//S� pode ser transformada na C�lula 1
				if(Celula1.Disponibilidade()==true){//Verifica disponibilidade c�lula 1	
					Celula1.AlteraDisponibilidade();
					return 1;
				}
				else{//N�o h� c�lulas disponiveis para este pedido
					return 0;
				}
			}
			else if(PO==1 && PF==3){//S� pode ser transformada na C�lula 1
				if(Celula1.Disponibilidade()==true){//Verifica disponibilidade c�lula 1
					Celula1.AlteraDisponibilidade();
					return 1;
				}
				else{//N�o h� c�lulas disponiveis para este pedido
					return 0;
				}	
			}
			else if(PO==1 && PF==4){//S� pode ser transformada na C�lula 1
				if(Celula1.Disponibilidade()==true){//Verifica disponibilidade c�lula 1	
					Celula1.AlteraDisponibilidade();
					return 1;
				}
				else{//N�o h� c�lulas disponiveis para este pedido
					return 0;
				}
			}
			else if(PO==1 && PF==8){//S� pode ser transformada por C2,C3,C4
				if(Celula2.Disponibilidade()==true){//Verifica disponibilidade c�lula 2	
					Celula2.AlteraDisponibilidade();
					return 1;
				}
				else if(Celula3.Disponibilidade()==true){//Verifica disponibilidade c�lula 3
					Celula3.AlteraDisponibilidade();
					return 1;
				}
				else if(Celula4.Disponibilidade()==true){//Verifica disponibilidade c�lula 4	
					Celula4.AlteraDisponibilidade();
					return 1;
				}
				else{
					return 0;//N�o h� c�lulas disponiveis para este pedido
				}
			}
			else if(PO==1 && PF==9){//S� pode ser transformada por C2,C3,C4
				if(Celula2.Disponibilidade()==true){//Verifica disponibilidade c�lula 2	
					Celula2.AlteraDisponibilidade();
					return 1;
				}
				else if(Celula3.Disponibilidade()==true){//Verifica disponibilidade c�lula 3	
					Celula3.AlteraDisponibilidade();
					return 1;
				}
				else if(Celula4.Disponibilidade()==true){//Verifica disponibilidade c�lula 4	
					Celula4.AlteraDisponibilidade();
					return 1;
				}
				else{
					return 0;//N�o h� c�lulas disponiveis para este pedido
				}
			}
			else if(PO==2 && PF==4){//S� pode ser transformada na C�lula 1
				if(Celula1.Disponibilidade()==true){//Verifica disponibilidade c�lula 1	
					Celula1.AlteraDisponibilidade();
					return 1;
				}
				else{//N�o h� c�lulas disponiveis para este pedido
					return 0;
				}	
			}
			else if(PO==2 && PF==3){//Pode ser transformada em qualquer c�lula de transforma��o
				if(Celula1.Disponibilidade()==true){//Verifica disponibilidade c�lula 1	
					Celula1.AlteraDisponibilidade();
					return 1;
				}
				else if(Celula2.Disponibilidade()==true){//Verifica disponibilidade c�lula 2	
					Celula2.AlteraDisponibilidade();
					return 1;
				}
				else if(Celula3.Disponibilidade()==true){//Verifica disponibilidade c�lula 3	
					Celula3.AlteraDisponibilidade();
					return 1;
				}
				else if(Celula4.Disponibilidade()==true){//Verifica disponibilidade c�lula 4	
					Celula4.AlteraDisponibilidade();
					return 1;
				}
				else{
					return 0;//N�o h� c�lulas disponiveis para este pedido
				}
			}
			else if(PO==3 && PF==4){//S� pode ser transformada na C�lula 1
				if(Celula1.Disponibilidade()==true){//Verifica disponibilidade c�lula 1	
					Celula1.AlteraDisponibilidade();
					return 1;
				}
				else{//N�o h� c�lulas disponiveis para este pedido
					return 0;
				}
			}
			else if(PO==5 && PF==6){//S� pode ser transformada em C2,C3,C4
				if(Celula2.Disponibilidade()==true){//Verifica disponibilidade c�lula 2	
					Celula2.AlteraDisponibilidade();
					return 1;
				}
				else if(Celula3.Disponibilidade()==true){//Verifica disponibilidade c�lula 3	
					Celula3.AlteraDisponibilidade();
					return 1;
				}
				else if(Celula4.Disponibilidade()==true){//Verifica disponibilidade c�lula 4	
					Celula4.AlteraDisponibilidade();
					return 1;
				}
				else{
					return 0;//N�o h� c�lulas disponiveis para este pedido
				}
			}
			else if(PO==5 && PF==8){//S� pode ser transformada em C2,C3,C4
				if(Celula2.Disponibilidade()==true){//Verifica disponibilidade c�lula 2	
					Celula2.AlteraDisponibilidade();
					return 1;
				}
				else if(Celula3.Disponibilidade()==true){//Verifica disponibilidade c�lula 3	
					Celula3.AlteraDisponibilidade();
					return 1;
				}
				else if(Celula4.Disponibilidade()==true){//Verifica disponibilidade c�lula 4	
					Celula4.AlteraDisponibilidade();
					return 1;
				}
				else{
					return 0;//N�o h� c�lulas disponiveis para este pedido
				}
			}
			else if(PO==5 && PF==7){//S� pode ser transformada em C2,C3,C4
				if(Celula2.Disponibilidade()==true){//Verifica disponibilidade c�lula 2	
					Celula2.AlteraDisponibilidade();
					return 1;
				}
				else if(Celula3.Disponibilidade()==true){//Verifica disponibilidade c�lula 3	
					Celula3.AlteraDisponibilidade();
					return 1;
				}
				else if(Celula4.Disponibilidade()==true){//Verifica disponibilidade c�lula 4	
					Celula4.AlteraDisponibilidade();
					return 1;
				}
				else{
					return 0;//N�o h� c�lulas disponiveis para este pedido
				}
			}
			else if(PO==5 && PF==9){//S� pode ser transformada em C2,C3,C4
				if(Celula2.Disponibilidade()==true){//Verifica disponibilidade c�lula 2	
					Celula2.AlteraDisponibilidade();
					return 1;
				}
				else if(Celula3.Disponibilidade()==true){//Verifica disponibilidade c�lula 3	
					Celula3.AlteraDisponibilidade();
					return 1;
				}
				else if(Celula4.Disponibilidade()==true){//Verifica disponibilidade c�lula 4	
					Celula4.AlteraDisponibilidade();
					return 1;
				}
				else{
					return 0;//N�o h� c�lulas disponiveis para este pedido
				}
			}
			else if(PO==6 && PF==7){//pode ser transformada em C1,C2,C3,C4
				if(Celula1.Disponibilidade()==true){//verifica disponibilidade c�lula 1
					Celula1.AlteraDisponibilidade();
					return 1;
				}
				else if(Celula2.Disponibilidade()==true){//Verifica disponibilidade c�lula 2	
					Celula2.AlteraDisponibilidade();
					return 1;
				}
				else if(Celula3.Disponibilidade()==true){//Verifica disponibilidade c�lula 3	
					Celula3.AlteraDisponibilidade();
					return 1;
				}
				else if(Celula4.Disponibilidade()==true){//Verifica disponibilidade c�lula 4	
					Celula4.AlteraDisponibilidade();
					return 1;
				}
				else{
					return 0;//N�o h� c�lulas disponiveis para este pedido
				}
			}
			else if(PO==8 && PF==7){
				if(Celula1.Disponibilidade()==true){//verifica disponibilidade c�lula 1
					Celula1.AlteraDisponibilidade();
					return 1;
				}
				else{
					return 0;//N�o h� c�lulas disponiveis para este pedido
				}
			}
			else{
				if(Celula2.Disponibilidade()==true){//Verifica disponibilidade c�lula 2	
					Celula2.AlteraDisponibilidade();
					return 1;
				}
				else if(Celula3.Disponibilidade()==true){//Verifica disponibilidade c�lula 3	
					Celula3.AlteraDisponibilidade();
					return 1;
				}
				else if(Celula4.Disponibilidade()==true){//Verifica disponibilidade c�lula 4	
					Celula4.AlteraDisponibilidade();
					return 1;
				}
				else{
					return 0;//N�o h� c�lulas disponiveis para este pedido
				}
			}		
		}
		else if(tipo=='M'){
			
		}
		else if(tipo=='U'){
			
		}
	return 0;
	}
}
		
