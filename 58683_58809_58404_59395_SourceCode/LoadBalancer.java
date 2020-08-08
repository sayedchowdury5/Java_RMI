import java.rmi.registry.Registry; 
import java.rmi.registry.LocateRegistry;
import java.net.InetAddress;
import java.rmi.Naming;
import java.rmi.RemoteException; 
import java.rmi.server.UnicastRemoteObject;
import java.util.Scanner; 
import java.lang.*;

public class LoadBalancer { 

	private static int[] RandomNumbers1;
    private static int[] RandomNumbers2;
    private static int[] RandomNumbers3;
	
   public static void main(String args[]) throws Exception { 
	
	   String ipServer1;
	   String ipServer2;
	   String ipServer3;
	   String ipClient;
	   	int j =30000;
	   int k =60000;
      try { 
         // Instantiating the implementation class 
         Impl obj = new Impl(); 
    
         // Exporting the object of implementation class  
         // (here we are exporting the remote object to the stub) 
         //Hello stub = (Hello) UnicastRemoteObject.exportObject(obj, 0);  
         
         // Binding the remote object (stub) in the registry 
         //Registry registry = LocateRegistry.getRegistry(); 
         
         Naming.rebind("Hello", obj); 
         System.err.println("Load Balancer ready");
         System.out.println(java.net.InetAddress.getLocalHost()); //Print out the loadbalancer's IP Address
         
		//ipServer1 = obj.ipHolder(ipAddress);
         
         //Load Balancer has to collect 3 IP Addresses from Server 1-3 
         //Here are the scanners to collect the IP Addresses.
         
         System.err.println("Please insert ip address Server 1");
         Scanner scan1 = new Scanner(System.in);
         ipServer1 = scan1.nextLine();
         System.err.println("Please insert ip address Server 2");
         Scanner scan2 = new Scanner(System.in);
         ipServer2 = scan2.nextLine();
         System.err.println("Please insert ip address Server 3");
         Scanner scan3 = new Scanner(System.in);
         ipServer3 = scan3.nextLine();
         
         RemoteInterface reqSort1 = (RemoteInterface)Naming.lookup("rmi://" + ipServer1 + "/Server1");
         RemoteInterface reqSort2 = (RemoteInterface)Naming.lookup("rmi://" + ipServer2 + "/Server2");
         RemoteInterface reqSort3 = (RemoteInterface)Naming.lookup("rmi://" + ipServer3 + "/Server3");
         
         //Ask Server 1 to generate and then return back the numbers
         //int[] RandomNumbers1;
         //int[] RandomNumbers2;
         //int[] RandomNumbers3;
         //RandomNumbers1 = reqSort1.sortNum();
         //RandomNumbers2 = reqSort2.sortNum2();
         //RandomNumbers3 = reqSort3.sortNum3();

         
         //Send back to server 1 to sort
         
//         for(int i=0; i<RandomNumbers1.length; i++)
//				System.out.println(RandomNumbers1[i]);
//         for(int i=0; i<RandomNumbers2.length; i++)
//				System.out.println(RandomNumbers2[i]);
         //for(int i=0; i<RandomNumbers2.length; i++)
				//System.out.println(RandomNumbers2[i]);
         

         int[] TotalNum = new int[100000];
         
		 
		 Thread genT1 = new Thread() {
			public void run() {
				try {
					RandomNumbers1 = reqSort1.sortNum();
				} catch (RemoteException e) {
					e.printStackTrace();
				}
			}
		};
		
		Thread genT2 = new Thread() {
			public void run() {
				try {
					RandomNumbers2 = reqSort2.sortNum2();
				} catch (RemoteException e) {
					e.printStackTrace();
				}
			}
		};
		
		Thread genT3 = new Thread() {
			public void run() {
				try {
					RandomNumbers3 = reqSort3.sortNum3();
				} catch (RemoteException e) {
					e.printStackTrace();
				}
			}
		};
		
		try {
			genT1.start();
			Thread.sleep(100);
			genT2.start();
			Thread.sleep(100);
			genT3.start();
			Thread.sleep(100);
			
			genT1.join();
			genT2.join();
			genT3.join();
		} catch (InterruptedException e1) {
			e1.printStackTrace();
		}
		
		for(int i=0;i<30000;i++) {
			TotalNum[i] = RandomNumbers1[i];
		}
		
		for(int i=0;i<30000;i++) {
				TotalNum[j] = RandomNumbers2[i];
				j = j+1;
		}
		
		for(int i=0;i<40000;i++) {
				TotalNum[k] = RandomNumbers3[i];
				k =k+1;
		}
		
		System.err.println("Please insert ip address of Client");
         Scanner scan4 = new Scanner(System.in);
         ipClient = scan4.nextLine();
         RemoteInterface clientPrint = (RemoteInterface)Naming.lookup("rmi://" + ipClient + "/Client");
	clientPrint.printMsg(TotalNum);
        //reqSort3.printMsg(TotalNum);
         
         
         
         
      } catch (Exception e) { 
         System.err.println("Server exception: " + e.toString()); 
         e.printStackTrace(); 
      } 
   }
} 