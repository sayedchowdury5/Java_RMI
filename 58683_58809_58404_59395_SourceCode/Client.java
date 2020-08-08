import java.net.InetAddress;
import java.rmi.Naming;
import java.rmi.registry.LocateRegistry; 
import java.rmi.registry.Registry;
import java.util.Random;  

public class Client {
	static int nums[] = new int[100000];
	static int start = 0, end = 100000;
	static int break1[],break2[],break3[];
	

	public static void main(String[] args) {
		InetAddress ipAddress;
		String hostname = args[0];
	
		
		try {  
			Impl obj = new Impl();
			
			Naming.rebind("Client", obj); 
			// Getting the registry 
			//Registry registry = LocateRegistry.getRegistry(null); 

			// Looking up the registry for the remote object 
			//Hello stub = (Hello) registry.lookup("Hello"); 

			// Calling the remote method using the obtained object 
			//stub.printMsg(); 

			// System.out.println("Remote method invoked");	
			//genRandom();
			
			//Connect to Servers
			
			RemoteInterface reqRandom = (RemoteInterface)Naming.lookup("rmi://" + hostname + "/Hello");
			RemoteInterface printIP = (RemoteInterface)Naming.lookup("rmi://" + hostname + "/Hello");
			//RemoteInterface printRandom = (RemoteInterface)Naming.lookup("rmi://" + hostname + "/Hello");
			
			
			
			
			//sortRandom.printMsg(nums);
			
			
			//Sortedar is for printing the last shits
			//int[] sortedarr;
			//sortedarr = 
			ipAddress = (java.net.InetAddress.getLocalHost());
			reqRandom.generateRandom();
			printIP.ipHolder(ipAddress);
			//for(int i=0; i<sortedarr.length; i++)
			//	System.out.println(sortedarr[i]);
		} catch (Exception e) {
			System.err.println("Client exception: " + e.toString()); 
			e.printStackTrace(); 
		} 
	}

	public static void genRandom() {
		Random rand = new Random(); 
		for (int i = start; i < end; i++) {
			nums[i] = rand.nextInt(nums.length);
		}
		
		for (int x = start; x <30000;x++) {
		break1[x] = nums[x];
		}
		for (int x = 30001; x <60000;x++) {
		break2[x] = nums[x];
		}
		for (int x = 60001; x <99999;x++) {
		break3[x] = nums[x];
		}
		
		
		
		
	}
	
	public static void theBreaker() {
		int x = 100000;
		//3 server
		int Server = 6;
		int []arr;
		
		arr = dividingNum(x,Server);
		
		for (int i=0;i<Server;i++)
			System.out.println(arr[i]);
	}
	
	public static int [] dividingNum(int total,int Server) {
		int[] arr = new int [Server];
		
		for (int i =0;Server>0;i++) {
			int size = (total + Server - 1)/ Server;
			arr[i] = size;
			total -= size;
			Server --;
		}
		return arr;
	}
}