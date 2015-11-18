
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
}
