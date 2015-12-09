import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;

public class UDPservidor implements Runnable {

	
	public void run(){
		DatagramSocket socket = null; // vai guardar a port connection
		int count=0; // para usar nas respostas
		String bNO="vazio";
	
		try{ // para verificar se a porta ja está ocupada, tratar dessa excepção
				socket = new DatagramSocket(8765); // nº port qualquer um
		} catch(IOException e){
			System.out.println(e);
			}
		boolean runServer = true; // para servidor sempre a funcionar
		
		while(runServer){
			try{
				System.out.println("\nServidor a correr3");
				byte block[]= new byte [256]; // pois DatagramPacket só funciona com tipo block (max block 1024)
				DatagramPacket inpacket = new DatagramPacket(block, block.length);
				
				socket.receive(inpacket); // mensagem recebida guardada em inpacket	
				
				int lenght = inpacket.getLength();
				
				//System.out.println("Data lenght:" +lenght); // escreve ecrã tamanho mensagem enviado pelo user
				byte inblock[] = inpacket.getData();	// vai buscar a informação que estava em bytes	
				String inmsg = new String(inblock, 0, lenght); //converte a mensagem que estava em bytes para string
				//System.out.println("Server obtained: " +inmsg);
				if(lenght==9 && bNO.compareTo(inmsg.substring(2,5))!=0)
				{
					//System.out.println(bNO);
					String pedido=inmsg.substring(0);//pedido em string
					//System.out.println("Pedido em string " +pedido);//
					//char p=inmsg.charAt(1);//tipo do pedido
					//System.out.println("Pedido do tipo " +p);//
					//bNO=inmsg.substring(2,5);
					//System.out.println("Número de ordem " +bNO);
					//int NO=Integer.parseInt(bNO);//Número de Ordem
					//String bPO=inmsg.substring(5,6);
					//char PO=bPO.charAt(0);//peça de origem
					//System.out.println("peça de origem " +PO);
					//String bPF=inmsg.substring(6,7);
					//char PF=bPF.charAt(0);//peça final
					//System.out.println("peça de fim  " +PF);
					//String bq=inmsg.substring(7,9);
					//System.out.println("Quantidade " +bq);
					//int Q=Integer.parseInt(bNO);//Quantidade
					GestordePedidos gestor=GestordePedidos.getInstance();//vai buscar objecto gestor pedidos
					gestor.novoPedidoPendente(pedido); // 0 , pois não se especifica destino
				}
				
				// parte para mandar resposta user
				String outmsg;
				count++;
				
					// testar aqui qual o pedido do user(se transforma, se outa )
				if(inmsg.equals("count")){ 
					outmsg = "number of messages: " + count;
				} else if (inmsg.equals("stop")){
					socket.close();
					return;
				} else{
					outmsg="mensagem recebida";
				}
					
				byte outblock[]= outmsg.getBytes(); // converte a string que contem a resposta para bytes (tipo usado pelo datagram)
					
				InetAddress returnAddress = inpacket.getAddress(); //ir buscar endereço ip do cliente
				int returnport= inpacket.getPort(); // ir buscar porta do cliente
				DatagramPacket outpacket = new DatagramPacket(outblock, outblock.length, returnAddress, returnport);
				socket.send(outpacket); // responder ao cliente 
				
				} catch(IOException e){ // se mensagem maior que 256 emite erro
					e.printStackTrace();
					}	
		}
	}
}	
	
	
	
	
	
	
