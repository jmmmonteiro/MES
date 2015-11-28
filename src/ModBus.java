import java.net.InetAddress;
import java.net.UnknownHostException;

import net.wimpi.modbus.io.ModbusTCPTransaction;
import net.wimpi.modbus.msg.ReadInputRegistersRequest;
import net.wimpi.modbus.msg.ReadInputRegistersResponse;
import net.wimpi.modbus.msg.WriteSingleRegisterRequest;
import net.wimpi.modbus.msg.WriteSingleRegisterResponse;
import net.wimpi.modbus.net.TCPMasterConnection;
import net.wimpi.modbus.procimg.SimpleRegister;

public class ModBus {
	private static ModBus instance;
	private ModBus(){}
	
	public static ModBus getInstance(){
		if(instance==null){
			instance=new ModBus();	
		}
		return instance;
	}
	//Singleton
	
	
	//fun��o para Ler PLC. 
	//ref-numero do primeiro registo a ler
	//count-numero de registos a ler
	public static int readPLC(int ref,int count) throws UnknownHostException, Exception {
		TCPMasterConnection con = null; //the connection
		ModbusTCPTransaction trans = null; //the transaction
		ReadInputRegistersRequest req = null; //the request
		ReadInputRegistersResponse res = null; //the response
		
		/* Variables for storing the parameters */
		InetAddress addr = InetAddress.getByName("127.0.0.1");
		int port = 505;
	
		//int repeat = 1; //a loop for repeating the transaction
		
		con = new TCPMasterConnection(addr);
		con.setPort(port);
		con.connect();
		
		//LER DO PLC
		//3. Prepare the request
		req = new ReadInputRegistersRequest(ref,count);

		//4. Prepare the transaction
		trans = new ModbusTCPTransaction(con);
		trans.setRequest(req);
		
		int a=0;
		trans.execute();
		res = (ReadInputRegistersResponse) trans.getResponse();
		a = res.getRegisterValue(ref);
		System.out.println("Digital Inputs Status=" +Integer.toBinaryString((a & 0xFF) + 0x100).substring(1));
		return a;//retorna inteiro
	}
	
	//fun��o para Escrever no PLC. 
	//ref-numero do primeiro registo a ler
	//w-Word a escrever no PLC
	public static void writePLC(int ref,int w) throws UnknownHostException,Exception {
		TCPMasterConnection con = null; //the connection
			
		/* Variables for storing the parameters */
		InetAddress addr = InetAddress.getByName("127.0.0.1");
		int port = 505;
		con = new TCPMasterConnection(addr);
		con.setPort(port);
		con.connect();
		
		//ESCREVER NO PLC
		SimpleRegister regis = new SimpleRegister(w);//prepara registo a enviar		
		WriteSingleRegisterRequest req2 = new WriteSingleRegisterRequest(ref,regis);//cria pedido
		ModbusTCPTransaction trans2 = new ModbusTCPTransaction(con);//cria transa��o
		trans2.setRequest(req2);//faz pedido
		trans2.execute();//executa transa��o
		WriteSingleRegisterResponse res2=(WriteSingleRegisterResponse) trans2.getResponse();//obtem resposta
		int c=res2.getRegisterValue();
		int d=res2.getReference();
		System.out.println("escrito no registo" +d +c);
	}
}
